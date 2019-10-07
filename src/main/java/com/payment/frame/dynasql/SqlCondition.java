package com.payment.frame.dynasql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SqlCond
 *
 * @author mysh
 * @since 2016/1/21
 */
public class SqlCondition extends DynamicSql<SqlCondition> implements Serializable {
	private static final long serialVersionUID = 263841661021043774L;

	List<Object[]> conds = new ArrayList<Object[]>();

	public enum Op {
		bi, between, nil, in, order, group, page,andCond,condition
	}

	@Override
	public SqlCondition bi(
					String col, String op, String paramName, Object paramValue) {
		if (ignoreChk(paramValue)) return this;
		conds.add(new Object[]{Op.bi, col, op, paramName, paramValue,LinkType.AND});
		return this;
	}
	@Override
	public SqlCondition bi(LinkType link,
					String col, String op, String paramName, Object paramValue) {
		if (ignoreChk(paramValue)) return this;
		conds.add(new Object[]{Op.bi, col, op, paramName, paramValue,link});
		return this;
	}
	protected SqlCondition betweenExp(
					boolean flag, String col, String fromName, Object from, String toName, Object to) {
		if (ignoreChk(fromName, from, toName, to)) return this;
		conds.add(new Object[]{Op.between, flag, col, fromName, from, toName, to});
		return this;
	}

	protected SqlCondition nullExp(boolean flag, String col) {
		if (ignoreChk()) return this;
		conds.add(new Object[]{Op.nil, flag, col});
		return this;
	}

	protected SqlCondition inExp(boolean flag, String col, Object[] enums) {
		if (enums == null || enums.length == 0 || ignoreChk(enums)) return this;
		conds.add(new Object[]{Op.in, flag, col, enums});
		return this;
	}
	
	public SqlCondition condition(String condition) {
	    //条件
		conds.add(new Object[]{Op.condition, condition});
		return this;
	}

	protected SqlCondition orderByExp(boolean flag, String col) {
		if (ignoreChk()) return this;
		conds.add(new Object[]{Op.order, flag, col});
		return this;
	}
	
	

	public SqlCondition groupBy(String col) {
		if (ignoreChk()) return this;
		conds.add(new Object[]{Op.group, col});
		return this;
	}

	public SqlCondition page(int pageNo, int pageSize) {
		if (ignoreChk()) return this;
		conds.add(new Object[]{Op.page, pageNo, pageSize});
		return this;
	}

	/**
	 * 合并条件.
	 */
	public void merge(SqlCondition cond) {
		if (cond != null && cond.conds != null) {
			this.conds.addAll(cond.conds);
		}
	}
	
	public SqlCondition andCond(SqlCondition cond) {
		if (cond != null && cond.conds != null) {
			this.conds.add(new Object[]{Op.andCond,cond});
		}
		return this;
	}

	@Deprecated
	public final SqlCondition append(String sql, Object... params) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public final SqlCondition appendRaw(String sql) {
		throw new UnsupportedOperationException();
	}
    ///更新更新

}
