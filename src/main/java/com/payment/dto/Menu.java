package com.payment.dto;

import java.util.List;

import com.payment.model.SysMenu;

public class Menu extends SysMenu {
	private SysMenu parentMenu;
	private List<Menu> subMenuList;
	private boolean hasMenu = true;

	public SysMenu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(SysMenu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
}
