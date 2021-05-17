package homepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class post extends JFrame implements ActionListener,WindowListener{

	public JPanel contentPane;
	public JTextField txtEnterprise_Name;
	public JTextField txtID_Address;
	public JTextField txtSalary;
	public JTextField txtID_Post;
	public JTextField txtJob_Name;
	public JTextField txtWork_Hour;
	public JLabel lblEnterprise_Name;
	public JTextField txtBenifits;
	JButton btnCancelR;
	JButton btnPostR;
	private JLabel lblIntroduce;
	JTextArea txtIntroduceRI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					post frame = new post();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public post() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 547);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecruitment = new JLabel("RECRUIMENT INFORMATION");
		lblRecruitment.setBackground(new Color(0, 255, 153));
		lblRecruitment.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecruitment.setForeground(new Color(0, 0, 204));
		lblRecruitment.setBorder(BorderFactory.createLineBorder(Color.red,1));
		lblRecruitment.setFont(new Font("VNI-Bandit", Font.PLAIN, 20));
		lblRecruitment.setBounds(138, 27, 284, 23);
		contentPane.add(lblRecruitment);
		
		txtEnterprise_Name = new JTextField();
		txtEnterprise_Name.setBounds(138, 88, 335, 28);
		contentPane.add(txtEnterprise_Name);
		txtEnterprise_Name.setColumns(10);
		
		txtID_Address = new JTextField();
		txtID_Address.setBounds(138, 130, 335, 28);
		contentPane.add(txtID_Address);
		txtID_Address.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(138, 286, 335, 28);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		txtID_Post = new JTextField();
		txtID_Post.setBounds(138, 169, 335, 28);
		contentPane.add(txtID_Post);
		txtID_Post.setColumns(10);
		
		txtJob_Name = new JTextField();
		txtJob_Name.setBounds(138, 208, 335, 28);
		contentPane.add(txtJob_Name);
		txtJob_Name.setColumns(10);
		
		txtWork_Hour = new JTextField();
		txtWork_Hour.setBounds(138, 247, 335, 28);
		contentPane.add(txtWork_Hour);
		txtWork_Hour.setColumns(10);
		
		lblEnterprise_Name = new JLabel("Enterprise_Name");
		lblEnterprise_Name.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblEnterprise_Name.setForeground(new Color(51, 0, 153));
		lblEnterprise_Name.setBounds(10, 89, 118, 20);
		contentPane.add(lblEnterprise_Name);
		
		 btnPostR = new JButton("POST");
		btnPostR.setForeground(new Color(0, 0, 153));
		btnPostR.setBackground(new Color(255, 102, 102));
		btnPostR.setFont(new Font("VNI-Fato", Font.PLAIN, 16));
		btnPostR.setBounds(157, 474, 95, 23);
		contentPane.add(btnPostR);
		
		txtBenifits = new JTextField();
		txtBenifits.setBounds(138, 328, 335, 28);
		contentPane.add(txtBenifits);
		txtBenifits.setColumns(10);
		
		JLabel lblID_Address = new JLabel("ID_Address");
		lblID_Address.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblID_Address.setForeground(new Color(51, 0, 153));
		lblID_Address.setBounds(34, 137, 94, 14);
		contentPane.add(lblID_Address);
		
		JLabel lblJob_Name = new JLabel("Job Name ");
		lblJob_Name.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblJob_Name.setForeground(new Color(51, 0, 153));
		lblJob_Name.setBounds(44, 213, 84, 14);
		contentPane.add(lblJob_Name);
		
		JLabel lblWork_Hour = new JLabel("Work_Hour ");
		lblWork_Hour.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblWork_Hour.setForeground(new Color(51, 0, 153));
		lblWork_Hour.setBounds(34, 252, 94, 14);
		contentPane.add(lblWork_Hour);
		
		JLabel lblSalary = new JLabel("Salaries");
		lblSalary.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblSalary.setForeground(new Color(51, 0, 153));
		lblSalary.setBounds(58, 291, 56, 14);
		contentPane.add(lblSalary);
		
		JLabel lblBenifits = new JLabel("Benefits");
		lblBenifits.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblBenifits.setForeground(new Color(51, 0, 153));
		lblBenifits.setBounds(58, 333, 70, 14);
		contentPane.add(lblBenifits);
		
		JLabel lblID_Post = new JLabel("ID_Post");
		lblID_Post.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblID_Post.setForeground(new Color(51, 0, 153));
		lblID_Post.setBounds(48, 176, 66, 14);
		contentPane.add(lblID_Post);
		
		btnCancelR = new JButton("CANCEL");
		btnCancelR.setForeground(new Color(0, 0, 102));
		btnCancelR.setFont(new Font("VNI-Fato", Font.PLAIN, 16));
		btnCancelR.setBackground(new Color(255, 102, 102));
		btnCancelR.setBounds(304, 474, 118, 23);
		btnCancelR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		//btnNewButton.addActionListener(this);
		contentPane.add(btnCancelR);
		
		lblIntroduce = new JLabel("Introduce Company");
		lblIntroduce.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblIntroduce.setForeground(new Color(0, 0, 153));
		lblIntroduce.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduce.setBounds(0, 390, 137, 23);
		contentPane.add(lblIntroduce);
		
		txtIntroduceRI = new JTextArea();
		txtIntroduceRI.setBounds(138, 367, 335, 91);
		txtIntroduceRI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(txtIntroduceRI);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		// if(e.getSource()==btnNewButton)
	    //  {
		//	System.exit(0);
	      // }
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
}
