package com.bank.bank.responsePojo;

import lombok.Data;

@Data
public class BranchesResponse {

	private String ifsc;
	private String bankName;
	private String branch;
	private String address;
	private String city;
	private String district;
	private String state;
	
}

