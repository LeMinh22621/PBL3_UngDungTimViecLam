package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_GUEST;
import DTO.JobSeeker;
import DTO.Post;

public class Guest extends JFrame implements ActionListener, WindowListener
{
	private JComboBox cbbName;
	private JComboBox cbbAddress;
	private JTable tablepost;
	private JTable tablejobseeker;

	public Guest()
	{
		initialize();
	}
	
	class Item
	{
		private int Value;
		private String Text;
		public Item(int value,String text)
		{
			Value = value;
			Text = text;
		}
		@Override
		public String toString()
		{
			return Text;
		};
		public void setValue(int value)
		{
			Value = value;
		}
		public int getValue()
		{
			return Value;
		}
		public void setText(String text)
		{
			Text = text;
		}
		public String getText()
		{
			return Text;
		}
	}
	private void initialize()
	{
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JPanel guest =new JPanel();
		guest.setPreferredSize(new Dimension( 750,750));
		guest.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		//lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel.setBounds(135, 0, 512, 51);
		guest.add(lblNewLabel);
		
		cbbName = new JComboBox();
		DefaultComboBoxModel tmpName = new DefaultComboBoxModel();
		DefaultComboBoxModel tmpProfessional = new DefaultComboBoxModel();
		cbbName.setModel(tmpName);
		cbbName.setBounds(147, 81, 459, 32);
		guest.add(cbbName);
		
		cbbAddress = new JComboBox();
		DefaultComboBoxModel tmpaddressPost = new DefaultComboBoxModel();
		DefaultComboBoxModel tmpaddressJobseeker = new DefaultComboBoxModel();
		cbbAddress.setModel(tmpaddressPost);
		cbbAddress.setBounds(147, 124, 459, 32);
		guest.add(cbbAddress);
		// cbb employer
		tmpProfessional.addAll(BLL_GUEST.getInstance().getListPROFESSIONAL_BLL_GUEST());
		tmpaddressJobseeker.addAll(BLL_GUEST.getInstance().getListAddressJobseeker_BLL_GUEST());
		// cbb jobseeker
		tmpName.addAll(BLL_GUEST.getInstance().getListJobName_BLL_GUEST());
		tmpaddressPost.addAll(BLL_GUEST.getInstance().getListAddressPost_BLL_GUEST());
		cbbName.setSelectedItem(cbbName.getItemAt(0));
		cbbAddress.setSelectedItem(cbbAddress.getItemAt(0));
		JComboBox cbb = new JComboBox();
		cbb.setModel(new DefaultComboBoxModel(new Item[] {new Item(0,"CategoryJob"), new Item(1,"SeekerName")}));
		cbb.setToolTipText("");
		cbb.setBounds(635, 81, 106, 32);
		guest.add(cbb);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(635, 124, 106, 32);
		guest.add(btnSearch);
		
		JLabel lblName = new JLabel("CATEGORY_JOB");
		lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0, 78, 137, 32);
		guest.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblAddress.setBounds(30, 121, 74, 32);
		guest.add(lblAddress);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 83, 32);
		guest.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("GUEST");
		//ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\ADMIN\\Pictures\\download1.jpg").getImage().getScaledInstance(20, 30, Image.SCALE_DEFAULT));
		//mnNewMenu.setIcon(imageIcon);
		menuBar.add(mnNewMenu);
		
		JButton btnProfile = new JButton("Post ");
		btnProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		mnNewMenu.add(btnProfile);
		
		JButton btnLogin = new JButton("Log-in ");
		mnNewMenu.add(btnLogin);
		
		JButton btnSentCV = new JButton("SEND CV");
		btnSentCV.setVisible(false);
		btnSentCV.setBounds(652, 422, 89, 23);
		guest.add(btnSentCV);
		
		JLabel lbseeker = new JLabel("Top-Ranking Jobs");
		lbseeker.setFont(new Font("VNI-Fato", Font.PLAIN, 15));
		lbseeker.setHorizontalAlignment(SwingConstants.CENTER);
		lbseeker.setBounds(42, 174, 150, 32);
		guest.add(lbseeker);
		
		// bang jobname
		tablepost = new JTable();
		String[] nameOfColumnsPost = {"EMPLOYER_NAME","CATEGORY_JOB_NAME","JOB_NAME","COMPANY_NAME","CITY",
				"SALARY","DESCIPTION_JOB","LABOR"};
		DefaultTableModel tmp = new DefaultTableModel();
		tmp.setColumnIdentifiers(nameOfColumnsPost);
		tablepost.setModel(tmp);
		JScrollPane scrollPane = new JScrollPane(tablepost);
		tablepost.setFillsViewportHeight(true);
		tablepost.setDefaultEditor(Object.class, null);
		scrollPane.setBounds(35, 206, 706, 216);
		guest.add(scrollPane);
		
		JButton btnSentMessage = new JButton("SEND MESSAGE");
		btnSentMessage.setVisible(false);
		btnSentMessage.setBounds(612, 726, 129, 23);
		guest.add(btnSentMessage);
		
		JLabel lbemployer = new JLabel("Top-Seeker");
		lbemployer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbemployer.setHorizontalAlignment(SwingConstants.CENTER);
		lbemployer.setBounds(20, 485, 150, 32);
		guest.add(lbemployer);
		
		tablejobseeker = new JTable();
		String[] nameOfColumnsjobseeker = {"JOBSEEKER_NAME","CITY","PHONENUMBER","AGE","PROFESSIONAL"};
		DefaultTableModel tmpjobseeker = new DefaultTableModel();
		tmpjobseeker.setColumnIdentifiers(nameOfColumnsjobseeker);
		tablejobseeker.setModel(tmpjobseeker);
		JScrollPane scrollPane1 = new JScrollPane(tablejobseeker);
		tablejobseeker.setFillsViewportHeight(true);
		tablejobseeker.setDefaultEditor(Object.class, null);
		scrollPane1.setBounds(35, 510, 706, 216);
		guest.add(scrollPane1);
		
		JScrollPane scrollPaneFrame = new JScrollPane(guest);
		
		scrollPaneFrame.setBounds(0, 0, 784, 450);
		scrollPaneFrame.setLayout(new ScrollPaneLayout());
		
		//p.setAutoscrolls(true);
		scrollPaneFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFrame.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Chuc nang
		// set SK bang Top-Ranking Jobs
		tablepost.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				if(tablepost.getSelectedRowCount()>0)
				{
					btnSentCV.setVisible(true);
				}
			}
		});
		// set SK bang Top-Seeker
		tablejobseeker.addMouseListener(new MouseListener() {
					
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
				// TODO Auto-generated method stub
				if(tablejobseeker.getSelectedRowCount()>0)
				{
					btnSentMessage.setVisible(true);
				}
			}
		});
		//login
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// mo form moi
				setVisible(false);
				LogIn Log = new LogIn("Choise Permission");
			}
		});
		//cbb
		cbb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(cbb.getSelectedItem().toString().equals("CategoryJob"))
				{
					lblName.setText("CATEGORY_JOB");
					cbbName.setModel(tmpName);
					cbbAddress.setModel(tmpaddressPost);
					cbbName.setSelectedItem(cbbName.getItemAt(0));
					cbbAddress.setSelectedItem(cbbAddress.getItemAt(0));
				}
				else
				{
					lblName.setText("PROFESSIONAL");
					cbbName.setModel(tmpProfessional);
					cbbAddress.setModel(tmpaddressJobseeker);
					cbbName.setSelectedItem(cbbName.getItemAt(0));
					cbbAddress.setSelectedItem(cbbAddress.getItemAt(0));
					
				}
			}
		});
		// tim kiem
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cbbName.getSelectedItem().toString();
				String address = cbbAddress.getSelectedItem().toString();
				switch(cbb.getSelectedItem().toString())
				{
				 	case "CategoryJob":
				 	{
				 		DefaultTableModel dtm = (DefaultTableModel) tablepost.getModel();
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
				 		break;
				 	}
				 	case "SeekerName":
				 	{
				 		DefaultTableModel dtm = (DefaultTableModel) tablejobseeker.getModel();
						dtm.setNumRows(0);
						for(JobSeeker i : BLL_GUEST.getInstance().GetlistJobSeeker_BLL_GUEST(name,address))
						{
							Object[] row = new Object[dtm.getColumnCount()];
							row[0] = i.getPROFILE().getNAME();
							row[1] = i.getPROFILE().getCITY();
							row[2] = i.getPROFILE().getPHONENUMBER();
							row[3] = i.getAGE();
							row[4] = i.getPROFESSIONAL();
							 
							dtm.addRow(row);
						}
				 		break;
				 	}
				}
			}
		});
		// SK table post
		
		getContentPane().add(scrollPaneFrame);
		addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
