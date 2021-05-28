package BLL;

import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> b8ebc18 (push code)
import java.util.List;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;
<<<<<<< HEAD
=======
import DTO.Post;
>>>>>>> b8ebc18 (push code)

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
<<<<<<< HEAD
		List<Account> list = null;
=======
		List<Account> list = new ArrayList<Account>();
>>>>>>> b8ebc18 (push code)
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
<<<<<<< HEAD
}
=======
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
			e.printStackTrace();
		}
		return tmp;
	}
	public List<String[]> getJOB_NAMEByID_POST_BLL(String ID)
	{
		try {
			return DAL.getInstance().getJOB_NAMEByID_POST_DAL(ID);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	// delete Account
	public void DeleteAccountbyID_BLL(String ID)
	{
		try {
			DAL.getInstance().DeleteAccountbyID_DAL(ID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void BlockAccountbyID_BLL(String iD) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().BlockAccountbyID_Account_DAL(iD);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void AcceptPost_BLL(String iD)  {
		try {
			DAL.getInstance().AcceptPost_DAL(iD);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeclinePost_BLL(String iD) {
		try {
			DAL.getInstance().DeleteTB_POSTbyID_POST_DAL(iD);
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Account> SortAccount_BLL(String item) {
		List<Account> list = new ArrayList<>();
		try {
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
							if(list.get(i).getACCESSER()!= list.get(j).getACCESSER()&&list.get(i).getACCESSER())
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return list;
	}
}
>>>>>>> b8ebc18 (push code)
