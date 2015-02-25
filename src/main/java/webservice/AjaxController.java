package webservice;

import legacy.LegacyRequest;
import legacy.LegacyDataProcessor;
import legacy.ScheduledLegacyDataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/**
 * 
 * @author Rauno Siimann
 *
 */
@RestController
public class AjaxController {
	
	@Autowired
	private ScheduledLegacyDataProvider provider;
    
	@RequestMapping(value = "/data", produces = "application/json")
    public String getData() throws Exception {
		LegacyDataProcessor processor = new LegacyDataProcessor();
		Gson gson = new Gson();
		int requestId = provider.getRequestId();
		String legacyData = provider.get();
		return gson.toJson(processor.process(legacyData, requestId));
    }
	
	@RequestMapping(value = "/databyid", produces = "text/html")
	public String getDataById(@RequestParam int id) throws Exception {
		LegacyRequest request = new LegacyRequest();
		return request.getLegacyData(id);
	}
    
}
