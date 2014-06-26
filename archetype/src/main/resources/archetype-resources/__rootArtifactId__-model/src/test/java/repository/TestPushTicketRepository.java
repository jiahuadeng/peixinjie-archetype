#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import static com.lordofthejars.nosqlunit.redis.RemoteRedisConfigurationBuilder.newRemoteRedisConfiguration;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.domain.PushTicket;
import ${package}.repository.redis.PushTicketRepositry;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.redis.RedisRule;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis/springdata-redis.xml")
public class TestPushTicketRepository{
	@Rule
	public RedisRule redisRule = new RedisRule(newRemoteRedisConfiguration().host("10.99.60.20").build());
	
	@Inject
	private PushTicketRepositry repository;
	
	@Test
	@UsingDataSet(locations="/redis/testdata/initialdata.json",loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
	@ShouldMatchDataSet(location="/redis/testdata/expected_data.json")
	public void savePushTicket(){
		PushTicket pt = new PushTicket();
		pt.setAppId("meeting");
		pt.setChannelId("lenovo");
		pt.setItCode("dengjh");
		pt.setPushTicket("pt121212121212");
		repository.savePushTicket(pt);
	}
	
	@Test
	@UsingDataSet(locations="/redis/testdata/initialdata.json",loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
	public void findPushTicketBy(){
		String pt = repository.findPushTicketBy("lenovo", "approve", "dengjh");
		assertEquals(pt, "pt1234567");
	}
	
}
