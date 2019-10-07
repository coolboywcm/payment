package com.payment.service.role;

import java.util.List;
import java.util.Map;

import com.payment.common.model.Qx;
import com.payment.dto.common.Page;
import com.payment.model.SysRole;
import com.payment.model.SysRoleExample;
import com.payment.model.SysRoleRight;

public interface IRoleSV {
	public SysRole getById(String id) throws Exception;

	public void add(SysRole record,String[] ckMenu) throws Exception;

	public void mod(SysRole record,String[] ckMenu) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<SysRole> getList(SysRoleExample ex) throws Exception;

	public List<SysRoleRight> getRoleRight(String roleId) throws Exception;
}
