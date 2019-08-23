package com.bank.bank.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="branches", schema = "public")
public class Branches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ifsc", nullable = false, updatable = false)
	private String ifsc;
	
	@JoinColumn(name="bank_id")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Banks banks;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
}

