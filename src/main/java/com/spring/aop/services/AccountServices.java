package com.spring.aop.services;

import com.spring.aop.model.Account;

/**
 * Account Services.
 * 
 * @author srikanth_p
 *
 */
public interface AccountServices {

	boolean loginService(String loginId, String loginByType, String password);

	Account createAccount(Account account);

	Account checkBalance(String accountNumber);

	Account deposit(String accountNumber, String amount);

	Account withDrawal(String accountNumber, String amount);

}
