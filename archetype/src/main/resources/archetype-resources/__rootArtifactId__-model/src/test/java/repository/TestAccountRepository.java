#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.domain.Account;
import ${package}.repository.jpa.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jpa/springdata-jpa.xml")
public class TestAccountRepository {

	@Inject
	private AccountRepository userRepository;
	
	@Test
	public void testSaveUser(){
		Account user = new Account();
		user.setAge(10);
		user.setCreateDate(new Date());
		user.setEmail("dengjh@lenovo.com");
		user.setNickName("nickname");
		user.setPassword("password");
		user.setStatus("a");
		user.setUserName("dengjh");
		user = userRepository.save(user);
		assertNotNull(user.getId());
	}
}
