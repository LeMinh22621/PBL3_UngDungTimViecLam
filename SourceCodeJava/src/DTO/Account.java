package DTO;

public class Account {
	private String ID_ACCOUNT;
	private String USERNAME;
	private String PASSWORD;
	private boolean ACCESSER;
	private boolean STATUS;
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

	public boolean getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(boolean sTATUS) {
		STATUS = sTATUS;
	}

	public boolean getACCESSER() {
		return ACCESSER;
	}

	public void setACCESSER(boolean aCCESSER) {
		ACCESSER = aCCESSER;
	}

}
