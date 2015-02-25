package webservice;

import javax.servlet.http.HttpServletRequest;

import legacy.LegacyDataNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Rauno Siimann
 *
 */
@ControllerAdvice
public class RestExceptionProcessor {
	
	@ExceptionHandler(LegacyDataNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleNoLegacyData(HttpServletRequest req, LegacyDataNotFoundException ex) {
		return new ErrorInfo(ex.getUrl(), "Legacy andmed pole antud urlil saadaval");
	}

}
