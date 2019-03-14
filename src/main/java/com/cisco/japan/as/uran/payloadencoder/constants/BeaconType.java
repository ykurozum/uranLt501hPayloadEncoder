package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;
import com.cisco.japan.as.uran.payloadencoder.util.EnumNameResolveUtil;

public enum BeaconType implements IEnumResolvable<String>,IEnumDecodable<String> {

	/** Beacon not available */
	BEACON_NOT_AVAILABLE("0","Beacon not available"), 
	/** iBeacon */	
	IBEACON("1","iBeacon"), 
	/** Eddystone Beacon */	
	EDDYSOTNE_BEACON("2","Eddystone Beacon"),
	/** ALT Beacon */	
	ALT_BEACON("3","ALT Beacon");
	
	/** コード値 */
	private String code;

	/** タグ名称 */
	private String tagName;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, BeaconType> decoder = EnumDecodeUtil.create(values());

	/** Nameリゾルバ */
	private static final EnumNameResolveUtil<String, BeaconType> nameResolver = EnumNameResolveUtil.create(values());
	/**
	 *
	 * コンストラクタ
	 *
	 * @param code
	 *            コード値
	 * @param tagName
	 *            タグ名称
	 */
	private BeaconType(String code, String tagName) {
		this.code = code;
		this.tagName = tagName;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static BeaconType decode(String code) {
		return decoder.decode(code);
	}

	/**
	 *
	 * ENUM名からコード定義を取得する
	 *
	 * @param name ENUM.name()
	 * @return ENUM
	 */
	public static BeaconType nameResolve(String name) {
		return nameResolver.resolve(name);
	}

	/**
	 * codeを取得します。
	 *
	 * @return コード値
	 */
	public String getCode() {
		return code;
	}

	/**
	 * tagNameを取得します。
	 *
	 * @return タグ名称
	 */
	public String getTagName() {
		return tagName;
	}
}
