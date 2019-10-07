package com.payment.common.model;

public class Qx {
	private String id;
	private String roleType;
	private int edit = 0;
    private int del = 0;
    private int add = 0;
	public Qx(String id,String roleType){
		this.id = id;
		this.roleType = roleType;
		if("1".equals(roleType) || "2".equals(roleType)){
			this.edit = 1; //支付运营商
			this.del = 1;
			this.add = 1;
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}
}
