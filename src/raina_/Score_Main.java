package raina_;

import java.util.Scanner;

public class Score_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		ScoreClass scc = new ScoreClass();		
	    System.out.println("================= || 3반 성적 관리 프로그램 || ================= ");		
		while(true) {
			System.out.println("1. 학생 성적 등록  2. 학생 검색  3. 성적 수정  4. 전체 과목별 평균  5. 우리반 일등 ");
			System.out.print(">>  ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 : 
				scc.register();
				break;
			case 2 : 
				scc.search();
				break;
			case 3 : 
				scc.modify();
				break;
			case 4 : 
				scc.avg();
				break;
			case 5 : 
				scc.rank();
				break;
			case 6 : 
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
			}
		}
	}
}
