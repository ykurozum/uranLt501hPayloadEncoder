package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum NodeElements implements IEnumDecodable<String> {

	/** payload_json */
	PAYLOAD_JSON("payload_json"),
	/** protocol_version */
	PROTOCOL_VERSION("protocol_version"),
	/** command_id */
	COMMAND_ID("command_id"),
	/** protocol */
	PROTOCOL("protocol"),
	/** Longitude */
	LONGITUDE("Longitude"),
	/** Latitude */
	LATITUDE("Latitude"),
	/** GpsFixStatus */
	GPS_FIX_STATUS("GpsFixStatus"),
	/** ReportType */
	REPORT_TYPE("ReportType"),
	/** BatteryCapacity */
	BATTERY_CAPACITY("BatteryCapacity"),
	/** DateTime */
	DATE_AND_TIME("Date&Time"),
	/** AlarmType */
	AlARM_TYPE("AlarmType"),
	/** BeaconType */
	BEACON_TYPE(" BeaconType"),
	/** iBeacon UUID */
	IBEACON_UUID("iBeacon UUID"),
	/** iBeacon Major ID */
	IBEACON_MAJOR_ID("iBeacon Major ID"),
	/** iBeacon Minor ID */
	IBEACON_MINOR_ID("iBeacon Minor ID"),
	/** Eddystone Beacon ID */
	EDDYSTONE_ID("Eddystone Beacon ID"),
	/** ALTBeacon ID */
	ALT_BEACON_ID("ALTBeacon ID"),
	/** RSSi */
	RSSI("RSSI"),
	/** TxPower */
	TXPOWER("TxPower"),
	/** Error */
	ERROR("Error");
	
	

    /**　コード値 */ 
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, NodeElements> decoder = EnumDecodeUtil
			.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code
	 *            コード値
	 */
	private NodeElements(String code) {
		this.code = code;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code
	 *            コード値
	 * @return コード定義
	 */
	public static NodeElements decode(String code) {
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


