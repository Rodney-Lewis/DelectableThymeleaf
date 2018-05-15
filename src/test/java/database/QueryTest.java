package database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import junit.framework.*;
import app.Database;
import org.junit.jupiter.api.Test;

class QueryTest extends TestCase {

	@Test
	void test() {
		String sql = "SELECT * FROM mytable";
		CachedRowSet test = Database.Query(sql);
		
		try {
			while(test.next())
			{
				System.out.println(test.getInt(1));
				System.out.println(test.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
