package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DTO.Account;
import DTO.Employer;

public class DAL
{
	private static DAL Instance;
	
	public static DAL getInstance()
	{
		if(Instance == null)
			Instance = new DAL();
		return Instance;
	}
	
	public List<Employer> getListEmployers_DAL() throws ClassNotFoundException, SQLException
	{
		List<Employer> list = new ArrayList<Employer>();
		String query = "Select * from TB_EMPLOYER";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			Employer employer = new Employer();
			
			employer.setID_EMPLOYER(defaultTableModel.getValueAt(i, 0).toString());
			employer.setNAME_EMPLOYER(defaultTableModel.getValueAt(i, 1).toString());
			employer.setID_ADDRESS(defaultTableModel.getValueAt(i, 2).toString());
			employer.setID_ACCOUNT(defaultTableModel.getValueAt(i, 3).toString());
			
			list.add(employer);
		}
		
		return list;
	}
	
	public static List<Account> getListAccounts_DAL() throws ClassNotFoundException, SQLException
	{
		List<Account> list = new ArrayList<Account>();
		String query = "Select * from TB_ACCOUNT";
		DefaultTableModel defaultTableModel = DBHelper.getInstance().GetRecords(query);
		
		for(int i = 0; i < defaultTableModel.getRowCount(); i++)
		{
			Account account = new Account();
			
			account.setID_ACCOUNT(defaultTableModel.getValueAt(i, 0).toString());
			account.setUSERNAME(defaultTableModel.getValueAt(i, 1).toString());
			account.setPASSWORD(defaultTableModel.getValueAt(i, 2).toString());
			account.setEMAIL(defaultTableModel.getValueAt(i, 3).toString());
			account.setPHONENUMBER(defaultTableModel.getValueAt(i, 4).toString());
			account.setSTATUS(Boolean.parseBoolean(defaultTableModel.getValueAt(i, 5).toString()));
			account.setCATEGORY(defaultTableModel.getValueAt(i, 6).toString());
			
			list.add(account);
		}
		
		return list;
	}

}
