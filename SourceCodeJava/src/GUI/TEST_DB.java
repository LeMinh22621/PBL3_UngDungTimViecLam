package GUI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.BLL;
import DAL.DBHelper;
import DTO.Account;

public class TEST_DB extends JFrame
{
	private JTable table;
	public TEST_DB(String title)
	{
		super(title);
		getContentPane().setLayout(null);
		setBounds(300, 200, 600, 400);
		
		table = new JTable();
		table.setBounds(57, 60, 475, 253);
		getContentPane().add(table);
		
		DefaultTableModel dtm = new DefaultTableModel();
		String[] nameOfColumns = {"ID","USER","PASS","EMAIL","PHONE","STATUS","CATEGORY"};
		dtm.setColumnIdentifiers(nameOfColumns);
		table.setModel(dtm);
		
		List<Account> list = new ArrayList<Account>();
		list = BLL.getInstance().getListAccount_BLL();
		
		
//		for(Account i : list)
//		{
//			Object[] row = new Object[dtm.getColumnCount()];
//			
//			row[0] = i.getID_ACCOUNT();
//			row[1] = i.getUSERNAME();
//			row[2] = i.getPASSWORD();
//			row[3] = i.getEMAIL();
//			row[4] = i.getPHONENUMBER();
//			row[5] = i.getSTATUS();
//			row[6] = i.getCATEGORY();
//			
//			dtm.addRow(row);
//		}
		
		setVisible(true);
	}
	public static void main(String[] args)
	{
//		String query = "select * from TB_PROFILE where ID_PROFILE='PF1'";
//		try {
//			DBHelper.getInstance().GetRecordProfile(query);
//			//System.out.println(defaultTableModel.getValueAt(0, 1));
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
};
