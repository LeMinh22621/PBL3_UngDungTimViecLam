package DTO;

public class Post {
	private String ID_POST;
	private Employer EMPLOYER;
	private Category_job CATEGORY_JOB;
	private String JOB_NAME;
	private String COMPANY_NAME;
	private String CITY;

	private int SALARY;
	private String DESCIPTION_JOB;
	private int LABOR;
	private boolean STATUS;

	public String getID_POST() {
		return ID_POST;
	}
	public void setID_POST(String iD_POST) {
		ID_POST = iD_POST;
	}
	public Employer getEMPLOYER() {
		return EMPLOYER;
	}
	public void setEMPLOYER(Employer eMPLOYER) {
		EMPLOYER = eMPLOYER;
	}
	public Category_job getCATEGORY_JOB() {
		return CATEGORY_JOB;
	}
	public void setCATEGORY_JOB(Category_job cATEGORY_JOB) {
		CATEGORY_JOB = cATEGORY_JOB;
	}
	public String getJOB_NAME() {
		return JOB_NAME;
	}
	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public int getSALARY() {
		return SALARY;
	}
	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}
	public String getDESCIPTION_JOB() {
		return DESCIPTION_JOB;
	}
	public void setDESCIPTION_JOB(String dESCIPTION_JOB) {
		DESCIPTION_JOB = dESCIPTION_JOB;
	}
	public int getLABOR() {
		return LABOR;
	}
	public void setLABOR(int lABOR) {
		LABOR = lABOR;
	}
	public boolean getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(boolean sTATUS) {
		STATUS = sTATUS;
	}
}
