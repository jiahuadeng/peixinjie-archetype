#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wangyao5 on 2014/5/8.
 */
@Document(collection="AppInfoDemo")
public class AppInfo {
	@Id
    private String appId;
    private String appName;
    private String groupId;
    private String description;
    private long createTime;

    
    private List<AppPlatform> appPlatforms;

    public List<AppPlatform> getAppPlatforms() {
        return appPlatforms;
    }

    public void setAppPlatforms(List<AppPlatform> appPlatforms) {
        this.appPlatforms = appPlatforms;
    }
    public AppInfo(){}
    public AppInfo(String appId, String appName, String groupId, String description, long createTime) {
        this.appId = appId;
        this.appName = appName;
        this.groupId = groupId;
        if (description != null) {
            this.description = description;
        }
        this.createTime = createTime;
    }

    public AppInfo(String appId){
        this.appId = appId;
    }
    public AppInfo(String appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AppInfo [appId=" + appId + ", appName=" + appName + ", groupId=" + groupId + ",description=" + description + ",createTime:" + createTime + "]";
    }
}
