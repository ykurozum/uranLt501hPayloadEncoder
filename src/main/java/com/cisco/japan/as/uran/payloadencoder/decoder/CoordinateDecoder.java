package com.cisco.japan.as.uran.payloadencoder.decoder;

import java.math.BigInteger;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class CoordinateDecoder {

	/** 座標を算出する際の倍率 */
	private static final double RATIO = 0.000001;

	/**
	 * 座標(緯度・経度)デコード処理
	 * 
	 * @param hexstr デコード用文字列
	 * @return Coordinate
	 */
	public static String decodeCoordinate(String hexstr) {

		// 10進数へ変換
		BigInteger tmpVal = new BigInteger(hexstr, 16);

		// リトルエンディアン変換
		int littleVal = CommonUtils.toLittleEndian(tmpVal);

		// リトルエンディアン変換後の値を16進数に変換
		String littleValStr = BigInteger.valueOf(littleVal).toString(16);

		// 10進数へ変換
		// long coorDinate = Long.parseLong(littleValStr, 16);
		long coorDinate = CommonUtils.toDecimalNumber(littleValStr);

		// 座標を算出
		return String.valueOf((double) coorDinate * RATIO);
	}

}
