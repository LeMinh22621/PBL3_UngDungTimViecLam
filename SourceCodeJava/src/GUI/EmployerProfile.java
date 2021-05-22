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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmployerProfile extends JFrame
{
	private static EmployerProfile Instance;
	public static EmployerProfile getInstance()
	{
		if(Instance == null)
			Instance = new EmployerProfile();
		return Instance;
	}
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtName;
	private JTextField txtCity;
	
	public EmployerProfile()
	{
		super("Employer Profile");
		setBounds(193, 0, 373, 451);
		getContentPane().setLayout(null);
		
		JLabel lbImage = new JLabel("Image");
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
		lbEmail.setBounds(32, 22, 55, 24);
		pContact.add(lbEmail);
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbPhoneNumber = new JLabel("Phone Number");
		lbPhoneNumber.setBounds(32, 49, 84, 24);
		pContact.add(lbPhoneNumber);
		lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(141, 24, 160, 20);
		pContact.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(141, 51, 160, 20);
		pContact.add(txtPhoneNumber);
		
		JLabel lbFacebook = new JLabel("facebook");
		lbFacebook.setBounds(32, 78, 269, 19);
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
		
		JLabel lblZalo = new JLabel("Zalo");
		lblZalo.setHorizontalAlignment(SwingConstants.CENTER);
		lblZalo.setBounds(32, 108, 269, 19);
		pContact.add(lblZalo);
		
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
		lblName.setBounds(34, 35, 55, 24);
		pAbout.add(lblName);
		
		JLabel lbCity = new JLabel("City");
		lbCity.setHorizontalAlignment(SwingConstants.CENTER);
		lbCity.setBounds(34, 62, 84, 24);
		pAbout.add(lbCity);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(143, 37, 160, 20);
		pAbout.add(txtName);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(143, 64, 160, 20);
		pAbout.add(txtCity);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(81, 382, 75, 28);
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
		btnCancel.setBounds(209, 382, 75, 28);
		getContentPane().add(btnCancel);		
	}
}
