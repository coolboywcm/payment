package com.payment.service.org.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.common.Const;
import com.payment.dao.SysOrgMapper;
import com.payment.dao.SysRoleMapper;
import com.payment.dto.User;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.model.SysRole;
import com.payment.service.org.IOrgSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class OrgSVImpl implements IOrgSV {
	@Autowired
    private SysOrgMapper mapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Override
	public List<SysOrg> getOrgList(SysOrgExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

	@Override
	public SysOrg getOrgById(String orgId) throws Exception {
		return mapper.selectByPrimaryKey(orgId);
	}

	@Override
	public void delById(String orgId) throws Exception {
		SysOrg org = this.getOrgById(orgId);
		org.setState("0");
		mapper.updateByPrimaryKeySelective(org);
		this.delSubId(orgId);
	}
	
	private void delSubId(String pId) throws Exception {
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andParentIdEqualTo(pId);
		List<SysOrg> subList = this.getOrgList(ex);
		if(subList!=null && !subList.isEmpty()){
			for(SysOrg subOrg : subList){
				subOrg.setState("0");
				mapper.updateByPrimaryKeySelective(subOrg);
				this.delSubId(subOrg.getId());
			}
		}
	}

	@Override
	public void modOrg(SysOrg record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void addOrg(SysOrg record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		mapper.insert(record);
	}
	
	@Override
	public List<SysOrg> getOrgTree(String orgId)throws Exception {
		List<SysOrg> orgTree = new ArrayList<SysOrg>();
		if(!"0".equals(orgId)){
			orgTree.add(this.getOrgById(orgId));
		}
		this.getSubOrg(orgId, orgTree);
		return orgTree;
	}

	@Override
	public void getSubOrg(String orgId,List<SysOrg> list){
		if(!StringUtils.isEmpty(orgId)){
			SysOrgExample ex = new SysOrgExample();
			SysOrgExample.Criteria c = ex.createCriteria();
			c.andStateEqualTo("1");
			c.andParentIdEqualTo(orgId);
			ex.setOrderByClause(" create_time  ");
			try {
				List<SysOrg> orgList = this.getOrgList(ex);
				if(orgList!=null && !orgList.isEmpty()){
					for(SysOrg subOrg : orgList){
						list.add(subOrg);
						getSubOrg(subOrg.getId(),list);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public  String getOrgCondtion(User user,String orgTbAliasName,String shopTbAliasName)throws Exception{
		return this.getOrgCondtion(user, orgTbAliasName, shopTbAliasName,false);
	} 
	
	
	@Override
	public  String getOrgCondtion(User user,String orgTbAliasName,String shopTbAliasName,boolean olnlyShopLimit)throws Exception {
		StringBuffer result = new StringBuffer();
		if(user!=null){
			String roleId = user.getROLE_ID();
			SysRole role = roleMapper.selectByPrimaryKey(roleId);
			if(Const.ROLE_ID_SUB_MGR.equals(role.getType()) && !StringUtils.isEmpty(orgTbAliasName)){
				if(!olnlyShopLimit){
					result.append(" and "+orgTbAliasName+" in ("+this.getOrgStringList(user.getOrgId())+")");
				}
				if(!StringUtils.isEmpty(shopTbAliasName)){
					result.append(" and "+shopTbAliasName+" in (select id from py_shop_info where org_id in ("+this.getOrgStringList(user.getOrgId())+") )");
				};
			}
			if(Const.ROLE_ID_SHOP.equals(role.getType()) && !StringUtils.isEmpty(shopTbAliasName)){
				result.append(" and "+shopTbAliasName+" in ("+user.getShopId()+")");
			}
		}
		return result.toString();
	}
	
	private String getOrgStringList(String orgId) throws Exception{
		List<SysOrg> list =  this.getOrgTree(orgId);
		StringBuffer result = new StringBuffer();
		if(list!=null && !list.isEmpty()){
			for(int i = 0; i<list.size();i++){
				SysOrg subOrg = list.get(i);
				result.append("'"+subOrg.getId()+"'");
				result.append(i == (list.size() - 1) ? "":",");
			}
		}
		return result.toString();
	}
}
