package com.cisco.japan.as.uran.payloadencoder.constants;

import com.cisco.japan.as.uran.payloadencoder.util.EnumDecodeUtil;

public enum BeaconId implements IEnumDecodable<String> {

	/** iBeacon UUID */
	IBEACON_UUID("iBeacon UUID"),
	/** iBeacon Major ID */
	IBEACON_MAJOR_ID("iBeacon Major ID"),
	/** Beacon Minor ID */
	IBEACON_MINOR_ID("Beacon Minor ID"),
	/** Eddystone Beacon ID */
	EDDYSTONE_BEACON_ID("Eddystone Beacon ID"),
	/** ALTBeacon ID */
	ALTBEACON_ID("ALTBeacon ID");

	/** コード値 */
	private String code;

	/** コードデコーダ */
	private static final EnumDecodeUtil<String, BeaconId> decoder = EnumDecodeUtil.create(values());

	/**
	 *
	 * コンストラクタ
	 *
	 * @param code コード値
	 */
	private BeaconId(String code) {
		this.code = code;
	}

	/**
	 *
	 * コード値からコード定義を取得する
	 *
	 * @param code コード値
	 * @return コード定義
	 */
	public static BeaconId decode(String code) {
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
