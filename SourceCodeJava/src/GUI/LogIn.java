package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import BLL.BLL_LOGIN;
import DTO.Account;
public class LogIn extends JFrame implements ActionListener
{
	
	private static LogIn Instance;
	public static LogIn getInstance()
	{
		if(Instance == null)
			Instance= new LogIn("MenuChoise");
		return Instance;
	}
	private int WIDTH = 800, HEIGHT = 500;
	
	private JPanel pMenuChoice, pLogIn, pRegister;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	private JTextField txtUsernameR;
	private JPasswordField pwdPasswordR;
	private JPasswordField pwdConfirmPassR;
	private JTextField txtGmailR;
	private JTextField txtPhoneR;

	private JTextField txtCityJSR;
	private JTextField txtProfessionalJSR;
	private JTextField txtNameJSR;
	private JTextField txtAgeJSR;

	private JTextField txtNameER;
	private JTextField txtCityER;

	private JButton btnAdmin, btnJobSeeker, btnEmployer, btnGuest;

	public static permission p;
	
	public LogIn(String title)
	{
		super(title);
		initialize();
	}

	private void setpMenuChoice()// set Menu Choice
	{
		pMenuChoice = new JPanel();
		pMenuChoice.setBackground(new Color(143, 188, 143));
		pMenuChoice.setLocation(0, 0);
		pMenuChoice.setSize(782, 460);
		pMenuChoice.setLayout(null);
		pMenuChoice.setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(143, 188, 143));
		p1.setBounds(0, 37, 782, 75);

		pMenuChoice.add(p1);
		p1.setLayout(null);

		JLabel lbMenuChoice = new JLabel("Menu Choice");
		lbMenuChoice.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 40));
		lbMenuChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lbMenuChoice.setBounds(170, 0, 423, 70);
		p1.add(lbMenuChoice);

		getContentPane().add(pMenuChoice);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(143, 188, 143));
		p2.setBounds(0, 140, 782, 296);
		pMenuChoice.add(p2);
		p2.setLayout(null);

		btnAdmin = new JButton("Admin");
		btnAdmin.setBorder(null);
		btnAdmin.setBackground(new Color(0, 128, 0));
		btnAdmin.setForeground(new Color(255, 140, 0));
		btnAdmin.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnAdmin.setBounds(235, 11, 315, 50);
		p2.add(btnAdmin);

		btnJobSeeker = new JButton("JobSeeker");
		btnJobSeeker.setBorder(null);
		btnJobSeeker.setForeground(new Color(255, 140, 0));
		btnJobSeeker.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnJobSeeker.setBackground(new Color(0, 128, 0));
		btnJobSeeker.setBounds(235, 78, 315, 50);
		p2.add(btnJobSeeker);

		btnEmployer = new JButton("Employer");
		btnEmployer.setBorder(null);
		btnEmployer.setForeground(new Color(255, 140, 0));
		btnEmployer.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnEmployer.setBackground(new Color(0, 128, 0));
		btnEmployer.setBounds(235, 146, 315, 50);
		p2.add(btnEmployer);

		btnGuest = new JButton("Guest");
		btnGuest.setBorder(null);
		btnGuest.setForeground(new Color(255, 140, 0));
		btnGuest.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnGuest.setBackground(new Color(0, 128, 0));
		btnGuest.setBounds(235, 217, 315, 50);
		p2.add(btnGuest);

		setVisible(true);
		btnAdmin.addActionListener(this);
		btnJobSeeker.addActionListener(this);
		btnEmployer.addActionListener(this);
		btnGuest.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		p = permission.valueOf(e.getActionCommand());
		switch (p)
		{
			case Admin:
			case Employer:
			case JobSeeker:
			{
				getContentPane().removeAll();
				getContentPane().repaint();
				setpLogIn();
				break;
			}
			case Guest:
			{
				dispose();
				Guest f = new Guest();
				f.setVisible(true);
				break;
			}
		}

	}

	private void setpRegisterJobSeeker(JPanel p1)
	{
		p1.setVisible(true);
	}

	private void setpRgisterEmployer(JPanel p1)
	{
		p1.setVisible(true);
	}

	private void setpRegister()// set Register
	{
		pRegister = new JPanel();
		pRegister.setSize(WIDTH, HEIGHT);
		pRegister.setLayout(null);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Employer
		JPanel pER = new JPanel();
		pER.setBackground(Color.GRAY);
		pER.setBounds(0, 0, 450, 461);
		pRegister.add(pER);
		pER.setLayout(null);

		txtCityER = new JTextField();
		txtCityER.setHorizontalAlignment(SwingConstants.CENTER);
		txtCityER.setBounds(219, 233, 135, 31);
		pER.add(txtCityER);
		txtCityER.setColumns(10);
		txtCityER.setBorder(null);
		txtCityER.setBackground(Color.GRAY);

		JSeparator spCityER = new JSeparator();
		spCityER.setBounds(219, 264, 135, 8);
		pER.add(spCityER);

		JLabel lblCityER = new JLabel("City");
		lblCityER.setBounds(71, 231, 109, 31);
		pER.add(lblCityER);
		lblCityER.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityER.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel lbNameER = new JLabel("Name of Company");
		lbNameER.setHorizontalAlignment(SwingConstants.CENTER);
		lbNameER.setFont(new Font("Cambria", Font.BOLD, 15));
		lbNameER.setBounds(56, 141, 152, 31);
		pER.add(lbNameER);

		txtNameER = new JTextField();
		txtNameER.setColumns(10);
		txtNameER.setBorder(null);
		txtNameER.setBackground(Color.GRAY);
		txtNameER.setBounds(218, 141, 135, 31);
		pER.add(txtNameER);

		JSeparator spNameER = new JSeparator();
		spNameER.setBounds(218, 172, 135, 8);
		pER.add(spNameER);

		JButton btnRegisterER = new JButton("Register");
		btnRegisterER.setBounds(175, 378, 101, 31);
		pER.add(btnRegisterER);

		JLabel lblDetailER = new JLabel("Detail Company");
		lblDetailER.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailER.setForeground(Color.GREEN);
		lblDetailER.setFont(new Font("Algerian", Font.PLAIN, 40));
		lblDetailER.setBounds(44, 36, 370, 77);
		pER.add(lblDetailER);

		pER.setVisible(false);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// JobSeeker
		JPanel pJSR = new JPanel();
		pJSR.setBackground(Color.GRAY);
		pJSR.setBounds(0, 0, 450, 461);
		pRegister.add(pJSR);
		pJSR.setLayout(null);

		txtProfessionalJSR = new JTextField();
		txtProfessionalJSR.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfessionalJSR.setBounds(218, 266, 135, 31);
		pJSR.add(txtProfessionalJSR);
		txtProfessionalJSR.setColumns(10);
		txtProfessionalJSR.setBorder(null);
		txtProfessionalJSR.setBackground(Color.GRAY);

		JSeparator spProfessionalJSR = new JSeparator();
		spProfessionalJSR.setBounds(218, 297, 135, 8);
		pJSR.add(spProfessionalJSR);

		JLabel lblProfessionalJSR = new JLabel("Professional");
		lblProfessionalJSR.setBounds(99, 266, 109, 31);
		pJSR.add(lblProfessionalJSR);
		lblProfessionalJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessionalJSR.setFont(new Font("Cambria", Font.BOLD, 15));

		txtCityJSR = new JTextField();
		txtCityJSR.setHorizontalAlignment(SwingConstants.CENTER);
		txtCityJSR.setBounds(218, 224, 135, 31);
		pJSR.add(txtCityJSR);
		txtCityJSR.setColumns(10);
		txtCityJSR.setBorder(null);
		txtCityJSR.setBackground(Color.GRAY);

		JSeparator spCityJSR = new JSeparator();
		spCityJSR.setBounds(218, 255, 135, 8);
		pJSR.add(spCityJSR);

		JLabel lblCityJSR = new JLabel("City");
		lblCityJSR.setBounds(99, 224, 109, 31);
		pJSR.add(lblCityJSR);
		lblCityJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityJSR.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel lbNameJSR = new JLabel("Name");
		lbNameJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lbNameJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbNameJSR.setBounds(99, 140, 109, 31);
		pJSR.add(lbNameJSR);

		txtNameJSR = new JTextField();
		txtNameJSR.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameJSR.setColumns(10);
		txtNameJSR.setBorder(null);
		txtNameJSR.setBackground(Color.GRAY);
		txtNameJSR.setBounds(218, 140, 135, 31);
		pJSR.add(txtNameJSR);

		JSeparator spNameJSR = new JSeparator();
		spNameJSR.setBounds(218, 171, 135, 8);
		pJSR.add(spNameJSR);

		JLabel lblAgeJSR = new JLabel("Age");
		lblAgeJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lblAgeJSR.setBounds(99, 182, 109, 31);
		pJSR.add(lblAgeJSR);

		txtAgeJSR = new JTextField();
		txtAgeJSR.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgeJSR.setColumns(10);
		txtAgeJSR.setBorder(null);
		txtAgeJSR.setBackground(Color.GRAY);
		txtAgeJSR.setBounds(218, 182, 135, 31);
		pJSR.add(txtAgeJSR);

		JSeparator spAgeJSR = new JSeparator();
		spAgeJSR.setBounds(218, 213, 135, 8);
		pJSR.add(spAgeJSR);
		
		JLabel lblGenderJSR = new JLabel("Gender");
		lblGenderJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenderJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lblGenderJSR.setBounds(98, 308, 109, 31);
		pJSR.add(lblGenderJSR);
		
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setBackground(Color.GRAY);
		rbMale.setBounds(215, 308, 74, 29);
		rbMale.setSelected(true);
		pJSR.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(Color.GRAY);
		rbFemale.setBounds(310, 308, 65, 29);
		pJSR.add(rbFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbFemale);bg.add(rbMale);
		
		JButton btnRegisterJSR = new JButton("Register");
		btnRegisterJSR.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String NAME = txtNameJSR.getText();
				String CITY = txtCityJSR.getText();
				String PHONE = txtPhoneR.getText();
				String EMAIL = txtGmailR.getText();
				
				String AGE = txtAgeJSR.getText();
				String PROFESSIONAL = txtProfessionalJSR.getText();
				boolean GENDER = (rbMale.isSelected())?true:false;
				
				String USERNAME = txtUsernameR.getText();
				String PASSWORD = pwdPasswordR.getText();
				String CONFIRM = pwdConfirmPassR.getText();
				
				if(BLL_LOGIN.getInstance().Register(NAME, CITY, PHONE, EMAIL, AGE, PROFESSIONAL, GENDER, USERNAME, PASSWORD, CONFIRM))
				{
					getContentPane().removeAll();
					getContentPane().repaint();
					setpLogIn();
				}
				
			}
		});
		btnRegisterER.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String NAME = txtNameER.getText();
				String CITY = txtCityER.getText();
				String PHONE = txtPhoneR.getText();
				String EMAIL = txtGmailR.getText();
				
				String USERNAME = txtUsernameR.getText();
				String PASSWORD = pwdPasswordR.getText();
				String CONFIRM = pwdConfirmPassR.getText();
			
				if(BLL_LOGIN.getInstance().Register(NAME, CITY, PHONE, EMAIL, "1", "1", true, USERNAME, PASSWORD, CONFIRM))
				{
					getContentPane().removeAll();
					getContentPane().repaint();
					setpLogIn();
				}
				
			}
		});
		btnRegisterJSR.setBounds(175, 378, 101, 31);
		pJSR.add(btnRegisterJSR);

		JLabel lblDetailJSR = new JLabel("Detail JobSeeker");
		lblDetailJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailJSR.setForeground(Color.GREEN);
		lblDetailJSR.setFont(new Font("Algerian", Font.PLAIN, 40));
		lblDetailJSR.setBounds(36, 36, 383, 77);
		pJSR.add(lblDetailJSR);

		pJSR.setVisible(false);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// register
		JPanel P2 = new JPanel();
		P2.setBackground(new Color(160, 82, 45));
		P2.setBounds(451, 0, 333, 461);
		pRegister.add(P2);
		P2.setLayout(null);

		txtUsernameR = new JTextField();
		txtUsernameR.setBounds(172, 146, 135, 31);
		txtUsernameR.setBorder(null);
		txtUsernameR.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameR.setBackground(new Color(160, 82, 45));
		P2.add(txtUsernameR);
		txtUsernameR.setColumns(10);

		JLabel lbUsernameR = new JLabel("Username");
		lbUsernameR.setBounds(27, 146, 109, 31);
		lbUsernameR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbUsernameR.setHorizontalAlignment(SwingConstants.LEFT);
		P2.add(lbUsernameR);

		JSeparator spUsernameR = new JSeparator();
		spUsernameR.setBounds(172, 177, 135, 8);
		spUsernameR.setBackground(new Color(255, 255, 255));
		P2.add(spUsernameR);

		JLabel lbPasswordR = new JLabel("Password");
		lbPasswordR.setBounds(27, 188, 109, 31);
		lbPasswordR.setHorizontalAlignment(SwingConstants.LEFT);
		lbPasswordR.setFont(new Font("Cambria", Font.BOLD, 15));
		P2.add(lbPasswordR);

		JLabel lbConfirmPassR = new JLabel("Confirm Password");
		lbConfirmPassR.setBounds(27, 230, 135, 31);
		lbConfirmPassR.setHorizontalAlignment(SwingConstants.LEFT);
		lbConfirmPassR.setFont(new Font("Cambria", Font.BOLD, 15));
		P2.add(lbConfirmPassR);

		JSeparator spConfirmPassR = new JSeparator();
		spConfirmPassR.setBounds(172, 261, 135, 8);
		P2.add(spConfirmPassR);

		pwdPasswordR = new JPasswordField();
		pwdPasswordR.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPasswordR.setBounds(172, 190, 135, 31);
		pwdPasswordR.setBackground(new Color(160, 82, 45));
		pwdPasswordR.setBorder(null);
		P2.add(pwdPasswordR);

		JSeparator spPasswordR = new JSeparator();
		spPasswordR.setBounds(172, 221, 135, 8);
		P2.add(spPasswordR);

		JButton btnBackR = new JButton("Back");
		btnBackR.setBounds(250, 11, 73, 23);
		btnBackR.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().repaint();
				setpLogIn();
			}
		});
		P2.add(btnBackR);

		JLabel lbGmailR = new JLabel("Gmail");
		lbGmailR.setHorizontalAlignment(SwingConstants.LEFT);
		lbGmailR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbGmailR.setBounds(27, 272, 109, 31);
		P2.add(lbGmailR);

		txtGmailR = new JTextField();
		txtGmailR.setHorizontalAlignment(SwingConstants.CENTER);
		txtGmailR.setColumns(10);
		txtGmailR.setBorder(null);
		txtGmailR.setBackground(new Color(160, 82, 45));
		txtGmailR.setBounds(172, 272, 135, 31);
		P2.add(txtGmailR);

		JSeparator spGmailR = new JSeparator();
		spGmailR.setBounds(172, 303, 135, 8);
		P2.add(spGmailR);

		JLabel lblPhoneNumberR = new JLabel("Phone Number");
		lblPhoneNumberR.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumberR.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPhoneNumberR.setBounds(27, 312, 109, 31);
		P2.add(lblPhoneNumberR);

		txtPhoneR = new JTextField();
		txtPhoneR.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneR.setColumns(10);
		txtPhoneR.setBorder(null);
		txtPhoneR.setBackground(new Color(160, 82, 45));
		txtPhoneR.setBounds(172, 314, 135, 31);
		P2.add(txtPhoneR);

		JSeparator spPhoneNumberR = new JSeparator();
		spPhoneNumberR.setBounds(172, 345, 135, 8);
		P2.add(spPhoneNumberR);

		pwdConfirmPassR = new JPasswordField();
		pwdConfirmPassR.setHorizontalAlignment(SwingConstants.CENTER);
		pwdConfirmPassR.setBorder(null);
		pwdConfirmPassR.setBackground(new Color(160, 82, 45));
		pwdConfirmPassR.setBounds(172, 230, 135, 31);
		P2.add(pwdConfirmPassR);

		JButton btnContinueR = new JButton("Continue");
		btnContinueR.setBounds(127, 385, 101, 31);
		btnContinueR.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(txtUsernameR.getText().length() != 0 && pwdPasswordR.getText().length() != 0 && pwdConfirmPassR.getText().length() != 0 && txtGmailR.getText().length() != 0 && txtPhoneR.getText().length() != 0)
				{
					if(pwdPasswordR.getText().equals(pwdConfirmPassR.getText()))
						switch (p)
						{
							case JobSeeker:
								setpRegisterJobSeeker(pJSR);
								break;
							case Employer:
								setpRgisterEmployer(pER);
								break;
							default:
								break;
						}
					else
					{
						JOptionPane.showMessageDialog(null, "Confirm wrong password!");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Please full fill");
			}
		});
		P2.add(btnContinueR);

		JLabel lbRegisterR = new JLabel("Register");
		lbRegisterR.setBounds(48, 58, 246, 77);
		P2.add(lbRegisterR);
		lbRegisterR.setForeground(new Color(0, 255, 0));
		lbRegisterR.setFont(new Font("Algerian", Font.PLAIN, 40));
		lbRegisterR.setHorizontalAlignment(SwingConstants.CENTER);

		getContentPane().add(pRegister);
		setVisible(true);
	}

	private void setpLogIn()// set Login
	{
		pLogIn = new JPanel();
		pLogIn.setSize(WIDTH, HEIGHT);
		pLogIn.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBounds(0, 0, 450, 461);
		panel.setBackground(new Color(0, 0, 153));
		panel.setLayout(null);

		Label lbLogin = new Label("");
		switch (p)
		{
			case Admin:
			{
				setTitle("Admin");
				lbLogin.setText("Admin Log In");
				break;
			}
			case Employer:
			{
				setTitle("Employer");
				lbLogin.setText("Employer Log In");
				break;
			}
			case JobSeeker:
			{
				setTitle("JobSeeker");
				lbLogin.setText("JobSeeker Log In");
				break;
			}
			default:
				break;
		}
		lbLogin.setBounds(10, 77, 430, 66);
		lbLogin.setForeground(new Color(0, 255, 0));
		panel.add(lbLogin);
		lbLogin.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
		lbLogin.setAlignment(Label.CENTER);
		lbLogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(160, 82, 45));
		panel_1.setBounds(450, 0, 341, 461);
		pLogIn.add(panel_1);
		panel_1.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(160, 82, 45));
		txtUsername.setBounds(157, 99, 152, 33);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setBorder(null);
		pwdPassword.setBackground(new Color(160, 82, 45));
		pwdPassword.setBounds(157, 153, 152, 33);
		panel_1.add(pwdPassword);

		JSeparator sepUsername = new JSeparator();
		sepUsername.setBackground(new Color(255, 255, 255));
		sepUsername.setBounds(157, 131, 152, 10);
		panel_1.add(sepUsername);

		JSeparator sepPassword = new JSeparator();
		sepPassword.setBackground(new Color(255, 255, 255));
		sepPassword.setBounds(157, 185, 152, 10);
		panel_1.add(sepPassword);

		Label lbUsername = new Label("Username");
		lbUsername.setFont(new Font("Dialog", Font.ITALIC, 16));
		lbUsername.setAlignment(Label.CENTER);
		lbUsername.setBounds(27, 99, 124, 41);
		panel_1.add(lbUsername);

		Label lbPassword = new Label("Password");
		lbPassword.setAlignment(Label.CENTER);
		lbPassword.setFont(new Font("Dialog", Font.ITALIC, 16));
		lbPassword.setBounds(27, 153, 124, 42);
		panel_1.add(lbPassword);

		Button btn_LogIn = new Button("Log In");
		btn_LogIn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String name = txtUsername.getText();
				String pwd = String.valueOf(pwdPassword.getPassword());
				boolean accesser=false;
				switch (p)
				{
					case Admin:
					{
						if(BLL_LOGIN.getInstance().CheckAccount_BLL_LOGIN(name,pwd,-1)!=null)
						{
							dispose();
							Admin f = new Admin();
							f.setVisible(true);
							accesser=true;
						}
						break;
					}
					case Employer:
					{
						Account i=BLL_LOGIN.getInstance().CheckAccount_BLL_LOGIN(name,pwd,1);
						if(i!=null)
						{
							dispose();
							Employer f =  new Employer(i);
							f.setVisible(true);
							accesser=true;
						}
						break;
					}
					case JobSeeker:
					{
						Account i=BLL_LOGIN.getInstance().CheckAccount_BLL_LOGIN(name,pwd,0);
						if(i!=null)
						{
							dispose();
							JobSeeker f =  new JobSeeker(i);
							f.setVisible(true);
							accesser=true;
						}
						break;
					}
					default:
					{
						break;
					}
				}
				if(!accesser)
				{
					JOptionPane.showMessageDialog(null, "Incorrect user or password");
				}
			}
		});
		btn_LogIn.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_LogIn.setBounds(130, 270, 93, 27);
		panel_1.add(btn_LogIn);

		JButton btnRegisterLogin = new JButton("Register");
		btnRegisterLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getContentPane().removeAll();
				getContentPane().repaint();
				setpRegister();
			}
		});
		btnRegisterLogin.setMnemonic(KeyEvent.VK_PLUS);
		btnRegisterLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegisterLogin.setFont(UIManager.getFont("ScrollPane.font"));
		btnRegisterLogin.setBackground(new Color(160, 82, 45));
		btnRegisterLogin.setBorder(null);
		btnRegisterLogin.setBounds(134, 319, 89, 23);
		panel_1.add(btnRegisterLogin);

		JButton btnBackLogin = new JButton("back");
		btnBackLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setTitle("Menu Choise");
				getContentPane().removeAll();
				getContentPane().repaint();
				setpMenuChoice();
			}
		});
		btnBackLogin.setBounds(268, 11, 63, 23);
		panel_1.add(btnBackLogin);

		getContentPane().add(pLogIn);
		pLogIn.add(panel);
		setVisible(true);

		if (p == permission.Admin)
			btnRegisterLogin.setVisible(false);
	}

	private void initialize()
	{
		setBounds(100, 100, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//setpLogIn();
		setpMenuChoice();
		//setpRegister();
	}

	public static void main(String[] args)
	{
		LogIn l = new LogIn("Log in");
	}

	public static enum permission
	{
		JobSeeker, Employer, Guest, Admin
	}
}