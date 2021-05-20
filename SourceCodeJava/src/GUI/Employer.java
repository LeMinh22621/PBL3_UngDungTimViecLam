package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableModel;

public class Employer extends JFrame implements ActionListener, WindowListener
{
	private JPanel contentPane;
	JTable tableE;
	private JTextField txtJobE;
	private JTextField txtAdressE;
	JButton btnPostE;
	Post post;

	public Employer()
	{
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel Employer_login = new JPanel();
		Employer_login.setBounds(0, 0, 784, 461);
		contentPane.add(Employer_login);
		Employer_login.setLayout(null);
		
		JPanel pTitleE = new JPanel();
		pTitleE.setBackground(new Color(51, 204, 153));
		pTitleE.setBounds(0, 0, 784, 62);
		Employer_login.add(pTitleE);
		pTitleE.setLayout(null);
		
		JLabel lblTitle = new JLabel("JOB-SEEKING APP FOR DESKTOP");
		lblTitle.setForeground(new Color(255, 255, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(135, 0, 512, 51);
		pTitleE.add(lblTitle);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 153));
		menuBar.setForeground(new Color(51, 0, 102));
		menuBar.setBounds(0, 0, 91, 37);
		pTitleE.add(menuBar);
		
		JMenu mnEmployer = new JMenu("EMPLOYER");
		mnEmployer.setFont(new Font("Century", Font.PLAIN, 12));
		mnEmployer.setForeground(new Color(255, 255, 0));
		mnEmployer.setBackground(new Color(204, 204, 204));
		menuBar.add(mnEmployer);
		
		JMenuItem mnItemProfile = new JMenuItem("Profile");
		mnItemProfile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		mnItemProfile.setBackground(new Color(255, 255, 153));
		mnItemProfile.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemProfile.setForeground(Color.BLUE);
		mnEmployer.add(mnItemProfile);
		
		JMenuItem mnItemLogOut = new JMenuItem("Log Out");
		mnItemLogOut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				LogIn f = new LogIn("Choise Permission");
				f.setVisible(true);
			}
		});
		mnItemLogOut.setBackground(new Color(255, 204, 51));
		mnItemLogOut.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemLogOut.setForeground(Color.BLUE);
		mnEmployer.add(mnItemLogOut);
		
		JPanel pSearchE = new JPanel();
		pSearchE.setBackground(new Color(51, 204, 153));
		pSearchE.setBounds(0, 60, 784, 109);
		Employer_login.add(pSearchE);
		pSearchE.setLayout(null);
		
		JLabel lblJobE = new JLabel("Enter Job");
		lblJobE.setForeground(new Color(0, 0, 102));
		lblJobE.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblJobE.setBounds(35, 25, 110, 14);
		pSearchE.add(lblJobE);
		
		JLabel lblAdressE = new JLabel("Enter Address");
		lblAdressE.setForeground(new Color(0, 0, 102));
		lblAdressE.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAdressE.setBounds(21, 69, 124, 14);
		pSearchE.add(lblAdressE);
		
		txtJobE = new JTextField();
		txtJobE.setBounds(140, 22, 405, 27);
		pSearchE.add(txtJobE);
		txtJobE.setColumns(10);
		
		txtAdressE = new JTextField();
		txtAdressE.setBounds(140, 66, 404, 27);
		pSearchE.add(txtAdressE);
		txtAdressE.setColumns(10);
		
		JButton btnSearchE = new JButton("SEARCH");
		btnSearchE.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSearchE.setBackground(Color.YELLOW);
		btnSearchE.setForeground(Color.RED);
		btnSearchE.setBounds(563, 39, 100, 37);
		pSearchE.add(btnSearchE);
		
	    btnPostE = new JButton("POST");
		btnPostE.setBackground(new Color(153, 255, 0));
		btnPostE.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnPostE.setBounds(673, 39, 72, 37);
		btnPostE.addActionListener(this);
		pSearchE.add(btnPostE);
		

		JPanel pListE = new JPanel();
		pListE.setBounds(0, 169, 784, 292);
		Employer_login.add(pListE);
		pListE.setLayout(null);
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
		tableE = new JTable(Data,Colums);
		tableE.setModel(new DefaultTableModel(
			new Object[][] {
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{"12", "KT"},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "Name"
			}
		));
		JScrollPane scrollPaneE = new JScrollPane(tableE);
		tableE.setFillsViewportHeight(true);
		scrollPaneE.setBounds(35, 44, 717, 219);
		pListE.add(scrollPaneE);
		
		JLabel lblTopSeeker = new JLabel("Top Seeker");
		lblTopSeeker.setFont(new Font("VNI-Fato", Font.PLAIN, 18));
		lblTopSeeker.setBorder(BorderFactory.createLineBorder(Color.RED));
		lblTopSeeker.setForeground(new Color(255, 51, 0));
		lblTopSeeker.setBounds(35, 11, 105, 27);
		pListE.add(lblTopSeeker);
		
		addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnPostE)
		{
			post = Post.getProfile();
			post.setVisible(true);
		}
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
}
