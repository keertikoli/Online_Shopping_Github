package org.zalando.PracticeTestCases;

import java.sql.SQLException;
import java.util.List;

import org.Zalando_OnlineShopping.genericUtility.DataBaseUtility;
import org.Zalando_OnlineShopping.genericUtility.IconstantUtility;

public class FetchdatafromDB {
//for DQL statement
	public static void main(String[] args) throws SQLException {
		DataBaseUtility dataBaseUtility = new DataBaseUtility();
		dataBaseUtility.openDBConnection(IconstantUtility.DB_URL, "root", "root");
		boolean status = dataBaseUtility.verifyDataInDB("select * from sdet40", "emp_name", "mohan");
		System.out.println(status);
		List<String> data = dataBaseUtility.getDataFromDatabase("select * from sdet40", "emp_name");
		System.out.println(data);
		dataBaseUtility.modifyDataIntoDB(("insert into sdet40 values(1007,'keeri',246486,'kdpr');"));
		boolean status2 = dataBaseUtility.verifyDataInDB("select * from sdet40", "emp_name", "keeri");
		System.out.println(status2);
		
//		//step1:Create the object for Driver
//		Driver dbdriver=new Driver();
//		//step2:Register the instance of Driver to JDBC
//		DriverManager.registerDriver(dbdriver);
//		//step3:Establish the database connection
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
//		try {
//		//step4:Create statements(Empty Spaces)
//		Statement statement = connection.createStatement();
//		//step5:Execute the Query
//		ResultSet result = statement.executeQuery("select * from sdet40;");
//		//step6:Verify/itterate/fetch the data
//		while(result.next()) {
//			System.out.println(result.getString("emp_name"));
//	}
//		}
//		finally {
//			//step7:close the db connection
//			connection.close();//mandatory
//			System.out.println("Connection closed successfully");
//		}
	}
}

	



