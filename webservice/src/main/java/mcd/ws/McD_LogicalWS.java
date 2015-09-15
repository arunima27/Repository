package mcd.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

import mcd.ws.base.McD_LogicalWSInterface;

public class McD_LogicalWS implements McD_LogicalWSInterface {
	private static final String connection_string = "jdbc:mysql://localhost:3306/company";
	private static final String username = "root";
	private static final String password = "password";

	public List<String> logicalMethod(String name) throws SQLException,
			ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connection_string,
				username, password);

		Statement stmt = conn.createStatement();

		String query = "select * from company.storelocator where Name = \""
				+ name + "\";";
		ResultSet rs = stmt.executeQuery(query);
		List<String> rsValues = new ArrayList<String>();
		ResultSetMetaData resultSetMetadata = (ResultSetMetaData) rs
				.getMetaData();
		int count = resultSetMetadata.getColumnCount();
		JSONObject obj = new JSONObject();
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				String cName = resultSetMetadata.getColumnName(i);
				String data = rs.getString(i);
				obj.put(cName, data);
			}
			rsValues.add(obj.toString());
		}

		return rsValues;
	}

//	 public static void main(String args[]) throws ClassNotFoundException,
//	 SQLException {
//	 McD_LogicalWS ab = new McD_LogicalWS();
//	 ab.logicalMethod("UCBA");
//	 }

}
