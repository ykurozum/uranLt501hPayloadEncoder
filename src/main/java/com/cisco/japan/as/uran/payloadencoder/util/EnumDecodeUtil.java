package com.cisco.japan.as.uran.payloadencoder.util;

import java.util.HashMap;
import java.util.Map;

import com.cisco.japan.as.uran.payloadencoder.constants.IEnumDecodable;


public class EnumDecodeUtil<K, V extends IEnumDecodable<K>> {

	private Map<K, V> map;

	/**
	 * コード定義デコードするためのユーティリティクラス
	 * 
	 * @param values Enum定義
	 */
	private EnumDecodeUtil(V[] values) {
		map = new HashMap<K, V>(values.length);

		for (V value : values) {
			V old = map.put(value.getCode(), value);

			if (old != null) {
				throw new IllegalArgumentException("duplicated code: " + value);
			}
		}
	}

	/**
	 *  コード返却
	 * 
	 * @param code コード 
	 * @return
	 */
	public V decode(K code) {
		return map.get(code);
	}

	/**
	 * Mapの作成
	 * 
	 * @param values Enum定義
	 * @return EnumDecodeUtil
	 */
	public static <K1, V1 extends IEnumDecodable<K1>> EnumDecodeUtil<K1, V1> create(
			V1[] values) {
		return new EnumDecodeUtil<K1, V1>(values);
	}
}