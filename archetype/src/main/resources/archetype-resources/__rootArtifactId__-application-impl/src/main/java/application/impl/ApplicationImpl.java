#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Qualifier;

import ${package}.application.Application;
import ${package}.domain.AppInfo;
import ${package}.domain.AppPlatform;
import ${package}.domain.AppVersion;
import ${package}.model.ReturnResult;
//import org.springframework.data.mongodb.core.MongoOperations;
import ${package}.repository.mongodb.AppInfoRepository;

@Named("application")
public class ApplicationImpl implements Application {

	@Inject
	private AppInfoRepository appInfoRepository;



	@Override
	public ReturnResult<AppInfo> createApp(String name, String groupId,
			String description) {
		AppInfo appInfo = new AppInfo();
		String appId = RandomStringUtils.randomAlphanumeric(20);
		System.out.println("appId = "+appId);
		appInfo.setAppId(appId);
		appInfo.setAppName(name);
		appInfo.setDescription(description);
		appInfo.setGroupId(groupId);
		List<AppPlatform> appPlatforms = new ArrayList<AppPlatform>();
		AppPlatform android = new AppPlatform("Android");
		List<AppVersion> versions = new ArrayList<AppVersion>();
		for(int i=0;i<5;i++){
			AppVersion version = new AppVersion();
			version.setVersionCode(""+i);
			version.setVersionName("1.0."+i);
			//version = appversionRepository.save(version);
			
			versions.add(version);			
		}
		android.setPlatformVersions(versions);
		
		//android = appPlatformRepository.save(android);
	
		
		appPlatforms.add(android);
				
		appInfo.setAppPlatforms(appPlatforms);
		
		AppInfo savedDomain = appInfoRepository.saveCascade(appInfo);
		
		
		ReturnResult<AppInfo> returnResult = new ReturnResult<AppInfo>();
		returnResult.setResult(ReturnResult.SUCCESS);
		returnResult.setMessage("save successfully!");
		returnResult.setContents(savedDomain);
		
		return returnResult;
	}


	@Override
	public ReturnResult<List<AppInfo>> queryByGroupId(String groupId) {
		List<AppInfo> appInfos = appInfoRepository.findByGroupId(groupId);
		ReturnResult<List<AppInfo>> returnResult = new ReturnResult<List<AppInfo>>();
		returnResult.setContents(appInfos);
		return returnResult;
	}


	@Override
	public ReturnResult<AppInfo> queryByAppId(String appId) {
		AppInfo appInfos = appInfoRepository.findOne(appId);
		ReturnResult<AppInfo> returnResult = new ReturnResult<AppInfo>();
		returnResult.setContents(appInfos);
		return returnResult;
	}


	@Override
	public ReturnResult<String> deleteByAppId(String appId) {
		appInfoRepository.delete(appId);
		
		int size = appInfoRepository.findAll().size();
		
		ReturnResult<String> returnResult = new ReturnResult<String>();
		returnResult.setResult(ReturnResult.SUCCESS);
		returnResult.setMessage("delete successfully!");
		returnResult.setContents(""+size);
		return returnResult;
	}



}
