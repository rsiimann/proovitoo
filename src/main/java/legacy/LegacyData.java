package legacy;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Rauno Siimann
 *
 */
public class LegacyData {
	
	private int id;
	private boolean active;
	private String phoneNr;
	private boolean xlService;
	private String language;
	private String xlLanguage;
	private Date endDate;
	private String xlStart;
	private String xlEnd;
	private boolean override;
	private List<Override> overrides;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public boolean isXlsService() {
		return xlService;
	}

	public void setXlService(boolean xlsService) {
		this.xlService = xlsService;
	}

	public String getXlStart() {
		return xlStart;
	}

	public void setXlStart(String xlStart) {
		this.xlStart = xlStart;
	}

	public String getXlEnd() {
		return xlEnd;
	}

	public void setXlEnd(String xlEnd) {
		this.xlEnd = xlEnd;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}

	public List<Override> getOverrides() {
		return overrides;
	}

	public void setOverrides(List<Override> overrides) {
		this.overrides = overrides;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getXlLanguage() {
		return xlLanguage;
	}

	public void setXlLanguage(String xlLanguage) {
		this.xlLanguage = xlLanguage;
	}

}
