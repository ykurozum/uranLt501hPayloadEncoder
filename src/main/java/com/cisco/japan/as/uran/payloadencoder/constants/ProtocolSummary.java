package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum ProtocolSummary implements IEnumDecodable<String> {

	/** TrackingReport */
	TRACKING_REPORT("0c1002"),
	/** TrackingRport(Short) */
	TRACKING_REPORT_S("8083"),
	/** HelpReport */
	HELP_REPORT("0c0b00"),
	/** HelpReport(Short) */
	HELP_REPORT_S("8001"),
	/** BeaconReport:TrackingReport */
	BEACON_REPORT_T("0c1302"),
	/** BeaconReport:HelpReport */
	BEACON_REPORT_H("0c0700");

	/** コード値 */
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, ProtocolSummary> decoder = EnumDecodeUtil.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code コード値
	 */
	private ProtocolSummary(String code) {
		this.code = code;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static ProtocolSummary decode(String code) {
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
