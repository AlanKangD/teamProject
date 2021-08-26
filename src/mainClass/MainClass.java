package mainClass;

import java.util.Scanner;



import alanFile.AlanFlie;




import five.Five;
import raina.RainaCase;
import soomin.soomin_func;



public class MainClass {

	public static void main(String[] args) {
		Five five = new Five();
		RainaCase raina = new RainaCase();
		soomin_func soomin = new soomin_func();
		
		Scanner sc = new Scanner(System.in);
		sunwoo.Test tes=new sunwoo.Test();
		System.out.println("1.강동원 2.김선우 3.박수민 4.김나현 5.김도윤");
		int num = sc.nextInt();

		AlanFlie  alan = new AlanFlie();

		switch(num) {
		case 1: alan.alanTest(); break;
		case 2: break;

		case 3: break;
		case 4: 
			tes.dis();
			break;
		case 3: soomin.one(); break;
		case 4: raina.hi(); break;
		case 5: five.selectFive();
				break;
		

		
		}
		
		
		
	}

}
