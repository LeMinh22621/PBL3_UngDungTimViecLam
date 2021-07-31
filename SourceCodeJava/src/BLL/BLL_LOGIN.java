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
	public Account CheckAccount_BLL_LOGIN(String name, String pwd,int accesser)
	{
		try
		{
			for(Account i : DAL.getInstance().getListAccounts_DAL())
			{
				if(i.getUSERNAME().equals(name)&&i.getPASSWORD().equals(pwd)&&i.getACCESSER()==accesser)
				{
					return i;
				}
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
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
	public int SelectLastRowJobSeekerOrEmployer_BLL()
	{
		int result = -1;
		try
		{
			if(LogIn.p == permission.Employer)
			{
				String id = DAL.getInstance().SelectLastRowEmployer_DAL("EM");
				String num = id.replaceAll("EM", "");
				result = Integer.parseInt(num);

			}
			else if(LogIn.p == permission.JobSeeker)
			{
				String id = DAL.getInstance().SelectLastRowJobSeeker_DAL("JS");
				String num = id.replaceAll("JS", "");
				result = Integer.parseInt(num);
			}
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
			if(LogIn.p == permission.Employer)
			{
				String id = DAL.getInstance().SelectLastRowAccount_DAL("AE");
				String num = id.replaceAll("AE", "");
				result = Integer.parseInt(num);
			}
			else if(LogIn.p == permission.JobSeeker)
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
			JOptionPane.showConfirmDialog(null, "Phone numbers must be numbers");
		}
		return false;
	}
	public boolean checkEmail(String email)
	{
		if(email.length() >= 0 && email.length() <= 50)
			return email.contains("@")?true:false;
		return false;
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
	public boolean checkUsername(String username)
	{
		if(username.length() < 10)
			return true;
		JOptionPane.showMessageDialog(null, "Length of Username must be less than 10");
		return false;
	}
	public boolean checkPassword(String password)
	{
		if(password.length() >4&&password.length() < 10)
			return true;
		JOptionPane.showMessageDialog(null, "Length of Password must be between 4 and 10");
		return false;
	}
	public boolean Register(String NAME, String CITY, String PHONE, String EMAIL, String AGE, String PROFESSIONAL,boolean GENDER, String USERNAME, String PASSWORD, String CONFIRM)
	{
			if(!checkUsername(USERNAME))
				return false;
			if(!checkPassword(PASSWORD))
				return false;
			try
			{
				if(DAL.getInstance().checkAccount_DAL(USERNAME, (LogIn.p == LogIn.permission.Employer)?true:false))
				{
					JOptionPane.showMessageDialog(null, "This Username had been registered");
					return false;
				}
			}
			catch (ClassNotFoundException | SQLException e)
			{
				JOptionPane.showMessageDialog(null, "Register failed!");
				return false;
			}

		
		int idp = SelectLastRowProfile_BLL() + 1;
		String IDP = "PF" + idp;
		
		int ida = SelectLastRowAccount_BLL() + 1;
		String IDA = "";
		if(LogIn.p == permission.JobSeeker)
			IDA = "AJ" + ida;
		else if( LogIn.p == LogIn.permission.Employer)
			IDA = "AE" + ida;
		
		String ID = "";
		int id = SelectLastRowJobSeekerOrEmployer_BLL() + 1;
		if(LogIn.p == permission.JobSeeker)
			ID = "JS" + id;
		else if( LogIn.p == LogIn.permission.Employer)
			ID = "EM" + id;
		
		if(NAME.length() != 0 && CITY.length() != 0 && PHONE.length() != 0 && EMAIL.length() != 0 && AGE.length() != 0 && PROFESSIONAL.length() != 0 && USERNAME.length() != 0 && PASSWORD.length() != 0)
		{
			if(PASSWORD.equals(CONFIRM))
			{
				if( checkPhone(PHONE) && checkEmail(EMAIL))
				{
					String insertP = "Insert into TB_PROFILE (ID_PROFILE, NAME, CITY, PHONE_NUMBER, EMAIL) VALUES ('";
					String queryP = insertP + IDP + "','" + NAME + "','" + CITY + "','" + PHONE + "','" + EMAIL + "')";
					
					boolean accesser,status;
					accesser = (LogIn.p == LogIn.permission.Employer)?true:false;
					status = true;
					String insertA = "Insert into TB_ACCOUNT (ID_ACCOUNT,USERNAME,PASSWORD,ACCESSER,STATUS) VALUES ('";
					String queryA = insertA + IDA + "','" + USERNAME + "','" + PASSWORD + "','" + accesser + "','" + status + "')";
					
					String insert = "";
					String query = "";
					if(LogIn.p == permission.JobSeeker && checkAge(AGE))
					{
						insert = "Insert into TB_JOBSEEKER (ID_JOBSEEKER, ID_ACCOUNT, ID_PROFILE, AGE, GENDER, PROFESSIONAL) VALUES ('";
						query = insert + ID + "','" + IDA + "','" + IDP + "'," + Integer.parseInt(AGE) + ",'" + GENDER + "','" + PROFESSIONAL + "')";
					}
					else if( LogIn.p == LogIn.permission.Employer)
					{
						insert = "Insert into TB_EMPLOYER (ID_EMPLOYER, ID_ACCOUNT, ID_PROFILE) VALUES ('";
						query = insert + ID +  "','" + IDA + "','" + IDP + "')";
					}
					
					try
					{
						DAL.getInstance().ExcuteDB(queryP);
						DAL.getInstance().ExcuteDB(queryA);
						DAL.getInstance().ExcuteDB(query);
						JOptionPane.showMessageDialog(null, "Register Success");
						
						return true;
					}
					catch (ClassNotFoundException | SQLException e)
					{
						JOptionPane.showMessageDialog(null, "Register failed");
						return false;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong data!\n( Email must be have @ or the length of Phonenumber == 10 or 0 < Age < 150 )");
					return false;
				}
					
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Confirm password wrong!");
				return false;
			}
				
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please full fill");
			return false;
		}
			
	}
	public boolean EditProfileEmployer_BLL_LOGIN(String iD, String name, String city, String phoneNumber, String email,String linkFacebook
			,String linkZalo) {
		if(name.length() != 0 && city.length() != 0 && phoneNumber.length() != 0 && email.length() != 0)
		{
			if( checkPhone(phoneNumber) && checkEmail(email))
			{
				try {
					DAL.getInstance().EditProfileEmployer_DAl(iD,name,city,phoneNumber,email,linkFacebook,linkZalo);
					JOptionPane.showMessageDialog(null, "Edit success!");
					return true;
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Edit failed");
					return false;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong data!\n( Email have @ or the number Phone == 10");
				return false;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please full fill");
			return false;
		}
	}
	public boolean EditProfileJobseeker_BLL_LOGIN(String iDprofile, String iDjobseeker, String name, String age,
			boolean gender,String phoneNumber, String email,String professional,String linkFacebook,String linkZalo) {
		if(name.length() != 0 && age.length() != 0 && phoneNumber.length() != 0 && email.length() != 0)
		{
			if( checkPhone(phoneNumber) && checkEmail(email) && checkAge(age))
			{
				try {
					DAL.getInstance().EditProfileJobseeker_DAl(iDprofile,iDjobseeker,name,age,gender,phoneNumber,email,professional,linkFacebook,linkZalo);
					JOptionPane.showMessageDialog(null, "Edit success!");
					return true;
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Edit failed");
					return false;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong data!\n( Email have @ or the number Phone == 10 or 0 < Age < 150 )");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please full fill");
			return false;
		}
		
	}
	public void EditImageProfile_BLL_LOGIN(byte[] image,String IDprofile) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().EditImageProfile_DAL(image,IDprofile);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
