package Memeber;

import java.util.ArrayList;

public class MemberDAO {
	
	MemberDB mdb = new MemberDB();
	ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
	
	public void memList() {
		ar = mdb.getList();
		
		System.out.println("============< 전체 회원 목록 >============");
		for(int i=0; i <ar.size(); i++) {
			MemberDTO d = ar.get(i);			
			System.out.println("이름 : " + d.getName() + " ,  아이디 : " + d.getId() + " ,  주소 : " + d.getAddr());
		}
		System.out.println("====================================");
		
	}
}
