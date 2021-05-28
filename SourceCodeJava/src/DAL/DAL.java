package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DTO.Account;
<<<<<<< HEAD
import DTO.Employer;
=======
import DTO.CV;
import DTO.Category_job;
import DTO.Employer;
import DTO.JobSeeker;
import DTO.Post;
import DTO.Profile;
>>>>>>> b8ebc18 (push code)

public class DAL
{
	private static DAL Instance;
	
	public static DAL getInstance()
	{
		if(Instance == null)
			Instance = new DAL();
		return Instance;
	}
	
<<<<<<< HEAD
	public List<Employer> getListEmployers_DAL() throws ClassNotFoundException, SQLException
=======
	public static List<Employer> getListEmployers_DAL() throws ClassNotFoundException, SQLException
>>>>>>> b8ebc18 (push code)
	{
		List<Employer> list = new ArrayList<Employer>();
		String query = "Select * from TB_EMPLOYER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			Employer employer = new Employer();
			
			employer.setID_EMPLOYER(defaultTableModel.getValueAt(i, 0).toString());
<<<<<<< HEAD
			employer.setNAME_EMPLOYER(defaultTableModel.getValueAt(i, 1).toString());
			employer.setID_ADDRESS(defaultTableModel.getValueAt(i, 2).toString());
			employer.setID_ACCOUNT(defaultTableModel.getValueAt(i, 3).toString());
=======
			employer.setACCOUNT(getAccountByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
			employer.setPROFILE(getProfileByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
>>>>>>> b8ebc18 (push code)
			
			list.add(employer);
		}
		
		return list;
	}
<<<<<<< HEAD
	
=======
	public static Employer getEmployerByID_DAL(String ID) throws ClassNotFoundException, SQLException
	{
		for(Employer i : getListEmployers_DAL())
		{
			if(i.getID_EMPLOYER().equals(ID))
			{
				return i;
			}
		}
		return null;
	}
>>>>>>> b8ebc18 (push code)
	public static List<Account> getListAccounts_DAL() throws ClassNotFoundException, SQLException
	{
		List<Account> list = new ArrayList<Account>();
		String query = "Select * from TB_ACCOUNT";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
<<<<<<< HEAD
		
=======
>>>>>>> b8ebc18 (push code)
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			Account account = new Account();
			
			account.setID_ACCOUNT(defaultTableModel.getValueAt(i, 0).toString());
			account.setUSERNAME(defaultTableModel.getValueAt(i, 1).toString());
			account.setPASSWORD(defaultTableModel.getValueAt(i, 2).toString());
<<<<<<< HEAD
			account.setEMAIL(defaultTableModel.getValueAt(i, 3).toString());
			account.setPHONENUMBER(defaultTableModel.getValueAt(i, 4).toString());
			account.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 5).toString()));
			account.setCATEGORY(defaultTableModel.getValueAt(i, 6).toString());
=======
			if(defaultTableModel.getValueAt(i, 3)==null)
			{
				break;
			}
			account.setACCESSER(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 3).toString()));
			account.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 4).toString()));
>>>>>>> b8ebc18 (push code)
			
			list.add(account);
		}
		
		return list;
	}
<<<<<<< HEAD

}
=======
	public static Account getAccountByID_DAL(String id_ACCOUNT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		for(Account i :getListAccounts_DAL())
		{
			if(i.getID_ACCOUNT().equals(id_ACCOUNT))
			{
				return i;
			}
		}
		return null;
	}
	// category
	public static Category_job getCategory_jobByID_DAL(String ID) throws ClassNotFoundException, SQLException
	{
		String query ="select from TB_CATEGORY_JOB where ID_CATEGORY_JOB ='"+ID+"'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		Category_job category_job = new Category_job();
			
		category_job.setID_CATEGORY_JOB(defaultTableModel.getValueAt(0, 0).toString());
		category_job.setCATEGORY_JOB_NAME(defaultTableModel.getValueAt(0, 1).toString());
		return category_job;
	}
	// List post
	public static List<Post> getListPost_DAL() throws ClassNotFoundException, SQLException
	{
		List<Post> list = new ArrayList<Post>();
		String query = "Select * from TB_POST";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			Post post = new Post();
			
			post.setID_POST(defaultTableModel.getValueAt(i, 0).toString());
			post.setEMPLOYER(getEmployerByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
			post.setCATEGORY_JOB(getCategory_jobByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
			post.setJOB_NAME(defaultTableModel.getValueAt(i, 3).toString());
			post.setCOMPANY_NAME(defaultTableModel.getValueAt(i, 4).toString());
			post.setCITY(defaultTableModel.getValueAt(i, 5).toString());
			post.setSALARY(Integer.parseInt(defaultTableModel.getValueAt(i, 6).toString()));
			post.setDESCIPTION_JOB(defaultTableModel.getValueAt(i, 7).toString());
			post.setLABOR(Integer.parseInt(defaultTableModel.getValueAt(i, 8).toString()));
			post.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 9).toString()));
			
			list.add(post);
		}
		
		return list;
	}
	public static Post getPostByID_DAL(String ID) throws ClassNotFoundException, SQLException
	{
		for(Post i : getListPost_DAL())
		{
			if(i.getID_POST().equals(ID))
			{
				return i;
			}
		}
		return null;
	}
	
	//
	public static List<String[]> getJOB_NAMEByID_POST_DAL(String ID) throws ClassNotFoundException, SQLException
	{
		List<String[]> tmp = new ArrayList<String[]>();
		for(Post i : getListPost_DAL())
		{
			if(i.getID_POST().equals(ID))
			{
				String[] t = {
						i.getID_POST(),i.getJOB_NAME(),i.getCITY()
				};
				tmp.add(t);
			}
		}
		return tmp;
	}
	
	public String getID_POSTByID_EMPLOYER(String ID) throws ClassNotFoundException, SQLException
	{
		for(Post i : getListPost_DAL())
		{
			if(i.getEMPLOYER().getID_EMPLOYER().equals(ID))
			{
				return i.getID_POST();
			}
		}
		return null;
	}
	public String getID_JOBSEEKERByID_ACCOUNT(String ID) throws ClassNotFoundException, SQLException
	{
		for(JobSeeker i : getAllJobSeeker_DAL())
		{
			if(i.getACCOUNT().getID_ACCOUNT().equals(ID))
			{
				return i.getACCOUNT().getID_ACCOUNT();
			}
		}
		return null;
	}
	
	public CV getCVByID_JOBSEEKER(String ID) throws ClassNotFoundException, SQLException
	{
		String query = "select * from TB_CV where ID_JOBSEEKER ='"+ID+"'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		CV cv = new CV();
		if(defaultTableModel.getRowCount()==1)
		{
			cv.setID_CV(defaultTableModel.getValueAt(0, 0).toString());
			cv.setJOBSEEKER(getJobSeekerByID(defaultTableModel.getValueAt(0, 1).toString()));
			cv.setADDRESS_CV(defaultTableModel.getValueAt(0, 2).toString());
		}
		return cv;
		
	}
	
	public void DeleteTB_POSTbyID_POST_DAL(String iD) throws ClassNotFoundException, SQLException
	{
		String query = "delete from TB_POST where ID_POST ='"+iD+"'";
		DBHelper.getInstance().ExcuteDB(query);
	}
	public void DeleteAccountbyID_DAL(String iD) throws ClassNotFoundException, SQLException {
		
		boolean kt = true;
		for(Employer i : getListEmployers_DAL())
		{
			System.out.println("for");
			if(iD.equals(i.getACCOUNT().getID_ACCOUNT()))
			{
				String query = "delete from TB_DETAIL_CV_AND_POST where ID_POST='"+getID_POSTByID_EMPLOYER(i.getID_EMPLOYER())+"'";
				DBHelper.getInstance().ExcuteDB(query);
				String query1 = "delete from TB_POST where ID_EMPLOYER='"+i.getID_EMPLOYER()+"'";
				DBHelper.getInstance().ExcuteDB(query1);
				String query2 = "delete from TB_EMPLOYER where ID_ACCOUNT='"+iD+"'";
				DBHelper.getInstance().ExcuteDB(query2);
				String query3 = "delete from TB_PROFILE where ID_PROFILE='"+i.getPROFILE().getID_PROFILE()+"'";
				DBHelper.getInstance().ExcuteDB(query3);
				kt = false;
			}
		}
		System.out.println("first hi");
		if(kt)
		{
			String query2 = "delete from TB_DETAIL_CV_AND_POST where ID_CV='"+getCVByID_JOBSEEKER(getID_JOBSEEKERByID_ACCOUNT(iD)).getID_CV()+"'";
			DBHelper.getInstance().ExcuteDB(query2);
			String query3 = "delete from TB_CV where ID_JOBSEEKER='"+getID_JOBSEEKERByID_ACCOUNT(iD)+"'";
			DBHelper.getInstance().ExcuteDB(query3);
			String query4 = "delete from TB_JOBSEEKER where ID_ACCOUNT='"+iD+"'";
			DBHelper.getInstance().ExcuteDB(query4);
			String query5 = "delete from TB_PROFILE where ID_PROFILE='"+getJobSeekerByID(getID_JOBSEEKERByID_ACCOUNT(iD)).getPROFILE().getID_PROFILE()+"'";
			DBHelper.getInstance().ExcuteDB(query5);
		}
		System.out.println("last hi");
		String query = "delete from TB_ACCOUNT where ID_ACCOUNT='"+iD+"'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void BlockAccountbyID_Account_DAL(String iD) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "update TB_ACCOUNT set STATUS = 'False' where ID_ACCOUNT='"+iD+"'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public void AcceptPost_DAL(String iD) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "update TB_POST set STATUS = 'True' where ID_POST='"+iD+"'";
		DBHelper.getInstance().ExcuteDB(query);
	}

	public static Profile getProfileByID_DAL(String id_PROFILE) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "select from TB_PROFILE where ID_PROFILE='"+id_PROFILE+"'";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		Profile profile = new Profile();
			
		profile.setID_PROFILE(defaultTableModel.getValueAt(0, 0).toString());
		profile.setIMAGE(defaultTableModel.getValueAt(0, 1).toString());
		profile.setNAME(defaultTableModel.getValueAt(0, 2).toString());
		profile.setCITY(defaultTableModel.getValueAt(0, 3).toString());
		profile.setPHONENUMBER(defaultTableModel.getValueAt(0, 4).toString());
		profile.setEMAIL(defaultTableModel.getValueAt(0, 5).toString());
		profile.setFACEBOOK(defaultTableModel.getValueAt(0, 6).toString());
		profile.setWEBSITE(defaultTableModel.getValueAt(0, 4).toString());
		
		return profile;
	}
	// bang jobseeker
	public List<JobSeeker> getAllJobSeeker_DAL() throws ClassNotFoundException, SQLException
	{
		List<JobSeeker> list = new ArrayList<JobSeeker>();
		String query = "select * from TB_JOBSEEKER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			JobSeeker jobSeeker = new JobSeeker();
			
			jobSeeker.setID_JOBSEEKER(defaultTableModel.getValueAt(i, 0).toString());
			jobSeeker.setACCOUNT(getAccountByID_DAL(defaultTableModel.getValueAt(i, 1).toString()));
			jobSeeker.setPROFILE(getProfileByID_DAL(defaultTableModel.getValueAt(i, 2).toString()));
			jobSeeker.setAGE(Integer.parseInt(defaultTableModel.getValueAt(i, 3).toString()));
			jobSeeker.setGENDER(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 4).toString()));
			jobSeeker.setPROFESSIONAL(defaultTableModel.getValueAt(i, 5).toString());
			
			list.add(jobSeeker);
		}
		
		return list;
	}
	public JobSeeker getJobSeekerByID(String ID) throws ClassNotFoundException, SQLException
	{
		JobSeeker j = new JobSeeker();
		for(JobSeeker i : getAllJobSeeker_DAL())
		{
			if(i.getID_JOBSEEKER().equals(ID))
			{
				return i;
			}
		}
		return null;
	}

	public boolean CheckAdmin_DAL(String name, String pwd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query="select * from TB_ACCOUNT where USERNAME='"+name + "' and PASSWORD='"+pwd +"' and ACCESSER IS NULL";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		if(defaultTableModel.getRowCount()==1)
			return true;
		return false;
	}

}
>>>>>>> b8ebc18 (push code)
