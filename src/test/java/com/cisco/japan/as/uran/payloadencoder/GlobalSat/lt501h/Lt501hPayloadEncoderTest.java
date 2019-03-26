package com.cisco.japan.as.uran.payloadencoder.GlobalSat.lt501h;

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
public class Lt501hPayloadEncoderTest {

	public static void main(String[] args) throws Exception {
		Lt501hPayloadEncoder target = new Lt501hPayloadEncoder();

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
		List<DecodedPayload> decodeInfoList = target.encode(str);

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
}

