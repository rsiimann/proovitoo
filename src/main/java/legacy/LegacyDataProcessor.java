package legacy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * 
 * @author Rauno Siimann
 *
 */

public class LegacyDataProcessor {

	public static final int NUMBER_LENGTH = 15;
	public static final int NAME_LENGTH = 20;
	public static final int NAMES_START_INDEX = 120;

	public LegacyData process(String dataString, int requestParam) {

		LegacyData data = new LegacyData();
		data.setId(requestParam);
		data.setActive(isActive(dataString.substring(0, 1)));
		data.setPhoneNr(dataString.substring(1, 21).trim());
		data.setXlService(isXlService(dataString.substring(21, 22)));
		data.setLanguage(parseLanguage(dataString.substring(22, 23)));
		;
		if (data.isXlsService()) {
			data.setXlLanguage(parseLanguage(dataString.substring(23, 24)));
		}
		data.setEndDate(parseEndDate(dataString.substring(24, 36)));
		data.setXlStart(parseXlsTime(dataString.substring(36, 40)));
		data.setXlEnd(parseXlsTime(dataString.substring(40, 44)));
		data.setOverride(parseOverride(dataString.substring(44, 45)));
		if (data.isOverride()) {
			data.setOverrides(parseOverrides(dataString.substring(45, 325)));
		}
		return data;
	}

	private boolean isXlService(String dataString) {
		return dataString.equals("J") ? true : false;
	}

	private boolean isActive(String dataString) {
		return dataString.equals("A") ? true : false;
	}

	private boolean parseOverride(String dataString) {
		return dataString.equals("K");
	}

	private String parseLanguage(String dataString) {
		if (dataString.equals("I")) {
			return "Inglise";
		} else if (dataString.equals("E")) {
			return "Eesti";
		}
		return null;
	}

	private List<Override> parseOverrides(String substring) {

		List<Override> overrideList = new ArrayList<Override>();
		for (int i = 0; i < 8; i++) {
			Override override = new Override();
			// number
			String number = substring.substring(i * NUMBER_LENGTH, i
					* NUMBER_LENGTH + NUMBER_LENGTH);
			override.setNumber(number.trim());
			// name
			String name = substring.substring(NAMES_START_INDEX + i
					* NAME_LENGTH, NAMES_START_INDEX + i * NAME_LENGTH
					+ NAME_LENGTH);
			override.setName(name.trim());
			if(StringUtils.hasText(name) || StringUtils.hasText(number)) {
				overrideList.add(override);
			}
		}
		return overrideList;
	}

	public String parseXlsTime(String dateString) {
		return dateString.substring(0, 2) + ":" + dateString.substring(2, 4);
	}

	public Date parseEndDate(String dateString) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
