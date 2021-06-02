package BLL;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;
import GUI.LogIn;
import GUI.LogIn.permission;

public class BLL_LOGIN {
	private static BLL_LOGIN Instance;
	public static BLL_LOGIN getInstance()
	{
		if( Instance == null)
			Instance = new BLL_LOGIN();
		return Instance;
	}
	public boolean CheckAccount_BLL_LOGIN(String name, String pwd,int accesser)
	{
		try
		{
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
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
	public boolean CheckAdmin_BLL_LOGIN(String name, String pwd)
	{
		try
		{
			if(DAL.getInstance().CheckAdmin_DAL(name,pwd))
			{
				return true;
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
	
	public int SelectLastRowProfile_BLL()
	{
		int result = -1;
		try
		{
			String id = DAL.getInstance().SelectLastRowProfile_DAL("PF");
			String num = id.replaceAll("PF", "");
			result = Integer.parseInt(num);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
	public int SelectLastRowJobSeeker_BLL()
	{
		int result = -1;
		try
		{
			String id = DAL.getInstance().SelectLastRowJobSeeker_DAL("JS");
			String num = id.replaceAll("JS", "");
			result = Integer.parseInt(num);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
	public int SelectLastRowAccount_BLL()
	{
		int result = -1;
		try
		{
			if(LogIn.p == permission.JobSeeker)
			{
				String id = DAL.getInstance().SelectLastRowAccount_DAL("AE");
				String num = id.replaceAll("AE", "");
				result = Integer.parseInt(num);
			}
			else if(LogIn.p == permission.Employer)
			{
				String id = DAL.getInstance().SelectLastRowAccount_DAL("AJ");
				String num = id.replaceAll("AJ", "");
				result = Integer.parseInt(num);
			}
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
	public boolean checkPhone(String phone)
	{
		try
		{
			if(phone.length() == 10 )
			{
				Double.parseDouble(phone);
				return true;
			}
		}
		catch(NumberFormatException | NullPointerException e)
		{
			
		}
		return false;
	}
	public boolean checkEmail(String email)
	{
		return email.contains("@")?true:false;
	}
	public boolean checkAge(String age)
	{
		try
		{
			if(Integer.parseInt(age) > 0 && Integer.parseInt(age) < 150);
				return true;
		}
		catch(NumberFormatException | NullPointerException e)
		{
			
		}
		return false;
	}
	public void Register(String NAME, String CITY, String PHONE, String EMAIL, String AGE, String PROFESSIONAL,boolean GENDER, String USERNAME, String PASSWORD, String CONFIRM)
	{
		int idp = SelectLastRowProfile_BLL() + 1;
		String IDP = "PF" + idp;
		
		int ida = SelectLastRowAccount_BLL() + 1;
		String IDA = "AJ" + ida;
		
		int idj = SelectLastRowJobSeeker_BLL() + 1;
		String IDJ = "JS" + idj;
		
		if(NAME.length() != 0 && CITY.length() != 0 && PHONE.length() != 0 && EMAIL.length() != 0 && AGE.length() != 0 && PROFESSIONAL.length() != 0 && USERNAME.length() != 0 && PASSWORD.length() != 0)
		{
			if(PASSWORD.equals(CONFIRM))
			{
				if( checkPhone(PHONE) && checkEmail(EMAIL) && checkAge(AGE))
				{
					String insertP = "Insert into TB_PROFILE (ID_PROFILE, NAME, CITY, PHONE_NUMBER, EMAIL) VALUES ('";
					String queryP = insertP + IDP + "','" + NAME + "','" + CITY + "','" + PHONE + "','" + EMAIL + "')";
					
					boolean accesser,status;
					accesser = false;
					status = true;
					String insertA = "Insert into TB_ACCOUNT (ID_ACCOUNT,USERNAME,PASSWORD,ACCESSER,STATUS) VALUES ('";
					String queryA = insertA + IDA + "','" + USERNAME + "','" + PASSWORD + "','" + accesser + "','" + status + "')";
					
					String insertJ = "Insert into TB_JOBSEEKER (ID_JOBSEEKER, ID_ACCOUNT, ID_PROFILE, AGE, GENDER, PROFESSIONAL) VALUES ('";
					String queryJ = insertJ + IDJ + "','" + IDA + "','" + IDP + "','" + Integer.parseInt(AGE) + "','" + GENDER + "','" + PROFESSIONAL + "')";
					try
					{
						DAL.getInstance().ExcuteDB(queryP);
						DAL.getInstance().ExcuteDB(queryA);
						DAL.getInstance().ExcuteDB(queryJ);
						JOptionPane.showMessageDialog(null, "Register success!");
					}
					catch (ClassNotFoundException | SQLException e)
					{
						JOptionPane.showMessageDialog(null, "Register failed");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong data!\n( Email have @ or the number Phone == 10 or 0 < Age < 150 )");
			}
			else
				JOptionPane.showMessageDialog(null, "Confirm password wrong!");
			
		}
		else
			JOptionPane.showMessageDialog(null, "Please full fill");
	}
	
}
