package mainClass;

import java.util.Scanner;

import five.Five;
import member_niyaoh.MemberMain;

public class MainClass {

	public static void main(String[] args) {
		MemberMain niyaoh = new MemberMain();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.강동원 2.김선우 3.박수민 4.김나현 5.김도윤");
		int num = sc.nextInt();
		switch(num) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: niyaoh.display();
				break;
		
		}
		
		
		
	}

}
