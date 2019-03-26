package com.cisco.japan.as.uran.payloadencoder.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cisco.japan.as.uran.payloadencoder.DecodedPayload;
import com.cisco.japan.as.uran.payloadencoder.EncodedPayload;
import com.cisco.japan.as.uran.payloadencoder.bean.HelpRepaortBean;
import com.cisco.japan.as.uran.payloadencoder.bean.TrackingReportBean;
import com.cisco.japan.as.uran.payloadencoder.constants.NodeElements;
import com.cisco.japan.as.uran.payloadencoder.constants.ProtocolSummary;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.summary.BeaconHelpReport;
import com.cisco.japan.as.uran.payloadencoder.summary.BeaconTrackingReport;
import com.cisco.japan.as.uran.payloadencoder.summary.HelpReport;
import com.cisco.japan.as.uran.payloadencoder.summary.HelpReportShort;
import com.cisco.japan.as.uran.payloadencoder.summary.TrackingReport;
import com.cisco.japan.as.uran.payloadencoder.summary.TrackingReportShort;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/** テスト用クラス */
public class Test {

	public static void main(String[] args) throws Exception {

		// 現在日時を取得
		Date date = new Date();

		// 日時,デコード用文字列(payload_hex),DeviceIdentifyerを入力
		EncodedPayload test1 = new EncodedPayload(date, "0c1002dbc43d0763737d012264A4989659", "test1");
		EncodedPayload test2 = new EncodedPayload(date, "0c100295967e08ffb09a02025a5813825c", "test2");
		EncodedPayload test3 = new EncodedPayload(date, "0c130272cb10575ab647568f3e113c29eda2de0000000022bfc55a",
				"test3");
		EncodedPayload test4 = new EncodedPayload(date, "0c070072cb10575ab647568f3e113c29eda2de0000000021b3c55f",
				"test4");

		// リストに追加していく
		List<EncodedPayload> str = new ArrayList<EncodedPayload>();
		str.add(test1);
		str.add(test2);
//		str.add(test3);
//		str.add(test4);

		// encodeを呼び出す(Lt501hPayloadEncoderと同じ処理)
		List<DecodedPayload> decodeInfoList = encode(str);

		// 結果をリスト分出力
		for (DecodedPayload decodeInfo : decodeInfoList) {
			System.out.println("--------start--------");
			System.out.println("PayloadString:" + decodeInfo.getPayloadString());
			System.out.println("Time:" + decodeInfo.getTime());
			System.out.println("PayloadJson:" + decodeInfo.getPalyloadJson());
			System.out.println("PayloadTime:" + decodeInfo.getPayloadTime());
			System.out.println("DeviceIdentifyer:" + decodeInfo.getDeviceIdentifiyer());
			System.out.println("--------end--------");
		}

	}

	public static List<DecodedPayload> encode(List<EncodedPayload> encodedPayloadList) throws Exception {

		// ObjectMapperを作成
		ObjectMapper mapper = new ObjectMapper();

		List<DecodedPayload> decodeInfoList = new ArrayList<DecodedPayload>();
		DecodedPayload decodeInfo = null;

		for (EncodedPayload payload : encodedPayloadList) {

			ObjectNode root = mapper.createObjectNode();
			ObjectNode payloadObject = mapper.createObjectNode();

			// payloadStringからpayload_hexを取得
			String hexStr = payload.getPayloadString();

			if (hexStr.startsWith(ProtocolSummary.TRACKING_REPORT.getCode())) { // protocol:0c1002

				// TrackingReport:peyload_hexを変換
				TrackingReportBean trBean = new TrackingReportBean();
				TrackingReport.decodeTrackingReport(payloadObject, hexStr, trBean);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, trBean.getDateTime());

			} else if (hexStr.startsWith(ProtocolSummary.TRACKING_REPORT_S.getCode())) { // protocol:8083

				// TrackingRport(short):peyload_hexを変換
				TrackingReportShort.decodeTrackingReportShort(payloadObject, hexStr);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, null);

			} else if (hexStr.startsWith(ProtocolSummary.HELP_REPORT.getCode())) { // protocol:0c0b00

				// HelpReport:peyload_hexを変換
				HelpRepaortBean hrBean = new HelpRepaortBean();
				HelpReport.decodeHelpReport(payloadObject, hexStr, hrBean);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, hrBean.getDateTime());

			} else if (hexStr.startsWith(ProtocolSummary.HELP_REPORT_S.getCode())) { // protocol:8001

				// HelpReport(short):peyload_hexを変換
				HelpReportShort.decodeHelpReportShort(payloadObject, hexStr);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, null);

			} else if (hexStr.startsWith(ProtocolSummary.BEACON_REPORT_T.getCode())) { // protocol:0c1302

				// BeaconTrackingReport:peyload_hexを変換
				BeaconTrackingReport.decodeBeaconTrackingReportd(payloadObject, hexStr);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, null);

			} else if (hexStr.startsWith(ProtocolSummary.BEACON_REPORT_H.getCode())) { // protocol:0c0700

				// BeaconHelpReport:peyload_hexを変換
				BeaconHelpReport.decodeBeaconHelpReport(payloadObject, hexStr);
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, null);

			} else { // unknwonProtocol

				CommonUtils.packingJson(payloadObject, NodeElements.PROTOCOL.getCode(),
						UnknownStatus.UNKNOWN_PROTOCOL.getCode());
				decodeInfo = makeDecodeInfo(root, payloadObject, payload, null);
			}

			decodeInfoList.add(decodeInfo);

		}
		return decodeInfoList;
	}

	/**
	 * デコード情報を詰め込む
	 * 
	 * @param root          Jsonのルート部分
	 * @param payloadObject Jsonの中身
	 * @param payload       Link_upTime&Payload_Hex
	 * @param dateTime      Payload内の日時
	 * @return decodeInfo デコード情報
	 */
	private static DecodedPayload makeDecodeInfo(ObjectNode root, ObjectNode payloadObject, EncodedPayload payload,
			Date payloadDateTime) {

		root.set(NodeElements.PAYLOAD_JSON.getCode(), payloadObject);
		DecodedPayload decodeInfo = new DecodedPayload(payload.getTime(), payloadDateTime, payload.getPayloadString(),
				root, payload.getDeviceIdentifiyer());

		return decodeInfo;

	}
}
