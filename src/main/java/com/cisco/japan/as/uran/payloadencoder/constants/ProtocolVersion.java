package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum ProtocolVersion implements IEnumDecodable<String> {
	
	/** TrackingReport */
	TRACKING_REPORT("0c"), 
	/** TrackingRport(Short) */
	TRACKING_REPORT_S("80"), 
	/** HelpReport */
	HELP_REPORT("0c"), 
	/** HelpReport(Short) */
	HELP_REPORT_S("80"), 
	/** BeaconReport:TrackingReport */
	BEACON_REPORT_T("0c"),
	/** BeaconReport:HelpReport */
	BEACON_REPORT_H("0c");

	/** コード値 */
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, ProtocolVersion> decoder = EnumDecodeUtil.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code コード値
	 */
	private ProtocolVersion(String code) {
		this.code = code;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static ProtocolVersion decode(String code) {
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
