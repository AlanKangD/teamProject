package Memeber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberNiyaohDB {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "java";
	private String pwd = "1234";
	
	public MemberNiyaohDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원가입 로직입니다!
	public int registerFunc(String id, String pw, String name, String addr, String reply) {
		String sql = "INSERT INTO teamMember VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, this.id, pwd);
			System.out.println("DB 연결에 성공하였습니다.");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, addr);
			pstmt.setString(5, reply);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
}
