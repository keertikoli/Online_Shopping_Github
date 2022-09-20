package org.zalando.PracticeTestCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertModifytheDataFromDB {
//for DMl,DDL Statements
	public static void main(String[] args) throws SQLException {
		//step1:Create the object for Driver
				Driver dbdriver=new Driver();
				//step2:Register the instance of Driver to JDBC
				DriverManager.registerDriver(dbdriver);
				//step3:Establish the database connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
				try {
				//step4:Create statements(Empty Spaces)
				Statement statement = connection.createStatement();
				//step5:Execute the Query
				int result = statement.executeUpdate("insert into sdet40 values(1004,'mohan',43256767,'shimoga');");
				//step6:Verify/itterate/fetch the data
					System.out.println(result+" Data updated successfully");
				}
				finally {
					//step7:close the db connection
					connection.close();//mandatory
					System.out.println("Connection closed successfully");
				}
			}
}

		

	



