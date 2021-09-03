package Memeber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberRainaDB {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dsjin123";
	private String pwd = "1234";
	
	public MemberRainaDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		String sql = "select * from teamMember";
		try {
			Connection conn = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));   //아이디 
				dto.setName(rs.getString("name"));  // 이름 
				dto.setAddr(rs.getString("addr"));  //주소까지만 보여주겠다 
				arr.add(dto);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return arr;
	}
	
	
	
}
