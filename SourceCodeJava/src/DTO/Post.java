package DTO;

public class Post {
	private String ID_POST;// id bai post
	private String JOB_NAME;// ten cong viec
	private String ENTERPRISE_NAME;// ten doanh nghiep
	private Address ID_ADDRESS;
	private int WORK_HOUR;
	private int SALARY;
	private int BENEFIT;

	public String getID_POST() {
		return ID_POST;
	}

	public void setID_POST(String iD_POST) {
		ID_POST = iD_POST;
	}

	public String getJOB_NAME() {
		return JOB_NAME;
	}

	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}

	public String getENTERPRISE_NAME() {
		return ENTERPRISE_NAME;
	}

	public void setENTERPRISE_NAME(String eNTERPRISE_NAME) {
		ENTERPRISE_NAME = eNTERPRISE_NAME;
	}

	public Address getID_ADDRESS() {
		return ID_ADDRESS;
	}

	public void setID_ADDRESS(Address iD_ADDRESS) {
		ID_ADDRESS = iD_ADDRESS;
	}

	public int getWORK_HOUR() {
		return WORK_HOUR;
	}

	public void setWORK_HOUR(int wORK_HOUR) {
		WORK_HOUR = wORK_HOUR;
	}

	public int getSALARY() {
		return SALARY;
	}

	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}

	public int getBENEFIT() {
		return BENEFIT;
	}

	public void setBENEFIT(int bENEFIT) {
		BENEFIT = bENEFIT;
	}

}
