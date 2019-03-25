package com.cisco.japan.as.uran.payloadencoder.GlobalSat.lt501h;

import java.util.List;

import com.cisco.japan.as.uran.payloadencoder.EncodedPayload;
import com.cisco.japan.as.uran.payloadencoder.PayloadEncoder;
import com.cisco.japan.as.uran.payloadencoder.constants.NodeElements;
import com.cisco.japan.as.uran.payloadencoder.constants.ProtocolSummary;
import com.cisco.japan.as.uran.payloadencoder.constants.UnknownStatus;
import com.cisco.japan.as.uran.payloadencoder.util.CommonUtils;
import com.cisco.japan.as.uran.payloadencoder.summary.BeaconHelpReport;
import com.cisco.japan.as.uran.payloadencoder.summary.BeaconTrackingReport;
import com.cisco.japan.as.uran.payloadencoder.summary.HelpReport;
import com.cisco.japan.as.uran.payloadencoder.summary.HelpReportShort;
import com.cisco.japan.as.uran.payloadencoder.summary.TrackingReport;
import com.cisco.japan.as.uran.payloadencoder.summary.TrackingReportShort;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Lt501hPayloadEncoder implements PayloadEncoder {

	/**
	 * Lt501のPayload変換処理
	 * 
	 * @param payloadString 変換対象のJSon
	 * @return 変換対象のJSon+変換後のJSon
	 */
	public List<JsonNode> encode(List<EncodedPayload> payloadString) throws Exception {

		// ObjectMapperを作成
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode node = (ObjectNode) mapper.readTree(payloadString.get(0).getPayloadString());

		// payloadStringからpayload_hexを取得
		String hexStr = node.get("DevEUI_uplink").get("payload_hex").toString().replace("\"", "");
		ObjectNode payloadObject = mapper.createObjectNode();

		if (hexStr.startsWith(ProtocolSummary.TRACKING_REPORT.getCode())) { // protocol:0c1002

			// TrackingReport:peyload_hexを変換
			TrackingReport.decodeTrackingReport(payloadObject, hexStr);

		} else if (hexStr.startsWith(ProtocolSummary.TRACKING_REPORT_S.getCode())) { // protocol:8083

			// TrackingRport(short):peyload_hexを変換
			TrackingReportShort.decodeTrackingReportShort(payloadObject, hexStr);

		} else if (hexStr.startsWith(ProtocolSummary.HELP_REPORT.getCode())) { // protocol:0c0b00

			// HelpReport:peyload_hexを変換
			HelpReport.decodeHelpReport(payloadObject, hexStr);

		} else if (hexStr.startsWith(ProtocolSummary.HELP_REPORT_S.getCode())) { // protocol:8001

			// HelpReport(short):peyload_hexを変換
			HelpReportShort.decodeHelpReportShort(payloadObject, hexStr);

		} else if (hexStr.startsWith(ProtocolSummary.BEACON_REPORT_T.getCode())) { // protocol:0c1302

			// BeaconTrackingReport:peyload_hexを変換
			BeaconTrackingReport.decodeBeaconTrackingReportd(payloadObject, hexStr);

		} else if (hexStr.startsWith(ProtocolSummary.BEACON_REPORT_H.getCode())) { // protocol:0c0700

			// BeaconHelpReport:peyload_hexを変換
			BeaconHelpReport.decodeBeaconHelpReport(payloadObject, hexStr);

		} else { // unknwonProtocol

			CommonUtils.packingJson(payloadObject, NodeElements.PROTOCOL.getCode(),
					UnknownStatus.UNKNOWN_PROTOCOL.getCode());

		}

		node.set(NodeElements.PAYLOAD_JSON.getCode(), payloadObject);
		return null;
	}
}
