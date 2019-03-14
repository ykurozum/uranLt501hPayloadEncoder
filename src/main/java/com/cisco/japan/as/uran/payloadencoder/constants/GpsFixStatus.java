package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;
import com.cisco.japan.as.uran.payloadencoder.util.EnumNameResolveUtil;

public enum GpsFixStatus implements IEnumResolvable<String>,IEnumDecodable<String> {
	
	/** not fix */
	NOT_FIX("0","not fix"),
	/** 2D fix */
	FIX_2D("1","2D fix"),
	/** 3D fix */
	FIX_3D("10","3D fix");

	/** コード値 */
	private String code;

	/** タグ名称 */
	private String tagName;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, GpsFixStatus> decoder = EnumDecodeUtil.create(values());

	/** Nameリゾルバ */
	private static final EnumNameResolveUtil<String, GpsFixStatus> nameResolver = EnumNameResolveUtil.create(values());
	/**
	 *
	 * コンストラクタ
	 *
	 * @param code
	 *            コード値
	 * @param tagName
	 *            タグ名称
	 */
	private GpsFixStatus(String code, String tagName) {
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
	public static GpsFixStatus decode(String code) {
		return decoder.decode(code);
	}

	/**
	 *
	 * ENUM名からコード定義を取得する
	 *
	 * @param name ENUM.name()
	 * @return ENUM
	 */
	public static GpsFixStatus nameResolve(String name) {
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