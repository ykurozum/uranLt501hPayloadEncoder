package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.constants.ReportType;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;

public class ReportTypeDecoder {

	/** ステータス算出時の値 */
	private static final int DIVISION_VALUE = 32;

	/**
	 * ReportTypeデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @return reportTypes
	 */
	public static String decodeReportType(String hexStr) {

		String reportType = null;

		// ReportType取得用の計算
		long dNum = CommonUtils.toDecimalNumber(hexStr);
		String dNumStr = String.valueOf(dNum % DIVISION_VALUE);

		// ReportType取得
		reportType = getReportType(dNumStr);

		return reportType;
	}

	/**
	 * ReportTypeの取得処理
	 * 
	 * @param dNumStr ReportType取得用の値
	 * @return reportType
	 */
	public static String getReportType(String dNumStr) {

		// 初期値:unknown
		String reportType = UnknownStatus.UNKNOWN_REPORT_TYPE.getCode();

		// 定義済みのReportTypeに一致するものを取得
		for (ReportType reportTypeVal : ReportType.values()) {
			if (reportTypeVal.getCode().equals(dNumStr)) {
				reportType = reportTypeVal.getTagName();
			}
		}

		return reportType;

	}
}
