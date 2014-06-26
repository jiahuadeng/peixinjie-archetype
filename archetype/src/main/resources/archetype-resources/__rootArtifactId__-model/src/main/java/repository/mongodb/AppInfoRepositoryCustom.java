#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.mongodb;

import ${package}.domain.AppInfo;

public interface AppInfoRepositoryCustom {
	public AppInfo saveCascade(AppInfo appInfo);
}
