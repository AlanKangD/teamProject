package Memeber;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberAlanDAO {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String reply;
	
	public void alan() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			int num;
			System.out.println("1.댓글 작성 2. 모든 댓글 확인 3. 댓글 확인 4.댓글 수정 5. 댓글 삭제");
			num = sc.nextInt();
			switch(num) {
			case 1: 
					insertReply();
				break;
			case 2: 
					allReply();
				break;
			case 3: 
					serchReply(); //다시 수정이 필요함 아직 기능이 정상적으로 수행되지 않습니다.
				break;
			case 4: 
					updateReply();
				break;
			case 5: 
					deleteReply();
				break;
			}
		}
	}
	
	
	
	
	
	public void allReply() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberAlanDB db = new MemberAlanDB();
		list = db.reply();
		for(int i=0; i<list.size(); i++) {
			System.out.println("아이디 : " + list.get(i).getId());
			System.out.println("비밀번호 : " + list.get(i).getPw());
			System.out.println("이름 : " + list.get(i).getName());
			System.out.println("주소 : " + list.get(i).getAddr());
			System.out.println("댓글 : " + list.get(i).getReply());
			System.out.println("---------------------------------");
		}
	}
	
	public void insertReply() {
		MemberAlanDB db = new MemberAlanDB();
		MemberDTO dto = new MemberDTO();
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		System.out.println("-----정보를 입력합니다-----");
		System.out.println("아이디 : ");
		id = sc.next();
		System.out.println("비밀번호 : ");
		pw = sc.next();
		System.out.println("이름 : ");
		name = sc.next();
		System.out.println("주소 : ");
		addr = sc.next();
		System.out.println("댓글 : ");
		reply = sc.next();
		
		result = db.insert(id,pw,name,addr,reply);
		if(result == 1) {
			System.out.println("정상적으로 저장되었습니다.");
		} else {
			System.out.println("아이디가 중복되었습니다.");
		}
		
	}
	
	public void serchReply() {
		Scanner sc = new Scanner(System.in);
		MemberAlanDB db = new MemberAlanDB();
		System.out.println("확인 할 댓글 아이디 : ");
		id = sc.next();
		MemberDTO dto = db.serch(id);
		if(dto != null) {
			System.out.println(dto.getId() + "님의 댓글은 : " + dto.getReply());
		} else {
			System.out.println("해당 아이디는 존재 하지 않습니다.");
		}
		
	}
	
	public void updateReply() {
		MemberAlanDB db = new MemberAlanDB();
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 아이디 : ");
		id = sc.next();
		System.out.println("비밀번호 : ");
		pw = sc.next();
		System.out.println("이름 : ");
		name = sc.next();
		System.out.println("주소 : ");
		addr = sc.next();
		System.out.println("댓글 : ");
		reply = sc.next();
		int result = db.update(id,pw,name,addr,reply);
		if(result == 1) {
			System.out.println("정상적으로 수정되셨습니다.");
		}else {
			System.out.println("해당하는 아이디가 없습니다. ");
		}
	}
	
	public void deleteReply() {
		MemberAlanDB db = new MemberAlanDB();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 아이디 입력 : ");
		id = sc.next();	
		int result = db.delete(id);
		if(result == 1 ) {
			System.out.println("정상적으로 삭제 되셨습니다.");
		}else {
			System.out.println("해당하는 아이디가 없습니다. ");
		}
	}

}
