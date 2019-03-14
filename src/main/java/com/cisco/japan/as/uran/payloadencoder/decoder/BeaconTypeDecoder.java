package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.constants.BeaconType;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class BeaconTypeDecoder {

	/** ステータス算出時の値 */
	private static final int DIVISION_VALUE = 32;

	/**
	 * BeaconTypeデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return beaconType
	 */
	public static String decodeBeaconType(String hexStr) {

		String beaconType = null;

		// BeaconType取得用の計算
		long dNum = CommonUtils.toDecimalNumber(hexStr);
		String dNumStr = String.valueOf(dNum % DIVISION_VALUE);

		// BeaconType取得
		beaconType = getBeaconType(dNumStr);

		return beaconType;
	}

	/**
	 * BeaconTypeの取得処理
	 * 
	 * @param dNumStr BeaconType取得用の値
	 * @return beaconTYpe
	 */
	public static String getBeaconType(String dNumStr) {

		// 初期値；unknown
		String beaconType = UnknownStatus.UNKNOWN_BEACON_TYPE.getCode();

		// 定義済みのBeaconTypeに一致するものを取得
		for (BeaconType beaconTypeVal : BeaconType.values()) {
			if (beaconTypeVal.getCode().equals(dNumStr)) {
				beaconType = beaconTypeVal.getTagName();
			}
		}

		return beaconType;
	}
}
