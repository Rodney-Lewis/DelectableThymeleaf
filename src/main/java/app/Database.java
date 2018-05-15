package app;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.lang.ClassLoader;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class Database {
	
	static String dbConnectionString = "";
	static String dbUsername = "";
	static String dbPassword = "";
	
	private static void GetDatabaseProperties() {
		InputStream input = null;
		
		try {
			ClassLoader classLoad = Thread.currentThread().getContextClassLoader();
			input = classLoad.getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(input);
			dbConnectionString = prop.getProperty("dbdriver") 
					   + "://" + prop.getProperty("dbhost") 
					   + ":" + prop.getProperty("dbport")
					   + "/" + prop.getProperty("dbname");
			dbUsername = prop.getProperty("dbusername");
			dbPassword = prop.getProperty("dbpassword");
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if (input != null) {
				try {
					input.close();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static Connection GetConnection() throws SQLException {
		if(dbConnectionString == "")
			GetDatabaseProperties();
		Connection conn = DriverManager.getConnection(dbConnectionString, dbUsername, dbPassword);
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
	
	public static CachedRowSet Query(String sqlQuery) {
		Connection queryConnection = null;
		Statement queryStatement = null;
		ResultSet queryResults = null;
		CachedRowSet cache = null;
		
		try {
			queryConnection = GetConnection();
			queryStatement = queryConnection.createStatement();
			queryResults = queryStatement.executeQuery(sqlQuery);
			cache = new CachedRowSetImpl();
			cache.populate(queryResults);
			return cache;
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
		return cache;
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
