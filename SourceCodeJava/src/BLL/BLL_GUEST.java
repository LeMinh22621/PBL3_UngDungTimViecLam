package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;
import DTO.Category_job;
import DTO.JobSeeker;
import DTO.Post;
import DTO.Profile;

public class BLL_GUEST {
	private static BLL_GUEST Instance;
	public static BLL_GUEST getInstance()
	{
		if( Instance == null)
			Instance = new BLL_GUEST();
		return Instance;
	}
	public List<Post> getListPostByNameAndAddress_BLL_GUEST(String name, String address)
	{
		try
		{
			List<Post> list = new ArrayList<Post>();
			for(Post i : DAL.getInstance().getListPost_DAL())
			{
				if(i.getCATEGORY_JOB().getCATEGORY_JOB_NAME().contains(name) && i.getCITY().contains(address))
				{
					list.add(i);
				}
			}
			return list;
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public List<JobSeeker> GetlistJobSeeker_BLL_GUEST(String name,String address) {
		try {
			List<JobSeeker> list = new ArrayList<JobSeeker>();
			for(JobSeeker i : DAL.getInstance().getAllJobSeeker_DAL())
			{
				if(i.getPROFESSIONAL().contains(name) && i.getPROFILE().getCITY().contains(address))
				{
					list.add(i);
				}
			}
			return list;
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
		
	}
	public Account getAccountByID_BLL_GUEST(String id_ACCOUNT) {
		// TODO Auto-generated method stub
		try {
			return DAL.getInstance().getAccountByID_DAL(id_ACCOUNT);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public Profile getProfileByID_BLL_GUEST(String id_PROFILE) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().getProfileByID_DAL(id_PROFILE);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public List<String> getListPROFESSIONAL_BLL_GUEST()
	{
		try {
			return DAL.getInstance().getListPROFESSIONAL_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public List<String> getListAddressJobseeker_BLL_GUEST() {

		try {
			return DAL.getInstance().getListAddressJobSeeker_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public List<String> getListJobName_BLL_GUEST() {
		try {
			return DAL.getInstance().getListJobName_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public List<String> getListAddressPost_BLL_GUEST() {
		try {
			return DAL.getInstance().getListAddressPost_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public Profile getProfileByID_Account_BLL_GUEST(String id_ACCOUNT) {
		
		try {
			return DAL.getInstance().getEmployerByIDAccount_DAL(id_ACCOUNT).getPROFILE();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public JobSeeker getJobseekerByID_Profile_BLL_GUEST(String id_PROFILE) {
		try {
			for(JobSeeker i : DAL.getInstance().getAllJobSeeker_DAL())
			{
				if(i.getPROFILE().getID_PROFILE().equals(id_PROFILE))
				{
					return i;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public Profile getProfileJobByID_Account_BLL_GUEST(String id_ACCOUNT) {
		try {
			return DAL.getInstance().getJobSeekerByIDAccount_DAL(id_ACCOUNT).getPROFILE();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	public int SelectLastRowPost_BLL()
	{
		int result = -1;
		try
		{
			String id = DAL.getInstance().SelectLastRowPost_DAL("P");
			String num = id.replaceAll("P", "");
			result = Integer.parseInt(num);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
	public void Post_BLL_GUEST(String iD_Acc, String jobname, String companyname, String city, String salary,
			String descrip, String labor,String category) {
		// TODO Auto-generated method stub
		if(jobname.length() != 0 && companyname.length() != 0 && city.length() != 0 && descrip.length() != 0 && salary.length() != 0)
		{
			try {
					int idp = SelectLastRowPost_BLL() + 1;
					String IDP = "P" + idp;
					DAL.getInstance().Post_DAl(IDP,iD_Acc,jobname,companyname,city,salary,descrip,labor,category);
					JOptionPane.showMessageDialog(null, "Post success!");
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Post failed");
				}
		}
		else
			JOptionPane.showMessageDialog(null, "Please full fill");
	}
	public List<String> getListCategoryJobName_BLL_GUEST() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		try {
			for(Category_job i: DAL.getInstance().getListCategory_job_DAL())
			{
				list.add(i.getCATEGORY_JOB_NAME());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}
}
