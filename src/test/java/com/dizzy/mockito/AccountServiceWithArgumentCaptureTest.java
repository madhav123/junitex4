package com.dizzy.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;
import com.dizzy.service.AccountRecord;
import com.dizzy.service.AccountService;
import com.dizzy.utility.StaticUtils;

@ExtendWith(SpringExtension.class)
public class AccountServiceWithArgumentCaptureTest {

	@InjectMocks  
	AccountService accountService;	
	@Mock
	AccountsRepository accountsRepository;
	@Mock
	JdbcTemplate template;
    
    
	@Test
	public void testTrue() {
		Accounts mockResponse = new Accounts();
		mockResponse.setBranchAddress("hyd");
	    Mockito.when(accountsRepository.findByCustomerId(Mockito.anyInt())).thenReturn(mockResponse);
		Accounts account = accountService.getAccountDetails(0);
		System.out.println("account" + account.getBranchAddress());
		assertEquals("hyd", account.getBranchAddress());
	}
	
	@Test
	public void testFalsecase() {
		Accounts mockResponse = new Accounts();
		mockResponse.setBranchAddress("hyd");
	    MockedStatic<StaticUtils> staticUtils = Mockito.mockStatic(StaticUtils.class);
	    staticUtils.when(StaticUtils::checkAccess).thenReturn(false);
	    Mockito.when(accountsRepository.findByCustomerId(Mockito.anyInt())).thenReturn(mockResponse);
		Accounts account = accountService.getAccountDetails(0);
		assertEquals(null, account);
	}
	
}

