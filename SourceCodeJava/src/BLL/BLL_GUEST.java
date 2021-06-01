package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAL.DAL;
import DTO.Account;
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
	public List<Post> getListPostByNameAndAddress_BLL_GUEST(String name, String address) {
		// TODO Auto-generated method stub
		try {
			List<Post> list = new ArrayList<Post>();
			for(Post i : DAL.getInstance().getListPost_DAL())
			{
				if(i.getJOB_NAME().contains(name) && i.getCITY().contains(address))
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
				if(i.getPROFILE().getNAME().contains(name) && i.getPROFILE().getCITY().contains(address))
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
}
