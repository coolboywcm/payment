package com.payment.frame.dynasql;

import java.io.Serializable;
import java.util.Map;

/**
 * FxRow
 *
 * @author mysh
 * @since 2015/8/25
 */
public class SqlRow implements Serializable {
	private static final long serialVersionUID = 8224277890360786034L;

	private int id;
	private Map<String, ?> cell;

	public SqlRow(int id, Map<String, ?> row) {
		this.id = id;
		this.cell = row;
	}

	public Map<String, ?> getCell() {
		return cell;
	}

	public SqlRow setCell(Map<String, ?> cell) {
		this.cell = cell;
		return this;
	}

	public int getId() {
		return id;
	}

	public SqlRow setId(int id) {
		this.id = id;
		return this;
	}
}
