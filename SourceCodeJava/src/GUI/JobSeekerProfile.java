package GUI;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import BLL.BLL;
import BLL.BLL_GUEST;
import BLL.BLL_LOGIN;
import DTO.Account;
import DTO.JobSeeker;
import DTO.Profile;

public class JobSeekerProfile extends JFrame
{
	private static JobSeekerProfile Instance;
	public static JobSeekerProfile getInstance(Account user)
	{
		if(Instance == null)
			Instance = new JobSeekerProfile(user);
		return Instance;
	}
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	public JobSeekerProfile(Account user)
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
		lbFacebook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbWebsite = new JLabel("Website");
		lbWebsite.setHorizontalAlignment(SwingConstants.CENTER);
		lbWebsite.setBounds(428, 68, 279, 35);
		pContact.add(lbWebsite);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(157, 22, 210, 35);
		pContact.add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEditable(false);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(157, 65, 210, 35);
		pContact.add(txtPhoneNumber);
		
		JLabel lbCV = new JLabel("NameCV");
		lbCV.setHorizontalAlignment(SwingConstants.CENTER);
		lbCV.setBounds(389, 114, 108, 43);
		pContact.add(lbCV);
		
		JButton btnCV = new JButton("CV");
		btnCV.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("C:\\Users\\lehon\\Desktop\\HK4\\PBL3_UngDungTimViecLam\\CV"));
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.addChoosableFileFilter(new FileNameExtensionFilter("DOC", "doc", "docx", "DOC", "DOCX"));
				fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "PDF", "pdf"));
				fc.setAcceptAllFileFilterUsed(true);
				
				int res = fc.showOpenDialog(btnCV);
				if(res == JFileChooser.APPROVE_OPTION)
				{
					File f = fc.getSelectedFile();
					String path = f.getAbsolutePath();
					String name = f.getName();
					lbCV.setText(name);
					BLL.getInstance().AddCV_BLL((lbCV.getText() == "NameCV")?true:false,user.getID_ACCOUNT(), path);
				}
			}
		});
		btnCV.setBounds(313, 114, 66, 43);
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
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(162, 30, 210, 35);
		pAbout.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
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
		
		JTextField txtProfessional = new JTextField();
		txtProfessional.setEditable(false);
		txtProfessional.setBounds(520, 73, 185, 35);
		pAbout.add(txtProfessional);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(516, 30, 84, 35);
		pAbout.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(621, 30, 84, 35);
		pAbout.add(rdbtnFemale);
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
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
		// set infor
		Profile profile = BLL_GUEST.getInstance().getProfileJobByID_Account_BLL_GUEST(user.getID_ACCOUNT());
		JobSeeker jobseeker = BLL_GUEST.getInstance().getJobseekerByID_Profile_BLL_GUEST(profile.getID_PROFILE());
		txtName.setText(profile.getNAME());
		txtAge.setText(String.valueOf(jobseeker.getAGE()));
		txtEmail.setText(profile.getEMAIL());
		txtPhoneNumber.setText(profile.getPHONENUMBER());
		txtProfessional.setText(jobseeker.getPROFESSIONAL());
		if(jobseeker.getGENDER())
		{
			rdbtnMale.setSelected(true);
		}
		else
		{
			rdbtnFemale.setSelected(true);
		}
		lbFacebook.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					if(!profile.getFACEBOOK().equals("Empty")) {
						Desktop.getDesktop().browse(new URI(profile.getFACEBOOK()));//"https://www.facebook.com/leminh2k1/"
					}
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
		lbWebsite.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					if(!profile.getWEBSITE().equals("Empty")) {
						Desktop.getDesktop().browse(new URI(profile.getWEBSITE()));//"https://www.facebook.com/leminh2k1/"
					}
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
		//edit
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btnEdit.getText().equals("Edit"))
				{
					btnEdit.setText("OK");
					txtName.setEditable(true);
					txtAge.setEditable(true);
					txtPhoneNumber.setEditable(true);
					txtEmail.setEditable(true);
					txtProfessional.setEditable(true);
				}
				else
				{
					String IDprofile = profile.getID_PROFILE();
					String IDjobseeker = profile.getID_PROFILE();
					String Name = txtName.getText();
					String Age = txtAge.getText();
					String PhoneNumber = txtPhoneNumber.getText();
					String Email = txtEmail.getText();
					String Professional = txtProfessional.getText();
					boolean Gender = rdbtnMale.isSelected();
					BLL_LOGIN.getInstance().EditProfileJobseeker_BLL_LOGIN(IDprofile,IDjobseeker,Name,Age,Gender,PhoneNumber,Email,Professional);
				}
			}
		});
		getContentPane().add(btnCancel);
	}
}
