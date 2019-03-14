package com.cisco.japan.as.uran.payloadencoder.decoder;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class DateTimeDecoder {

	/** 日付を算出する際の倍率 */
	private static final long RATIO = 1000;

	/**
	 * DateTimeデコード処理
	 * 
	 * @param hexstr デコード用文字列
	 * @return DateTime
	 */
	public static String decodeDateTime(String hexstr) {

		// 10進数へ変換
		BigInteger tmpVal = new BigInteger(hexstr, 16);

		// TODO payloadencodeへいどう
		// リトルエンディアン変換
		ByteBuffer buf = ByteBuffer.allocate(4);
		buf.putInt(tmpVal.intValue());
		buf.flip();
		buf.order(ByteOrder.LITTLE_ENDIAN);
		int littleVal = buf.getInt();

		// リトルエンディアン変換後の値を16進数に変換
		String littleValStr = BigInteger.valueOf(littleVal).toString(16);

		// 10進数へ変換
		long dateTime = CommonUtils.toDecimalNumber(littleValStr);
		Date date = new Date();
		date.setTime(dateTime * RATIO);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");

		// 日付を算出
		return sdf.format(date).toString();
	}

}
