package com.dizzy.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dizzy.model.Accounts;

public class AccountRecord implements RowMapper<Accounts>
{
    public Accounts mapRow(ResultSet rs, int rownum) throws SQLException {
                // TODO Auto-generated method stub
    	Accounts account=new Accounts();
    	account.setAccountNumber(rs.getInt("accountAumber"));
    	account.setAccountType(rs.getString("accountType"));
         return account;
    }
}



