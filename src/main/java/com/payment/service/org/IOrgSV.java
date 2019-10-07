package com.payment.service.org;

import java.util.List;

import com.payment.dto.User;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;

public interface IOrgSV {
	public List<SysOrg> getOrgList(SysOrgExample ex) throws Exception;
	public SysOrg getOrgById(String orgId) throws Exception;
	public void delById(String orgId) throws Exception;
	public void modOrg(SysOrg record) throws Exception;
	public void addOrg(SysOrg record) throws Exception;
	public List<SysOrg> getOrgTree(String orgId)throws Exception;
	public void getSubOrg(String orgId,List<SysOrg> list);
	public String getOrgCondtion(User user, String orgTbAliasName,
			String shopTbAliasName) throws Exception;
	public String getOrgCondtion(User user, String orgTbAliasName,
			String shopTbAliasName,boolean olnlyShopLimit) throws Exception;
}
