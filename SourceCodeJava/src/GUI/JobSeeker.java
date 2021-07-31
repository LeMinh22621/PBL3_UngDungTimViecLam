package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

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

import BLL.BLL;
import BLL.BLL_GUEST;
import DTO.Account;
import DTO.Post;

public class JobSeeker extends JFrame implements WindowListener
{
	private List<Post> list;
	private JPanel contentPane;
	private JComboBox cbbJobS;
	private JComboBox cbbAddressS;
	private JTable tableJ;
	private JTable tableNotifications;
	private JTable tableApplied;
	JobSeekerProfile profile;
	GUI.Post viewingPost;

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
		
		JMenuItem mnItemHomepage = new JMenuItem("Home");
		mnItemHomepage.setBackground(new Color(255, 255, 153));
		mnItemHomepage.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemHomepage.setForeground(Color.BLUE);
		mnJobSeeker.add(mnItemHomepage);
		
		JMenuItem mnItemProfile = new JMenuItem("Profile");
		mnItemProfile.setBackground(new Color(255, 255, 153));
		mnItemProfile.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemProfile.setForeground(Color.BLUE);
		mnJobSeeker.add(mnItemProfile);
		
		JMenuItem mnItemApplied = new JMenuItem("Applied");
		mnItemApplied.setBackground(new Color(255, 255, 153));
		mnItemApplied.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemApplied.setForeground(Color.BLUE);
		mnJobSeeker.add(mnItemApplied);
		
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
		
		JLabel lblJobS = new JLabel("CATEGORY_JOB_NAME");
		lblJobS.setForeground(new Color(0, 0, 102));
		lblJobS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblJobS.setBounds(10, 23, 182, 23);
		pSearchS.add(lblJobS);
		
		JLabel lblAdressS = new JLabel("ADDRESS");
		lblAdressS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdressS.setForeground(new Color(0, 0, 102));
		lblAdressS.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAdressS.setBounds(37, 70, 124, 14);
		pSearchS.add(lblAdressS);
		
		cbbJobS = new JComboBox();
		DefaultComboBoxModel tmpPost = new DefaultComboBoxModel();
		tmpPost.addAll(BLL_GUEST.getInstance().getListJobName_BLL_GUEST());
		cbbJobS.setModel(tmpPost);
		cbbJobS.setSelectedItem(cbbJobS.getItemAt(0));
		cbbJobS.setBounds(205, 21, 459, 32);
		pSearchS.add(cbbJobS);
		
		cbbAddressS = new JComboBox();
		DefaultComboBoxModel tmpaddress = new DefaultComboBoxModel();
		tmpaddress.addAll(BLL_GUEST.getInstance().getListAddressPost_BLL_GUEST());
		cbbAddressS.setModel(tmpaddress);
		cbbAddressS.setSelectedItem(cbbAddressS.getItemAt(0));
		cbbAddressS.setBounds(205, 64, 459, 32);
		pSearchS.add(cbbAddressS);
		
		JButton btnSearchS = new JButton("SEARCH");
		btnSearchS.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSearchS.setBackground(Color.YELLOW);
		btnSearchS.setForeground(Color.RED);
		btnSearchS.setBounds(674, 44, 100, 27);
		pSearchS.add(btnSearchS);
		
		JPanel pListS = new JPanel();
		pListS.setBackground(new Color(51, 204, 153));
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
		
		JPanel pAppliedS = new JPanel();
		pAppliedS.setVisible(false);
		pAppliedS.setBackground(new Color(51, 204, 153));
		pAppliedS.setBounds(0, 60, 784, 401);
		seeker_login.add(pAppliedS);
		pAppliedS.setLayout(null);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lblNotifications.setForeground(new Color(51, 0, 153));
		lblNotifications.setBounds(35, 0, 155, 22);
		pAppliedS.add(lblNotifications);
		
		tableNotifications = new JTable();
		String[] nameOfColumnsNoti= {"EMPLOYER_NAME","CATEGORY_JOB_NAME","JOB_NAME","COMPANY_NAME","CITY",
				"SALARY","DESCIPTION_JOB","LABOR","INFO"};
		DefaultTableModel tmpNoti = new DefaultTableModel();
		tmpNoti.setColumnIdentifiers(nameOfColumnsNoti);
		tableNotifications.setModel(tmpNoti);
		JScrollPane scrollPaneSNoti = new JScrollPane(tableNotifications);
		tableNotifications.setFillsViewportHeight(true);
		tableNotifications.setDefaultEditor(Object.class, null);
		scrollPaneSNoti.setBounds(35, 25, 717, 150);
		pAppliedS.add(scrollPaneSNoti);
		
		JLabel lblApplieds = new JLabel("List of Applieds");
		lblApplieds.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lblApplieds.setForeground(new Color(51, 0, 153));
		lblApplieds.setBounds(35, 181, 155, 22);
		pAppliedS.add(lblApplieds);
		
		tableApplied = new JTable();
		String[] nameOfColumnsApplied = {"EMPLOYER_NAME","CATEGORY_JOB_NAME","JOB_NAME","COMPANY_NAME","CITY",
				"SALARY","DESCIPTION_JOB","LABOR","STATUS","ID_POST"};
		DefaultTableModel tmpApplied = new DefaultTableModel();
		tmpApplied.setColumnIdentifiers(nameOfColumnsApplied);
		tableApplied.setModel(tmpApplied);
		JScrollPane scrollPaneSApplied = new JScrollPane(tableApplied);
		tableApplied.setFillsViewportHeight(true);
		tableApplied.setDefaultEditor(Object.class, null);
		scrollPaneSApplied.setBounds(35, 209, 717, 150);
		pAppliedS.add(scrollPaneSApplied);
		
		JButton btnCancelApplieds = new JButton("CANCEL");
		btnCancelApplieds.setVisible(false);
		btnCancelApplieds.setBackground(new Color(204, 204, 255));
		btnCancelApplieds.setBounds(649, 365, 103, 23);
		pAppliedS.add(btnCancelApplieds);
		
		JButton btnSortPost = new JButton("SORT");
		btnSortPost.setBackground(new Color(204, 204, 255));
		btnSortPost.setBounds(480, 258, 103, 23);
		pListS.add(btnSortPost);
		
		String[] itemsPost = {"CATEGORY_JOB_NAME","COMPANY_NAME","SALARY"};
		JComboBox cbbSortPost = new JComboBox(itemsPost);
		cbbSortPost.setBounds(593, 258, 159, 23);
		pListS.add(cbbSortPost);
		
		JLabel lblTopJob = new JLabel("Top Ranking-job");
		lblTopJob.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lblTopJob.setForeground(new Color(51, 0, 153));
		lblTopJob.setBounds(35, 11, 155, 22);
		pListS.add(lblTopJob);
		getContentPane().add(contentPane);
		//Sort
		btnSortPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cbbJobS.getSelectedItem().toString();
				String address = (cbbAddressS.getSelectedItem() != null)?cbbAddressS.getSelectedItem().toString():"";
				DefaultTableModel dtm = (DefaultTableModel) tableJ.getModel();
				dtm.setNumRows(0);
				String item = cbbSortPost.getSelectedItem().toString();
				list = BLL_GUEST.getInstance().getListSort_BLL_GUEST(item,name,address);
				for(Post i : list)
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
		//
		btnCancelApplieds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tableApplied.getSelectedRowCount() > 0)
				{
					int index = tableApplied.getSelectedRows()[0];
					BLL_GUEST.getInstance().CancelAppliedsI_BLL_GUEST(tableApplied.getModel().getValueAt(tableApplied.getSelectedRow(),9).toString());
					mnItemApplied.doClick();
				}
			}
		});
		//Homepage
		mnItemHomepage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pAppliedS.setVisible(false);
				pListS.setVisible(true);
				pSearchS.setVisible(true);
			}
		});
		
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
		//applied
		mnItemApplied.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pAppliedS.setVisible(true);
				pListS.setVisible(false);
				pSearchS.setVisible(false);
				DefaultTableModel dtm = (DefaultTableModel) tableApplied.getModel();
				dtm.setNumRows(0);
				for(Post i : BLL.getInstance().getListPostApplied_BLL_GUEST(user.getID_ACCOUNT()))
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
					row[8] = i.getSTATUS();
					row[9] = i.getID_POST();
					dtm.addRow(row);
				}
				if(tableApplied.getColumnCount()>9)
				{
					tableApplied.removeColumn(tableApplied.getColumnModel().getColumn(9));
				}
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
		// search
		btnSearchS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cbbJobS.getSelectedItem().toString();
				String address = (cbbAddressS.getSelectedItem() != null)?cbbAddressS.getSelectedItem().toString():"";
				DefaultTableModel dtm = (DefaultTableModel) tableJ.getModel();
				dtm.setNumRows(0);
				list = BLL_GUEST.getInstance().getListPostByNameAndAddress_BLL_GUEST(name,address);
				for(Post i : list)
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
		tableJ.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(tableJ.getSelectedRowCount() > 0)
				{
					int index = tableJ.getSelectedRow();
					String idJobSeeker = BLL.getInstance().getIdJobSeekerByIdAccount_BLL(user.getID_ACCOUNT());
					viewingPost = GUI.Post.getPost(list.get(index),idJobSeeker);
					viewingPost.setVisible(true);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tableApplied.addMouseListener(new MouseAdapter() {;
			public void mouseClicked(MouseEvent e)
			{
				if(tableApplied.getSelectedRowCount() > 0)
				{
					btnCancelApplieds.setVisible(true);
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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
