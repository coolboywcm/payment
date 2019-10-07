package com.payment.service.common.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.payment.common.Const;
import com.payment.dao.SysFileMapper;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.SysFile;
import com.payment.model.SysFileExample;
import com.payment.service.common.ISysFileSV;
import com.payment.util.DateUtil;
import com.payment.util.Tools;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class SysFileSVImpl implements ISysFileSV {
	@Autowired
	private SysFileMapper mapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Override
	public SysFile getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(SysFile record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		mapper.insert(record);
	}

	@Override
	public void mod(SysFile record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,o.name org_name,s.name shop_name "
				+ "        from py_adimg a left join sys_org o on a.org_id = o.id left join py_shop_info s on a.shop_id = s.id ");
		String activeId = page.getPd().getString("activeId");
		if(!StringUtils.isEmpty(activeId)){
			sql.append(" and active_id = :activeId ");
			params.put("activeId", activeId);
		}
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void del(String id) throws Exception {
		mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void del(String[] ids) throws Exception {
		for(String id : ids){
			this.del(id);
		}
	}
	@Override
	public List<SysFile> getList(SysFileExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

	@Override
	public String saveFile(MultipartFile file) throws Exception {
		// 上传的图片的名称
		String fileName = file.getOriginalFilename();
		String newfileName = UuidUtil.get32UUID()+ fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
		// 获得工程下面upload资源包路径，当然这个包是已经存在的了
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		String path = request.getSession().getServletContext().getRealPath("uploadFiles/adimg");
		//看是否存在upload包，没有则会新建一个upload包，作为资源上传的路径
        File targetFile = new File(path, newfileName);
        if (!targetFile.exists()) {
            //targetFile.mkdirs();
        }
        //文件上传
        file.transferTo(targetFile);
        SysFile data = new SysFile();
        data.setFileName(newfileName);
        data.setFilePatch(targetFile.getPath());
        data.setOriFileName(fileName);
        data.setUrl(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath()+"/uploadFiles/adimg/"+newfileName);
        this.add(data);
		return data.getId();
	}
}
