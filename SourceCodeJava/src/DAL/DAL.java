package DAL;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DTO.Account;
import DTO.CV;
import DTO.Category_job;
import DTO.Detail_CV_And_Post;
import DTO.Employer;
import DTO.JobSeeker;
import DTO.JobSeekerApply;
import DTO.Post;
import DTO.Profile;
import DTO.Communication;

public class DAL {
	private static DAL Instance;

	public static DAL getInstance() {
		if (Instance == null)
			Instance = new DAL();
		return Instance;
	}

	public List<Employer> getListEmployers_DAL() throws ClassNotFoundException, SQLException {
		List<Employer> list = new ArrayList<Employer>();
		String query = "Select * from TB_EMPLOYER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Employer employer = new Employer();

				employer.setID_EMPLOYER(defaultTableModel.getValueAt(i, 0).toString());
				employer.setACCOUNT(getAccountByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
				employer.setPROFILE(getProfileByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
				list.add(employer);
			}
		}
		return list;
	}

	public Employer getEmployerByID_DAL(String ID) throws ClassNotFoundException, SQLException {
		for (Employer i : getListEmployers_DAL()) {
			if (i.getID_EMPLOYER().equals(ID)) {
				return i;
			}
		}
		return null;
	}

	public List<Account> getListAccounts_DAL() throws ClassNotFoundException, SQLException {
		List<Account> list = new ArrayList<Account>();
		String query = "Select * from TB_ACCOUNT";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Account account = new Account();

				account.setID_ACCOUNT(defaultTableModel.getValueAt(i, 0).toString());
				account.setUSERNAME(defaultTableModel.getValueAt(i, 1).toString());
				account.setPASSWORD(defaultTableModel.getValueAt(i, 2).toString());
				if (defaultTableModel.getValueAt(i, 3) != null)
					account.setACCESSER(
							(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 3).toString()) == true) ? 1 : 0);
				else
					account.setACCESSER(-1);
				account.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 4).toString()));

				list.add(account);

			}
		}
		return list;
	}

	public Account getAccountByID_DAL(String id_ACCOUNT) throws ClassNotFoundException, SQLException {
		for (Account i : getListAccounts_DAL()) {
			if (i.getID_ACCOUNT().equals(id_ACCOUNT)) {
				return i;
			}
		}
		return null;
	}

	// category
	public Category_job getCategory_jobByID_DAL(String ID) throws ClassNotFoundException, SQLException {
		String query = "select * from TB_CATEGORY_JOB where ID_CATEGORY_JOB ='" + ID + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		Category_job category_job = new Category_job();

		category_job.setID_CATEGORY_JOB(defaultTableModel.getValueAt(0, 0).toString());
		category_job.setCATEGORY_JOB_NAME(defaultTableModel.getValueAt(0, 1).toString());
		return category_job;
	}

	// List post
	public List<Post> getListPost_DAL() throws ClassNotFoundException, SQLException, ParseException {
		List<Post> list = new ArrayList<Post>();
		String query = "Select * from TB_POST";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Post post = new Post();

				post.setID_POST(defaultTableModel.getValueAt(i, 0).toString());
				post.setEMPLOYER(getEmployerByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
				post.setCATEGORY_JOB(getCategory_jobByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
				post.setJOB_NAME(defaultTableModel.getValueAt(i, 3).toString());
				post.setCOMPANY_NAME(
						(defaultTableModel.getValueAt(i, 4) != null) ? defaultTableModel.getValueAt(i, 4).toString()
								: "");
				post.setCITY(defaultTableModel.getValueAt(i, 5).toString());
				post.setSALARY((defaultTableModel.getValueAt(i, 6) != null)
						? Integer.parseInt(defaultTableModel.getValueAt(i, 6).toString())
						: -1);
				post.setDESCIPTION_JOB(
						(defaultTableModel.getValueAt(i, 7) != null) ? defaultTableModel.getValueAt(i, 7).toString()
								: "");
				post.setLABOR((defaultTableModel.getValueAt(i, 8) != null)
						? Integer.parseInt(defaultTableModel.getValueAt(i, 8).toString())
						: -1);
				post.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 9).toString()));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				post.setDATETIME(format.parse(defaultTableModel.getValueAt(i, 10).toString()));

				list.add(post);
			}
		}
		return list;
	}

	public Post getPostByID_DAL(String ID) throws ClassNotFoundException, SQLException, ParseException {
		for (Post i : getListPost_DAL()) {
			if (i.getID_POST().equals(ID)) {
				return i;
			}
		}
		return null;
	}

	//
	public List<String[]> getJOB_NAMEByID_Post_DAL(String ID) throws ClassNotFoundException, SQLException, ParseException {
		List<String[]> tmp = new ArrayList<String[]>();
		for (Post i : getListPost_DAL()) {
			if (i.getID_POST().equals(ID)) {
				String[] t = { i.getID_POST(), i.getJOB_NAME(), i.getCITY() };
				tmp.add(t);
			}
		}
		return tmp;
	}

	public String getID_POSTByID_EMPLOYER(String ID) throws ClassNotFoundException, SQLException, ParseException {
		for (Post i : getListPost_DAL()) {
			if (i.getEMPLOYER().getID_EMPLOYER().equals(ID)) {
				return i.getID_POST();
			}
		}
		return null;
	}

	public String getIdJobSeekerByIdAccount_DAL(String ID) throws ClassNotFoundException, SQLException {
		String idJobSeeker = "";
		for (JobSeeker i : getAllJobSeeker_DAL()) {
			if (i.getACCOUNT().getID_ACCOUNT().equals(ID)) {
				idJobSeeker = i.getID_JOBSEEKER();
			}
		}
		return idJobSeeker;
	}

	public CV getCVByID_JOBSEEKER(String ID) throws ClassNotFoundException, SQLException {
		String query = "select * from TB_CV where ID_JOBSEEKER ='" + ID + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		CV cv = new CV();
		if (defaultTableModel != null) {
			if (defaultTableModel.getRowCount() == 1) {
				cv.setID_CV(defaultTableModel.getValueAt(0, 0).toString());
				cv.setJOBSEEKER(getJobSeekerByID(defaultTableModel.getValueAt(0, 1).toString()));
				cv.setADDRESS_CV(defaultTableModel.getValueAt(0, 2).toString());
			}
		}
		return cv;

	}

	public void DeleteTB_POSTbyID_Post_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query = "delete from TB_POST where ID_POST ='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public Employer getEmployerByIDAccount_DAL(String id_account) throws ClassNotFoundException, SQLException {
		Employer e = new Employer();

		for (Employer i : getAllEmployer_DAL()) {
			if (i.getACCOUNT().getID_ACCOUNT().equals(id_account)) {
				e.setACCOUNT(i.getACCOUNT());
				e.setID_EMPLOYER(i.getID_EMPLOYER());
				e.setPROFILE(i.getPROFILE());
				break;
			}
		}
		return e;
	}

	public JobSeeker getJobSeekerByIDAccount_DAL(String id_account) throws ClassNotFoundException, SQLException {
		JobSeeker e = new JobSeeker();

		for (JobSeeker i : getAllJobSeeker_DAL()) {

			if (i.getACCOUNT().getID_ACCOUNT().equals(id_account)) {
				e.setACCOUNT(i.getACCOUNT());
				e.setAGE(i.getAGE());
				e.setGENDER(i.getGENDER());
				e.setID_JOBSEEKER(i.getID_JOBSEEKER());
				e.setPROFESSIONAL(i.getPROFESSIONAL());
				e.setPROFILE(i.getPROFILE());
				break;
			}
		}
		return e;
	}

	public void DeleteAccount_DAL(Account acc) throws ClassNotFoundException, SQLException, ParseException {
		if (acc.getACCESSER() == 1) {
			Employer em = new Employer();
			em = getEmployerByIDAccount_DAL(acc.getID_ACCOUNT());

			String query0 = "delete from TB_COMMUNICATION where ID_EMPLOYER ='" + em.getID_EMPLOYER() + "'";
			DBHelper.getInstance().ExcuteDB(query0);

			String query = "delete from TB_DETAIL_CV_AND_POST where ID_POST='"
					+ getID_POSTByID_EMPLOYER(em.getID_EMPLOYER()) + "'";
			DBHelper.getInstance().ExcuteDB(query);

			String query1 = "delete from TB_POST where ID_EMPLOYER='" + em.getID_EMPLOYER() + "'";
			DBHelper.getInstance().ExcuteDB(query1);

			String query2 = "delete from TB_EMPLOYER where ID_EMPLOYER='" + em.getID_EMPLOYER() + "'";
			DBHelper.getInstance().ExcuteDB(query2);

			String query3 = "delete from TB_PROFILE where ID_PROFILE='" + em.getPROFILE().getID_PROFILE() + "'";
			DBHelper.getInstance().ExcuteDB(query3);
		}

		else if (acc.getACCESSER() == 0) {
			JobSeeker js = new JobSeeker();
			js = getJobSeekerByIDAccount_DAL(acc.getID_ACCOUNT());

			String query0 = "delete from TB_COMMUNICATION where ID_JOBSEEKER ='" + js.getID_JOBSEEKER() + "'";
			DBHelper.getInstance().ExcuteDB(query0);
			String query2 = "delete from TB_DETAIL_CV_AND_POST where ID_CV='"
					+ getCVByID_JOBSEEKER(js.getID_JOBSEEKER()).getID_CV() + "'";
			DBHelper.getInstance().ExcuteDB(query2);
			String query3 = "delete from TB_CV where ID_JOBSEEKER='" + js.getID_JOBSEEKER() + "'";
			DBHelper.getInstance().ExcuteDB(query3);
			String query4 = "delete from TB_JOBSEEKER where ID_JOBSEEKER='" + js.getID_JOBSEEKER() + "'";
			DBHelper.getInstance().ExcuteDB(query4);
			String query5 = "delete from TB_PROFILE where ID_PROFILE='" + js.getPROFILE().getID_PROFILE() + "'";
			DBHelper.getInstance().ExcuteDB(query5);
		}

		String querya = "delete from TB_ACCOUNT where ID_ACCOUNT='" + acc.getID_ACCOUNT() + "'";
		DBHelper.getInstance().ExcuteDB(querya);
	}

	public void BanAccountByIDAccount_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query = "update TB_ACCOUNT set STATUS = 'False' where ID_ACCOUNT='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void ActiveAccountByIDAccount_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query = "update TB_ACCOUNT set STATUS = 'True' where ID_ACCOUNT = '" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void AcceptPost_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query = "update TB_POST set STATUS = 'True' where ID_POST='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void DeclinePost_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query2 = "delete from TB_COMMUNICATION where ID_POST = '" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query2);
		String query1 = "delete from TB_DETAIL_CV_AND_POST where ID_POST = '" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query1);
		String query = "delete from TB_POST where ID_POST='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public Profile getProfileByID_DAL(String id_PROFILE) throws ClassNotFoundException, SQLException {
		String query = "select * from TB_PROFILE where ID_PROFILE='" + id_PROFILE + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		Profile profile = new Profile();

		profile.setID_PROFILE(defaultTableModel.getValueAt(0, 0).toString());
		// profile.setIMAGE((defaultTableModel.getValueAt(0, 1) !=
		// null)?defaultTableModel.getValueAt(0, 1).toString():"");
		profile.setIMAGE(DBHelper.getInstance().GetImageProfile(query));
		profile.setNAME(defaultTableModel.getValueAt(0, 2).toString());
		profile.setCITY(defaultTableModel.getValueAt(0, 3).toString());
		profile.setPHONENUMBER(defaultTableModel.getValueAt(0, 4).toString());
		profile.setEMAIL(defaultTableModel.getValueAt(0, 5).toString());
		profile.setFACEBOOK(
				(defaultTableModel.getValueAt(0, 6) == null) ? "Empty" : defaultTableModel.getValueAt(0, 6).toString());
		profile.setWEBSITE(
				(defaultTableModel.getValueAt(0, 7) == null) ? "Empty" : defaultTableModel.getValueAt(0, 7).toString());

		return profile;
	}

	// bang jobseeker
	public List<JobSeeker> getAllJobSeeker_DAL() throws ClassNotFoundException, SQLException {
		List<JobSeeker> list = new ArrayList<JobSeeker>();
		String query = "select * from TB_JOBSEEKER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				JobSeeker jobSeeker = new JobSeeker();

				jobSeeker.setID_JOBSEEKER(defaultTableModel.getValueAt(i, 0).toString());
				jobSeeker.setACCOUNT(getAccountByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
				jobSeeker.setPROFILE(getProfileByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
				jobSeeker.setAGE(Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString()));
				jobSeeker.setGENDER(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 4).toString()));
				jobSeeker.setPROFESSIONAL(defaultTableModel.getValueAt(i, 5).toString());

				list.add(jobSeeker);
			}
		}
		return list;
	}

	// category
	public List<Category_job> getListCategory_job_DAL() throws ClassNotFoundException, SQLException {
		List<Category_job> list = new ArrayList<Category_job>();
		String query = "select * from TB_CATEGORY_JOB";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Category_job category_job = new Category_job();

				category_job.setID_CATEGORY_JOB(defaultTableModel.getValueAt(i, 0).toString());
				category_job.setCATEGORY_JOB_NAME(defaultTableModel.getValueAt(i, 1).toString());
				list.add(category_job);
			}
		}
		return list;
	}

	public List<Employer> getAllEmployer_DAL() throws ClassNotFoundException, SQLException {
		List<Employer> list = new ArrayList<Employer>();
		String query = "select * from TB_EMPLOYER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Employer em = new Employer();

				em.setID_EMPLOYER(defaultTableModel.getValueAt(i, 0).toString());
				em.setACCOUNT(getAccountByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
				em.setPROFILE(getProfileByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));

				list.add(em);
			}
		}
		return list;
	}

	public JobSeeker getJobSeekerByID(String ID) throws ClassNotFoundException, SQLException {
		for (JobSeeker i : getAllJobSeeker_DAL())
			if (i.getID_JOBSEEKER().equals(ID))
				return i;
		return null;
	}

	public String SelectLastRow_DAL(String query) throws ClassNotFoundException, SQLException {
		DefaultTableModel defaultTableModel = (DBHelper.getInstance().GetRecords(query) != null)
				? DBHelper.getInstance().GetRecords(query)
				: null;
		return (defaultTableModel != null) ? defaultTableModel.getValueAt(0, 0).toString() : null;
	}

	public boolean checkAccount_DAL(String username, boolean accesser) throws ClassNotFoundException, SQLException {
		String query = "select * from TB_ACCOUNT where USERNAME = '" + username + "' and ACCESSER = '" + accesser + "'";
		DefaultTableModel defaultTableModel = (DBHelper.getInstance().GetRecords(query) != null)
				? DBHelper.getInstance().GetRecords(query)
				: null;
		if (defaultTableModel == null)
			return false;
		if (defaultTableModel.getRowCount() == 1)
			return true;
		return false;
	}

	public boolean CheckAdmin_DAL(String name, String pwd) throws ClassNotFoundException, SQLException {
		String query = "select * from TB_ACCOUNT where USERNAME='" + name + "' and PASSWORD='" + pwd
				+ "' and ACCESSER IS NULL";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel.getRowCount() == 1)
			return true;
		return false;
	}

	public List<String> getListJobName_DAL() throws ClassNotFoundException, SQLException {
		String query = "select CATEGORY_JOB_NAME from TB_CATEGORY_JOB";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < defaultTableModel.getRowCount(); i++)
			tmp.add(defaultTableModel.getValueAt(i, 0).toString());
		return tmp;
	}

	public List<String> getListPROFESSIONAL_DAL() throws ClassNotFoundException, SQLException {
		List<String> tmp = new ArrayList<String>();
		for (JobSeeker i : getAllJobSeeker_DAL())
			if (!tmp.contains(i.getPROFESSIONAL()))
				tmp.add(i.getPROFESSIONAL());
		return tmp;
	}

	public List<String> getListAddressJobSeeker_DAL() throws ClassNotFoundException, SQLException {
		List<String> tmp = new ArrayList<String>();
		for (JobSeeker i : getAllJobSeeker_DAL())
			if (!tmp.contains(i.getPROFILE().getCITY()))
				tmp.add(i.getPROFILE().getCITY());
		return tmp;
	}

	public String SelectLastRowEmployer_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_EMPLOYER\r\n" + "from TB_EMPLOYER\r\n" + "where ID_EMPLOYER like '" + spe
				+ "%'\r\n" + "order by ID_EMPLOYER desc ";
		return SelectLastRow_DAL(readID);
	}

	public String SelectLastRowJobSeeker_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_JOBSEEKER\r\n" + "from TB_JOBSEEKER\r\n" + "where ID_JOBSEEKER like '" + spe
				+ "%'\r\n" + "order by ID_JOBSEEKER desc ";
		return SelectLastRow_DAL(readID);
	}

	public String SelectLastRowAccount_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_ACCOUNT\r\n" + "from TB_ACCOUNT\r\n" + "where ID_ACCOUNT like '" + spe
				+ "%'\r\n" + "order by ID_ACCOUNT desc ";
		return SelectLastRow_DAL(readID);
	}

	public String SelectLastRowProfile_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_PROFILE\r\n" + "from TB_PROFILE\r\n" + "where ID_PROFILE like '" + spe
				+ "%'\r\n" + "order by ID_PROFILE desc ";
		return SelectLastRow_DAL(readID);
	}

	public String SelectLastRowPost_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_POST\r\n" + "from TB_POST\r\n" + "where ID_POST like '" + spe + "%'\r\n"
				+ "order by ID_POST desc ";
		return SelectLastRow_DAL(readID);
	}

	public String SelectLastRowCV_DAL(String spe) throws ClassNotFoundException, SQLException {
		String readID = "select top 1 ID_CV\r\n" + "from TB_CV\r\n" + "where ID_CV like '" + spe + "%'\r\n"
				+ "order by ID_CV desc ";
		return SelectLastRow_DAL(readID);
	}

	public void ExcuteDB(String query) throws ClassNotFoundException, SQLException {
		DBHelper.getInstance().ExcuteDB(query);
	}

	public List<String> getListAddressPost_DAL() throws ClassNotFoundException, SQLException {
		String query = "select CITY from TB_POST";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		List<String> tmp = new ArrayList<String>();
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				if (!tmp.contains(defaultTableModel.getValueAt(i, 0).toString())) {
					tmp.add(defaultTableModel.getValueAt(i, 0).toString());
				}
			}
		}
		return tmp;
	}

	public void EditProfileEmployer_DAl(String iD, String name, String city, String phoneNumber, String email,
			String linkFacebook, String linkZalo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "update TB_PROFILE set Name ='" + name + "', CITY = '" + city + "', PHONE_NUMBER = '"
				+ phoneNumber + "', EMAIL = '" + email + "'";
		if (!linkFacebook.equals("Empty")) {
			query += ", FACEBOOK='" + linkFacebook + "'";
		}
		if (!linkZalo.equals("Empty")) {
			query += ", WEBSITE='" + linkZalo + "'";
		}
		query += " where ID_PROFILE = '" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void EditProfileJobseeker_DAl(String iDprofile, String iDjobseeker, String name, String age, boolean gender,
			String phoneNumber, String email, String professional, String linkFacebook, String linkZalo)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "update TB_PROFILE set NAME ='" + name + "', PHONE_NUMBER = '" + phoneNumber + "', EMAIL = '"
				+ email + "'";
		if (!linkFacebook.equals("Empty") || !linkFacebook.equals("")) {
			query += ", FACEBOOK='" + linkFacebook + "'";
		}
		if (!linkZalo.equals("Empty") || !linkZalo.equals("")) {
			query += ", WEBSITE='" + linkZalo + "'";
		}
		query += " where ID_PROFILE = '" + iDprofile + "'";
		String query2 = "update TB_JOBSEEKER set AGE =" + age + ", GENDER ='" + gender + "', PROFESSIONAL = '"
				+ professional + "' where ID_JOBSEEKER = '" + iDjobseeker + "'";
		DBHelper.getInstance().ExcuteDB(query);
		DBHelper.getInstance().ExcuteDB(query2);

	}

	public String getIDCategoryByName(String category_job_name) throws ClassNotFoundException, SQLException {
		for (Category_job i : getListCategory_job_DAL()) {
			if (i.getCATEGORY_JOB_NAME().equals(category_job_name)) {
				return i.getID_CATEGORY_JOB();
			}
		}
		return null;
	}

	public void Post_DAL(String idP, String iD_Acc, String jobname, String companyname, String city, String salary,
			String descrip, String labor, String category, String date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "insert into TB_POST values('" + idP + "','"
				+ getEmployerByIDAccount_DAL(iD_Acc).getID_EMPLOYER() + "','" + getIDCategoryByName(category) + "','"
				+ jobname + "','" + companyname + "','" + city + "'," + salary + ",'" + descrip + "'," + labor
				+ ",'False','" + date+"')";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void AddCV_DAL(String idcv, String idjob, String path) throws ClassNotFoundException, SQLException {
		String query = "Insert into TB_CV(ID_CV, ID_JOBSEEKER, ADDRESS_CV) values ('" + idcv + "','" + idjob + "','"
				+ path + "')";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void EditCV_DAL(String idcv, String path) throws ClassNotFoundException, SQLException {
		String query = "Update TB_CV set ADDRESS_CV = '" + path + "' where ID_CV = '" + idcv + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void AddCVToPost_DAL(String idPost, String idCV, String date) throws ClassNotFoundException, SQLException {

		String query = "Insert into TB_DETAIL_CV_AND_POST VALUES ('" + idPost + "','" + idCV + "','False','"+ date +"')";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public String getIdCVByIdJobSeeker_DAL(String idJobSeeker) throws ClassNotFoundException, SQLException {
		String query = "Select ID_CV from TB_CV where ID_JOBSEEKER = '" + idJobSeeker + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);

		return (defaultTableModel != null) ? defaultTableModel.getValueAt(0, 0).toString() : "";
	}

	public void DeletePostByID_DAL(String iD) throws ClassNotFoundException, SQLException {
		String query = "delete from TB_POST where ID_POST ='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public byte[] getImage(String idProfile) throws ClassNotFoundException, SQLException {
		byte[] image = null;
		String query = "Select IMAGE from TB_PROFILE where ID_PROFILE = '" + idProfile + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		JOptionPane.showMessageDialog(null, defaultTableModel != null);
		image = (defaultTableModel != null) ? (defaultTableModel.getValueAt(0, 0).toString().getBytes()) : null;

		return image;
	}

	public boolean checkApply(String idPost, String idCV) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "Select * from TB_DETAIL_CV_AND_POST where ID_POST = '" + idPost + "'and ID_CV = '" + idCV + "'";
		if (DBHelper.getInstance().GetRecords(query) != null)
			return true;
		return false;
	}

	public void EditImageProfile_DAL(byte[] image, String IDprofile) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "UPDATE TB_PROFILE set IMAGE=? where [ID_PROFILE] = '" + IDprofile + "'";
		DBHelper.getInstance().ExcuteDBImage(image, query);
	}

	public List<String> getListCVByID_Jobseeker_DAL(String id_JOBSEEKER) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "Select ADDRESS_CV from TB_CV where ID_JOBSEEKER = '" + id_JOBSEEKER + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		List<String> ListCV = new ArrayList<String>();
		if (defaultTableModel != null) {
			for (int i = 0; i < defaultTableModel.getRowCount(); i++)
				ListCV.add(defaultTableModel.getValueAt(i, 0).toString());
			return ListCV;
		}
		return null;
	}

	public String getIdJobSeekerByIdCV(String idCV) throws ClassNotFoundException, SQLException {
		String query = "SELECT ID_JOBSEEKER FROM TB_CV WHERE ID_CV = '" + idCV + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);

		return (defaultTableModel != null) ? defaultTableModel.getValueAt(0, 0).toString() : "";
	}

	public CV getCvByIdCV(String idCV) throws ClassNotFoundException, SQLException {
		CV cv = new CV();
		String query = "SELECT * FROM TB_CV WHERE ID_CV = '" + idCV + "'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		cv.setID_CV(defaultTableModel.getValueAt(0, 0).toString());
		cv.setJOBSEEKER(getJobSeekerByID(defaultTableModel.getValueAt(0, 1).toString()));
		cv.setADDRESS_CV(defaultTableModel.getValueAt(0, 2).toString());

		return cv;
	}

	public List<JobSeekerApply> getListJobSeekerApplies_DAL(String idPost) throws ClassNotFoundException, SQLException, ParseException {
		List<JobSeekerApply> listJobSeekerApplies = new ArrayList<JobSeekerApply>();
		String query = "SELECT * FROM TB_DETAIL_CV_AND_POST WHERE ID_POST = '" + idPost + "'";
		DefaultTableModel dtm = null;

		dtm = DBHelper.getInstance().GetRecords(query);
		if (dtm != null) {
			for (int i = 0; i < dtm.getRowCount(); i++) {
				JobSeekerApply jobSeekerApply = new JobSeekerApply();
				String idCV = dtm.getValueAt(i, 1).toString();
				boolean status = (boolean) dtm.getValueAt(i, 2);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String dateString = dtm.getValueAt(i, 3).toString();
				java.util.Date date = new java.util.Date();
				if(dateString.length() != 0)
					date = format.parse(dateString);

				JobSeeker jobSeeker = new JobSeeker();
				jobSeeker = getJobSeekerByID(getIdJobSeekerByIdCV(idCV));
				CV cv = new CV();
				cv = getCvByIdCV(idCV);

				jobSeekerApply.setCv(cv);
				jobSeekerApply.setJobSeeker(jobSeeker);
				jobSeekerApply.setStatus(status);
				jobSeekerApply.setDateTime(date);

				listJobSeekerApplies.add(jobSeekerApply);
			}
		}
		return listJobSeekerApplies;
	}

	public List<Detail_CV_And_Post> getDetailByIDCV_DAL(String iDCV) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Detail_CV_And_Post> listDetail = new ArrayList<Detail_CV_And_Post>();
		String query = "select * from TB_DETAIL_CV_AND_POST where ID_CV = '" + iDCV + "'";
		DefaultTableModel dtm = DBHelper.getInstance().GetRecords(query);
		if (dtm != null) {
			for (int i = 0; i < dtm.getRowCount(); i++) {
				Detail_CV_And_Post detail_CV_And_Post = new Detail_CV_And_Post();

				detail_CV_And_Post.setID_POST(dtm.getValueAt(i, 0).toString());
				detail_CV_And_Post.setID_CV(dtm.getValueAt(i, 1).toString());
				detail_CV_And_Post.setSTATUS(Boolean.parseBoolean(dtm.getValueAt(i, 2).toString()));

				listDetail.add(detail_CV_And_Post);
			}
		}
		return listDetail;
	}

	public List<Post> getListPostApplied_DAL(String idJobseeker) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String IDCV = getIdCVByIdJobSeeker_DAL(idJobseeker);
		List<Post> listPost = new ArrayList<Post>();
		String query = "select * from TB_POST where ID_POST = '";
		for (Detail_CV_And_Post i : getDetailByIDCV_DAL(IDCV)) {
			DefaultTableModel dtm = DBHelper.getInstance().GetRecords(query + i.getID_POST() + "'");
			if (dtm != null) {
				Post post = new Post();
				post.setID_POST(dtm.getValueAt(0, 0).toString());
				post.setEMPLOYER(getEmployerByID_DAL(dtm.getValueAt(0, 1).toString()));
				post.setCATEGORY_JOB(getCategory_jobByID_DAL(dtm.getValueAt(0, 2).toString()));
				post.setJOB_NAME(dtm.getValueAt(0, 3).toString());
				post.setCOMPANY_NAME((dtm.getValueAt(0, 4) != null) ? dtm.getValueAt(0, 4).toString() : "");
				post.setCITY(dtm.getValueAt(0, 5).toString());
				post.setSALARY((dtm.getValueAt(0, 6) != null) ? Integer.parseInt(dtm.getValueAt(0, 6).toString()) : -1);
				post.setDESCIPTION_JOB((dtm.getValueAt(0, 7) != null) ? dtm.getValueAt(0, 7).toString() : "");
				post.setLABOR((dtm.getValueAt(0, 8) != null) ? Integer.parseInt(dtm.getValueAt(0, 8).toString()) : -1);
				post.setSTATUS(i.getSTATUS());

				listPost.add(post);
			}
		}
		return listPost;
	}

	public void CancelAppliedsI_DAL(String iD) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "delete from TB_DETAIL_CV_AND_POST where ID_POST='" + iD + "'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public boolean checkCommunication_DAL(String idEmployer, String idJobSeeker, String idPost)
			throws ClassNotFoundException, SQLException {
		String query = "select * from TB_COMMUNICATION where ID_EMPLOYER = '" + idEmployer + "' and ID_JOBSEEKER = '"
				+ idJobSeeker + "' and ID_POST = '" + idPost + "'";
		DefaultTableModel defaultTableModel = (DBHelper.getInstance().GetRecords(query) != null)
				? DBHelper.getInstance().GetRecords(query)
				: null;
		if (defaultTableModel == null)
			return false;
		if (defaultTableModel.getRowCount() == 1)
			return true;
		return false;
	}

	public void sendMessToJobSeeker_DAL(String idEmployer, String idJobSeeker, String contents, String idPost)
			throws ClassNotFoundException, SQLException {
		String query = "Insert into TB_COMMUNICATION values ('" + idEmployer + "','" + idJobSeeker + "','" + contents
				+ "','" + idPost + "')";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public List<Communication> getListCommunicationByID_Jobseeker_DAL(String idJobseeker)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "select * from TB_COMMUNICATION where ID_JOBSEEKER = '" + idJobseeker + "'";
		List<Communication> listCommunication = new ArrayList<Communication>();
		DefaultTableModel dtm = DBHelper.getInstance().GetRecords(query);
		if (dtm != null) {
			for (int i = 0; i < dtm.getRowCount(); i++) {
				Communication communication = new Communication();

				communication.setID_EMPLOYER(dtm.getValueAt(i, 0).toString());
				communication.setID_JOBSEEKER(dtm.getValueAt(i, 1).toString());
				communication.setMESS(dtm.getValueAt(i, 2).toString());
				communication.setID_POST(dtm.getValueAt(i, 3).toString());

				listCommunication.add(communication);
			}
		}
		return listCommunication;
	}

	public Post getPostByIDPOST_DAL(String id_POST) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "select * from TB_POST where ID_POST = '" + id_POST + "'";
		Post post = new Post();
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if (defaultTableModel != null) {
			post.setID_POST(defaultTableModel.getValueAt(0, 0).toString());
			post.setEMPLOYER(getEmployerByID_DAL(defaultTableModel.getValueAt(0, 1).toString()));
			post.setCATEGORY_JOB(getCategory_jobByID_DAL(defaultTableModel.getValueAt(0, 2).toString()));
			post.setJOB_NAME(defaultTableModel.getValueAt(0, 3).toString());
			post.setCOMPANY_NAME(
					(defaultTableModel.getValueAt(0, 4) != null) ? defaultTableModel.getValueAt(0, 4).toString() : "");
			post.setCITY(defaultTableModel.getValueAt(0, 5).toString());
			post.setSALARY((defaultTableModel.getValueAt(0, 6) != null)
					? Integer.parseInt(defaultTableModel.getValueAt(0, 6).toString())
					: -1);
			post.setDESCIPTION_JOB(
					(defaultTableModel.getValueAt(0, 7) != null) ? defaultTableModel.getValueAt(0, 7).toString() : "");
			post.setLABOR((defaultTableModel.getValueAt(0, 8) != null)
					? Integer.parseInt(defaultTableModel.getValueAt(0, 8).toString())
					: -1);
			post.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(0, 9).toString()));

		}
		return post;
	}
}