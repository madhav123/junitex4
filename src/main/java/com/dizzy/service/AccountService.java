package com.dizzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;
import com.dizzy.utility.StaticUtils;

@Service
public class AccountService {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private  JdbcTemplate template;

	public Accounts getAccountDetails(int id) {
		Accounts accounts = accountsRepository.findByCustomerId(id);
		if (accounts != null && StaticUtils.checkAccess()) {
			return accounts;
		} else {
			return null;
		}
	}
	
	
	public List<Accounts> selectRecords()
    {
         String sql="select a.account_number as accountAumber, a.account_type as accountType from accounts a"; 
         System.out.println("select record form Rommapper");
         AccountRecord dd=new AccountRecord();
         List<Accounts> accounts=template.query(sql, dd);
         System.out.println(accounts.size()+"-------------");
         return accounts;
         }

	
}
