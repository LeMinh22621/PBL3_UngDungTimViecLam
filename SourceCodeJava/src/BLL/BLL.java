package BLL;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;
import DTO.JobSeekerApply;
import DTO.Post;

public class BLL
{
	private static BLL Instance;
	public static BLL getInstance()
	{
		if( Instance == null)
			Instance = new BLL();
		return Instance;
	}
	public List<Account> getListAccount_BLL()
	{
		List<Account> list = new ArrayList<Account>();
		try
		{
			list = DAL.getInstance().getListAccounts_DAL();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return list;
	}
	
	public List<Post> getListPost_BLL()
	{
		List<Post> list = new ArrayList<Post>();
		try
		{
			list = DAL.getInstance().getListPost_DAL();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}
	public List<String[]> ShowPostForAdmin_BLL()
	{
		List<String[]> tmp = new ArrayList<String[]>();
		try {
			for(Post i : DAL.getInstance().getListPost_DAL())
			{
				String[] t = {
						i.getID_POST(),i.getJOB_NAME(),i.getCITY()
				};
				tmp.add(t);
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return tmp;
	}
	public List<String[]> getJOB_NAMEByID_POST_BLL(String ID)
	{
		try {
			return DAL.getInstance().getJOB_NAMEByID_Post_DAL(ID);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	// delete Account
	public void DeleteAccount_BLL(Account acc)
	{
		try
		{
			DAL.getInstance().DeleteAccount_DAL(acc);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void BanAccountByIDAccount_BLL(String iD)
	{
		try
		{
			DAL.getInstance().BanAccountByIDAccount_DAL(iD);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void ActiveAccountByIDAccount_BLL(String iD)
	{
		try
		{
			DAL.getInstance().ActiveAccountByIDAccount_DAL(iD);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void AcceptPost_BLL(String iD) 
	{
		try
		{
			DAL.getInstance().AcceptPost_DAL(iD);
		}
		catch (ClassNotFoundException |SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void DeclinePost_BLL(String iD) {
		try
		{
			DAL.getInstance().DeclinePost_DAL(iD);
		}
		catch (ClassNotFoundException |SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public List<Account> SortAccount_BLL(String item) {
		List<Account> list = new ArrayList<Account>();
		try
		{
			list = DAL.getInstance().getListAccounts_DAL();
			switch(item) {
				case "ID_ACCOUNT":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getID_ACCOUNT().compareTo(list.get(j).getID_ACCOUNT())>=0)
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
				case "USERNAME":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getUSERNAME().compareTo(list.get(j).getUSERNAME())>=0)
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
				case "ACCESSER":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getACCESSER()!= list.get(j).getACCESSER())
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
				case "STATUS":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getSTATUS()!= list.get(j).getSTATUS()&&list.get(i).getSTATUS())
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}
	public List<Post> SortPost_BLL(String item) {
		// TODO Auto-generated method stub "ID_POST","ID_EMPLOYER","STATUS"
		List<Post> list = new ArrayList<>();
		try {
			list = DAL.getInstance().getListPost_DAL();
			switch(item) {
				case "ID_POST":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getID_POST().compareTo(list.get(j).getID_POST())>=0)
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
				case "ID_EMPLOYER":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getEMPLOYER().getPROFILE().getNAME().compareTo(list.get(j).getEMPLOYER().getPROFILE().getNAME())>=0)
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
				case "STATUS":
				{
					for(int i=0; i<list.size()-1;i++)
					{
						for(int j=i+1;j<list.size();j++)
						{
							if(list.get(i).getSTATUS()!= list.get(j).getSTATUS()&&list.get(i).getSTATUS())
							{
								java.util.Collections.swap(list,i,j);
							}
						}
					}
					break;
				}
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}
	public int SelectLastRowCV_BLL()
	{
		int result = 1;
		try
		{
			String id = DAL.getInstance().SelectLastRowCV_DAL("CV");
			String num = id.replaceAll("CV", "");
			result = Integer.parseInt(num);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
	public void AddCV_BLL(boolean isAdd, String idAccount, String path)
	{
		try
		{
			String idCV = "CV" + SelectLastRowCV_BLL();
			if(isAdd)
			{
				String idJobSeeker = DAL.getInstance().getIdJobSeekerByIdAccount_DAL(idAccount);
				DAL.getInstance().AddCV_DAL(idCV, idJobSeeker, path);
			}
			else
			{
				DAL.getInstance().EditCV_DAL(idCV, path);
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public String getIdCVByIdJobSeeker_BLL(String idJobSeeker)
	{
		String idCV = "";
		try
		{
			idCV = DAL.getInstance().getIdCVByIdJobSeeker_DAL(idJobSeeker);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return idCV;
	}
	public boolean CheckApply(String idPost, String idCV)
	{
		try {
			if(DAL.getInstance().checkApply(idPost,idCV))
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
	public void AddCVToPost_BLL(String idPost, String idCV)
	{
		try
		{
			if(!CheckApply(idPost,idCV))
			{
				DAL.getInstance().AddCVToPost_DAL(idPost, idCV);
				JOptionPane.showMessageDialog(null, "successfully applied");
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public String getIdJobSeekerByIdAccount_BLL(String idAccount)
	{
		String idJobSeeker = "";
		try
		{
			idJobSeeker = DAL.getInstance().getIdJobSeekerByIdAccount_DAL(idAccount);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return idJobSeeker;
	}
	public Image  getImage_BLL(String idProfile)
	{
		
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(new ByteArrayInputStream(DAL.getInstance().getImage(idProfile)));
			JOptionPane.showMessageDialog(null, idProfile);
		}
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return image;
	}
	public List<JobSeekerApply> getListJobSeekerApply_BLL(String idPost)
	{
		List<JobSeekerApply> listJobSeekerApplies = new ArrayList<JobSeekerApply>();
		try
		{
			listJobSeekerApplies = DAL.getInstance().getListJobSeekerApplies_DAL(idPost);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			//JOptionPane.showMessageDialog(null, "No one has applied yet!!");
			e.printStackTrace();
		}
		return listJobSeekerApplies;
	}
}