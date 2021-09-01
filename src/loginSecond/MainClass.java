package loginSecond;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		DAO fun = new DAO();
		
		while(true) {
			System.out.println("웹페이지 입니다 원하는 기능을 선택하세요~");
			System.out.println("1. 회원가입 2. 로그인 관리 3. 게시판 4. 답글 5. 마이페이지");
			num = sc.nextInt();
			switch(num) {
			case 1: fun.display();
				break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			}
			
		}
		
		
		
		
		
		
	}

}
