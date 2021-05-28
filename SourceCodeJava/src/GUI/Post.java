package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class Post extends JFrame implements ActionListener, WindowListener
{
	private static Post Instance;
	public static Post getProfile()
	{
		if(Instance == null)
			Instance = new Post("Post");
		return Instance;
	}
	private JTextField txtJobTilte;
	private JTextField txtCompanyName;
	private JTextField txtAddress;
	private JTextField txtSalary;
	private Post(String title)
	{
		super(title);
		getContentPane().setLayout(null);
		setBounds(EXIT_ON_CLOSE, ABORT, 460, 530);
		
		JPanel pPost = new JPanel();
		pPost.setBounds(10, 11, 424, 469);
		getContentPane().add(pPost);
		pPost.setLayout(null);
		
		JLabel lbJobTitle = new JLabel("Job title");
		lbJobTitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbJobTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbJobTitle.setBounds(21, 11, 111, 31);
		pPost.add(lbJobTitle);
		
		txtJobTilte = new JTextField();
		txtJobTilte.setBounds(46, 44, 340, 31);
		pPost.add(txtJobTilte);
		txtJobTilte.setColumns(10);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName.setBounds(21, 86, 168, 31);
		pPost.add(lblCompanyName);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(46, 118, 340, 31);
		pPost.add(txtCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(21, 151, 111, 31);
		pPost.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(46, 183, 340, 31);
		pPost.add(txtAddress);
		
		JLabel lbHowManyHires = new JLabel("How many hires?");
		lbHowManyHires.setHorizontalAlignment(SwingConstants.CENTER);
		lbHowManyHires.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbHowManyHires.setBounds(197, 261, 141, 31);
		pPost.add(lbHowManyHires);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(46, 261, 143, 31);
		pPost.add(txtSalary);
		
		JLabel lbSalary = new JLabel("Salary(VND)");
		lbSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lbSalary.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSalary.setBounds(44, 225, 98, 31);
		pPost.add(lbSalary);
		
		JLabel lbJobDescription = new JLabel("Job Description");
		lbJobDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lbJobDescription.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbJobDescription.setBounds(46, 292, 130, 31);
		pPost.add(lbJobDescription);
		
		JTextArea txtAJobDescription = new JTextArea();
		txtAJobDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAJobDescription.setLineWrap(true);
		txtAJobDescription.setBounds(46, 328, 340, 100);
		pPost.add(txtAJobDescription);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "OK");
			}
		});
		btnOK.setBounds(129, 439, 74, 31);
		pPost.add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
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
		
		JSpinner spinHires = new JSpinner();
		spinHires.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinHires.setBounds(348, 261, 38, 31);
		pPost.add(spinHires);
		
		JScrollPane scrollPanePostJobDescription = new JScrollPane(txtAJobDescription);
		scrollPanePostJobDescription.setBounds(46, 326, 340, 100);
		pPost.add(scrollPanePostJobDescription);
		
	}
	public static void main(String[] args)
	{
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		
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
<<<<<<< HEAD
}
=======
}
>>>>>>> b8ebc18 (push code)
