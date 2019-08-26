package com.bank.bank.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bank.entities.Branches;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {

	Branches findByIfsc(String ifsc);
	
	Page<Branches> findByBanksNameAndCity(String bankName, String city, Pageable pageable);

	List<Branches> findByBanksNameAndCity(String bankName, String city);
	
}
