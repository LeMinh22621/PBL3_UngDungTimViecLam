package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;

public class Admin extends JFrame implements ActionListener, WindowListener
{
	public Admin()
	{
		initialize();
	}

	private void initialize()
	{
		setBounds(100, 100, 800, 500);
		
		JPanel admin = new JPanel();
		JTable tableAccount;
		JTable tableContents;
		JTable tableContentsDetail;
		admin.setLayout(new BorderLayout());
		JButton AccountManagement = new JButton("ACCOUNT MANAGEMENT");
		JButton CensorContents = new JButton("CENSOR CONTENTS");
		
		JPanel pAccMgt = new JPanel();
		pAccMgt.setBackground(Color.GRAY);
		pAccMgt.setPreferredSize(new Dimension( 758,435));
		pAccMgt.setLayout(null);
		JPanel pConsor = new JPanel();
		pConsor.setBackground(Color.GRAY);
		pConsor.setForeground(Color.LIGHT_GRAY);
		pConsor.setPreferredSize(new Dimension( 758,435));
		pConsor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(135, 0, 512, 51);
		pAccMgt.add(lblNewLabel);
		
		
		JScrollPane scrollpAccMgt = new JScrollPane(pAccMgt);
		scrollpAccMgt.setBounds(0, 0, 784, 450);
		scrollpAccMgt.setLayout(new ScrollPaneLayout());
		
		scrollpAccMgt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpAccMgt.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 278, 21);
		admin.add(menuBar,BorderLayout.NORTH);
		
		AccountManagement.setHorizontalAlignment(SwingConstants.CENTER);
		AccountManagement.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(AccountManagement);
		
		
		CensorContents.setHorizontalAlignment(SwingConstants.CENTER);
		CensorContents.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(CensorContents);
		pConsor.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel1.setForeground(Color.YELLOW);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel1.setBounds(135, 0, 512, 51);
		pConsor.add(lblNewLabel1);
		
		JScrollPane scrollpConsor = new JScrollPane(pConsor);
		scrollpConsor.setBounds(0, 0, 784, 450);
		scrollpConsor.setLayout(new ScrollPaneLayout());
		
		scrollpConsor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpConsor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		admin.add(scrollpAccMgt,BorderLayout.CENTER);
		//admin.add(scrollpConsor,BorderLayout.CENTER);
		
		
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
		
		JLabel lbAccMgt = new JLabel("LIST ACCOUNT");
		lbAccMgt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAccMgt.setHorizontalAlignment(SwingConstants.CENTER);
		lbAccMgt.setBounds(12, 68, 118, 32);
		pAccMgt.add(lbAccMgt);
		
		
		tableAccount = new JTable(data,Colums);
		JScrollPane scrollPane = new JScrollPane(tableAccount);
		tableAccount.setFillsViewportHeight(true);
		scrollPane.setBounds(25, 100, 730, 287);
		pAccMgt.add(scrollPane);
		
		JButton btnNewButton_3 = new JButton("SHOW");
		btnNewButton_3.setBackground(new Color(204, 204, 255));
		btnNewButton_3.setBounds(52, 398, 89, 23);
		pAccMgt.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.setBackground(new Color(204, 204, 255));
		btnNewButton_4.setBounds(210, 398, 89, 23);
		pAccMgt.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BLOCK");
		btnNewButton_5.setBackground(new Color(204, 204, 255));
		btnNewButton_5.setBounds(368, 398, 89, 23);
		pAccMgt.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("SORT");
		btnNewButton_6.setBackground(new Color(204, 204, 255));
		btnNewButton_6.setBounds(517, 398, 89, 23);
		pAccMgt.add(btnNewButton_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(627, 398, 96, 22);
		pAccMgt.add(comboBox);
		
		JLabel lbContents = new JLabel("LIST CONTENTS");
		lbContents.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbContents.setHorizontalAlignment(SwingConstants.CENTER);
		lbContents.setBounds(0, 68, 150, 32);
		pConsor.add(lbContents);
		
		tableContents = new JTable(data,Colums);
		JScrollPane scrollPane1 = new JScrollPane(tableContents);
		tableContents.setFillsViewportHeight(true);
		scrollPane1.setBounds(25, 100, 303, 287);
		pConsor.add(scrollPane1);
		
		JLabel lblDetail = new JLabel("DETAILS");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDetail.setBounds(306, 68, 76, 32);
		pConsor.add(lblDetail);
		
		tableContentsDetail = new JTable(data,Colums);
		JScrollPane scrollPaneCD = new JScrollPane(tableContentsDetail);
		tableContents.setFillsViewportHeight(true);
		scrollPaneCD.setBounds(338, 100, 417, 287);
		pConsor.add(scrollPaneCD);
		
		JButton btnShowdetail = new JButton("SHOWDETAILS");
		btnShowdetail.setBackground(new Color(204, 204, 255));
		btnShowdetail.setBounds(25, 398, 125, 23);
		pConsor.add(btnShowdetail);
		
		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setBackground(new Color(204, 204, 255));
		btnAccept.setBounds(386, 398, 89, 23);
		btnAccept.setVisible(false);
		pConsor.add(btnAccept);
		
		JButton btnDecline = new JButton("DECLINE");
		btnDecline.setBackground(new Color(204, 204, 255));
		btnDecline.setBounds(603, 398, 89, 23);
		btnDecline.setVisible(false);
		pConsor.add(btnDecline);
		
		JButton btnNewButton_7 = new JButton("SORT");
		btnNewButton_7.setBackground(new Color(204, 204, 204));
		btnNewButton_7.setBounds(160, 398, 69, 23);
		pConsor.add(btnNewButton_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(233, 398, 95, 22);
		pConsor.add(comboBox_1);
		
		AccountManagement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.remove(scrollpConsor);
				admin.add(scrollpAccMgt,BorderLayout.CENTER);
				admin.revalidate();
				admin.repaint();
			}
		});
		CensorContents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.remove(scrollpAccMgt);
				admin.add(scrollpConsor,BorderLayout.CENTER);
				admin.revalidate();
				admin.repaint();
			}
		});
		btnShowdetail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAccept.setVisible(true);
				btnDecline.setVisible(true);
			}
		});
		btnAccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAccept.setVisible(false);
				btnDecline.setVisible(false);
			}
		});
		btnDecline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAccept.setVisible(false);
				btnDecline.setVisible(false);
			}
		});
		
		getContentPane().add(admin);
		addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	@Override
	public void windowClosing(WindowEvent e)
	{
//		if (JOptionPane.showConfirmDialog(this, "Are you sure you want to close this window?", "Close Window?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
//		{
//	            
//	    }
		dispose();
        LogIn f = new LogIn("Choise Permission");
        f.setVisible(true);
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
