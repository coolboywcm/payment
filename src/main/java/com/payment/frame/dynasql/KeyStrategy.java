package com.payment.frame.dynasql;

/**
 * 取数据为 map 时 key 策略.
 */
public enum KeyStrategy {
	/**
	 * key is converted to upper case
	 */
	UPPER_CASE,
	/**
	 * key is converted upper case, then camel case.
	 */
	CAMEL
}
