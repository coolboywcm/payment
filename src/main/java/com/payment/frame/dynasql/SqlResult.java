package com.payment.frame.dynasql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * FxResult
 *
 * @author mysh
 * @since 2015/8/25
 */
public class SqlResult implements Serializable {
	private static final long serialVersionUID = 1502123858699489219L;

	private int page;
	private int total;
	private List<SqlRow> rows;

	public SqlResult(int page, int total, List<Map<String, Object>> rows) {
		this.page = page;
		this.total = total;
		if (rows == null || rows.size() == 0)
			this.rows = Collections.emptyList();
		else {
			this.rows = new ArrayList<SqlRow>();
			int id = 0;
			for (Map<String, ?> row : rows) {
				this.rows.add(new SqlRow(id++, row));
			}
		}
	}

	// ========= get and set ==========


	public int getPage() {
		return page;
	}

	public SqlResult setPage(int page) {
		this.page = page;
		return this;
	}

	public List<SqlRow> getRows() {
		return rows;
	}

	public SqlResult setRows(List<SqlRow> rows) {
		this.rows = rows;
		return this;
	}

	public int getTotal() {
		return total;
	}

	public SqlResult setTotal(int total) {
		this.total = total;
		return this;
	}
}
