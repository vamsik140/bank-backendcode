package com.bank.bank.pojo;

import lombok.Data;

@Data
public class CommonPojo {
	
	private Boolean isPaginationRequired;
	private Boolean isOrderRequired;
	private Boolean isAscending;
	private Integer pageNumber;
	private Integer pageSize;
	private String orderField;
	
}
