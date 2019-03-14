package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum UnknownStatus implements  IEnumDecodable<String> {

	/** unknown Protocol */
	UNKNOWN_PROTOCOL("unknown Protocol"), 
	/** unknown Beacon Type */
	UNKNOWN_BEACON_TYPE("unknown Beacon Type"),
	/** unknown Report Type */
	UNKNOWN_REPORT_TYPE("unknown Report Type"),
	/** unknown GPS Fix Status */
	UNKNOWN_GPS_FIX_STATUS("unknown GPS Fix Status"),
	/** unknown Alarm Type */
	UNKNOWN_ALARM_TYPE("unknown Alarm Type"),
	/** unknown Format */
	UNKNOWN_FORMAT("unknown Format");
	
	/** コード値 */
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, UnknownStatus> decoder = EnumDecodeUtil.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code
	 *            コード値
	 */
	private UnknownStatus(String code) {
		this.code = code;
	}

	/**
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static UnknownStatus decode(String code) {
		return decoder.decode(code);
	}

	/**
	 * codeを取得します。
	 *
	 * @return コード値
	 */
	public String getCode() {
		return code;
	}

}
