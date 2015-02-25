package legacy;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Rauno Siimann
 *
 */
@Component
public class ScheduledLegacyDataProvider {

	private int requestId = 0;
	private LegacyRequest request;
	private String data;
	
	public ScheduledLegacyDataProvider() {
		this.request = new LegacyRequest();
	}
	
	public String get() throws LegacyDataNotFoundException {
		if(data == null) {
			String url =  "http://people.proekspert.ee/ak/data_" + requestId + ".txt";
			throw new LegacyDataNotFoundException(url);
		}
		return data;
	}

	@Scheduled(fixedRate = 5000)
	public void makeRequest() throws Exception {
		requestId = requestId == 9 ? 1 : requestId + 1;
		try {
			data = request.getLegacyData(requestId);
		} catch(LegacyDataNotFoundException e) {
			data = null;
		}
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

}
