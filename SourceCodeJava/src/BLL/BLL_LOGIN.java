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
	public boolean CheckAccount_BLL_LOGIN(String name, String pwd,boolean accesser) {
		// TODO Auto-generated method stub
		try {
			for(Account i : DAL.getInstance().getListAccounts_DAL())
			{
				String s = "";
				s += i.getID_ACCOUNT() + " " + i.getUSERNAME() + " " + i.getPASSWORD();
				JOptionPane.showMessageDialog(null, s);
				
				if(i.getUSERNAME().equals(name)&&i.getPASSWORD().equals(pwd)&&i.getACCESSER()==accesser)
				{
					return true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean CheckAdmin_BLL_LOGIN(String name, String pwd) {
		// TODO Auto-generated method stub
		try {
			if(DAL.getInstance().CheckAdmin_DAL(name,pwd))
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
