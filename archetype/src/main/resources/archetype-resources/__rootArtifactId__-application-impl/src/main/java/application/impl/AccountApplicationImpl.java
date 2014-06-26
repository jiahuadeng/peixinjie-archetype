#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import ${package}.application.AccountApplication;
import ${package}.domain.Account;
import ${package}.model.ReturnResult;
import ${package}.repository.jpa.AccountRepository;

@Named("accountApplication")
public class AccountApplicationImpl implements AccountApplication {
	 
	@Inject
	private AccountRepository accountRepository;

	@Override
	public ReturnResult<Account> createAccount() {
		Account user = new Account();
		user.setAge(10);
		user.setCreateDate(new Date());
		user.setEmail("dengjh@lenovo.com");
		user.setNickName("nickname");
		user.setPassword("password");
		user.setStatus("a");
		user.setUserName("dengjh");
		user = accountRepository.save(user);
		
		ReturnResult<Account> returnResult = new ReturnResult<Account>();
		returnResult.setResult(ReturnResult.SUCCESS);
		returnResult.setMessage("save successfully!");
		returnResult.setContents(user);
		
		return returnResult;
	}

}
