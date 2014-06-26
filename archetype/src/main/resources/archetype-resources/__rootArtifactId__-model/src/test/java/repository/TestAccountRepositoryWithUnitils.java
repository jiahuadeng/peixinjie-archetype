#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.CleanInsertLoadStrategy;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import ${package}.domain.Account;
import ${package}.repository.jpa.AccountRepository;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("classpath:jpa/springdata-jpa.xml")
/*@Transactional(TransactionMode.ROLLBACK)*/
//@ContextConfiguration("classpath:jpa/springdata-jpa.xml")
public class TestAccountRepositoryWithUnitils{

	@SpringBean("accountRepository")
	private AccountRepository userRepository;
	
	@Test
	@DataSet(value="TestAccountRepositoryWithUnitils-blank.xml",loadStrategy=CleanInsertLoadStrategy.class)
	@ExpectedDataSet
	public void testSaveUser(){
		Account user = new Account();
		user.setAge(20);
		user.setCreateDate(new Date());
		user.setEmail("dengjh@lenovo.com");
		user.setNickName("nickname");
		user.setPassword("password");
		user.setStatus("a");
		user.setUserName("dengjh");
		user = userRepository.save(user);
	}
	
	@Test
	@DataSet(loadStrategy=CleanInsertLoadStrategy.class)
	public void testFindByUserName(){
		Account user = userRepository.findByUserName("dengjh");
		
		System.out.println(user.getAge());
		assertPropertyLenientEquals("age",20,user);
	}
}
