package Memeber;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		MemberSoominDB db = new MemberSoominDB();
		
		while(true) {
			System.out.println("1. 회원가입 2. 회원전체조회 3. 회원정보검색 4. 회원수정 5. 회원삭제 6. 댓글관리");
			num = sc.nextInt();
			switch(num) {
			case 1: break; //도윤
			case 2: break; //나현
			case 3: 
				System.out.println("회원정보를 검색합니다.");
				System.out.print("검색할 아이디 입력 : ");
				String id = sc.next();
				MemberSoominDTO dto = db.searchMem(id);
				
				if(dto != null) {
					System.out.println("아이디 : " + dto.getId());
					System.out.println("이름 : " + dto.getName());
					System.out.println("주소 : " + dto.getAddr());
				}else {
					System.out.println("해당하는 아이디를 찾지못했습니다.");
				}
				
				break; //수민
			case 4: break; //선우
			case 5: break; //동수
			case 6: break; //댓글관리에서는 기능으로 해당 회원이 쓴 댓글만 볼수 있게 만들어 줍니다. 
			
			}
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
