package com.payment.service.terminal.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.payment.dao.PyShopInfoMapper;
import com.payment.dao.PyTerminalMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.model.PyTerminal;
import com.payment.model.PyTerminalExample;
import com.payment.service.org.IOrgSV;
import com.payment.service.terminal.ITerminalSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;

@Service
@Transactional
public class TerminalSVImpl implements ITerminalSV {
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private PyTerminalMapper mapper;
	@Autowired
	private PyShopInfoMapper shopMapper;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public List<PyTerminal> getList(PyTerminalExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

	@Override
	public PyTerminal getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyTerminal record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		mapper.insert(record);
	}

	@Override
	public void del(String id) throws Exception {
		PyTerminalExample ex = new PyTerminalExample();
		PyTerminalExample.Criteria c = ex.createCriteria();
		PyTerminal record = mapper.selectByPrimaryKey(id);
		record.setState("0");
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void mod(PyTerminal record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> getPageList(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,b.code shop_code,b.name shop_name from py_terminal a,py_shop_info b where a.SHOP_ID = b.id and a.STATE <> '0' ");
		String qryShopName = page.getPd().getString("qryShopName");
		if(!StringUtils.isEmpty(qryShopName)){
			sql.append(" and (b.name like :qryShopName) ");
			params.put("qryShopName", "%" + qryShopName + "%");
		}
		String qryShopCode = page.getPd().getString("qryShopCode");
		if(!StringUtils.isEmpty(qryShopCode)){
			sql.append(" and (b.code like :qryShopCode ) ");
			params.put("qryShopCode", "%" + qryShopCode + "%");
		}
		String qryCode = page.getPd().getString("qryCode");
		if(!StringUtils.isEmpty(qryCode)){
			sql.append(" and (a.code like :qryCode ) ");
			params.put("qryCode", "%" + qryCode + "%");
		}
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "a.org_id", "b.id",true);
		sql.append(condition);
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void batch(int count, PyTerminal record) throws Exception {
			record.setBatchId(UuidUtil.get32UUID());
			record.setState("1");
			long code = Long.parseLong(record.getCode());
		for(int i=0;i<count;i++){
			record.setId(UuidUtil.get32UUID());
			record.setCreateTime(DateUtil.getTime());
			if(i>0){
				record.setCode((code+i)+"");
			}
			mapper.insert(record);
		}
	}
	
	private PyShopInfo getShopByCode(String shopCode) throws Exception {
		PyShopInfoExample ex = new PyShopInfoExample();
		PyShopInfoExample.Criteria c = ex.createCriteria();
		c.andCodeEqualTo(shopCode);
		List<PyShopInfo> list = shopMapper.selectByExample(ex);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public void batch(PyTerminal record, MultipartFile file) throws Exception {
		if(file == null){
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
		if(colsNum != 2 || rowsNum<=3){
			throw new Exception("导入的excel格式不正确，请使用系统提供的模板");
		}
		//单元格
		Cell cell_1;
		Cell cell_2;
		record.setBatchId(UuidUtil.get32UUID());
		record.setState("1");
		for (int i = 3; i < rowsNum; i++) {//我的excel第一行是标题,所以 i从1开始
			cell_1 =  sheet.getCell(0, i);
			cell_2 =  sheet.getCell(1, i);
			String shopCode = cell_1.getContents();
			String code = cell_2.getContents();
			PyShopInfo shop = this.getShopByCode(shopCode);
			if(shop == null){
				throw new Exception("商户编号["+shopCode+"]不存在，导入失败。请修改后重新导入！");
			}
			record.setId(UuidUtil.get32UUID());
			record.setCreateTime(DateUtil.getTime());
			record.setShopId(shop.getId());
			record.setCode(code);
			mapper.insert(record);
		}

	}

	@Override
	public void del(String[] ids) throws Exception {
		for(String id : ids){
			this.del(id);
		}
	}

}
