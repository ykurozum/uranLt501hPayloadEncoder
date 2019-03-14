package com.cisco.japan.as.uran.payloadencoder.decoder;

import com.cisco.japan.as.uran.payloadencoder.constants.BeaconType;

public class BeaconIdDecoder {

	/**
	 * BeaconIdデコード処理
	 * 
	 * @param hexStr デコード用文字列
	 * @param beaconType BeaconType
	 * @return beaconId
	 */
	public static String[] decodeBeaconId(String hexStr, String beaconType) {

		String[] beaconId = new String[3];

		if (BeaconType.IBEACON.getTagName().equals(beaconType)) { // iBeacon
			beaconId[0] = hexStr.substring(0, 31);
			beaconId[1] = hexStr.substring(32, 36);
			beaconId[2] = hexStr.substring(37, 40);
		} else if (BeaconType.EDDYSOTNE_BEACON.getTagName().equals(beaconType)) { // Eddystone Beacon
			beaconId[0] = hexStr;
		} else { // ALT Beacon
			beaconId[0] = hexStr;
		}
		return beaconId;
	}

}
