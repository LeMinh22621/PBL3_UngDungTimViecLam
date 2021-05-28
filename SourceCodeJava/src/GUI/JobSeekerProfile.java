package GUI;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JobSeekerProfile extends JFrame
{
	private static JobSeekerProfile Instance;
	public static JobSeekerProfile getInstance()
	{
		if(Instance == null)
			Instance = new JobSeekerProfile();
		return Instance;
	}
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JobSeekerProfile()
	{
		super("JobSeeker Profile");
		setBounds(193, 0, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lbImage = new JLabel("Image");
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbImage.setBounds(327, 11, 136, 111);
		getContentPane().add(lbImage);
		
		JPanel pContact = new JPanel();
		pContact.setBounds(10, 254, 764, 157);
		getContentPane().add(pContact);
		pContact.setLayout(null);
		
		JLabel lbContact = new JLabel("Contact");
		lbContact.setBounds(0, 0, 84, 35);
		pContact.add(lbContact);
		lbContact.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(32, 22, 84, 35);
		pContact.add(lbEmail);
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbPhoneNumber = new JLabel("Phone Number");
		lbPhoneNumber.setBounds(32, 68, 84, 35);
		pContact.add(lbPhoneNumber);
		lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbFacebook = new JLabel("facebook");
		lbFacebook.setBounds(428, 22, 279, 35);
		pContact.add(lbFacebook);
		lbFacebook.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Desktop.getDesktop().browse(new URI("https://www.facebook.com/leminh2k1/"));
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
				catch (URISyntaxException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		lbFacebook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbWebsite = new JLabel("Website");
		lbWebsite.setHorizontalAlignment(SwingConstants.CENTER);
		lbWebsite.setBounds(428, 68, 279, 35);
		pContact.add(lbWebsite);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(157, 22, 210, 35);
		pContact.add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(157, 65, 210, 35);
		pContact.add(txtPhoneNumber);
		
		JButton btnCV = new JButton("CV");
		btnCV.setBounds(313, 114, 131, 43);
		pContact.add(btnCV);
		
		JPanel pAbout = new JPanel();
		pAbout.setLayout(null);
		pAbout.setBounds(10, 133, 764, 121);
		getContentPane().add(pAbout);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setBounds(0, 0, 84, 35);
		pAbout.add(lblAbout);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(53, 30, 84, 35);
		pAbout.add(lblName);
		
		JLabel lbAge = new JLabel("Age");
		lbAge.setHorizontalAlignment(SwingConstants.CENTER);
		lbAge.setBounds(53, 73, 84, 35);
		pAbout.add(lbAge);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(162, 30, 210, 35);
		pAbout.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(162, 73, 210, 35);
		pAbout.add(txtAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(399, 30, 111, 35);
		pAbout.add(lblGender);
		
		JLabel lblProfessional = new JLabel("Professional");
		lblProfessional.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessional.setBounds(399, 73, 111, 35);
		pAbout.add(lblProfessional);
		
		JComboBox cbProfessional = new JComboBox();
		cbProfessional.setBounds(520, 73, 185, 35);
		pAbout.add(cbProfessional);
		
		JRadioButton rbbtnMale = new JRadioButton("Male");
		rbbtnMale.setSelected(true);
		rbbtnMale.setBounds(516, 30, 84, 35);
		pAbout.add(rbbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(621, 30, 84, 35);
		pAbout.add(rdbtnFemale);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(218, 422, 75, 28);
		getContentPane().add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		btnCancel.setBounds(564, 422, 75, 28);
		getContentPane().add(btnCancel);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> b8ebc18 (push code)
