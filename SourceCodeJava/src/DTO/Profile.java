package DTO;

public class Profile {
	private String ID_PROFILE;
	private String IMAGE;
	private String NAME;
	private String CITY;
	private String PHONENUMBER;
	private String EMAIL;
	private String FACEBOOK;
	private String WEBSITE;
	
	public String getID_PROFILE() {
		return ID_PROFILE;
	}

	public void setID_PROFILE(String iD_PROFILE) {
		ID_PROFILE = iD_PROFILE;
	}
	public String getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONENUMBER() {
		return PHONENUMBER;
	}

	public void setPHONENUMBER(String pHONENUMBER) {
		PHONENUMBER = pHONENUMBER;
	}
	public String getFACEBOOK() {
		return FACEBOOK;
	}

	public void setFACEBOOK(String fACEBOOK) {
		FACEBOOK = fACEBOOK;
	}

	public String getWEBSITE() {
		return WEBSITE;
	}

	public void setWEBSITE(String wEBSITE) {
		WEBSITE = wEBSITE;
	}
}
