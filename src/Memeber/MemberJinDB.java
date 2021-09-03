package Memeber;

import java.sql.*;

public class MemberJinDB {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "dsjin123";
	String pw = "1234";
	
	public MemberJinDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public int deleteMem(String userId) {
		int result = 0;
		String sql = "delete from teamMember where id = '"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pw);
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
		return result;
	}
	
}
