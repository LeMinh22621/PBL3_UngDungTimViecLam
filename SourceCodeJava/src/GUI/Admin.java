package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.DefaultTableModel;

import BLL.BLL;
import DTO.Account;
import DTO.Post;

public class Admin extends JFrame implements ActionListener, WindowListener{
	public Admin() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel admin = new JPanel();
		JTable tableAccountG;
		JTable tableContentsG;
		admin.setLayout(new BorderLayout());
		JButton AccountManagementG = new JButton("ACCOUNT MANAGEMENT");
		JButton CensorContentsG = new JButton("CENSOR CONTENTS");
		
		JPanel pAccMgtG = new JPanel();
		pAccMgtG.setBackground(Color.GRAY);
		pAccMgtG.setPreferredSize(new Dimension( 758,435));
		pAccMgtG.setLayout(null);
		JPanel pConsorG = new JPanel();
		pConsorG.setBackground(Color.GRAY);
		pConsorG.setForeground(Color.LIGHT_GRAY);
		pConsorG.setPreferredSize(new Dimension( 758,435));
		pConsorG.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(135, 0, 512, 51);
		pAccMgtG.add(lblNewLabel);
		
		
		JScrollPane scrollpAccMgt = new JScrollPane(pAccMgtG);
		scrollpAccMgt.setBounds(0, 0, 784, 450);
		scrollpAccMgt.setLayout(new ScrollPaneLayout());
		
		scrollpAccMgt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpAccMgt.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 278, 21); 
		admin.add(menuBar,BorderLayout.NORTH);
		
		AccountManagementG.setHorizontalAlignment(SwingConstants.CENTER);
		AccountManagementG.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(AccountManagementG);
		
		
		CensorContentsG.setHorizontalAlignment(SwingConstants.CENTER);
		CensorContentsG.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(CensorContentsG);
		pConsorG.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("JOBS-SEEKING APP FOR DESKTOP");
		lblNewLabel1.setForeground(Color.YELLOW);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel1.setBounds(135, 0, 512, 51);
		pConsorG.add(lblNewLabel1);
		
		JScrollPane scrollpConsorG = new JScrollPane(pConsorG);
		scrollpConsorG.setBounds(0, 0, 784, 450);
		scrollpConsorG.setLayout(new ScrollPaneLayout());
		
		scrollpConsorG.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpConsorG.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		admin.add(scrollpAccMgt,BorderLayout.CENTER);
		//admin.add(scrollpConsorG,BorderLayout.CENTER);
		
		
		JLabel lbAccMgtG = new JLabel("LIST ACCOUNT");
		lbAccMgtG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAccMgtG.setHorizontalAlignment(SwingConstants.CENTER);
		lbAccMgtG.setBounds(12, 68, 118, 32);
		pAccMgtG.add(lbAccMgtG);
		
		//bang account
		tableAccountG = new JTable();
		String[] nameOfColumnsAcc = {"ID_ACCOUNT","USERNAME","PASSWORD","ACCESSER","STATUS"};
		DefaultTableModel tmpAcc = new DefaultTableModel();
		tmpAcc.setColumnIdentifiers(nameOfColumnsAcc);
		tableAccountG.setModel(tmpAcc);
		//
		JScrollPane scrollPane = new JScrollPane(tableAccountG);
		tableAccountG.setFillsViewportHeight(true);
		scrollPane.setBounds(25, 100, 730, 287);
		pAccMgtG.add(scrollPane);
		
		JButton btnShowListAccG = new JButton("SHOW");
		btnShowListAccG.setBackground(new Color(204, 204, 255));
		btnShowListAccG.setBounds(52, 398, 89, 23);
		pAccMgtG.add(btnShowListAccG);
		
		JButton btnDeleteAccG = new JButton("DELETE");
		btnDeleteAccG.setBackground(new Color(204, 204, 255));
		btnDeleteAccG.setBounds(210, 398, 89, 23);
		pAccMgtG.add(btnDeleteAccG);
		
		JButton btnBlockAccG = new JButton("BLOCK");
		btnBlockAccG.setBackground(new Color(204, 204, 255));
		btnBlockAccG.setBounds(368, 398, 89, 23);
		pAccMgtG.add(btnBlockAccG);
		
		JButton btnSortAccG = new JButton("SORT");
		btnSortAccG.setBackground(new Color(204, 204, 255));
		btnSortAccG.setBounds(517, 398, 89, 23);
		pAccMgtG.add(btnSortAccG);
		
		String[] itemsacc = {"ID_ACCOUNT","USERNAME","ACCESSER","STATUS"};
		JComboBox cbbSortAccG = new JComboBox(itemsacc);
		cbbSortAccG.setBounds(627, 398, 109, 22);
		pAccMgtG.add(cbbSortAccG);
		
		JLabel lbContents = new JLabel("LIST CONTENTS");
		lbContents.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbContents.setHorizontalAlignment(SwingConstants.CENTER);
		lbContents.setBounds(0, 68, 150, 32);
		pConsorG.add(lbContents);
		
		// bang post
		tableContentsG = new JTable();
		// dua du lieu vao bang list contents
		String[] nameOfColumnsPost = {"ID_POST","EMPLOYER_NAME","CATEGORY_JOB_NAME","JOB_NAME","COMPANY_NAME","CITY",
				"SALARY","DESCIPTION_JOB","LABOR","STATUS"};
		DefaultTableModel tmp = new DefaultTableModel();
		tmp.setColumnIdentifiers(nameOfColumnsPost);
		tableContentsG.setModel(tmp);
		
		//
		JScrollPane scrollPane1 = new JScrollPane(tableContentsG);
		tableContentsG.setFillsViewportHeight(true);
		scrollPane1.setBounds(25, 100, 718, 287);
		pConsorG.add(scrollPane1);
		
		tableContentsG.setFillsViewportHeight(true);
		
		JButton btnAcceptG = new JButton("ACCEPT");
		btnAcceptG.setVisible(false);
		btnAcceptG.setBackground(new Color(204, 204, 255));
		btnAcceptG.setBounds(220, 398, 89, 23);
		pConsorG.add(btnAcceptG);
		
		JButton btnDeclineG = new JButton("DECLINE");
		btnDeclineG.setVisible(false);
		btnDeclineG.setBackground(new Color(204, 204, 255));
		btnDeclineG.setBounds(389, 398, 89, 23);
		pConsorG.add(btnDeclineG);
		
		JButton btnSortCensorG = new JButton("SORT");
		btnSortCensorG.setBackground(new Color(204, 204, 204));
		btnSortCensorG.setBounds(558, 398, 69, 23);
		pConsorG.add(btnSortCensorG);
		
		String[] itemspost = {"ID_POST","EMPLOYER_NAME","STATUS"};
		JComboBox cbbSortCensorG = new JComboBox(itemspost);
		cbbSortCensorG.setBounds(637, 398, 106, 22);
		pConsorG.add(cbbSortCensorG);
		
		JButton btnShowPostG = new JButton("SHOW");
		btnShowPostG.setBounds(49, 398, 89, 23);
		pConsorG.add(btnShowPostG);
		
		// Chuc nang
		
		AccountManagementG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.remove(scrollpConsorG);
				admin.add(scrollpAccMgt,BorderLayout.CENTER);
				admin.revalidate();
				admin.repaint();
			}
		});
		CensorContentsG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.remove(scrollpAccMgt);
				admin.add(scrollpConsorG,BorderLayout.CENTER);
				admin.revalidate();
				admin.repaint();
			}
		});
		
		// Account management
		// Show
		btnShowListAccG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) tableAccountG.getModel();
				dtm.setNumRows(0);
				for(Account i : BLL.getInstance().getListAccount_BLL())
				{
					Object[] row = new Object[dtm.getColumnCount()];

					row[0] = i.getID_ACCOUNT();
					row[1] = i.getUSERNAME();
					row[2] = i.getPASSWORD();
					row[3] = i.getACCESSER();
					row[4] = i.getSTATUS();
					
					dtm.addRow(row);
				}
			}
		});
		
		//Delete
		btnDeleteAccG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < tableAccountG.getSelectedRowCount(); i++)
					{
						int index = tableAccountG.getSelectedRows()[i];
						BLL.getInstance().DeleteAccountbyID_BLL(tableAccountG.getValueAt(index,0).toString());
					}
				btnShowListAccG.doClick();
			}
		});
		// Block
		btnBlockAccG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < tableAccountG.getSelectedRowCount(); i++)
				{
					int index = tableAccountG.getSelectedRows()[i];
					BLL.getInstance().BlockAccountbyID_BLL(tableAccountG.getValueAt(index,0).toString());
				}
				btnShowListAccG.doClick();
			}
		});
		// Sort
		btnSortAccG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) tableAccountG.getModel();
				dtm.setNumRows(0);
				String item = cbbSortAccG.getSelectedItem().toString();
				for(Account i : BLL.getInstance().SortAccount_BLL(item))
				{
					Object[] row = new Object[dtm.getColumnCount()];

					row[0] = i.getID_ACCOUNT();
					row[1] = i.getUSERNAME();
					row[2] = i.getPASSWORD();
					row[3] = i.getACCESSER();
					row[4] = i.getSTATUS();
					
					dtm.addRow(row);
				}
			}
		});
		// Censor Contents
		tableContentsG.addMouseListener(new MouseListener() {
			
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
				if(tableContentsG.getSelectedRowCount()>0) {
					btnAcceptG.setVisible(true);
					btnDeclineG.setVisible(true);
				}
			}
		});
		// Show
		btnShowPostG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm = (DefaultTableModel) tableContentsG.getModel();
				dtm.setNumRows(0);
				for(Post i : BLL.getInstance().getListPost_BLL())
				{
					Object[] row = new Object[dtm.getColumnCount()];
					row[0] = i.getID_POST();
					row[1] = i.getEMPLOYER().getPROFILE().getNAME();
					row[2] = i.getCATEGORY_JOB().getCATEGORY_JOB_NAME();
					row[3] = i.getJOB_NAME();
					row[4] = i.getCOMPANY_NAME();
					row[5] = i.getCITY();
					row[6] = i.getSALARY();
					row[7] = i.getDESCIPTION_JOB();
					row[8] = i.getLABOR();
					row[9] = i.getSTATUS();
					 
					dtm.addRow(row);
				}
			}
		});
		// Accept
		btnAcceptG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < tableContentsG.getSelectedRowCount(); i++)
				{
					int index = tableContentsG.getSelectedRows()[i];
					BLL.getInstance().AcceptPost_BLL(tableContentsG.getValueAt(index,0).toString());
				}
				btnShowPostG.doClick();
				btnAcceptG.setVisible(false);
				btnDeclineG.setVisible(false);
			}
		});
		// Decline
		btnDeclineG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < tableContentsG.getSelectedRowCount(); i++)
				{
					int index = tableContentsG.getSelectedRows()[i];
					if(Boolean.parseBoolean(tableContentsG.getValueAt(index,9).toString()) == false)
					{
						BLL.getInstance().DeclinePost_BLL(tableContentsG.getValueAt(index,0).toString());
					}
				}
				btnShowPostG.doClick();
				btnAcceptG.setVisible(false);
				btnDeclineG.setVisible(false);
			}
		});
		// Sort
		btnSortCensorG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DefaultTableModel dtm = (DefaultTableModel) tableContentsG.getModel();
					dtm.setNumRows(0);
					String item = cbbSortCensorG.getSelectedItem().toString();
					for(Post i : BLL.getInstance().SortPost_BLL(item))
					{
						Object[] row = new Object[dtm.getColumnCount()];
						
						row[0] = i.getID_POST();
						row[1] = i.getEMPLOYER().getPROFILE().getNAME();
						row[2] = i.getCATEGORY_JOB().getCATEGORY_JOB_NAME();
						row[3] = i.getJOB_NAME();
						row[4] = i.getCOMPANY_NAME();
						row[5] = i.getCITY();
						row[6] = i.getSALARY();
						row[7] = i.getDESCIPTION_JOB();
						row[8] = i.getLABOR();
						row[9] = i.getSTATUS();
						 
						dtm.addRow(row);
					}
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
	public void windowaccesser(WindowEvent e) {
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
