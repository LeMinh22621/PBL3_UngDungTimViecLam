package GUI;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.BLL;
import DAL.DBHelper;
import DTO.Account;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TEST_DB extends JFrame
{
	private JPanel jpanel;
	private JTextField textField;
	public TEST_DB(String title,byte[] imageData)
	{
		super(title);
		getContentPane().setLayout(null);
		setBounds(300, 200, 600, 400);
		
		jpanel = new JPanel();
		getContentPane().add(jpanel);
		jpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageData).getImage().getScaledInstance(190, 113, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(23, 29, 190, 113);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField("TEST");
		textField.setBounds(256, 25, 198, 117);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		setVisible(true);
	}
	public static void main(String[] args)
	{
//		String query = "select * from TB_PROFILE where ID_PROFILE='PF1'";
//		try {
//			byte[] imageData = DBHelper.getInstance().GetImageProfile(query);
//			TEST_DB test = new TEST_DB("HI",imageData);
//			//System.out.println(defaultTableModel.getValueAt(0, 1));
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
};
