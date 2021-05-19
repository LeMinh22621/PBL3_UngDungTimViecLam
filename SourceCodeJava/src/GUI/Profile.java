package GUI;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Profile extends JFrame
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Profile()
	{
		getContentPane().setLayout(null);
		
		JPanel pPost = new JPanel();
		pPost.setBounds(10, 11, 422, 439);
		getContentPane().add(pPost);
		pPost.setLayout(null);
		
		JLabel lbJobTitle = new JLabel("Job title");
		lbJobTitle.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbJobTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbJobTitle.setBounds(22, 11, 111, 31);
		pPost.add(lbJobTitle);
		
		textField = new JTextField();
		textField.setBounds(47, 44, 340, 31);
		pPost.add(textField);
		textField.setColumns(10);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCompanyName.setBounds(22, 86, 168, 31);
		pPost.add(lblCompanyName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(47, 118, 340, 31);
		pPost.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAddress.setBounds(22, 151, 111, 31);
		pPost.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(47, 183, 340, 31);
		pPost.add(textField_2);
		
		JLabel lbHowManyHires = new JLabel("How many hires?");
		lbHowManyHires.setHorizontalAlignment(SwingConstants.CENTER);
		lbHowManyHires.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbHowManyHires.setBounds(198, 225, 141, 31);
		pPost.add(lbHowManyHires);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(335, 225, 52, 31);
		pPost.add(spinner);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(47, 261, 143, 31);
		pPost.add(textField_3);
		
		JLabel lbBenefit = new JLabel("Benefit");
		lbBenefit.setHorizontalAlignment(SwingConstants.CENTER);
		lbBenefit.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbBenefit.setBounds(34, 225, 86, 31);
		pPost.add(lbBenefit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(228, 261, 67, 31);
		pPost.add(comboBox);
		
		JLabel lbBenefit_1 = new JLabel("Job Description");
		lbBenefit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbBenefit_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbBenefit_1.setBounds(47, 292, 130, 31);
		pPost.add(lbBenefit_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setBounds(47, 328, 340, 100);
		pPost.add(textArea);
		
	}
	public static void main(String[] args)
	{
		
	}
}
