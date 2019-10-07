package com.payment.service.active.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.payment.dao.PyActiveCardMapper;
import com.payment.dao.PyActiveMapper;
import com.payment.dao.PyActiveShopMapper;
import com.payment.dao.PyBonusPoolMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyActive;
import com.payment.model.PyActiveCard;
import com.payment.model.PyActiveCardExample;
import com.payment.model.PyActiveExample;
import com.payment.model.PyActiveShop;
import com.payment.model.PyActiveShopExample;
import com.payment.model.PyActiveWithBLOBs;
import com.payment.model.PyBonusPool;
import com.payment.service.active.IActiveSV;
import com.payment.service.org.IOrgSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class ActiveSVImpl implements IActiveSV {
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private PyActiveMapper mapper;
	@Autowired
	private PyActiveCardMapper cardMapper;
	@Autowired
	private PyActiveShopMapper shopMapper;
	@Autowired
	private PyBonusPoolMapper bonusMapper;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public List<PyActive> getList(PyActiveExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

	@Override
	public PyActiveWithBLOBs getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyActiveWithBLOBs record) throws Exception {
		this.initActiveInfo(record);
		mapper.insert(record);
	}
	private void initActiveInfo(PyActiveWithBLOBs record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		record.setUsedTotal(BigDecimal.ZERO);
		if("1".equals(record.getBonusType())){//奖金池控制
			/*PyBonusPool bonus = bonusMapper.selectByPrimaryKey(record.getBonusId());
			record.setBonusTotal(bonus.getTotal());*/
		}
		
	}
	
	private List<PyActiveCard> getCardListByFile(PyActiveWithBLOBs record, MultipartFile file) throws Exception {
		if("2".equals(record.getCardAddType()) && file == null){
			throw new Exception("导入的excel文件为空");
		}
		//转换成输入流
		InputStream is = file.getInputStream();
		//得到excel
		Workbook workbook = Workbook.getWorkbook(is);
		//得到sheet
		Sheet sheet = workbook.getSheet(0);
		//得到列数
		int colsNum = sheet.getColumns();
		//得到行数
		int rowsNum = sheet.getRows();
		if(colsNum == 0 || rowsNum<=3){
			throw new Exception("导入的excel格式不正确，请使用系统提供的模板");
		}
		//单元格
		Cell cell;
		List<PyActiveCard> cardList = new ArrayList<PyActiveCard>();
		for (int i = 1; i < rowsNum; i++) {//我的excel第一行是标题,所以 i从1开始
			for (int j = 0; j < 1; j++) {
				cell = sheet.getCell(j, i);//注意:第一个参数是列.第二个参数是行
				String cardNo = cell.getContents();
				PyActiveCard card = new PyActiveCard();
				card.setCardNo(cardNo);
				cardList.add(card);
				System.out.println(cell.getContents());
			}
		}
		return cardList;
	}
	
	@Override
	public void mod(PyActiveWithBLOBs record,String str) throws Exception{
		this.mod(record,this.getCardListByStr(record, str));
	}
	@Override
	public void mod(PyActiveWithBLOBs record, MultipartFile file) throws Exception{
		this.mod(record,this.getCardListByFile(record, file));
	}
	@Override
	public void mod(PyActiveWithBLOBs active,List<PyActiveCard> cardList) throws Exception {
		mapper.updateByPrimaryKeySelective(active);
		PyActiveCardExample ex = new PyActiveCardExample();
		PyActiveCardExample.Criteria c = ex.createCriteria();
		c.andActiveIdEqualTo(active.getId());
		//cardMapper.deleteByExample(ex);
		for(PyActiveCard card:cardList){
			card.setActiveId(active.getId());
			card.setBatchId(active.getId());
			card.setCreateTime(active.getCreateTime());
			card.setCreateUserId(active.getCreateUserId());
			card.setId(UuidUtil.get32UUID());
			card.setIndentifyType(active.getCardIdentifyType());
			card.setState("1");
			cardMapper.insert(card);
		}
	}
	@Override
	public void add(PyActiveWithBLOBs active,List<PyActiveCard> cardList) throws Exception {
		this.initActiveInfo(active);
		for(PyActiveCard card:cardList){
			card.setActiveId(active.getId());
			card.setBatchId(active.getId());
			card.setCreateTime(active.getCreateTime());
			card.setCreateUserId(active.getCreateUserId());
			card.setId(UuidUtil.get32UUID());
			card.setIndentifyType(active.getCardIdentifyType());
			card.setState("1");
			cardMapper.insert(card);
		}
		mapper.insert(active);
	}

	@Override
	public void del(String id) throws Exception {
		PyActiveWithBLOBs record = mapper.selectByPrimaryKey(id);
		record.setState("0");
		mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public void del(String[] ids) throws Exception {
		for(String id : ids){
			this.del(id);
		}
	}

	@Override
	public void mod(PyActiveWithBLOBs record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<Map<String, Object>> listCard(Page page,String activeId) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,b.name active_name,case when b.card_add_type = '1' then '卡BIN' else '卡号' end as card_type_name" +
				         " from py_active_card a,py_active b where a.active_id = b.id    and a.active_id = :activeId            ");     
		params.put("activeId", activeId);
		String qryCardNo = page.getPd().getString("qryCardNo");
		if(!StringUtils.isEmpty(qryCardNo)){
			sql.append(" and (a.card like :qryCardNo) ");
			params.put("qryCardNo", "%" + qryCardNo + "%");
		}
		
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}
	@Override
	public List<Map<String, Object>> listActive(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		String qryType = page.getPd().getString("type");
		sql.append(" select p.name bonus_name, p.total p_bonus_total,p.USED_TOTAL p_used_total,case when STR_TO_DATE(a.END_DATE,'%Y-%m-%d') < NOW() then '已过期' else '进行中' end as state_name ," +
				"a.*,b.name org_name,ifnull(c.shop_count,0) shop_count,ifnull(d.card_count,0) card_count,ifnull(dt.detail_count,0) detail_count    "); 
		if("all".equals(qryType)){
			sql.append("  ,FORMAT(ifnull(o.amount_total,0)/100,2) amount_total,FORMAT(ifnull(o.discount_total,0)/100,2) discount_total        ");
		}
		sql.append(" from py_active a  LEFT JOIN (select active_id,count(*) shop_count from py_active_shop group by active_id) c on a.id=c.active_id  LEFT JOIN py_bonus_pool p on a.bonus_id=p.id   "); 
		sql.append("  LEFT JOIN (select active_id,count(*) card_count from py_active_card where state='1' group by active_id) d on a.id=d.active_id        ");
		sql.append("  LEFT JOIN (select active_id,count(*) detail_count from py_active_detail where state='1'  group by active_id) dt on a.id=dt.active_id        ");
		if("all".equals(qryType)){
			sql.append("  LEFT JOIN (select active_id,sum(ifnull(ORDER_AMOUNT,0)) amount_total,sum(ifnull(DISCOUNT_AMOUNT_TOTAL,0)) discount_total from py_order where 1=1 group by active_id) o on a.id=o.active_id        ");
		}
		sql.append(" ,sys_org b                    ");
		sql.append("where a.state ='1' and a.org_id = b.id                                                                                                                           ");
		String id = page.getPd().getString("id");
		if(!StringUtils.isEmpty(id)){
			sql.append(" and (a.id = :id ) ");
			params.put("id", id);
		}
		String qryName = page.getPd().getString("qryName");
		if(!StringUtils.isEmpty(qryName)){
			sql.append(" and (a.name like :qryName ) ");
			params.put("qryName", "%" + qryName + "%");
		}
		if(!StringUtils.isEmpty(qryType) && !"all".equals(qryType)){
			sql.append(" and (a.type = :qryType ) ");
			params.put("qryType", qryType);
		}
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "a.org_id", "a.shop_id");
		sql.append(condition);
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list;
	}


	@Override
	public void add(PyActiveWithBLOBs record, MultipartFile file) throws Exception {
		this.add(record, this.getCardListByFile(record, file));
	}
	
	@Override
	public void add(PyActiveWithBLOBs record, String cardStr) throws Exception {
		List<PyActiveCard> cardList = this.getCardListByStr(record, cardStr);
		this.add(record, cardList);
	}

	private List<PyActiveCard> getCardListByStr(PyActiveWithBLOBs record, String cardStr) throws Exception {
		List<PyActiveCard> cardList = new ArrayList<PyActiveCard>();
		if( cardStr == null || "".equals(cardStr)){
			throw new Exception("卡号为空");
		}
		String[] cardArray = cardStr.split("\\|");
		for(String cardNo:cardArray){
			PyActiveCard card = new PyActiveCard();
			card.setCardNo(cardNo);
			cardList.add(card);
		}
		return cardList;
	}
	
   public static void main(String[] args) {
		String s = "111|222";
		System.out.println(s.split("|")[0]);
	}

@Override
public void setShop(String activeId,String shopId,String userId) throws Exception {
	PyActiveShopExample ex = new PyActiveShopExample();
	PyActiveShopExample.Criteria c = ex.createCriteria();
	c.andActiveIdEqualTo(activeId);
	shopMapper.deleteByExample(ex);
	String[] shops = shopId.split(",");
	for(String id:shops){
		PyActiveShop  record = new PyActiveShop();
		record.setActiveId(activeId);
		record.setCreateTime(DateUtil.getTime());
		record.setCreateUserId(userId);
		record.setId(UuidUtil.get32UUID());
		record.setShopId(id);
		shopMapper.insert(record);
	}
}

@Override
public void delShop(String id) throws Exception {
	shopMapper.deleteByPrimaryKey(id);
}

@Override
public List<PyActiveShop> getShopList(String activeId) throws Exception {
	PyActiveShopExample ex = new PyActiveShopExample();
	PyActiveShopExample.Criteria c = ex.createCriteria();
	c.andActiveIdEqualTo(activeId);
	return shopMapper.selectByExample(ex);
}

@Override
public void delCard(String id) throws Exception {
	cardMapper.deleteByPrimaryKey(id);
}
}
