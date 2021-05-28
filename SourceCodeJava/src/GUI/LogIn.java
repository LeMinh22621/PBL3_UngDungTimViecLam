package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

<<<<<<< HEAD
=======
import BLL.BLL_LOGIN;

>>>>>>> b8ebc18 (push code)
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

	private JTextField txtUsernameJSR;
	private JPasswordField pwdPasswordJSR;
	private JPasswordField pwdConfirmPassJSR;
	private JTextField txtGmailJSR;
	private JTextField txtPhoneJSR;

	private JTextField txtAddressJSR;
	private JTextField txtProfessionalJSR;
	private JTextField txtNameJSR;
	private JTextField txtAgeJSR;

	private JTextField txtNameER;
	private JTextField txtAddressER;

	private JButton btnAdmin, btnJobSeeker, btnEmployer, btnGuest;

	private permission p;
	
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

		txtAddressER = new JTextField();
		txtAddressER.setBounds(219, 233, 135, 31);
		pER.add(txtAddressER);
		txtAddressER.setColumns(10);
		txtAddressER.setBorder(null);
		txtAddressER.setBackground(new Color(160, 82, 45));

		JSeparator spAddressER = new JSeparator();
		spAddressER.setBounds(219, 264, 135, 8);
		pER.add(spAddressER);

		JLabel lblAddressER = new JLabel("Address");
		lblAddressER.setBounds(100, 233, 109, 31);
		pER.add(lblAddressER);
		lblAddressER.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddressER.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel lbNameER = new JLabel("Name of Company");
		lbNameER.setHorizontalAlignment(SwingConstants.CENTER);
		lbNameER.setFont(new Font("Cambria", Font.BOLD, 15));
		lbNameER.setBounds(99, 141, 109, 31);
		pER.add(lbNameER);

		txtNameER = new JTextField();
		txtNameER.setColumns(10);
		txtNameER.setBorder(null);
		txtNameER.setBackground(new Color(160, 82, 45));
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
		// Image backgroundpJSR =
		// java.awt.Toolkit.getDefaultToolkit().createImage("C:\\Users\\lehon\\Desktop\\HK4\\PBL3_UngDungTimViecLam\\Image\\Register.jpg");
		// pJSR.paint(getGraphics());
		// pJSR.set
		pJSR.setBounds(0, 0, 450, 461);
		pRegister.add(pJSR);
		pJSR.setLayout(null);

		txtProfessionalJSR = new JTextField();
		txtProfessionalJSR.setBounds(219, 275, 135, 31);
		pJSR.add(txtProfessionalJSR);
		txtProfessionalJSR.setColumns(10);
		txtProfessionalJSR.setBorder(null);
		txtProfessionalJSR.setBackground(new Color(160, 82, 45));

		JSeparator spProfessionalJSR = new JSeparator();
		spProfessionalJSR.setBounds(219, 306, 135, 8);
		pJSR.add(spProfessionalJSR);

		JLabel lblProfessionalJSR = new JLabel("Professional");
		lblProfessionalJSR.setBounds(100, 275, 109, 31);
		pJSR.add(lblProfessionalJSR);
		lblProfessionalJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessionalJSR.setFont(new Font("Cambria", Font.BOLD, 15));

		txtAddressJSR = new JTextField();
		txtAddressJSR.setBounds(219, 233, 135, 31);
		pJSR.add(txtAddressJSR);
		txtAddressJSR.setColumns(10);
		txtAddressJSR.setBorder(null);
		txtAddressJSR.setBackground(new Color(160, 82, 45));

		JSeparator spAddressJSR = new JSeparator();
		spAddressJSR.setBounds(219, 264, 135, 8);
		pJSR.add(spAddressJSR);

		JLabel lblAddressJSR = new JLabel("Address");
		lblAddressJSR.setBounds(100, 233, 109, 31);
		pJSR.add(lblAddressJSR);
		lblAddressJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddressJSR.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel lbNameJSR = new JLabel("Name");
		lbNameJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lbNameJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbNameJSR.setBounds(99, 141, 109, 31);
		pJSR.add(lbNameJSR);

		txtNameJSR = new JTextField();
		txtNameJSR.setColumns(10);
		txtNameJSR.setBorder(null);
		txtNameJSR.setBackground(new Color(160, 82, 45));
		txtNameJSR.setBounds(218, 141, 135, 31);
		pJSR.add(txtNameJSR);

		JSeparator spNameJSR = new JSeparator();
		spNameJSR.setBounds(218, 172, 135, 8);
		pJSR.add(spNameJSR);

		JLabel lblAgeJSR = new JLabel("Age");
		lblAgeJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lblAgeJSR.setBounds(99, 183, 109, 31);
		pJSR.add(lblAgeJSR);

		txtAgeJSR = new JTextField();
		txtAgeJSR.setColumns(10);
		txtAgeJSR.setBorder(null);
		txtAgeJSR.setBackground(new Color(160, 82, 45));
		txtAgeJSR.setBounds(218, 183, 135, 31);
		pJSR.add(txtAgeJSR);

		JSeparator spAgeJSR = new JSeparator();
		spAgeJSR.setBounds(218, 214, 135, 8);
		pJSR.add(spAgeJSR);

		JButton btnRegisterJSR = new JButton("Register");
		btnRegisterJSR.setBounds(175, 378, 101, 31);
		pJSR.add(btnRegisterJSR);

		JLabel lblDetailJSR = new JLabel("Detail JobSeeker");
		lblDetailJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailJSR.setForeground(Color.GREEN);
		lblDetailJSR.setFont(new Font("Algerian", Font.PLAIN, 40));
		lblDetailJSR.setBounds(36, 36, 383, 77);
		pJSR.add(lblDetailJSR);

		pJSR.setVisible(false);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////LogIn
		JPanel P2 = new JPanel();
		P2.setBackground(new Color(160, 82, 45));
		P2.setBounds(451, 0, 333, 461);
		pRegister.add(P2);
		P2.setLayout(null);

		txtUsernameJSR = new JTextField();
		txtUsernameJSR.setBounds(172, 146, 135, 31);
		txtUsernameJSR.setBorder(null);
		txtUsernameJSR.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameJSR.setBackground(new Color(160, 82, 45));
		P2.add(txtUsernameJSR);
		txtUsernameJSR.setColumns(10);

		JLabel lbUsernameJSR = new JLabel("Username");
		lbUsernameJSR.setBounds(27, 146, 109, 31);
		lbUsernameJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbUsernameJSR.setHorizontalAlignment(SwingConstants.LEFT);
		P2.add(lbUsernameJSR);

		JSeparator spUsernameJSR = new JSeparator();
		spUsernameJSR.setBounds(172, 177, 135, 8);
		spUsernameJSR.setBackground(new Color(255, 255, 255));
		P2.add(spUsernameJSR);

		JLabel lbPasswordJSR = new JLabel("Password");
		lbPasswordJSR.setBounds(27, 188, 109, 31);
		lbPasswordJSR.setHorizontalAlignment(SwingConstants.LEFT);
		lbPasswordJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		P2.add(lbPasswordJSR);

		JLabel lbConfirmPassJSR = new JLabel("Confirm Password");
		lbConfirmPassJSR.setBounds(27, 230, 135, 31);
		lbConfirmPassJSR.setHorizontalAlignment(SwingConstants.LEFT);
		lbConfirmPassJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		P2.add(lbConfirmPassJSR);

		JSeparator spConfirmPassJSR = new JSeparator();
		spConfirmPassJSR.setBounds(172, 261, 135, 8);
		P2.add(spConfirmPassJSR);

		pwdPasswordJSR = new JPasswordField();
		pwdPasswordJSR.setBounds(172, 190, 135, 31);
		pwdPasswordJSR.setBackground(new Color(160, 82, 45));
		pwdPasswordJSR.setBorder(null);
		P2.add(pwdPasswordJSR);

		JSeparator spPasswordJSR = new JSeparator();
		spPasswordJSR.setBounds(172, 221, 135, 8);
		P2.add(spPasswordJSR);

		JButton btnBackJSR = new JButton("Back");
		btnBackJSR.setBounds(250, 11, 73, 23);
		btnBackJSR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				setpLogIn();
			}
		});
		P2.add(btnBackJSR);

		JLabel lbGmailJSR = new JLabel("Gmail");
		lbGmailJSR.setHorizontalAlignment(SwingConstants.LEFT);
		lbGmailJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lbGmailJSR.setBounds(27, 272, 109, 31);
		P2.add(lbGmailJSR);

		txtGmailJSR = new JTextField();
		txtGmailJSR.setColumns(10);
		txtGmailJSR.setBorder(null);
		txtGmailJSR.setBackground(new Color(160, 82, 45));
		txtGmailJSR.setBounds(172, 272, 135, 31);
		P2.add(txtGmailJSR);

		JSeparator spGmailJSR = new JSeparator();
		spGmailJSR.setBounds(172, 303, 135, 8);
		P2.add(spGmailJSR);

		JLabel lblPhoneNumberJSR = new JLabel("Phone Number");
		lblPhoneNumberJSR.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumberJSR.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPhoneNumberJSR.setBounds(27, 312, 109, 31);
		P2.add(lblPhoneNumberJSR);

		txtPhoneJSR = new JTextField();
		txtPhoneJSR.setColumns(10);
		txtPhoneJSR.setBorder(null);
		txtPhoneJSR.setBackground(new Color(160, 82, 45));
		txtPhoneJSR.setBounds(172, 314, 135, 31);
		P2.add(txtPhoneJSR);

		JSeparator spPhoneNumberJSR = new JSeparator();
		spPhoneNumberJSR.setBounds(172, 345, 135, 8);
		P2.add(spPhoneNumberJSR);

		pwdConfirmPassJSR = new JPasswordField();
		pwdConfirmPassJSR.setBorder(null);
		pwdConfirmPassJSR.setBackground(new Color(160, 82, 45));
		pwdConfirmPassJSR.setBounds(172, 230, 135, 31);
		P2.add(pwdConfirmPassJSR);

		JButton btnContinueJSR = new JButton("Continue");
		btnContinueJSR.setBounds(127, 385, 101, 31);
		btnContinueJSR.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch (p)
				{
					case JobSeeker:
						setpRegisterJobSeeker(pJSR);
						break;
					case Employer:
						setpRgisterEmployer(pER);
						break;
				}

			}
		});
		P2.add(btnContinueJSR);

		JLabel lbRegisterJSR = new JLabel("Register");
		lbRegisterJSR.setBounds(48, 58, 246, 77);
		P2.add(lbRegisterJSR);
		lbRegisterJSR.setForeground(new Color(0, 255, 0));
		lbRegisterJSR.setFont(new Font("Algerian", Font.PLAIN, 40));
		lbRegisterJSR.setHorizontalAlignment(SwingConstants.CENTER);

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
		// panel.setLayout(new GridLayout(0, 1, 0, 0));
		// panel.add(new Label(""));

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
<<<<<<< HEAD
				dispose();
=======
				String name = txtUsername.getText();
				String pwd = String.valueOf(pwdPassword.getPassword());//.toString();
				System.out.println(pwd);
				boolean opened=false;
>>>>>>> b8ebc18 (push code)
				switch (p)
				{
					case Admin:
					{
<<<<<<< HEAD
						
						Admin f = new Admin();
						f.setVisible(true);
=======
						if(BLL_LOGIN.getInstance().CheckAdmin_BLL_LOGIN(name,pwd))
						{
							dispose();
							Admin f = new Admin();
							f.frame.setVisible(true);
							opened=true;
						}
>>>>>>> b8ebc18 (push code)
						break;
					}
					case Employer:
					{
<<<<<<< HEAD
						Employer f =  new Employer();
						f.setVisible(true);
						
=======
						if(BLL_LOGIN.getInstance().CheckAccount_BLL_LOGIN(name,pwd,true))
						{
							dispose();
							Employer f =  new Employer();
							f.setVisible(true);
							opened=true;
						}
>>>>>>> b8ebc18 (push code)
						break;
					}
					case JobSeeker:
					{
<<<<<<< HEAD
						JobSeeker f =  new JobSeeker();
						f.setVisible(true);
						break;
					}
				}
=======
						if(BLL_LOGIN.getInstance().CheckAccount_BLL_LOGIN(name,pwd,false))
						{
							dispose();
							JobSeeker f =  new JobSeeker();
							f.setVisible(true);
							opened=true;
						}
						break;
					}
				}
				if(!opened)
				{
					System.out.println("PASS OR USER IS INCORRECT");
				}
>>>>>>> b8ebc18 (push code)
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
			btnRegisterLogin.setEnabled(false);
	}

	private void initialize()
	{
		setBounds(100, 100, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//setpLogIn();
		setpMenuChoice();
		// setpRegister();
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