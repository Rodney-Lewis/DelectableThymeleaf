package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static Connection GetConnection() throws SQLException {
		//TODO connection info should be at configuration level
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root")) {
			return conn;
		}
	}
	
	static ResultSet Query(String sqlQuery) throws SQLException {
		Connection queryConnection = GetConnection();
		Statement queryStatement = queryConnection.createStatement();
		ResultSet queryResults = queryStatement.executeQuery(sqlQuery);
		return queryResults;
	}
	
	static void CloseConnection(Connection conn) throws SQLException {
		conn.commit();
		conn.close();
	}
	
	static String Update(String sqlQuery) throws SQLException {
		//TODO return statuses should exist in their own class/enum
		String returnStatus = null;
		return returnStatus;
	}
	
}
