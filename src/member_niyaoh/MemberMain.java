package member_niyaoh;

import java.util.Scanner;

public class MemberMain extends Member {

	public void display() {

		Member member = new Member();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=================================");
			System.out.println("[ 회원 관리 프로그램 (By Niyaoh) ]");
			System.out.println("■ 현재 권한 : " + member.getAdmin() + "]");
			System.out.println("■ 현재 접속한 아이디 : " + member.getNowId() + "]");
			System.out.println("=================================");
			System.out.println("(1) 회원가입\t(5) 정보목록 (관리자)");
			System.out.println("(2) 로그인\t(6) 로그아웃");
			System.out.println("(3) 정보수정\t(7) 관리자 인증");
			System.out.println("(4) 정보삭제\t(8) 프로그램 종료");
			System.out.println("=================================");
			System.out.print("선택 >>> ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :member.registerFunc();
					break;
			case 2 :member.loginFunc();
					break;
			case 3 :member.modifyInfo();
					break;
			case 4 :member.deleteInfo();
					break;
			case 5 :member.infoPrint();
					break;
			case 6 :member.logoutFunc();
					break;
			case 7 :member.adminConfirm();
					break;
			case 8 :member.endProgram();
					return;
					
			}
			
		}
		
	}

}
