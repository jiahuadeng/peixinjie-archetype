#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by wangyao5 on 2014/5/9.
 */
public class AppVersion {
	@Id
	private String id;
	private String appId;
    private String versionCode;
    private String versionName;


    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }


}
