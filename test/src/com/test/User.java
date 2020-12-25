package com.test;

public class User {
	
	private String lineCode = "HCSA01";
	
	private String offlinerunflagString;
	
	
	
	public String getOfflinerunflagString() {
		return offlinerunflagString;
	}

	public void setOfflinerunflagString(String offlinerunflagString) {
		this.offlinerunflagString = offlinerunflagString;
	}

	public String getLineCode() {
		if(this.lineCode == null || this.lineCode.isEmpty()) {
			return "";
		}
		return lineCode;
	}
	
	public String getRightMachineCode() {
		String lineCode = this.getLineCode();
		return lineCode + "R";
	}
	
	public String getLeftMachineCode() {
		String lineCode = this.getLineCode();
		return lineCode + "L";
	}
	
	public static boolean isEqualsExceptNullOrEmpty(String sourceCode, String destCode) {
		if (sourceCode == null) {
			return false;
		}
		if (destCode == null) {
			return false;
		}
		if (sourceCode.isEmpty()) {
			return false;
		}
		if (destCode.isEmpty()) {
			return false;
		}
		if (sourceCode.equals(destCode) == false) {
			return false;
		}
		return true;
	}
	
}
