package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_GUEST;
import DTO.Account;
import DTO.Post;

public class JobSeeker extends JFrame implements ActionListener, WindowListener
{
	
	private JPanel contentPane;
	private JComboBox cbbJobS;
	private JComboBox cbbAddressS;
	private JTable tableJ;
	JobSeekerProfile profile;
	Post viewingPost;

	public JobSeeker(Account user)
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
		
		JLabel lblJobS = new JLabel("JOB-NAME");
		lblJobS.setForeground(new Color(0, 0, 102));
		lblJobS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblJobS.setBounds(27, 27, 110, 14);
		pSearchS.add(lblJobS);
		
		JLabel lblAdressS = new JLabel("ADDRESS");
		lblAdressS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdressS.setForeground(new Color(0, 0, 102));
		lblAdressS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAdressS.setBounds(13, 70, 124, 14);
		pSearchS.add(lblAdressS);
		
		cbbJobS = new JComboBox();
		DefaultComboBoxModel tmpPost = new DefaultComboBoxModel();
		tmpPost.addAll(BLL_GUEST.getInstance().getListJobName_BLL_GUEST());
		cbbJobS.setModel(tmpPost);
		cbbJobS.setSelectedItem(cbbJobS.getItemAt(0));
		cbbJobS.setBounds(147, 21, 459, 32);
		pSearchS.add(cbbJobS);
		
		cbbAddressS = new JComboBox();
		DefaultComboBoxModel tmpaddress = new DefaultComboBoxModel();
		tmpaddress.addAll(BLL_GUEST.getInstance().getListAddressPost_BLL_GUEST());
		cbbAddressS.setModel(tmpaddress);
		cbbAddressS.setSelectedItem(cbbAddressS.getItemAt(0));
		cbbAddressS.setBounds(147, 64, 459, 32);
		pSearchS.add(cbbAddressS);
		
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
		
		tableJ = new JTable();
		String[] nameOfColumns = {"EMPLOYER_NAME","CATEGORY_JOB_NAME","JOB_NAME","COMPANY_NAME","CITY",
				"SALARY","DESCIPTION_JOB","LABOR"};
		DefaultTableModel tmp = new DefaultTableModel();
		tmp.setColumnIdentifiers(nameOfColumns);
		tableJ.setModel(tmp);
		JScrollPane scrollPaneS = new JScrollPane(tableJ);
		tableJ.setFillsViewportHeight(true);
		tableJ.setDefaultEditor(Object.class, null);
		scrollPaneS.setBounds(35, 44, 717, 210);
		pListS.add(scrollPaneS);
		
		JLabel lblTopJob = new JLabel("Top Ranking-job");
		lblTopJob.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lblTopJob.setForeground(new Color(51, 0, 153));
		lblTopJob.setBounds(35, 11, 155, 22);
		pListS.add(lblTopJob);
		getContentPane().add(contentPane);
		//logout
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
		//profile
		mnItemProfile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				profile = new JobSeekerProfile(user);
				profile.setVisible(true);
			}
		});
		// SK
		tableJ.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(tableJ.getSelectedRowCount()>0)
				{
//					int index = tableJ.getSelectedRow();
//					String idEmployer = tableJ.getValueAt(index, 0)
				}
			}
		});
		// search
		btnSearchS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cbbJobS.getSelectedItem().toString();
				String address = (cbbAddressS.getSelectedItem() != null)?cbbAddressS.getSelectedItem().toString():"";
				DefaultTableModel dtm = (DefaultTableModel) tableJ.getModel();
				dtm.setNumRows(0);
				for(Post i : BLL_GUEST.getInstance().getListPostByNameAndAddress_BLL_GUEST(name,address))
				{
					Object[] row = new Object[dtm.getColumnCount()];
					row[0] = i.getEMPLOYER().getPROFILE().getNAME();
					row[1] = i.getCATEGORY_JOB().getCATEGORY_JOB_NAME();
					row[2] = i.getJOB_NAME();
					row[3] = i.getCOMPANY_NAME();
					row[4] = i.getCITY();
					row[5] = i.getSALARY();
					row[6] = i.getDESCIPTION_JOB();
					row[7] = i.getLABOR();
					 
					dtm.addRow(row);
				}
			}
		});
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
