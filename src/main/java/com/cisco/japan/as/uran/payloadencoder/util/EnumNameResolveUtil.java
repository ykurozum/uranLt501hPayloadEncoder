package com.cisco.japan.as.uran.payloadencoder.util;

import java.util.HashMap;
import java.util.Map;

import com.cisco.japan.as.uran.payloadencoder.constants.IEnumResolvable;

/**
 *
 * enum名を解決するためのユーティリティクラス
 *
 */
public class EnumNameResolveUtil<K, V extends IEnumResolvable<K>> {

	private Map<K, V> map;

	/**
	 * 定義をMapに詰め込む処理
	 * 
	 * @param values Enum定義
	 */
	private EnumNameResolveUtil(V[] values) {
		map = new HashMap<K, V>(values.length);

		for (V value : values) {
			V old = map.put(value.name(), value);

			if (old != null) {
				throw new IllegalArgumentException("duplicated name: " + value);
			}
		}
	}

	/**
	 * コードの返却
	 * 
	 * @param code コード値
	 * @return code
	 */
	public V resolve(K code) {
		return map.get(code);
	}

	/**
	 * 	 Mapの作成
	 * 
	 * @param values Enum定義
	 * @return EnumNameResolveUtil
	 */
	public static <K1, V1 extends IEnumResolvable<K1>> EnumNameResolveUtil<K1, V1> create(V1[] values) {
		return new EnumNameResolveUtil<K1, V1>(values);
	}
}
