package com.dizzy.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dizzy.model.Accounts;
import com.dizzy.service.AccountRecord;
import com.dizzy.service.AccountService;

@ExtendWith(SpringExtension.class)
public class AccountServiceWithArgumentCaptureTest {
	
	
	@InjectMocks  
	AccountService accountService;	
	
	
	@Mock
	JdbcTemplate template;
    
	@Captor
	 ArgumentCaptor<String> query;
	
	@Captor
	 ArgumentCaptor<AccountRecord> accountRecord;
	
	@Test
	public void testAllAccounts() {	
		String sqlQuery="select a.account_number as accountAumber, a.account_type as accountType from accounts a";
		List<Accounts> res =accountService.selectRecords();  //target method call
		verify(template).query(query.capture(), accountRecord.capture());
		assertEquals(sqlQuery,query.getValue());
		
		
	}

	

		
}

