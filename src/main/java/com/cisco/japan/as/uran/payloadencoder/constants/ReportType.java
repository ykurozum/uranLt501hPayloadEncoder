package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;
import com.cisco.japan.as.uran.payloadencoder.util.EnumNameResolveUtil;

public enum ReportType implements IEnumResolvable<String>,IEnumDecodable<String> {

	/** Ping report */
	PING_REPORT("1","Ping report"), 
	/** Periodic mode repport */
	PERIODIC_MODE_REPORT("2","Periodic mode repport"), 
	/** Motion mode static report */
	MOTION_MODE_STATIC_REPORT("4","Motion mode static report"),
	/** Motion mode moving report */
	MOTION_MODE_MOVING_REPORT("5","Motion mode moving report"),
	/** Motion mode static to moving report */
	MOTION_MODE_SATIC_TO_MOVING_REPORT("6","Motion mode static to moving report"),
	/** Motion mode moving to static report */
	MOTION_MODE_MOVING_TO_STATIC_REPORT("7","Motion mode moving to static report"),
	/** Low battery alarm report */
	LOW_BATTERY_ALARM_REPORT("15","Low battery alarm report"),
	/** Power on(temperature) */
	POWER_ON_TEMPERATURE("17","Power on(temperature)"),
	/** Power off(low battery) */
	POWER_OFF_LOW_BATTERY("19","Power off(low battery)"),
	/** Power off(temperature) */
	POWER_OFF_TEMPERATURE("20","Power off(temperature)"),
	/** External GPS antenna fall report */
	EXTERNAL_GPS_ANTENNA_FAIL_REPORT("25","External GPS antenna fall report");
	
	/** コード値 */
	private String code;

	/** タグ名称 */
	private String tagName;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, ReportType> decoder = EnumDecodeUtil.create(values());

	/** Nameリゾルバ */
	private static final EnumNameResolveUtil<String, ReportType> nameResolver = EnumNameResolveUtil.create(values());
	/**
	 *
	 * コンストラクタ
	 *
	 * @param code
	 *            コード値
	 * @param tagName
	 *            タグ名称
	 */
	private ReportType(String code, String tagName) {
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
	public static ReportType decode(String code) {
		return decoder.decode(code);
	}

	/**
	 *
	 * ENUM名からコード定義を取得する
	 *
	 * @param name ENUM.name()
	 * @return ENUM
	 */
	public static ReportType nameResolve(String name) {
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
