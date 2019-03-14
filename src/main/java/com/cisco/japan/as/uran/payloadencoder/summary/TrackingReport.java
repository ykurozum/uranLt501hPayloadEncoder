package com.cisco.japan.as.uran.payloadencoder.summary;

import com.cisco.japan.as.uran.payloadencoder.constants.NodeElements;
import com.cisco.japan.as.uran.payloadencoder.constants.ProtocolSummary;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.decoder.BatteryCapacityDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.CoordinateDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.DateTimeDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.GpsFixStatusDecoder;
import com.cisco.japan.as.uran.payloadencoder.decoder.ReportTypeDecoder;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TrackingReport {

	/** protocol部のlength */
	private static final int PROTOCOL_LENGTH = 6;
	/** 最大長 */
	private static final int MAX_LENGTH = 34;

	/**
	 * TrackingReportデコード処理
	 * 
	 * @param payloadObject JSONオブジェクト
	 * @param hexStr        デコード用文字列
	 */
	public static void decodeTrackingReport(ObjectNode payloadObject, String hexStr) {

		// protocol詰め
		CommonUtils.packingJson(payloadObject, NodeElements.PROTOCOL.getCode(),
				ProtocolSummary.TRACKING_REPORT.getCode());

		// hexStrのlengthチェック
		if (CommonUtils.checkPayloadLength(hexStr, MAX_LENGTH)) {

			// protocol部以降を切りだし
			hexStr = hexStr.substring(PROTOCOL_LENGTH);

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

			// BatteryCapacity変換
			String baatteryCapacity = BatteryCapacityDecoder.decodeBatteryCapacity(hexStr.substring(18, 20));
			CommonUtils.packingJson(payloadObject, NodeElements.BATTERY_CAPACITY.getCode(), baatteryCapacity);

			// Date&Time変換
			String DateTime = DateTimeDecoder.decodeDateTime(hexStr.substring(20, 28));
			CommonUtils.packingJson(payloadObject, NodeElements.DATE_AND_TIME.getCode(), DateTime);

		} else { // error

			CommonUtils.packingJson(payloadObject, NodeElements.ERROR.getCode(),
					UnknownStatus.UNKNOWN_FORMAT.getCode());

		}
	}
}
