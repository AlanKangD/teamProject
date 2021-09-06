package Memeber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDB {
		private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
		private String id = "foracle";
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
	
	public int deleteMem(String userId) {
		int result = 0;
		String sql = "delete from teamMember where id = '"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
		return result;
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
	
	public MemberDTO searchMem(String id) {
		String sql = "select * from teammember where id = '" + id + "'";
		MemberDTO dto = null;
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
//			System.out.println("연결 확인");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int updateData(String id,String name,String password,String addr,String reply) {
		int result=0;
		Connection con=null;
		PreparedStatement ps=null;
		String sql="update teamMember set name=?,password=?,addr=?,reply=? where id=?";
		try {
			con=DriverManager.getConnection(url,this.id,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(5, id);
			ps.setString(4, reply);
			ps.setString(3,addr);
			ps.setString(2, password);
			ps.setString(1, name);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
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

