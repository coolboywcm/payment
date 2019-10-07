package com.payment.service.menu;

import java.util.List;

import com.payment.dto.Menu;
import com.payment.model.SysMenu;
import com.payment.model.SysRole;

public interface IMenuSV {

	List<SysMenu> getAllMenu();

	List<SysMenu> getParentMenu();

	List<Menu> getSubMenu(String parentId) throws Exception;

	List<Menu> getMenuTree(String qx) throws Exception;

	List<Menu> getMenuTreeByRoleId(SysRole role) throws Exception;

}