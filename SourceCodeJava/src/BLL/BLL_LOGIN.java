package BLL;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;

public class BLL_LOGIN {
	private static BLL_LOGIN Instance;
	public static BLL_LOGIN getInstance()
	{
		if( Instance == null)
			Instance = new BLL_LOGIN();
		return Instance;
	}
	public boolean CheckAccount_BLL_LOGIN(String name, String pwd,int accesser) {
		// TODO Auto-generated method stub
		try
		{
			for(Account i : DAL.getInstance().getListAccounts_DAL())
			{
				if(i.getUSERNAME().equals(name)&&i.getPASSWORD().equals(pwd)&&i.getACCESSER()==accesser)
				{
					return true;
				}
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
	public void RegisterE(String username, String password, String gmail, String phonenumber, String nameOfCompany,
			String address) {
		try {
			DAL.RegisterE(username,password,gmail,phonenumber,nameOfCompany,address);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
