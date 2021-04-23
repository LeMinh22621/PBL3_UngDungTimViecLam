package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class LogIn extends JFrame implements ActionListener, WindowListener
{
	String username, password;
	JButton btnLogIn,btnRegister;
	JTextField txtUsername, txtPassword;
	JLabel lbLogin;
	JPanel p, p1, p2, p3;
	
	public LogIn(String title)
	{
		super(title);
		setBounds(300, 200, 300, 200);
		setBackground(Color.BLUE);
		
		setPanel1();
		setPanel2();
		
		p = new JPanel(new GridLayout(3,1));
		p.add(p1);
		p.add(p2);
		
		add(p);
		
		setVisible(true);
		addWindowListener(this);
	}
	private void setPanel1()
	{
		p1 = new JPanel();
		lbLogin = new JLabel("Log In");
		lbLogin.setFont(new Font("Serif", Font.ITALIC, 30));
		lbLogin.setForeground(Color.DARK_GRAY);
		
		p1.add(lbLogin);
	}
	private void setPanel2()
	{
		p2 = new JPanel(new GridLayout(2,3));
		txtUsername = new JTextField("UserName");txtUsername.setEditable(true);
		txtPassword = new JTextField("Password");txtPassword.setEditable(true);

		p2.add(new JLabel(""));p2.add(txtUsername);p2.add(new JLabel(""));
		p2.add(new JLabel(""));p2.add(txtPassword);p2.add(new JLabel(""));
	}
	private void setPanel3()
	{
		p3 = new JPanel();
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
	
	public static void main(String[] args)
	{
		LogIn logIn = new LogIn("Log In");
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}