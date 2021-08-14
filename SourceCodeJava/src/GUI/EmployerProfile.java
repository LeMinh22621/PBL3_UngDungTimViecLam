package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BLL.BLL_GUEST;
import BLL.BLL_LOGIN;
import DTO.Account;
import DTO.Profile;

public class EmployerProfile extends JFrame {
	private static EmployerProfile Instance;

	public static EmployerProfile getInstance(Account user) {
		if (Instance == null)
			Instance = new EmployerProfile(user);
		return Instance;
	}

	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtName;
	private JTextField txtCity;
	private byte[] image = null;

	public EmployerProfile(Account user) {
		super("Employer Profile");
		setBounds(193, 0, 373, 451);
		getContentPane().setLayout(null);

		JLabel lbImage = new JLabel();
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbImage.setBounds(110, 11, 136, 111);
		getContentPane().add(lbImage);

		JPanel pContact = new JPanel();
		pContact.setBounds(10, 252, 337, 130);
		getContentPane().add(pContact);
		pContact.setLayout(null);

		JLabel lbContact = new JLabel("Contact");
		lbContact.setBounds(0, 0, 55, 24);
		pContact.add(lbContact);
		lbContact.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(32, 22, 84, 24);
		pContact.add(lbEmail);
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbPhoneNumber = new JLabel("Phone Number");
		lbPhoneNumber.setBounds(32, 49, 84, 24);
		pContact.add(lbPhoneNumber);
		lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(141, 24, 160, 20);
		pContact.add(txtEmail);
		txtEmail.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEditable(false);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(141, 51, 160, 20);
		pContact.add(txtPhoneNumber);

		JLabel lbFacebook = new JLabel("facebook");
		lbFacebook.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbFacebook.setForeground(new Color(255, 204, 0));
		lbFacebook.setBounds(32, 78, 269, 19);
		pContact.add(lbFacebook);
		lbFacebook.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField txtFacebook = new JTextField();
		txtFacebook.setBounds(32, 78, 269, 19);
		pContact.add(txtFacebook);
		txtFacebook.setVisible(false);

		JLabel lblZalo = new JLabel("Zalo");
		lblZalo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZalo.setForeground(new Color(255, 204, 0));
		lblZalo.setHorizontalAlignment(SwingConstants.CENTER);
		lblZalo.setBounds(32, 108, 269, 19);
		pContact.add(lblZalo);

		JTextField txtZalo = new JTextField();
		txtZalo.setBounds(32, 108, 269, 19);
		txtZalo.setVisible(false);
		pContact.add(txtZalo);

		JPanel pAbout = new JPanel();
		pAbout.setLayout(null);
		pAbout.setBounds(10, 133, 337, 108);
		getContentPane().add(pAbout);

		JLabel lblAbout = new JLabel("About");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setBounds(0, 0, 55, 24);
		pAbout.add(lblAbout);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(34, 35, 84, 24);
		pAbout.add(lblName);

		JLabel lbCity = new JLabel("City");
		lbCity.setHorizontalAlignment(SwingConstants.CENTER);
		lbCity.setBounds(34, 62, 84, 24);
		pAbout.add(lbCity);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(143, 37, 160, 20);
		pAbout.add(txtName);

		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setColumns(10);
		txtCity.setBounds(143, 64, 160, 20);
		pAbout.add(txtCity);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(81, 382, 75, 28);
		getContentPane().add(btnEdit);

		JButton btnCancel = new JButton("Cancel");
		// set infor
		Profile profile = BLL_GUEST.getInstance().getProfileByID_Account_BLL_GUEST(user.getID_ACCOUNT());
		txtName.setText(profile.getNAME());
		txtCity.setText(profile.getCITY());
		txtEmail.setText(profile.getEMAIL());
		txtPhoneNumber.setText(profile.getPHONENUMBER());
		if (profile.getIMAGE() != null) {
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(profile.getIMAGE()).getImage().getScaledInstance(136, 111, Image.SCALE_DEFAULT));
			lbImage.setIcon(imageIcon);
		}
		// Edit
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnEdit.getText().equals("Edit")) {
					btnEdit.setText("OK");
					txtName.setEditable(true);
					txtCity.setEditable(true);
					txtPhoneNumber.setEditable(true);
					txtEmail.setEditable(true);
				} else {
					String ID = profile.getID_PROFILE();
					String Name = txtName.getText();
					String City = txtCity.getText();
					String PhoneNumber = txtPhoneNumber.getText();
					String Email = txtEmail.getText();
					String linkFacebook = txtFacebook.getText();
					String linkZalo = txtZalo.getText();
					if (image != null) {
						BLL_LOGIN.getInstance().EditImageProfile_BLL_LOGIN(image, ID);
					}
					if (BLL_LOGIN.getInstance().EditProfileEmployer_BLL_LOGIN(ID, Name, City, PhoneNumber, Email,
							linkFacebook, linkZalo)) {
						dispose();
						EmployerProfile profile = new EmployerProfile(user);
						profile.setVisible(true);
					}
				}
			}
		});
		// Cancel
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(209, 382, 75, 28);

		lbFacebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (btnEdit.getText().equals("OK")) {
						lbFacebook.setVisible(false);
						txtFacebook.setVisible(true);
						txtFacebook.setText(profile.getFACEBOOK());
					} else {
						if (!profile.getFACEBOOK().equals("Empty")) {
							Desktop.getDesktop().browse(new URI(profile.getFACEBOOK()));
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblZalo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (btnEdit.getText().equals("OK")) {
						lblZalo.setVisible(false);
						txtZalo.setVisible(true);
						txtZalo.setText(profile.getWEBSITE());
					} else {
						if (!profile.getWEBSITE().equals("Empty")) {
							Desktop.getDesktop().browse(new URI(profile.getWEBSITE()));
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		lbImage.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnEdit.getText().equals("OK")) {
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File("C:\\Users\\ADMIN\\Desktop\\PBL\\PBL3_UngDungTimViecLam\\Image"));
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setAcceptAllFileFilterUsed(true);
					int res = fc.showOpenDialog(lbImage);
					if (res == JFileChooser.APPROVE_OPTION) {
						File f = fc.getSelectedFile();
						ImageIcon imageIcon = new ImageIcon(
								new ImageIcon(f.getPath()).getImage().getScaledInstance(136, 111, Image.SCALE_DEFAULT));
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
