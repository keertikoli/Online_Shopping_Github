package org.Zalando_OnlineShopping.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is created for fetching,verifying and modifying the data from
 * DataBase
 * 
 * @author rishikesh
 *
 */
public final class DataBaseUtility {
	Connection connection;

	/**
	 * This method is get connection and get the data from DataBase
	 * 
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	//conflict created
	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list = new ArrayList<>();
		while (result.next()) {
			list.add(result.getString(columnName));
		}
		return list;
	}

	/**
	 * This method is to Open the DataBase Connection
	 * 
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public void openDBConnection(String dbURL, String dbUserName, String dbPassword) throws SQLException {
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	}

	/**
	 * This method is to Modify the Data Into DataBase
	 * 
	 * @param query
	 * @throws SQLException
	 */
	public void modifyDataIntoDB(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	}

	/**
	 * This method is to Verify the Data of DataBase
	 * 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean verifyDataInDB(String query, String columnName, String expectedData) throws SQLException {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for (String actualdata : list) {
			if (actualdata.equalsIgnoreCase(expectedData)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	/**
	 * This method is to close the DataBase Connection
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		connection.close();
	}
}
