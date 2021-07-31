package GUI;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JobSeekerApply extends Panel{

	private JFrame frame;
	public JobSeekerApply() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,462, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameJobSeeker = new JLabel("Name");
		nameJobSeeker.setBounds(10, 0, 426, 22);
		nameJobSeeker.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		nameJobSeeker.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(nameJobSeeker);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(52, 29, 65, 23);
		frame.getContentPane().add(btnOpen);
		
		JLabel lbCV = new JLabel("NameCV");
		lbCV.setBounds(127, 25, 274, 27);
		lbCV.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbCV);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.setBounds(254, 57, 89, 23);
		frame.getContentPane().add(btnDecline);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(94, 57, 89, 23);
		frame.getContentPane().add(btnAccept);
		frame.getContentPane().show();
	}
}
