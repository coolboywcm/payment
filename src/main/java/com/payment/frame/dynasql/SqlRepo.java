package com.payment.frame.dynasql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.payment.dto.common.Page;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

/**
 * SqlRepo
 *
 * @author mysh
 * @since 2016/1/21
 */
public class SqlRepo {
	private static final Logger log = LoggerFactory.getLogger(SqlRepo.class);

	private final Map<String, String> repo = new HashMap<String, String>();
	private NamedParamQueryImpl jdbc;
	private DictRepo dictRepo;
	private EnumSet<KeyStrategy> keyStrategies = EnumSet.of(KeyStrategy.UPPER_CASE);

	public void setMapperLocations(Resource[] locations) throws IOException {
		if (locations != null) {
			for (Resource res : locations) {
				InputStream is = res.getInputStream();
				loadSqlFile(is);
			}
		}
	}

	public SqlRepo setDictRepo(DictRepo dictRepo) {
		this.dictRepo = dictRepo;
		return this;
	}

	public NamedParamQueryImpl getJdbc() {
		return jdbc;
	}

	public void setJdbc(NamedParamQueryImpl jdbc) {
		this.jdbc = jdbc;
	}

	/**
	 * keyStrategies used only in fetch <code>list&lt;map&gt;</code>
	 */
	public SqlRepo setKeyStrategies(KeyStrategy... ks) {
		this.keyStrategies.clear();
		if (ks != null) {
			for (KeyStrategy k : ks) {
				this.keyStrategies.add(k);
			}
		}
		return this;
	}

	public KeyStrategy[] getKeyStrategies() {
		return keyStrategies.toArray(new KeyStrategy[keyStrategies.size()]);
	}

	private void loadSqlFile(InputStream is) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String line, id = null;
		StringBuilder sb = null;
		while (true) {
			line = in.readLine();
			if (line != null) line = line.trim();

			if (line == null || line.startsWith("--!")) { // sql sep
				if (id != null) {
					if (sb.charAt(sb.length() - 1) == ';')
						sb.deleteCharAt(sb.length() - 1);
					String sql = sb.toString();
					String old = repo.put(id, sql);
					if (old != null)
						throw new RuntimeException("duplicated sql: " + id);
					log.debug("repo-put: [" + id + "] " + sql);
				}

				if (line == null) return;
				if (Strings.isBlank(line)) continue;
				id = line.substring(3).trim();
				sb = new StringBuilder();
			} else if (!line.startsWith("--")) { // non comment
				int commentIdx = line.indexOf("--");
				if (commentIdx > -1)
					line = line.substring(0, commentIdx).trim();
				if (line.length() > 0)
					sb.append(' ').append(line);
			}
		}
	
	}

	@PostConstruct
	public void validate() {
		if(jdbc == null){
			throw new RuntimeException("jdbc template should not be null");
		}
		//Objects.requireNonNull(jdbc, "");
	}

	/**
	 * 从配置的 sql 创建 SqlHelper
	 *
	 * @param sqlId 配置的 sql 语句 id
	 */
	SqlHelper create(String sqlId) {
		String querySql = repo.get(sqlId);
		if (querySql == null)
			throw new RuntimeException(sqlId + " undefined");
		return SqlHelper.create(jdbc, querySql);
	}

	/**
	 * 从 sql 配置取查询结果.
	 *
	 * @param sqlId  配置的 sql 语句 id
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public List<Map<String, Object>> fetchByConfig(String sqlId, Map<String, ?> params,
	                                               SqlCondition cond) throws Exception {
		SqlHelper sqlHelper = create(sqlId).appendParams(params).appendCond(cond);
		List<Map<String, Object>> result = sqlHelper.fetch(keyStrategies);
		for (Map<String, Object> map : result){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null)
					if ((entry.getValue() instanceof Long) || (entry.getValue() instanceof BigDecimal))
					entry.setValue(entry.getValue().toString());
			}
		}
		return result;
	}

	/**
	 * 从 sql 配置取查询结果.
	 *
	 * @param sqlId  配置的 sql 语句 id
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 * @param type   返回结果封装类型
	 */
	public <T> List<T> fetchByConfig(String sqlId, Map<String, ?> params,
	                                 SqlCondition cond, Class<T> type) throws Exception {
		SqlHelper sqlHelper = create(sqlId).appendParams(params).appendCond(cond);
		return sqlHelper.fetch(type);
	}

	/**
	 * 从 sql 取查询结果.
	 *
	 * @param sql    sql 语句
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public List<Map<String, Object>> fetchBySql(String sql, Map<String, ?> params,
	                                            SqlCondition cond) throws Exception {
		SqlHelper sqlHelper = new SqlHelper(this.jdbc, new StringBuilder(sql), null)
						.appendParams(params).appendCond(cond);
		List<Map<String, Object>> result = sqlHelper.fetch(keyStrategies);
		for (Map<String, Object> map : result){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null)
					if ((entry.getValue() instanceof Long) || (entry.getValue() instanceof BigDecimal))
					entry.setValue(entry.getValue().toString());
			}
		}
		return result;
	}
	
	/**
	 * 从 sql 分页取查询结果.
	 *
	 * @param sql    sql 语句
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public List<Map<String, Object>> fetchBySql(String sql, Map<String, ?> params,
	                                            SqlCondition cond,Page page) throws Exception {
		if(page!=null){
			int total = this.fetchTotalBySql(sql.toString(), params, cond);
			page.setTotalResult(total);
			cond.page(page.getCurrentPage(), page.getShowCount());
		}
		return this.fetchBySql(sql.toString(), params, cond);
	}

	/**
	 * 从 sql 取查询结果.
	 *
	 * @param sql    sql 语句
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 * @param type   返回结果封装类型
	 */
	public <T> List<T> fetchBySql(String sql, Map<String, ?> params,
	                              SqlCondition cond, Class<T> type) throws Exception {
		SqlHelper sqlHelper = new SqlHelper(this.jdbc, new StringBuilder(sql), null)
						.appendParams(params).appendCond(cond);
		return sqlHelper.fetch(type);
	}

	/**
	 * 从 sql 取数值结果. 返回第一条结果第一列的值, 没有结果则返回 null.
	 *
	 * @param sql    sql 语句
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public <T extends Number> T fetchNumberBySql(String sql, Map<String, ?> params,
	                                             SqlCondition cond) throws Exception {
		List<Map<String, Object>> r = fetchBySql(sql, params, cond);
		if (r != null && r.size() > 0) {
			Iterator<Map.Entry<String, Object>> it = r.get(0).entrySet().iterator();
			return (T) it.next().getValue();
		} else
			return null;
	}

	/**
	 * 从 sql 取总记录数统计.
	 *
	 * @param sql    sql 语句
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public int fetchTotalBySql(String sql, Map<String, ?> params,
	                                             SqlCondition cond) throws Exception {
		StringBuffer countSql = new StringBuffer();
		countSql.append(" select count(1) as value from ( ").append(sql).append(" ) as a ");
		List<Map<String, Object>> r = fetchBySql(countSql.toString(), params, cond);
		if (r != null && !r.isEmpty()) {
			return Integer.parseInt(r.get(0).get("value").toString());
		}
	   return 0;
	}
	
	/**
	 * 从 sql 取数值结果. 返回第一条结果第一列的值, 没有结果则返回 null.
	 *
	 * @param sqlId  配置的 sql 语句 id
	 * @param params sql 参数, 可 null
	 * @param cond   外部条件, 可 null
	 */
	public <T extends Number> T fetchNumberByConfig(String sqlId, Map<String, ?> params,
	                                                SqlCondition cond) throws Exception {
		List<Map<String, Object>> r = fetchByConfig(sqlId, params, cond);
		if (r != null && r.size() > 0) {
			Iterator<Map.Entry<String, Object>> it = r.get(0).entrySet().iterator();
			return (T) it.next().getValue();
		} else
			return null;
	}

	/**
	 * 从 sql 配置取查询结果.
	 *
	 * @param sqlId   配置的 sql 语句 id
	 * @param params  sql 参数, 可 null
	 * @param cond    外部条件, 可 null
	 * @param dictMap 字典配置, 属性名->字典key
	 */
	public List<Map<String, Object>> fetchByConfig(String sqlId, Map<String, ?> params,
	                                               SqlCondition cond, Map<String, String> dictMap) throws Exception {
		SqlHelper sqlHelper = create(sqlId).appendParams(params).appendCond(cond);
		handleDict(sqlHelper, dictMap);
		List<Map<String, Object>> result = sqlHelper.fetch(keyStrategies);
		for (Map<String, Object> map : result){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null)
					if ((entry.getValue() instanceof Long) || (entry.getValue() instanceof BigDecimal))
					entry.setValue(entry.getValue().toString());
			}
		}
		return result;
	}

	/**
	 * 从 sql 取查询结果.
	 *
	 * @param sql     sql 语句
	 * @param params  sql 参数, 可 null
	 * @param cond    外部条件, 可 null
	 * @param dictMap 字典配置, 属性名->字典key
	 */
	public List<Map<String, Object>> fetchBySql(String sql, Map<String, ?> params,
	                                            SqlCondition cond, Map<String, String> dictMap) throws Exception {
		SqlHelper sqlHelper = new SqlHelper(this.jdbc, new StringBuilder(sql), null)
						.appendParams(params).appendCond(cond);
		handleDict(sqlHelper, dictMap);
		List<Map<String, Object>> result = sqlHelper.fetch(keyStrategies);
		for (Map<String, Object> map : result){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null)
					if ((entry.getValue() instanceof Long) || (entry.getValue() instanceof BigDecimal))
					entry.setValue(entry.getValue().toString());
			}
		}
		return result;
	}

	private void handleDict(SqlHelper sqlHelper, final Map<String, String> dictMap) {
		if (dictMap != null) {
			if (keyStrategies.contains(KeyStrategy.CAMEL)) {
				Map<String, String> tMap = new HashMap<String, String>();
				for (Map.Entry<String, String> e : dictMap.entrySet()) {
					tMap.put(CodeUtil.underline2FieldCamel(e.getKey()), e.getValue());
				}
				dictMap.clear();
				dictMap.putAll(tMap);
			}

			sqlHelper.onResult(new ResultHandler() {
				@Override
				public void handle(Map<String, Object> item) {
					for (Map.Entry<String, String> m : dictMap.entrySet()) {
						String col = m.getKey();
						String dictKey = m.getValue();
						Object itemValue = item.get(col);

						if (itemValue != null && dictRepo != null) {
							String desc = dictRepo.getDesc(dictKey, itemValue);
							if (desc != null) {
								item.put(col, desc);
							}
							item.put(col + "Code", itemValue);
						}
					}
				}
			});
		}
	}

}
