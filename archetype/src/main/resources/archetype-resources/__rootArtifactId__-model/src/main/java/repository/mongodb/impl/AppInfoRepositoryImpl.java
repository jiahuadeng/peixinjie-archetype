#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.mongodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;

import ${package}.domain.AppInfo;
import ${package}.domain.AppPlatform;
import ${package}.domain.AppVersion;
import ${package}.repository.mongodb.AppInfoRepositoryCustom;
import ${package}.repository.mongodb.AppPlatformRepository;
import ${package}.repository.mongodb.AppVersionRepository;

public class AppInfoRepositoryImpl implements AppInfoRepositoryCustom {
	
	@Inject
	private MongoTemplate template;
	
	@Inject
	private AppPlatformRepository platformRepository;
	@Inject
	private AppVersionRepository versionRepository;

	@Override
	public AppInfo saveCascade(AppInfo appInfo) {
		
		List<AppPlatform> platforms = appInfo.getAppPlatforms();
		
		if(platforms != null){
			for(AppPlatform platform : platforms){
				List<AppVersion> versions = platform.getPlatformVersions();
				if(versions != null){
					for(AppVersion version : versions){
						version = versionRepository.save(version);
					}
				}
				platform = platformRepository.save(platform);
			}
		}
		template.save(appInfo);
		// TODO Auto-generated method stub
		return appInfo;
	}

}
