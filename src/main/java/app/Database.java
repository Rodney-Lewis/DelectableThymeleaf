package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.media.jfxmedia.logging.Logger;

public class Database {

	private static Connection GetConnection() throws SQLException {
		//TODO connection info should be at configuration level
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root");
		return conn;
	}
	
	private static void CloseConnection(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void CloseStatement(Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void CloseResultSet(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ResultSet Query(String sqlQuery) {
		Connection queryConnection = null;
		Statement queryStatement = null;
		ResultSet queryResults = null;
		
		try {
			queryConnection = GetConnection();
			queryStatement = queryConnection.createStatement();
			queryResults = queryStatement.executeQuery(sqlQuery);
			return queryResults;
		}
		catch (SQLException ex) {
			//TODO Add rollback on exception and more useful logging with stacktrace
			ex.printStackTrace();
		}
		finally {
			CloseConnection(queryConnection);
			CloseStatement(queryStatement);
			CloseResultSet(queryResults);
		}
		return queryResults;
	}
	
	public static String Update(String sqlQuery) {
		int effectedRows = 0;
		Connection updateConnection = null;
		Statement updateStatement = null;
		
		try {
			updateConnection = GetConnection();
			updateStatement = updateConnection.createStatement();
			effectedRows = updateStatement.executeUpdate(sqlQuery);
			
			if(effectedRows > 0) {
				return StatusCode.DATABASE_UPDATE_OKAY.ToString();
			}
			else {
				return StatusCode.DATABASE_NO_EFFECTED_ROWS.ToString();
			}
		}
		catch (SQLException ex) {
			//TODO Add rollback on exception and more useful logging with stacktrace
			ex.printStackTrace();
		}
		finally {
			CloseConnection(updateConnection);
			CloseStatement(updateStatement);
		}
		return StatusCode.DATABASE_UPDATE_ERROR.ToString();
	}
}
