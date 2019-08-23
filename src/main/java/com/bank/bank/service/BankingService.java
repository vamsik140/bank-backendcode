package com.bank.bank.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.bank.bank.pojo.BranchDetailsReq;
import com.bank.bank.pojo.CommonPojo;
import com.bank.bank.responsePojo.AbstractResponse;

public interface BankingService {

	ResponseEntity<? extends AbstractResponse> getBankDetails(String ifscCode);

	ResponseEntity<? extends AbstractResponse> getAllBankDetails(CommonPojo pagination);

	ResponseEntity<? extends AbstractResponse> getAllBankDetails(@Valid BranchDetailsReq req);


}
