package DTO;

public class Employer
{
	private String ID_EMPLOYER;
	private Account ACCOUNT;
	private Profile PROFILE;

	public String getID_EMPLOYER() {
		return ID_EMPLOYER;
	}

	public void setID_EMPLOYER(String iD_EMPLOYER) {
		ID_EMPLOYER = iD_EMPLOYER;
	}

	public Account getACCOUNT() {
		return ACCOUNT;
	}

	public void setACCOUNT(Account aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}

	public Profile getPROFILE() {
		return PROFILE;
	}

	public void setPROFILE(Profile pROFILE) {
		PROFILE = pROFILE;
	}
}
