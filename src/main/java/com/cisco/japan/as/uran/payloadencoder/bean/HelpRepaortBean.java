package com.cisco.japan.as.uran.payloadencoder.bean;

import java.util.Date;

public class HelpRepaortBean {

	/**
	 * ProtocolVersion
	 */
	String protocolVersion;

	/**
	 * CommandID
	 */
	String commandId;

	/**
	 * 経度
	 */
	String longitude;

	/**
	 * 緯度
	 */
	String latitude;

	/**
	 * GPS-FixStatus
	 */
	String gpsFixStatus;

	/**
	 * AlarmType
	 */
	String alarmType;

	/**
	 * batteryCapacity
	 */
	String batteryCapacity;

	/**
	 * Date&Time
	 */
	Date dateTime;

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getGpsFixStatus() {
		return gpsFixStatus;
	}

	public void setGpsFixStatus(String gpsFixStatus) {
		this.gpsFixStatus = gpsFixStatus;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
