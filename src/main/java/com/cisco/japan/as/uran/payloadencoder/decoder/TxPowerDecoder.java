package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class TxPowerDecoder {

	/**
	 * TxPowerデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return TxPower
	 */
	public static String decodeTxPower(String hexStr) {

		// 10進数へ変換
		return String.valueOf(CommonUtils.toDecimalNumber(hexStr));

	}
}
