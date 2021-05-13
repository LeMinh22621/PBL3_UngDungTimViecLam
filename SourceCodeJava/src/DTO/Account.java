package DTO;

public class Account {
	private String ID_ACCOUNT;
	private String USERNAME;
	private String PASSWORD;
	private String EMAIL;
	private String PHONENUMBER;
	private boolean STATUS;
	private String CATEGORY;

	public String getID_ACCOUNT() {
		return ID_ACCOUNT;
	}

	public void setID_ACCOUNT(String iD_ACCOUNT) {
		ID_ACCOUNT = iD_ACCOUNT;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
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

	public boolean getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(boolean sTATUS) {
		STATUS = sTATUS;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

}
