package com.bank.bank.responsePojo;

import java.util.List;

import lombok.Data;

@Data
public class BranchesResponseList extends AbstractResponse{

	private List<BranchesResponse> branchesResponse;
}
