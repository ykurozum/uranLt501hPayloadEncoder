package com.cisco.japan.as.uran.payloadencoder.summary;

import com.cisco.japan.as.uran.payloadencoder.constants.NodeElements;
import com.cisco.japan.as.uran.payloadencoder.constants.ProtocolSummary;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.decoder.CoordinateDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.GpsFixStatusDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.ReportTypeDecoder;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TrackingReportShort {

	/** protocol部のlength */
	private static final int PROTOCOL_LENGTH = 4;
	/** 最大長 */
	private static final int MAX_LENGTH = 22;

	/**
	 * TrackingReport(Short)デコード処理
	 * 
	 * @param payloadObject JSONオブジェクト
	 * @param hexStr        デコード用文字列
	 */
	public static void decodeTrackingReportShort(ObjectNode payloadObject, String hexStr) {

		// hexStrのlengthチェック
		if (CommonUtils.checkPayloadLength(hexStr, MAX_LENGTH)) {

			// protocol部以降を切りだし
			hexStr = hexStr.substring(PROTOCOL_LENGTH);

			// protocol詰め
			CommonUtils.packingJson(payloadObject, NodeElements.PROTOCOL.getCode(),
					ProtocolSummary.TRACKING_REPORT.getCode());

			// 経度変換
			String longitude = CoordinateDecoder.decodeCoordinate(hexStr.substring(0, 8));
			CommonUtils.packingJson(payloadObject, NodeElements.LONGITUDE.getCode(), longitude);

			// 緯度変換
			String latitude = CoordinateDecoder.decodeCoordinate(hexStr.substring(8, 16));
			CommonUtils.packingJson(payloadObject, NodeElements.LATITUDE.getCode(), latitude);

			// GPS-FixStatus変換
			String gpsFixStatus = GpsFixStatusDecoder.decodeGpsFixStatus(hexStr.substring(16, 18));
			CommonUtils.packingJson(payloadObject, NodeElements.GPS_FIX_STATUS.getCode(), gpsFixStatus);

			// ReportType変換
			String reportType = ReportTypeDecoder.decodeReportType(hexStr.substring(16, 18));
			CommonUtils.packingJson(payloadObject, NodeElements.REPORT_TYPE.getCode(), reportType);

		} else { // error

			CommonUtils.packingJson(payloadObject, NodeElements.ERROR.getCode(),
					UnknownStatus.UNKNOWN_FORMAT.getCode());

		}
	}
}
