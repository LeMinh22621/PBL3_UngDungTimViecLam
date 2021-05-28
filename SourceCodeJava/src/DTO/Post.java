package DTO;

<<<<<<< HEAD
public class Post
{
	private String ID_POST;// id bai post
	private String JOB_NAME;// ten cong viec
	private String ID_EMPLOYER;// ten doanh nghiep
	private Address ID_ADDRESS;
	private int WORK_HOUR;
=======
public class Post {
	private String ID_POST;
	private Employer EMPLOYER;
	private Category_job CATEGORY_JOB;
	private String JOB_NAME;
	private String COMPANY_NAME;
	private String CITY;
>>>>>>> b8ebc18 (push code)
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
<<<<<<< HEAD

	public String getID_EMPLOYER() {
		return ID_EMPLOYER;
	}

	public void setID_EMPLOYER(String iD_EMPLOYER) {
		ID_EMPLOYER = iD_EMPLOYER;
	}

	public Address getID_ADDRESS() {
		return ID_ADDRESS;
=======
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
>>>>>>> b8ebc18 (push code)
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
