#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import ${package}.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	public Account findByUserName(String userName);
}
