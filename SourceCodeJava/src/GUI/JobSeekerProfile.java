package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel lbCV;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JButton btnCV;
	private byte[] image=null;
	public JobSeekerProfile(Account user)
	{
		super("JobSeeker Profile");
		setBounds(193, 0, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lbImage = new JLabel();
//		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\ADMIN\\Pictures\\download1.jpg").getImage().getScaledInstance(20, 30, Image.SCALE_DEFAULT));
//		lbImage.setIcon(imageIcon);
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
		lbFacebook.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbFacebook.setForeground(new Color(255, 204, 0));
		lbFacebook.setBackground(Color.WHITE);
		lbFacebook.setBounds(518, 22, 95, 35);
		pContact.add(lbFacebook);
		lbFacebook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField txtFacebook = new JTextField();
		txtFacebook.setBounds(428, 22, 279, 35);
		pContact.add(txtFacebook);
		txtFacebook.setVisible(false);
		
		JLabel lbZalo= new JLabel("Zalo");
		lbZalo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbZalo.setForeground(new Color(255, 204, 0));
		lbZalo.setBackground(Color.RED);
		lbZalo.setHorizontalAlignment(SwingConstants.CENTER);
		lbZalo.setBounds(518, 68, 98, 35);
		pContact.add(lbZalo);
		
		JTextField txtZalo = new JTextField();
		txtZalo.setBounds(428, 68, 279, 35);
		txtZalo.setVisible(false);
		pContact.add(txtZalo);
		
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
		
		lbCV = new JLabel("NameCV");
		lbCV.setHorizontalAlignment(SwingConstants.CENTER);
		lbCV.setBounds(389, 114, 108, 43);
		pContact.add(lbCV);
		
		btnCV = new JButton("CV");
		//btnCV.hide();
		btnCV.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("C:\\Users\\ADMIN\\Desktop\\PBL\\PBL3_UngDungTimViecLam\\CV"));// C:\\Users\\lehon\\Desktop\\HK4\\PBL3_UngDungTimViecLam\\CV
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
					BLL.getInstance().AddCV_BLL((lbCV.getText() == "NameCV")?true:false,user.getID_ACCOUNT(), path);
					lbCV.setText(name);
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
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(516, 30, 84, 35);
		pAbout.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
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
		if(profile.getIMAGE()!=null)
		{
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(profile.getIMAGE()).getImage().getScaledInstance(136, 111, Image.SCALE_DEFAULT));
			lbImage.setIcon(imageIcon);
		}
		txtProfessional.setText(jobseeker.getPROFESSIONAL());
		List<String> ListCV = BLL_GUEST.getInstance().getListCVByID_Jobseeker_BLL_GUEST(jobseeker.getID_JOBSEEKER());
		File tmpfile = new File(ListCV.get(0));
		lbCV.setText(tmpfile.getName());
		if(jobseeker.getGENDER())
		{
			rdbtnMale.setSelected(true);
			rdbtnFemale.setEnabled(false);
			rdbtnMale.setEnabled(false);
		}
		else
		{
			rdbtnFemale.setSelected(true);
			rdbtnFemale.setEnabled(false);
			rdbtnMale.setEnabled(false);
		}
		rdbtnFemale.setEnabled(false);
		rdbtnMale.setEnabled(false);
		lbFacebook.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					if(btnEdit.getText().equals("OK"))
					{
						lbFacebook.setVisible(false);
						txtFacebook.setVisible(true);
						txtFacebook.setText(profile.getFACEBOOK());
					}
					else
					{
						if(!profile.getFACEBOOK().equals("Empty")) {
							Desktop.getDesktop().browse(new URI(profile.getFACEBOOK()));
						}
					}
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "No Facebook linked yet");
				}
			}
		});
		lbZalo.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					if(btnEdit.getText().equals("OK"))
					{
						lbZalo.setVisible(false);
						txtZalo.setVisible(true);
						txtZalo.setText(profile.getWEBSITE());
					}
					else
					{
						if(!profile.getWEBSITE().equals("Empty")) {
							Desktop.getDesktop().browse(new URI(profile.getWEBSITE()));//"https://www.facebook.com/leminh2k1/"
						}
					}
				}
				catch (IOException | URISyntaxException e1)
				{
					JOptionPane.showMessageDialog(null, "No Website linked yet");
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
					rdbtnFemale.setEnabled(true);
					rdbtnMale.setEnabled(true);
 				}
				else
				{
					String IDprofile = profile.getID_PROFILE();
					String IDjobseeker = jobseeker.getID_JOBSEEKER();
					String Name = txtName.getText();
					String Age = txtAge.getText();
					String PhoneNumber = txtPhoneNumber.getText();
					String Email = txtEmail.getText();
					String Professional = txtProfessional.getText();
					boolean Gender = rdbtnMale.isSelected()?true:false;
					String linkFacebook = txtFacebook.getText();
					String linkZalo = txtZalo.getText();
					if(image != null)
					{
						BLL_LOGIN.getInstance().EditImageProfile_BLL_LOGIN(image,IDprofile);
					}
					if(BLL_LOGIN.getInstance().EditProfileJobseeker_BLL_LOGIN(IDprofile,IDjobseeker
							,Name,Age,Gender,PhoneNumber,Email,Professional,linkFacebook,linkZalo))
					{
						dispose();
						JobSeekerProfile profile = new JobSeekerProfile(user);
						profile.setVisible(true);
					}
				}
			}
		});
		lbImage.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(btnEdit.getText().equals("OK"))
				{
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File("C:\\Users\\ADMIN\\Desktop\\PBL\\PBL3_UngDungTimViecLam\\Image"));
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setAcceptAllFileFilterUsed(true);
					int res = fc.showOpenDialog(lbImage);
					if(res == JFileChooser.APPROVE_OPTION)
					{
						File f = fc.getSelectedFile();
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(f.getPath()).getImage().getScaledInstance(136, 111, Image.SCALE_DEFAULT));
						lbImage.setIcon(imageIcon);
						image = new byte[(int) f.length()];
						try {
							FileInputStream fis = new FileInputStream(f);
							fis.read(image);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							image = null;
						}
					}
				}
			}
		});
		getContentPane().add(btnCancel);
	}
}
