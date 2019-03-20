package com.cisco.japan.as.uran.payloadencoder.decoder;

import java.math.BigInteger;
import java.util.Date;

import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class DateTimeDecoder {

	/** 日付を算出する際の倍率 */
	private static final long RATIO = 1000;

	/**
	 * DateTimeデコード処理
	 * 
	 * @param hexstr デコード用文字列
	 * @return isoDate デコード後のDate&Time
	 */
	public static Date decodeDateTime(String hexstr) {

		// 10進数へ変換
		BigInteger tmpVal = new BigInteger(hexstr, 16);

		// リトルエンディアン変換
		int littleVal = CommonUtils.toLittleEndian(tmpVal);

		// リトルエンディアン変換後の値を16進数に変換
		String littleValStr = BigInteger.valueOf(littleVal).toString(16);

		// 10進数へ変換
		long dateTime = CommonUtils.toDecimalNumber(littleValStr);
		Date date = new Date();
		date.setTime(dateTime * RATIO);

		return date;
	}

}
