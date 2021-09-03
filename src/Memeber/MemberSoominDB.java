package Memeber;

import java.sql.*;
import java.util.*;

public class MemberSoominDB {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "dsjin123";
	private String pwd = "1234";
	private Connection con;
	
	public MemberDTO searchMem(String id) {
		String sql = "select * from teammember where id = '" + id + "'";
		MemberDTO dto = null;
		try {
			con = DriverManager.getConnection(url, this.id, pwd);
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
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		MemberSoominDB db = new MemberSoominDB();
		System.out.println("회원정보를 검색합니다");
		System.out.print("검색할 아이디 입력 : ");
		String id = sc.next();
		MemberDTO dto = db.searchMem(id);
		
		if(dto != null) {
			System.out.println("아이디 : " + dto.getId());
			System.out.println("이름 : " + dto.getName());
			System.out.println("주소 : " + dto.getAddr());
		}else {
			System.out.println("해당하는 아이디를 찾지못했습니다.");
		}
	}

}
