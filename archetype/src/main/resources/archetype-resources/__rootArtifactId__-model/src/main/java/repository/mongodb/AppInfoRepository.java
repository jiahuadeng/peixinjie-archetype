#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ${package}.domain.AppInfo;

public interface AppInfoRepository extends MongoRepository<AppInfo, String>,AppInfoRepositoryCustom {
	List<AppInfo> findByGroupId(String groupId);
	
	
}
