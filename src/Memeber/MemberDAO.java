package Memeber;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String reply;
	private Scanner sc;
	private int result;
	
	
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
		MemberDB db = new MemberDB();
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
		MemberDB db = new MemberDB();
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
		MemberDB db = new MemberDB();
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
		MemberDB db = new MemberDB();
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
		MemberDB db = new MemberDB();
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
	
	public void dispDeleteMem() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 id 입력 : ");
		String id = scan.next();
		MemberDB md = new MemberDB();
		int result = md.deleteMem(id);
		if(result == 1) {
			System.out.println("삭제가 정상적으로 완료되었습니다.\n");
		}else {
			System.out.println("삭제할 id가 없습니다. (삭제 실패)");
		}
	}
	
	
	
	
	//회원가입 메서드
	public void register() {
		Scanner sc = new Scanner(System.in);
		MemberDB db = new MemberDB();
		result = 0;
		System.out.println("==============================");
		System.out.println("회원가입을 시작합니다.");
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		pw = sc.next();
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("주소 : ");
		addr = sc.next();
		System.out.print("댓글 : ");
		reply = sc.next();
		
		result = db.registerFunc(id, pw, name, addr, reply);
		
		if(result == 1) {
			System.out.println("회원가입에 성공하였습니다.");
		} else {
			System.out.println("동일한 아이디가 존재하거나, 오류가 발생하였습니다.");
		}
		System.out.println("==============================");
	}
	
	
	
	public void memList() {
		MemberDB mdb = new MemberDB();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		
		ar = mdb.getList();
		
		System.out.println("============< 전체 회원 목록 >============");
		for(int i=0; i <ar.size(); i++) {
			MemberDTO d = ar.get(i);			
			System.out.println("이름 : " + d.getName() + " ,  아이디 : " + d.getId() + " ,  주소 : " + d.getAddr());
		}
		System.out.println("====================================");
		
	}
	
	public void display() {
		MemberDB db=new MemberDB();
		result = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디입력");
		id=sc.next();
		System.out.println("수정할이름");
		name=sc.next();
		System.out.println("수정할비번");
		pw=sc.next();
		System.out.println("수정할주소");
		addr=sc.next();
		System.out.println("수정할 댓글");
		reply=sc.next();
		result = db.updateData(id,name,pw,addr,reply);
		
		if(result==1) {
			System.out.println("수정이완료되었습니다");
		}else {
			System.out.println("없는계정입니다(수정실패)");
		}
	}
	
	public void soominDisplay() {
		Scanner sc = new Scanner(System.in);
		MemberDB db = new MemberDB();
		System.out.println("회원정보를 검색합니다");
		System.out.print("검색할 아이디 입력 : ");
		id = sc.next();
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
