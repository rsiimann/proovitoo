package legacy;

/**
 * 
 * @author Rauno Siimann
 *
 */
public class LegacyDataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3882333471288023664L;
	
	private String url;
	
	public LegacyDataNotFoundException(String url) {
		this.setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
