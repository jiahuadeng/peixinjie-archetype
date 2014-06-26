#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * Created by wangyao5 on 2014/5/9.
 */
public class AppPlatform {
	@Id
	private String id;
    private String platformName;
    private List<AppVersion> platformVersions;
    public AppPlatform(String platformName){
        this.platformName = platformName;
    }
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<AppVersion> getPlatformVersions() {
        return platformVersions;
    }

    public void setPlatformVersions(List<AppVersion> platformVersions) {
        this.platformVersions = platformVersions;
    }
}
