package Memeber;

import java.sql.*;

public class MemberDB {

	public int deleteMem(String userId) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "dsjin123";
		String pw = "1234";
		int result = 0;
		String sql = "delete from teamMember where id = '"+userId+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, id, pw);
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
		return result;
	}
	
}
