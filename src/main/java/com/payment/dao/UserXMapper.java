package com.payment.dao;

import com.payment.util.PageData;

public interface UserXMapper {
	void saveU(PageData pd);
	void deleteAllU(String UserId);
	PageData findByUiId(String UserId);
	void editU(PageData UserId);
}