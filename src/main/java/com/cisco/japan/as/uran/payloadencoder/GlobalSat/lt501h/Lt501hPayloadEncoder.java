package com.cisco.japan.as.uran.payloadencoder.GlobalSat.lt501h;

import com.cisco.japan.as.uran.payloadencoder.PayloadEncoder;
import com.fasterxml.jackson.databind.JsonNode;

public class Lt501hPayloadEncoder implements PayloadEncoder {

	public JsonNode encode(String[] payloadString) throws Exception {
		
		// for Debug
		System.out.println("Lt501hPayloadEncoder:encoder IN:<" + payloadString.length + ">" );
		for ( int i=0 ; i < payloadString.length ; i++ ) {
			System.out.println("["+i+"]:"+payloadString[0]);
		}

		return null;
	}

}
