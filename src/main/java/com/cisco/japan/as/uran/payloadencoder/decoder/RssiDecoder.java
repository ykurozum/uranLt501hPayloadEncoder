package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class RssiDecoder {
	
	/**
	 * RSSIデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return RSSI
	 */
	public static String decodeRssi(String hexStr) {
		
		// 10進数へ変換
		return String.valueOf(CommonUtils.toDecimalNumber(hexStr));
		
	}
}
