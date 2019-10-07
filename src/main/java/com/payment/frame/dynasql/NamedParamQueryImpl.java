package com.payment.frame.dynasql;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Map;

/**
 * NamedParamQueryImpl
 *
 * @author mysh
 * @since 2015/8/25
 */
public class NamedParamQueryImpl implements NamedParamQuery {
	private NamedParameterJdbcOperations jdbcTemplate;

	public NamedParamQueryImpl setJdbcTemplate(NamedParameterJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		return this;
	}

	public NamedParameterJdbcOperations getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql, Map<String, ?> params) {
		return jdbcTemplate.queryForList(sql, params);
	}

	@Override
	public int queryForInt(String sql, Map<String, ?> params) {
		return jdbcTemplate.queryForInt(sql, params);
	}

	@Override
	public long queryForLong(String sql, Map<String, ?> params) {
		return jdbcTemplate.queryForLong(sql, params);
	}
}
