package Memeber;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		MemberNiyaohDAO daoN = new MemberNiyaohDAO();
		Scanner sc = new Scanner(System.in);
		MemberAlanDAO dao = new MemberAlanDAO();
		int num;
		MemberSoominDB db = new MemberSoominDB();
		MemberRainaDAO md = new MemberRainaDAO();
		
		while(true) {
			System.out.println("1. 회원가입 2. 회원전체조회 3. 회원정보검색 4. 회원수정 5. 회원삭제 6. 댓글관리");
			num = sc.nextInt();
			switch(num) {
			case 1: daoN.register(); break; //도윤
			case 2: 
				md.memList();
				break; //나현
			case 3: 
				db.display();
				break; //수민		
			case 4: break; //선우
			case 5: break; //동수
			case 6: 
				dao.alan();
				break; //댓글관리에서는 기능으로 해당 회원이 쓴 댓글만 볼수 있게 만들어 줍니다. 
			
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
