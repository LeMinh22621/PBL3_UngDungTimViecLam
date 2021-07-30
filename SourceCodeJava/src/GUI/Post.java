package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import BLL.BLL;
import BLL.BLL_GUEST;
import DTO.Account;

public class Post extends JFrame
{
	private static Post Instance_U;
	private static Post Instance_P;
	public static Post getProfile(Account user)
	{
		if(Instance_U == null)
			Instance_U = new Post(user);
		return Instance_U;
	}
	public static Post getPost(DTO.Post post, String idJobSeeker)
	{
		if(Instance_P != null)
			Instance_P.dispose();
		Instance_P = new Post(idJobSeeker,post);
		return Instance_P;
	}
	private JTextField txtJobTilte;
	private JTextField txtCompanyName;
	private JTextField txtAddress;
	private JTextField txtSalary;
	private JPanel pPost;
	private JLabel lbJobTitle;
	private JLabel lblCompanyName;
	private JLabel lblAddress;
	private JLabel lbHowManyHires;
	private JLabel lbSalary;
	private JLabel lbJobDescription;
	private JTextArea txtAJobDescription;
	private JSpinner spinHires;
	private JComboBox<String> cbbCategory;
	private JButton btnCancel;
	private JScrollPane scrollPanePostJobDescription;
	private JLabel lbCategoryName;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dtmodel;
	private List<Object> listmodel;
	
	private void setPost(DTO.Post post)
	{
		txtJobTilte.setText(post.getJOB_NAME());txtJobTilte.setEditable(false);
		txtCompanyName.setText(post.getCOMPANY_NAME());txtCompanyName.setEditable(false);
		txtAddress.setText(post.getCITY());txtAddress.setEditable(false);
		txtSalary.setText(Integer.toString(post.getSALARY()));txtSalary.setEditable(false);
		txtAJobDescription.setText(post.getDESCIPTION_JOB());txtAJobDescription.setEditable(false);
		cbbCategory.removeAllItems();
		cbbCategory.addItem(post.getCATEGORY_JOB().getCATEGORY_JOB_NAME());//cbbCategory.setEditable(false);
		cbbCategory.setSelectedItem(cbbCategory.getItemAt(0));
		//cbbCategory.setEnabled(false);
		spinHires.setValue(post.getLABOR());
		spinHires.setEnabled(false);
	}
	private void initE()
	{
		pPost.setBounds(0, 0, 444, 511);
		getContentPane().add(pPost);
	}
	private void initJ(String idPost)
	{
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 444, 511);
		getContentPane().add(tabbedPane);
		tabbedPane.addTab("Detail", null, pPost, null);
		
		Object[] columns = {"JobSeeker", "CV", "Status"};
		dtmodel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		dtmodel.setColumnIdentifiers(columns);
		
		table = new JTable();
		table.setModel(dtmodel);
		table.setBackground(Color.cyan);
		table.setForeground(Color.red);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		
		scrollPane = new JScrollPane(table);
		tabbedPane.addTab("Proposals", null, scrollPane, null);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex() == 1)
				{
					List<DTO.JobSeekerApply> listJobSeekerApplies = new ArrayList<DTO.JobSeekerApply>();
					listJobSeekerApplies.addAll(BLL.getInstance().getListJobSeekerApply_BLL(idPost));
					if(listJobSeekerApplies != null)
					{
						table.removeAll();
						Vector<DTO.JobSeekerApply> vector = new Vector<DTO.JobSeekerApply>();
						for(int i = 0; i < listJobSeekerApplies.size(); i++)
						{
							dtmodel.addRow( new Object[]
								{
									listJobSeekerApplies.get(i).getJobSeeker().getPROFILE().getNAME(),
									listJobSeekerApplies.get(i).getCv().getID_CV(),
									listJobSeekerApplies.get(i).getStatus()
								}
							);
						}
					}
					
				}
			}
		});
	}
	private void initial()
	{
		getContentPane().setLayout(null);
		setBounds(EXIT_ON_CLOSE, ABORT, 460, 545);

		pPost = new JPanel();
		pPost.setLayout(null);
		
		lbJobTitle = new JLabel("Job title");
		lbJobTitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbJobTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbJobTitle.setBounds(21, 11, 111, 31);
		pPost.add(lbJobTitle);
		
		txtJobTilte = new JTextField();
		txtJobTilte.setBounds(46, 36, 340, 31);
		pPost.add(txtJobTilte);
		txtJobTilte.setColumns(10);
		
		lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName.setBounds(21, 66, 168, 31);
		pPost.add(lblCompanyName);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(46, 97, 340, 31);
		pPost.add(txtCompanyName);
		
		lblAddress = new JLabel("City");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(10, 128, 111, 22);
		pPost.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(46, 149, 340, 31);
		pPost.add(txtAddress);
		
		lbHowManyHires = new JLabel("How many hires?");
		lbHowManyHires.setHorizontalAlignment(SwingConstants.CENTER);
		lbHowManyHires.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbHowManyHires.setBounds(197, 261, 141, 31);
		pPost.add(lbHowManyHires);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(46, 260, 143, 31);
		pPost.add(txtSalary);
		
		lbSalary = new JLabel("Salary(VND)");
		lbSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lbSalary.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSalary.setBounds(46, 238, 98, 22);
		pPost.add(lbSalary);
		
		lbJobDescription = new JLabel("Job Description");
		lbJobDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lbJobDescription.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbJobDescription.setBounds(46, 301, 130, 22);
		pPost.add(lbJobDescription);
		
		txtAJobDescription = new JTextArea();
		txtAJobDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAJobDescription.setLineWrap(true);
		txtAJobDescription.setBounds(1, 1, 413, 98);
		pPost.add(txtAJobDescription);
		
		spinHires = new JSpinner();
		spinHires.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinHires.setBounds(348, 261, 38, 31);
		pPost.add(spinHires);
		
		cbbCategory = new JComboBox<String>();
		cbbCategory.setSize(197, 31);
		cbbCategory.setLocation(189, 200);
		pPost.add(cbbCategory);
		
		DefaultComboBoxModel<String> tmpCategory = new DefaultComboBoxModel<String>();
		if(cbbCategory.getSelectedItem()==null)
		{
			tmpCategory.addAll(BLL_GUEST.getInstance().getListCategoryJobName_BLL_GUEST());
			cbbCategory.setSelectedItem(cbbCategory.getItemAt(0));
		}
		cbbCategory.setModel(tmpCategory);
		scrollPanePostJobDescription = new JScrollPane(txtAJobDescription);
		scrollPanePostJobDescription.setBounds(46, 326, 340, 100);
		pPost.add(scrollPanePostJobDescription);
		
		lbCategoryName = new JLabel("Category_Name");
		lbCategoryName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbCategoryName.setBounds(46, 200, 143, 27);
		pPost.add(lbCategoryName);
	}
	/**
	 * @wbp.parser.constructor
	 */
	public Post(String idJobSeeker, DTO.Post post)
	{
		
		initial();initJ(post.getID_POST());
		setPost(post);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String idCV = "";
				idCV = BLL.getInstance().getIdCVByIdJobSeeker_BLL(idJobSeeker);
				BLL.getInstance().AddCVToPost_BLL(post.getID_POST(),idCV);
			}
		});
		btnApply.setBounds(168, 435, 81, 23);
		pPost.add(btnApply);
	}
	public Post(Account user)
	{
		
		initial();
		initE();
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String ID_Acc = user.getID_ACCOUNT();
				String Jobname = txtJobTilte.getText();
				String Companyname = txtCompanyName.getText();
				String City = txtAddress.getText();
				String Salary = txtSalary.getText();
				String Descrip = txtAJobDescription.getText();
				String Labor = String.valueOf(spinHires.getValue());
				String Category = (cbbCategory.getSelectedIndex() == -1)?"":cbbCategory.getSelectedItem().toString();
				if(BLL_GUEST.getInstance().Post_BLL_GUEST(ID_Acc,Jobname,Companyname,City,Salary,Descrip,Labor,Category))
				{
					txtJobTilte.setText("");
					txtCompanyName.setText("");
					txtAddress.setText("");
					txtSalary.setText("");
					txtAJobDescription.setText("");
				}
			}
		});
		btnOK.setBounds(129, 439, 74, 31);
		pPost.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		btnCancel.setBounds(238, 438, 74, 31);
		pPost.add(btnCancel);
	}
}
