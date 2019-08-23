package com.bank.bank.responsePojo;

public class StatusResponse extends AbstractResponse {
	
	private int status;
	private String statusDesc;
	
	
	
	public StatusResponse(int status, String statusDesc) {
		this.status = status;
		this.statusDesc = statusDesc;
	}
	
	public StatusResponse() {
		// TODO Auto-generated constructor stub
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	

}
