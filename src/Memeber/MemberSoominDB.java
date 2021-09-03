package Memeber;

import java.sql.*;

public class MemberSoominDB {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "foracle";
	private String pwd = "1234";
	private Connection con;
	
	public MemberSoominDTO searchMem(String id) {
		String sql = "select * from teammember where id = '" + id + "'";
		MemberSoominDTO dto = null;
		try {
			con = DriverManager.getConnection(url, this.id, pwd);
//			System.out.println("연결 확인");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberSoominDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
