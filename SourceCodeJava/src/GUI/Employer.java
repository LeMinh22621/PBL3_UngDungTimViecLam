package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
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
import DTO.JobSeeker;

public class Employer extends JFrame implements WindowListener
{
	private JPanel contentPane;
	JTable tableE;
	private JComboBox cbbJobE;
	private JComboBox cbbAddressE;
	Post post;
	EmployerProfile profile;
	Post viewingPost;
	
	public Employer(Account user)
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
				profile = new EmployerProfile(user);
				profile.setVisible(true);
			}
		});
		mnItemProfile.setBackground(new Color(255, 255, 153));
		mnItemProfile.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemProfile.setForeground(Color.BLUE);
		mnEmployer.add(mnItemProfile);
		
		JMenuItem mnItemPost = new JMenuItem("Post");
		mnItemPost.setBackground(new Color(255, 204, 51));
		mnItemPost.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemPost.setForeground(Color.BLUE);
		mnEmployer.add(mnItemPost);
		JMenuItem mnItemLogOut = new JMenuItem("Log Out");
		mnItemLogOut.setBackground(new Color(255, 204, 51));
		mnItemLogOut.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		mnItemLogOut.setForeground(Color.BLUE);
		mnEmployer.add(mnItemLogOut);
		
		JPanel pSearchE = new JPanel();
		pSearchE.setBackground(new Color(51, 204, 153));
		pSearchE.setBounds(0, 60, 774, 109);
		Employer_login.add(pSearchE);
		pSearchE.setLayout(null);
		
		JLabel lblJobE = new JLabel("PROFESSIONAL");
		lblJobE.setForeground(new Color(0, 0, 102));
		lblJobE.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblJobE.setBounds(13, 27, 124, 14);
		pSearchE.add(lblJobE);
		
		JLabel lblAdressE = new JLabel("ADDRESS");
		lblAdressE.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdressE.setForeground(new Color(0, 0, 102));
		lblAdressE.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAdressE.setBounds(13, 70, 124, 14);
		pSearchE.add(lblAdressE);
		
		cbbJobE = new JComboBox();
		DefaultComboBoxModel tmpjob = new DefaultComboBoxModel();
		tmpjob.addAll(BLL_GUEST.getInstance().getListPROFESSIONAL_BLL_GUEST());
		cbbJobE.setModel(tmpjob);
		cbbJobE.setSelectedItem(cbbJobE.getItemAt(0));
		cbbJobE.setBounds(147, 21, 477, 32);
		pSearchE.add(cbbJobE);
		
		cbbAddressE = new JComboBox();
		DefaultComboBoxModel tmpaddress = new DefaultComboBoxModel();
		tmpaddress.addAll(BLL_GUEST.getInstance().getListAddressJobseeker_BLL_GUEST());
		cbbAddressE.setModel(tmpaddress);
		cbbAddressE.setSelectedItem(cbbAddressE.getItemAt(0));
		cbbAddressE.setBounds(147, 64, 477, 32);
		pSearchE.add(cbbAddressE);
		
		List<JobSeeker> listJobSeeker = new ArrayList<JobSeeker>();
		JButton btnSearchE = new JButton("SEARCH");
		btnSearchE.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnSearchE.setBackground(Color.YELLOW);
		btnSearchE.setForeground(Color.RED);
		btnSearchE.setBounds(645, 45, 101, 27);
		pSearchE.add(btnSearchE);	

		JPanel pListE = new JPanel();
		pListE.setBackground(new Color(51, 204, 153));
		pListE.setBounds(0, 169, 784, 292);
		Employer_login.add(pListE);
		pListE.setLayout(null);
		
		tableE = new JTable();
		String[] nameOfColumns = {"JOBSEEKER_NAME","CITY","PHONENUMBER","AGE","PROFESSIONAL","EMAIL"};
		DefaultTableModel tmp = new DefaultTableModel();
		tmp.setColumnIdentifiers(nameOfColumns);
		tableE.setModel(tmp);
		JScrollPane scrollPaneE = new JScrollPane(tableE);
		tableE.setFillsViewportHeight(true);
		tableE.setDefaultEditor(Object.class, null);
		scrollPaneE.setBounds(35, 44, 717, 210);
		pListE.add(scrollPaneE);
		
		// table xem nhung bai post da dang
		JTable tablepost = new JTable();
		List<DTO.Post> listPost = new ArrayList<DTO.Post>();
		String[] nameOfColumnsPost = {"JOB_NAME","COMPANY_NAME","CITY","SALARY","DESCIPTION_JOB","LABOR"};
		DefaultTableModel tmppost = new DefaultTableModel()
		{
			@Override
			public boolean isCellEditable(int row, int col)
			{
				return false;
			}
		};
		tmppost.setColumnIdentifiers(nameOfColumnsPost);
		tablepost.setModel(tmppost);
		JScrollPane scrollPanePost = new JScrollPane(tablepost);
		tablepost.setFillsViewportHeight(true);
		tablepost.setDefaultEditor(Object.class, null);
		scrollPanePost.setBounds(35, 44, 717, 210);
		scrollPanePost.setVisible(false);
		pListE.add(scrollPanePost);
		
		JButton btnPost = new JButton("POST");
		btnPost.setVisible(false);
		btnPost.setBounds(357, 258, 103, 23);
		pListE.add(btnPost);
		
		JButton btnShowPost = new JButton("Show");
		btnShowPost.setVisible(false);
		btnShowPost.setBounds(65, 258, 103, 23);
		pListE.add(btnShowPost);
		
		JButton btnDeletePost = new JButton("DELETE");
		btnDeletePost.setVisible(false);
		btnDeletePost.setBounds(649, 258, 103, 23);
		pListE.add(btnDeletePost);
		
		JButton btnSortSeekerName = new JButton("SORT");
		btnSortSeekerName.setBackground(new Color(204, 204, 255));
		btnSortSeekerName.setBounds(499, 258, 103, 23);
		pListE.add(btnSortSeekerName);
		
		String[] itemsSeekerName = {"JOBSEEKER_NAME","AGE"};
		JComboBox cbbSortSeekerName = new JComboBox(itemsSeekerName);
		cbbSortSeekerName.setBounds(612, 258, 140, 23);
		pListE.add(cbbSortSeekerName);
		
		JLabel lblTopSeeker = new JLabel("Top Seeker");
		lblTopSeeker.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lblTopSeeker.setForeground(new Color(255, 51, 0));
		lblTopSeeker.setBounds(35, 11, 105, 27);
		pListE.add(lblTopSeeker);
		
		JButton btnSentMessage = new JButton("SEND MESSAGE");
		btnSentMessage.setVisible(false);
		btnSentMessage.setBounds(35, 258, 133, 23);
		btnSentMessage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(tableE.getSelectedRowCount() == 1)
				{
					int index = tableE.getSelectedRow();
					JobSeeker job = listJobSeeker.get(index);
					SendPost sendPost = SendPost.getInstance(BLL_GUEST.getInstance().getIDEMployerByIDAccount_BLL_GUEST(user.getID_ACCOUNT()),job.getID_JOBSEEKER());
					sendPost.show();
				}
			}
		});
		pListE.add(btnSentMessage);
		mnItemPost.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				scrollPaneE.setVisible(false);
				lblTopSeeker.setVisible(false);
				btnSentMessage.setVisible(false);
				cbbSortSeekerName.setVisible(false);
				btnSortSeekerName.setVisible(false);
				scrollPanePost.setVisible(true);
				btnPost.setVisible(true);
				btnShowPost.setVisible(true);
			}
		});
		// Sort
		btnSortSeekerName.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				DefaultTableModel dtm = (DefaultTableModel) tableE.getModel();
				dtm.setNumRows(0);
				String name = cbbJobE.getSelectedItem().toString();
				String address = cbbAddressE.getSelectedItem().toString();
				String item = cbbSortSeekerName.getSelectedItem().toString();
				for(JobSeeker i : BLL_GUEST.getInstance().SortJobseeker_BLL(item,name,address))
				{
					Object[] row = new Object[dtm.getColumnCount()];
					row[0] = i.getPROFILE().getNAME();
					row[1] = i.getPROFILE().getCITY();
					row[2] = i.getPROFILE().getPHONENUMBER();
					row[3] = i.getAGE();
					row[4] = i.getPROFESSIONAL();
					row[5] = i.getPROFILE().getEMAIL();
					 
					dtm.addRow(row);
				}
			}
		});
		// logout
		mnItemLogOut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				LogIn f = new LogIn("Choose Permission");
				f.setVisible(true);
			}
		});
		// Set SK
		tableE.addMouseListener(new MouseListener() {
			
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
			public void mouseClicked(MouseEvent e) {
				if(tableE.getSelectedRowCount()>0)
				{
					btnSentMessage.setVisible(true);
				}
			}
		});
		// tablePost
		tablepost.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
					
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
				if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2)
				{
					if(tablepost.getSelectedRowCount() == 1)
					{
						int index = tablepost.getSelectedRow();
						viewingPost = new Post(null, listPost.get(index));
						viewingPost.setVisible(true);
						btnDeletePost.setVisible(true);
					}
				}
			}
		});
		// search
		btnSearchE.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				String name = cbbJobE.getSelectedItem().toString();
				String address = cbbAddressE.getSelectedItem().toString();
				DefaultTableModel dtm = (DefaultTableModel) tableE.getModel();
				dtm.setNumRows(0);
				scrollPaneE.setVisible(true);
				lblTopSeeker.setVisible(true);
				cbbSortSeekerName.setVisible(true);
				btnSortSeekerName.setVisible(true);
				scrollPanePost.setVisible(false);
				btnPost.setVisible(false);
				btnShowPost.setVisible(false);
				btnDeletePost.setVisible(false);
				listJobSeeker.clear();
				listJobSeeker.addAll(BLL.getInstance().GetlistJobSeeker_BLL(name, address));
				for(JobSeeker i : listJobSeeker)
				{
					Object[] row = new Object[dtm.getColumnCount()];
					row[0] = i.getPROFILE().getNAME();
					row[1] = i.getPROFILE().getCITY();
					row[2] = i.getPROFILE().getPHONENUMBER();
					row[3] = i.getAGE();
					row[4] = i.getPROFESSIONAL();
					row[5] = i.getPROFILE().getEMAIL();
					 
					dtm.addRow(row);
				}
		}
		});
		// Show
		btnShowPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) tablepost.getModel();
				dtm.setNumRows(0);
				String IDEMployer = BLL_GUEST.getInstance().getIDEMployerByIDAccount_BLL_GUEST(user.getID_ACCOUNT());
				listPost.clear();
				listPost.addAll(BLL_GUEST.getInstance().getListPostByIDEmployer_BLL_GUEST(IDEMployer) );
				for(DTO.Post i : listPost)
				{
					Object[] row = new Object[dtm.getColumnCount()];
					row[0] = i.getJOB_NAME();
					row[1] = i.getCOMPANY_NAME();
					row[2] = i.getCITY();
					row[3] = i.getSALARY();
					row[4] = i.getDESCIPTION_JOB();
					row[5] = i.getLABOR();
					dtm.addRow(row);
				}
			}
		});
		// post
		btnPost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				post = new Post(user);
				post.setVisible(true);
			}
		});
		//delete
		btnDeletePost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<tablepost.getSelectedRowCount();i++)
				{
					int index = tablepost.getSelectedRows()[i];
					BLL_GUEST.getInstance().DeletePostByID_BLL_GUEST(listPost.get(index).getID_POST());
				}
				btnDeletePost.setVisible(false);
				btnShowPost.doClick();
			}
		});
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
}
