#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ${package}.domain.AppInfo;
import ${package}.model.ReturnResult;

@WebService
public interface WsApplication {
	
	public ReturnResult<List<AppInfo>> queryByGroupId(@PathParam("groupId") String groupId);

}
