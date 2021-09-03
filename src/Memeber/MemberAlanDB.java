package Memeber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberAlanDB {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "java";
	private String pwd = "1234";
	
	public void DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> reply() {
		String sql = "select * from teamMember";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(); //여기서 주의할 점은 dto의 객체가 여기서 만들어져야 객체를 하나씩 받아올수 있습니다.
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setReply(rs.getString("reply"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(String userId, String userPw,String userName, String userAddr, String reply) {
		String sql = "insert into teamMember values(?,?,?,?,?)";
		int result=0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPw);
			ps.setString(3, userName);
			ps.setString(4, userAddr);
			ps.setString(5, reply);
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public MemberDTO serch(String userId) {
		String sql = "select reply from teamMember where id=?";
		MemberDTO dto = null;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setReply(rs.getString("reply"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
	}

	public int update(String userId, String userPw, String userName, String userAddr, String reply) {
		String sql = "update teamMember set pw=?, name=?, addr=?, reply=? where id=?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userPw);
			ps.setString(2, userName);
			ps.setString(3, userAddr);
			ps.setString(4, reply);
			ps.setString(5, userId);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int delete(String userId) {
		String sql = "delete from teamMember where id=?";
		int result =0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	
	
}




















