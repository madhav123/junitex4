package com.dizzy.controller;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;
import com.dizzy.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	public AccountController() {
		System.out.print("called -AccountController");
	}

    @Autowired
    private AccountService sccountService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = sccountService.getAccountDetails(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
    @GetMapping("/myAccount1")
    public Accounts getAccountDetails() {
        Accounts accounts = sccountService.getAccountDetails(23);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}
