package DTO;

public class JobSeeker {
	private String ID_JOBSEEKER;
	private Account ACCOUNT;
	private Profile PROFILE;
	private int AGE;
	private boolean GENDER;
	private String PROFESSIONAL;

	public String getID_JOBSEEKER() {
		return ID_JOBSEEKER;
	}

	public void setID_JOBSEEKER(String iD_JOBSEEKER) {
		ID_JOBSEEKER = iD_JOBSEEKER;
	}

	public Profile getPROFILE() {
		return PROFILE;
	}

	public void setPROFILE(Profile pROFILE) {
		PROFILE = pROFILE;
	}

	public boolean getGENDER() {
		return GENDER;
	}

	public void setGENDER(boolean gENDER) {
		GENDER = gENDER;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getPROFESSIONAL() {
		return PROFESSIONAL;
	}

	public void setPROFESSIONAL(String pROFESSIONAL) {
		PROFESSIONAL = pROFESSIONAL;
	}

	public Account getACCOUNT() {
		return ACCOUNT;
	}

	public void setACCOUNT(Account aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}

}
