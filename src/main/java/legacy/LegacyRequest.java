package legacy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author Rauno Siimann
 *
 */
public class LegacyRequest {

	public String getLegacyData(int requestParam) throws Exception {
		HttpClient httpclient = HttpClientBuilder.create().build();
		String url = "http://people.proekspert.ee/ak/data_"
				+ requestParam + ".txt";
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new LegacyDataNotFoundException(url);
		}
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

}
