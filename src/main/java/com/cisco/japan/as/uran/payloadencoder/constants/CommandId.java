package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum CommandId implements IEnumDecodable<String> {

	/** TrackingReport */
	TRACKING_REPORT("1002"),
	/** TracKingReport(Short) */
	TRACKING_REPORT_S("83"),
	/** HelpReport */
	HELP_REPORT("0b00"),
	/** HelpReport(Short) */
	HELP_REPORT_S("01"),
	/** BeaconReport:TrackingReport */
	BEACON_REPORT_T("1302"),
	/** BeaconReport:HelpReport */
	BEACON_REPORT_H("0700");

	/** コード値 */
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, CommandId> decoder = EnumDecodeUtil.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code コード値
	 */
	private CommandId(String code) {
		this.code = code;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static CommandId decode(String code) {
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
