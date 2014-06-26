#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.mongodb.impl;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.redis.core.RedisTemplate;

import ${package}.domain.PushTicket;
import ${package}.repository.redis.PushTicketRepositry;

@Named("pushTicketRepository")
public class PushTicketRepositryRedisImpl implements PushTicketRepositry {
	@Inject
	private RedisTemplate<String,String> redisTemplate;

	@Override
	public PushTicket savePushTicket(PushTicket pt) {
		redisTemplate.opsForValue().set(pt.getKey(), pt.getPushTicket());
		
		/*Set<String> keys = redisTemplate.keys("PT.*");
		for(String key:keys){
			System.out.println("key = "+key);
		}*/
		
		return pt;
	}

	@Override
	public String findPushTicketBy(String channelId, String appId, String itCode) {
		PushTicket pt = new PushTicket();
		pt.setAppId(appId);
		pt.setChannelId(channelId);
		pt.setItCode(itCode);
		Set<String> keys = redisTemplate.keys(pt.getKey()+"*");
		String pticket = "";
		if(keys != null && keys.size() > 0){
			pticket = redisTemplate.opsForValue().get(keys.iterator().next());
		}
		return pticket;
	}

}
