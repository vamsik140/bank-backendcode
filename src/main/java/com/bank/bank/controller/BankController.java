package com.bank.bank.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.pojo.BranchDetailsReq;
import com.bank.bank.pojo.CommonPojo;
import com.bank.bank.responsePojo.AbstractResponse;
import com.bank.bank.service.BankingService;

@RestController
public class BankController {

	private static final Logger LOGGER = Logger.getLogger(BankController.class);

	@Autowired
	BankingService bankingService;

	@RequestMapping("/greeting")
	public String greeting() {
		return "Welcome!!!";
	}

	@RequestMapping(value = "/getBankDetails", method = RequestMethod.GET)
	public ResponseEntity<? extends AbstractResponse> getBankDetails(@RequestParam(name = "ifscCode") String ifscCode)
			throws Exception {

		LOGGER.info("getBankDetails--> ifscCode: " + ifscCode);

		System.out.println("getBankDetails");
		return bankingService.getBankDetails(ifscCode);
	}// end of getBankDetails

	@RequestMapping(value = "/getAllBankDetails", method = RequestMethod.POST)
	public ResponseEntity<? extends AbstractResponse> getAllBankDetails(@Valid @RequestBody CommonPojo pagination)
			throws Exception {

		LOGGER.info("getAllBankDetails-->");

		System.out.println("getAllBankDetails");
		return bankingService.getAllBankDetails(pagination);
	}// end of getAllBankDetails

	@RequestMapping(value = "/getBranchDetails", method = RequestMethod.POST)
	public ResponseEntity<? extends AbstractResponse> getBranchDetails(@RequestParam(name = "bankName") String bankName,
			@RequestParam(name = "city") String city, @Valid @RequestBody CommonPojo pagination)
			throws Exception {

		LOGGER.info("getBranchDetails-->");

		BranchDetailsReq req = new BranchDetailsReq();
		req.setBankName(bankName);
		req.setCity(city);
		
		System.out.println("getBranchDetails");
		return bankingService.getAllBankDetails(req, pagination);
	}// end of getBranchDetails

}
