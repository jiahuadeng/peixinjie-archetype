#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.redis;

import ${package}.domain.PushTicket;



public interface PushTicketRepositry {
	
	public PushTicket savePushTicket(PushTicket pt);
	
	public String findPushTicketBy(String channelId,String appId,String itCode);

}
