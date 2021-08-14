package DTO;

import java.util.Date;

public class Detail_CV_And_Post {
	private String ID_POST;
	private String ID_CV;
	private Boolean STATUS;
	private Date DATETIME;

	public String getID_POST() {
		return ID_POST;
	}

	public void setID_POST(String iD_POST) {
		ID_POST = iD_POST;
	}

	public String getID_CV() {
		return ID_CV;
	}

	public void setID_CV(String iD_CV) {
		ID_CV = iD_CV;
	}

	public Boolean getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(Boolean iTATUS) {
		STATUS = iTATUS;
	}

	public Date getDATETIME() {
		return DATETIME;
	}

	public void setDATETIME(Date dATETIME) {
		DATETIME = dATETIME;
	}
}
