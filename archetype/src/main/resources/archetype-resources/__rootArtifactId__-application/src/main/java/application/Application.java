#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ${package}.domain.AppInfo;
import ${package}.model.ReturnResult;

@Path(value = "/demo/")
public interface Application {
	
    @POST
    @Path(value = "/createApp/{name}/{groupId}/{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnResult<AppInfo> createApp(@PathParam("name") String name, @PathParam("groupId") String groupId, @PathParam("description") String description);

	@GET
	@Path(value="/findByGroupId/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnResult<List<AppInfo>> queryByGroupId(@PathParam("groupId") String groupId);
	
	@GET
	@Path(value="/findByAppId/{appId}")
	@Produces(MediaType.APPLICATION_JSON)	
	public ReturnResult<AppInfo> queryByAppId(@PathParam("appId") String appId);
	
	@POST
	@Path(value="/deleteApp/{appId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnResult<String> deleteByAppId(@PathParam("appId") String appId);
	
}
