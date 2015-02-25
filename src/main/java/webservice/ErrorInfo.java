package webservice;

/**
 * 
 * @author Rauno Siimann
 *
 */
public class ErrorInfo {

	private String url;
	private String message;

	public ErrorInfo(String url, String message) {
		this.setUrl(url);
		this.setMessage(message);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}