#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

public class PushTicket {
	//In redis, pt is stored using the following rule:
	//key: PT.${symbol_dollar}{appId}.${symbol_dollar}{channelId}.${symbol_dollar}{itCode}.${symbol_dollar}{pushTicket}
	//value: ${symbol_dollar}{pushTicket}
	public final static String PT_KEY_PREFIX="PT.";
	
	private String appId;
	private String channelId;
	private String pushTicket;
	private String itCode;
	private String key;
	
	public String getKey() {
		if(pushTicket == null){
			return PT_KEY_PREFIX+appId+"."+channelId+"."+itCode;
		}else{
			return PT_KEY_PREFIX+appId+"."+channelId+"."+itCode+"."+pushTicket;
		}
		
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getPushTicket() {
		return pushTicket;
	}
	public void setPushTicket(String pushTicket) {
		this.pushTicket = pushTicket;
	}
	public String getItCode() {
		return itCode;
	}
	public void setItCode(String itCode) {
		this.itCode = itCode;
	}
	
	

}
