package mainClass;

import java.util.Scanner;

import five.Five;

public class MainClass {

	public static void main(String[] args) {
		Five five = new Five();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.강동원 2.김선우 3.박수민 4.김나현 5.김도윤");
		int num = sc.nextInt();
		switch(num) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: five.selectFive();
				break;
		
		}
		
		
		
	}

}
