package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class LogIn extends JFrame implements ActionListener
{
	private int WIDTH = 800, HEIGHT = 500;
	private JPanel pMenuChoice, pLogIn, pRegister;
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtUsernameRegister;
	private JTextField txtGmailRegister;
	private JPasswordField pwdPasswordRegister;
	
	public LogIn(String title)
	{
		super(title);
		initialize();
	}
	private void setpMenuChoice()//								set Menu Choice
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
		
		
		frame.getContentPane().add(pMenuChoice);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(143, 188, 143));
		p2.setBounds(0, 140, 782, 296);
		pMenuChoice.add(p2);
		p2.setLayout(null);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBorder(null);
		btnAdmin.setBackground(new Color(0, 128, 0));
		btnAdmin.setForeground(new Color(255, 140, 0));
		btnAdmin.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnAdmin.setBounds(235, 11, 315, 50);
		p2.add(btnAdmin);
		
		JButton btnJobSeeker = new JButton("JobSeeker");
		btnJobSeeker.setBorder(null);
		btnJobSeeker.setForeground(new Color(255, 140, 0));
		btnJobSeeker.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnJobSeeker.setBackground(new Color(0, 128, 0));
		btnJobSeeker.setBounds(235, 78, 315, 50);
		p2.add(btnJobSeeker);
		
		JButton btnEmployer = new JButton("Employer");
		btnEmployer.setBorder(null);
		btnEmployer.setForeground(new Color(255, 140, 0));
		btnEmployer.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnEmployer.setBackground(new Color(0, 128, 0));
		btnEmployer.setBounds(235, 146, 315, 50);
		p2.add(btnEmployer);
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.setBorder(null);
		btnGuest.setForeground(new Color(255, 140, 0));
		btnGuest.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		btnGuest.setBackground(new Color(0, 128, 0));
		btnGuest.setBounds(235, 217, 315, 50);
		p2.add(btnGuest);
		
		frame.setVisible(true);
		btnAdmin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				setpLogIn();
			}
		});
		btnJobSeeker.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				setpLogIn();
			}
		});
		btnEmployer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		btnGuest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	private void setpRegister()//								set Register
	{
		pRegister = new JPanel();
		pRegister.setSize(WIDTH, HEIGHT);
		pRegister.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0, 0, 139));
		p1.setBounds(0, 0, 450, 461);
		pRegister.add(p1);
		p1.setLayout(null);
		
		JLabel lbRegister = new JLabel("Register");
		lbRegister.setForeground(new Color(0, 255, 0));
		lbRegister.setFont(new Font("Algerian", Font.PLAIN, 40));
		lbRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegister.setBounds(80, 55, 273, 77);
		p1.add(lbRegister);
		
		JPanel P2 = new JPanel();
		P2.setBackground(new Color(160, 82, 45));
		P2.setBounds(451, 0, 333, 461);
		pRegister.add(P2);
		P2.setLayout(null);
		
		txtUsernameRegister = new JTextField();
		txtUsernameRegister.setBorder(null);
		txtUsernameRegister.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsernameRegister.setBackground(new Color(160, 82, 45));
		txtUsernameRegister.setBounds(153, 79, 135, 31);
		P2.add(txtUsernameRegister);
		txtUsernameRegister.setColumns(10);
		
		JLabel lbUsernameRegister = new JLabel("Username");
		lbUsernameRegister.setFont(new Font("Cambria", Font.BOLD, 15));
		lbUsernameRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lbUsernameRegister.setBounds(34, 79, 109, 31);
		P2.add(lbUsernameRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(153, 110, 135, 8);
		P2.add(separator);
		
		JLabel lbPasswordRegister = new JLabel("Password");
		lbPasswordRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lbPasswordRegister.setFont(new Font("Cambria", Font.BOLD, 15));
		lbPasswordRegister.setBounds(34, 141, 109, 31);
		P2.add(lbPasswordRegister);
		
		JLabel lbGmailRegister = new JLabel("Gmail");
		lbGmailRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lbGmailRegister.setFont(new Font("Cambria", Font.BOLD, 15));
		lbGmailRegister.setBounds(34, 204, 109, 31);
		P2.add(lbGmailRegister);
		
		txtGmailRegister = new JTextField();
		txtGmailRegister.setBackground(new Color(160, 82, 45));
		txtGmailRegister.setBorder(null);
		txtGmailRegister.setColumns(10);
		txtGmailRegister.setBounds(153, 204, 135, 31);
		P2.add(txtGmailRegister);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(153, 235, 135, 8);
		P2.add(separator_2);
		
		pwdPasswordRegister = new JPasswordField();
		pwdPasswordRegister.setBackground(new Color(160, 82, 45));
		pwdPasswordRegister.setBorder(null);
		pwdPasswordRegister.setBounds(153, 143, 135, 31);
		P2.add(pwdPasswordRegister);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(153, 174, 135, 8);
		P2.add(separator_1);
		
		JButton btnRegisterRegister = new JButton("Register");
		btnRegisterRegister.setBounds(117, 294, 101, 31);
		P2.add(btnRegisterRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				setpLogIn();
			}
		});
		btnBack.setBounds(260, 0, 73, 23);
		P2.add(btnBack);
		
		frame.getContentPane().add(pRegister);
		frame.setVisible(true);
		/*for(int i = 450; i >= 0; i--)
		{
			try
			{
				p1.setBounds(i, 0, 450, 461);
				Thread.sleep(2);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}*/
		
	}
	private void setpLogIn()//									set Login
	{
		pLogIn = new JPanel();
		pLogIn.setSize(WIDTH, HEIGHT);
		pLogIn.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBounds(0, 0, 450, 461);
		panel.setBackground(new Color(0, 0, 153));
		panel.setLayout(null);
		//panel.setLayout(new GridLayout(0, 1, 0, 0));
		//panel.add(new Label(""));
		
		Label label = new Label("Log in");
		label.setBounds(141, 77, 162, 66);
		label.setForeground(new Color(0, 255, 0));
		panel.add(label);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 40));
		label.setAlignment(Label.CENTER);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
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
		btn_LogIn.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_LogIn.setBounds(130, 270, 93, 27);
		panel_1.add(btn_LogIn);
		
		JButton btnRegisterLogin = new JButton("Register");
		btnRegisterLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
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
		
		frame.add(pLogIn);
		pLogIn.add(panel);
		frame.setVisible(true);
		/*for(int i = 450; i >= 0; i--)
		{
			try
			{
				panel.setBounds(i, 0, 450, 461);
				Thread.sleep(2);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}*/
	}
	public static void main(String[] args)
	{
		LogIn l = new LogIn("Log in");
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//setpLogIn();
		setpMenuChoice();
		//setpRegister();
	}
}
