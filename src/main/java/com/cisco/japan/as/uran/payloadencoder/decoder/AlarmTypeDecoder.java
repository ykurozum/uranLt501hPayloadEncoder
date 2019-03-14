package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.constants.AlarmType;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class AlarmTypeDecoder {

	/** ステータス算出時の値 */
	private static final int DIVISION_VALUE = 32;

	/**
	 * AlarmTypeデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return alarmType
	 */
	public static String decodeAlarmType(String hexStr) {

		String alarmType = null;

		// AlarmType取得用の計算
		long dNum = CommonUtils.toDecimalNumber(hexStr);
		String dNumStr = String.valueOf(dNum % DIVISION_VALUE);

		// AlarmType取得
		alarmType = getAlarmType(dNumStr);

		return alarmType;
	}

	/**
	 * AlarmTypeの取得処理
	 * 
	 * @param dNumStr AlarmType取得用の値
	 * @return alarmType
	 */
	public static String getAlarmType(String dNumStr) {

		// 初期値:unknown
		String alarmType = UnknownStatus.UNKNOWN_ALARM_TYPE.getCode();

		// 定義済みのAlarmTypeに一致するものを取得
		for (AlarmType alarmTypeVal : AlarmType.values()) {
			if (alarmTypeVal.getCode().equals(dNumStr)) {
				alarmType = alarmTypeVal.getTagName();
			}
		}

		return alarmType;
	}
}
