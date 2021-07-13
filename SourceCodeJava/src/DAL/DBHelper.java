package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBHelper
{
	private static DBHelper Instance;
	private Connection Con;
	private static String url = "jdbc:sqlserver://DESKTOP-0QMTVFB\\LEHONGMINH;databaseName=UngDungTimViecLam;integratedSecurity=true";
	public static DBHelper getInstance() throws ClassNotFoundException, SQLException
	{
		if(Instance == null)
		{
			Instance = new DBHelper(url);
		}
		return Instance;
	}

	private DBHelper(String url) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	}
	public DefaultTableModel GetRecords(String sql) throws SQLException
	{
		DefaultTableModel dataTableModel = new DefaultTableModel();
		Con = DriverManager.getConnection(url, "", "");
		Statement statement = Con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		
		for(int i = 1; i <= metaData.getColumnCount(); i++)
		{
			dataTableModel.addColumn(metaData.getColumnLabel(i));
		}
		while(resultSet.next())
		{
			Object[] arr = new Object[metaData.getColumnCount()];
			for(int i = 0; i < metaData.getColumnCount(); i++)
			{
				arr[i] = resultSet.getObject(i+1);
			}
			dataTableModel.addRow(arr);
		}
		resultSet.close();
		statement.close();
		Con.close();
		return (dataTableModel.getRowCount() > 0)?dataTableModel:null;
	}
	
	public void ExcuteDB(String sql) throws SQLException
	{
		Con = DriverManager.getConnection(url, "", "");
		PreparedStatement preparedStatement = Con.prepareStatement(sql);
		preparedStatement.execute();
		preparedStatement.close();
		Con.close();
	}
}
