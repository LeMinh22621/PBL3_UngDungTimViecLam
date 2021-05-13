package BLL;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;

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
		List<Account> list = null;
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
}
