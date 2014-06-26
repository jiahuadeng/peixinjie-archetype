#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import ${package}.domain.AppPlatform;

public interface AppPlatformRepository extends MongoRepository<AppPlatform, String> {
	
	
}
