package com.payment.frame.dynasql;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DbType
 *
 * @author mysh
 * @since 2015/10/9
 */
public class DbUtil {
	private static final Logger log = LoggerFactory.getLogger(DbUtil.class);
	private static boolean isOracle;

	static {
		try {
			Properties prop = new Properties();
			
			URL url = DbUtil.class.getClassLoader().getResource("config.properties");
			if(url!=null){
				prop.load(DbUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			}else{
				prop.load(DbUtil.class.getClassLoader().getResourceAsStream("META-INF/config.properties"));
			}
				
			String dbType = prop.getProperty("db.type");
			isOracle = dbType.equalsIgnoreCase("oracle");
		} catch (IOException e) {
			log.error("load properties error.", e);
		}
	}

	public static boolean isOracle() {
		return isOracle;
	}
}
