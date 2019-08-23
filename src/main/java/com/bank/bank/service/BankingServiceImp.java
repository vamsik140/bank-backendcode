package com.bank.bank.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.bank.entities.Branches;
import com.bank.bank.pojo.BranchDetailsReq;
import com.bank.bank.pojo.CommonPojo;
import com.bank.bank.repositories.BranchesRepository;
import com.bank.bank.responsePojo.AbstractResponse;
import com.bank.bank.responsePojo.BranchesResponse;
import com.bank.bank.responsePojo.BranchesResponseList;

@Service
public class BankingServiceImp implements BankingService {

	@Autowired	
	BranchesRepository branchesRepository;

	
	private static final Logger LOGGER = Logger.getLogger(BankingServiceImp.class);


	@Override
	public ResponseEntity<? extends AbstractResponse> getBankDetails(String ifscCode) {

		LOGGER.info("getBankDetails-->");
		
		Branches res = branchesRepository.findByIfsc(ifscCode);
		
		BranchesResponse br = new BranchesResponse();
		br.setAddress(res.getAddress());
		br.setBankName(res.getBanks().getName());
		br.setBranch(res.getBranch());
		br.setCity(res.getCity());
		br.setDistrict(res.getDistrict());
		br.setIfsc(res.getIfsc());
		
		
		List<BranchesResponse> list = new ArrayList<BranchesResponse>();
		list.add(br);
		
		BranchesResponseList a = new BranchesResponseList();
		a.setBranchesResponse(list);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}


	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<? extends AbstractResponse> getAllBankDetails(CommonPojo pagination) {

		LOGGER.info("getAllBankDetails-->");
		
		List<Branches> branchess = null;
		Page<Branches> pageBranches = null;
		Pageable pageable = null;
		
		if (pagination.getIsPaginationRequired()) {
			if (pagination.getIsOrderRequired()) {
				pageable = new PageRequest(pagination.getPageNumber(), pagination.getPageSize(),
						(pagination.getIsAscending() == true ? Sort.Direction.ASC : Sort.Direction.DESC),
						pagination.getOrderField());
			} else {
				pageable = new PageRequest(pagination.getPageNumber(), pagination.getPageSize());
			}
			Long start = System.currentTimeMillis();
			pageBranches = branchesRepository.findAll(pageable);
			Long end = System.currentTimeMillis();
			LOGGER.info("total time taken by getAllBankDetails in M/S " + (end - start));
		} else {
			Long start = System.currentTimeMillis();
			branchess = branchesRepository.findAll();
			Long end = System.currentTimeMillis();
			LOGGER.info("total time taken by getAllBankDetails in M/S " + (end - start));
		}
		
		List<BranchesResponse> list = new ArrayList<BranchesResponse>();
		for(Branches res : pagination.getIsPaginationRequired() == true ? pageBranches : branchess){
			BranchesResponse br = new BranchesResponse();
			br.setAddress(res.getAddress());
			br.setBankName(res.getBanks().getName());
			br.setBranch(res.getBranch());
			br.setCity(res.getCity());
			br.setDistrict(res.getDistrict());
			br.setIfsc(res.getIfsc());
			
			list.add(br);
		}
		
		BranchesResponseList a = new BranchesResponseList();
		a.setBranchesResponse(list);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<? extends AbstractResponse> getAllBankDetails(@Valid BranchDetailsReq req) {

		LOGGER.info("getAllBankDetails-->");
		
		List<Branches> listBranches = branchesRepository.findByBanksNameAndCity(req.getBankName(), req.getCity());
		
		List<BranchesResponse> list = new ArrayList<BranchesResponse>();
		for(Branches res : listBranches){
			BranchesResponse br = new BranchesResponse();
			br.setAddress(res.getAddress());
			br.setBankName(res.getBanks().getName());
			br.setBranch(res.getBranch());
			br.setCity(res.getCity());
			br.setDistrict(res.getDistrict());
			br.setIfsc(res.getIfsc());
			
			list.add(br);
		}
		
		BranchesResponseList a = new BranchesResponseList();
		a.setBranchesResponse(list);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	
}
