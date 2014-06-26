#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ${package}.application.WsApplication;
import ${package}.domain.AppInfo;
import ${package}.model.ReturnResult;
//import org.springframework.data.mongodb.core.MongoOperations;
import ${package}.repository.mongodb.AppInfoRepository;

@Named("wsApplication")
public class WsApplicationImpl implements WsApplication {

	@Inject
	private AppInfoRepository appInfoRepository;



	@Override
	public ReturnResult<List<AppInfo>> queryByGroupId(String groupId) {
		List<AppInfo> appInfos = appInfoRepository.findByGroupId(groupId);
		ReturnResult<List<AppInfo>> returnResult = new ReturnResult<List<AppInfo>>();
		returnResult.setContents(appInfos);
		return returnResult;
	}




}
