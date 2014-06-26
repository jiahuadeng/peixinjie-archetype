#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model;

import java.io.Serializable;
import java.util.List;

public class ReturnResult<T> implements Serializable {
	
	public final static String SUCCESS = "SUCCESS";
	public final static String ERROR = "ERROR";
	
	private String result;
	private String message;
	private T contents;
	

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getContents() {
		return contents;
	}
	public void setContents(T contents) {
		this.contents = contents;
	}
	
	

}
