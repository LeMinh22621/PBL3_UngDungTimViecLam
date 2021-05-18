package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class Guest extends JFrame implements ActionListener, WindowListener
{
	private JTextField textName;
	private JTextField textAddress;
	private JTable table;
	private JTable table1;

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
		guest.setPreferredSize(new Dimension( 750,800));
		guest.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		//lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel.setBounds(135, 0, 512, 51);
		guest.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(94, 81, 459, 32);
		guest.add(textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(94, 131, 459, 32);
		guest.add(textAddress);
		
		
		JComboBox cbb = new JComboBox();
		cbb.setModel(new DefaultComboBoxModel(new Item[] {new Item(0,"JobName"), new Item(1,"SeekerName")}));
		cbb.setToolTipText("");
		cbb.setBounds(635, 81, 106, 32);
		guest.add(cbb);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String address = textAddress.getText();
				//if(cbb.)
				//textTEST.setText(name + " : " +address);
			}
		});
		btnSearch.setBounds(635, 131, 106, 32);
		guest.add(btnSearch);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 79, 74, 32);
		guest.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(10, 131, 74, 32);
		guest.add(lblAddress);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 83, 32);
		guest.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("GUEST");
		//ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\ADMIN\\Pictures\\download1.jpg").getImage().getScaledInstance(20, 30, Image.SCALE_DEFAULT));
		//mnNewMenu.setIcon(imageIcon);
		menuBar.add(mnNewMenu);
		
		JButton btnProfile = new JButton("Profile ");
		btnProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// mo form moi
			}
		});
		mnNewMenu.add(btnProfile);
		
		JButton btnLogin = new JButton("Log-in ");
		mnNewMenu.add(btnLogin);
		
		String[] Colums = {"Name","Lop"};
		Object[][] data = {
				{ "KT","12" },
				{ "KY","13" },
				{ "KU","14" },
				{ "KT","12" },
				{ "KY","13" },
				{ "KU","14" },
				{ "KT","12" },
				{ "KY","13" },
				{ "KU","14" },
				{ "KT","12" },
				{ "KY","13" },
				{ "KU","14" },
				{ "KT","12" },
				{ "KY","13" },
				{ "KU","14" }
			
		};
		
		JLabel lbseeker = new JLabel("Top-Ranking Jobs");
		lbseeker.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbseeker.setHorizontalAlignment(SwingConstants.CENTER);
		lbseeker.setBounds(62, 174, 150, 32);
		guest.add(lbseeker);
		
		
		table = new JTable(data,Colums);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(72, 206, 613, 225);
		guest.add(scrollPane);
		
		JLabel lbemployer = new JLabel("Top-Seeker");
		lbemployer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbemployer.setHorizontalAlignment(SwingConstants.CENTER);
		lbemployer.setBounds(50, 485, 150, 32);
		guest.add(lbemployer);
		
		table1 = new JTable(data,Colums);
		JScrollPane scrollPane1 = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		scrollPane1.setBounds(74, 510, 613, 225);
		guest.add(scrollPane1);
		
		JScrollPane scrollPaneFrame = new JScrollPane(guest);
		scrollPaneFrame.setBounds(0, 0, 784, 450);
		scrollPaneFrame.setLayout(new ScrollPaneLayout());
		
		//p.setAutoscrolls(true);
		scrollPaneFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFrame.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
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
