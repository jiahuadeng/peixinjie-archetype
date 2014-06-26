#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ${package}.domain.Account;
import ${package}.model.ReturnResult;

@Path(value="/account")
public interface AccountApplication {
	
	@POST
	@Path(value="/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnResult<Account> createAccount();

}
