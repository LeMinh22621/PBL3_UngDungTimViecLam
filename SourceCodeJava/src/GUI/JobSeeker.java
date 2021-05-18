package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JobSeeker extends JFrame implements ActionListener, WindowListener
{
	private JPanel contentPane;
	private JTextField txtJobS;
	private JTextField txtAddressS;
	private JTable tableS;
//	apply apl;

	public JobSeeker()
	{
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JPanel seeker_login = new JPanel();
		seeker_login.setBounds(0, 0, 784, 461);
		contentPane.add(seeker_login);
		seeker_login.setLayout(null);
		
		JPanel pTitleS = new JPanel();
		pTitleS.setBackground(new Color(51, 204, 153));
		pTitleS.setBounds(0, 0, 784, 62);
		seeker_login.add(pTitleS);
		pTitleS.setLayout(null);
		
		JLabel lblTitle = new JLabel("JOB-SEEKING APP FOR DESKTOP");
		lblTitle.setForeground(new Color(255, 255, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(135, 0, 512, 51);
		pTitleS.add(lblTitle);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 153));
		menuBar.setForeground(new Color(51, 0, 102));
		menuBar.setBounds(0, 0, 91, 37);
		pTitleS.add(menuBar);
		
		JMenu mnJobSeeker = new JMenu("JOB-SEEKER");
		mnJobSeeker.setFont(new Font("Century", Font.PLAIN, 12));
		mnJobSeeker.setForeground(new Color(255, 255, 0));
		mnJobSeeker.setBackground(new Color(204, 204, 204));
		menuBar.add(mnJobSeeker);
		
		JMenuItem mnItemProfile = new JMenuItem("Profile");
		mnItemProfile.setBackground(new Color(255, 255, 153));
		mnItemProfile.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemProfile.setForeground(Color.BLUE);
		mnJobSeeker.add(mnItemProfile);
		
		JMenuItem mnItemLogOut = new JMenuItem("Log Out");
		mnItemLogOut.setBackground(new Color(255, 204, 51));
		mnItemLogOut.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemLogOut.setForeground(Color.BLUE);
		mnJobSeeker.add(mnItemLogOut);
		
		JPanel pSearchS = new JPanel();
		pSearchS.setBackground(new Color(51, 204, 153));
		pSearchS.setBounds(0, 60, 784, 109);
		seeker_login.add(pSearchS);
		pSearchS.setLayout(null);
		
		JLabel lblJobS = new JLabel("Enter Job");
		lblJobS.setForeground(new Color(0, 0, 102));
		lblJobS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblJobS.setBounds(48, 35, 110, 14);
		pSearchS.add(lblJobS);
		
		JLabel lblAdressS = new JLabel("Enter Address");
		lblAdressS.setForeground(new Color(0, 0, 102));
		lblAdressS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAdressS.setBounds(48, 69, 124, 14);
		pSearchS.add(lblAdressS);
		
		txtJobS = new JTextField();
		txtJobS.setBounds(181, 22, 405, 27);
		pSearchS.add(txtJobS);
		txtJobS.setColumns(10);
		
		txtAddressS = 
				new JTextField();
		txtAddressS.setBounds(182, 66, 404, 27);
		pSearchS.add(txtAddressS);
		txtAddressS.setColumns(10);
		
		JButton btnSearchS = new JButton("SEARCH");
		btnSearchS.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSearchS.setBackground(Color.YELLOW);
		btnSearchS.setForeground(Color.RED);
		btnSearchS.setBounds(619, 44, 100, 27);
		pSearchS.add(btnSearchS);
		
		JPanel pListS = new JPanel();
		pListS.setBounds(0, 169, 784, 292);
		seeker_login.add(pListS);
		pListS.setLayout(null);
		String[] Colums = {"ID","Name"};
		Object[][] Data = {
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"},
				{"12","KT"}
		};
		tableS = new JTable(Data,Colums);
		
		JScrollPane scrollPaneS = new JScrollPane(tableS);
		tableS.setFillsViewportHeight(true);
		scrollPaneS.setBounds(35, 44, 717, 237);
		pListS.add(scrollPaneS);
		
		JLabel lblTopJob = new JLabel("Top Ranking-job");
		lblTopJob.setFont(new Font("VNI-Fato", Font.PLAIN, 18));
		lblTopJob.setForeground(new Color(51, 0, 153));
		lblTopJob.setBounds(35, 11, 155, 22);
		pListS.add(lblTopJob);
		getContentPane().add(contentPane);

		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		dispose();
        LogIn f = new LogIn("Choise Permission");
        f.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
