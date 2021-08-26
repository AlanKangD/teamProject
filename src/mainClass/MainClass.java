package mainClass;

import java.util.Scanner;




import alanFile.AlanFlie;

import five.Five;
import raina.RainaCase;
import soomin.soomin_func;
import sunwoo.Test;


public class MainClass {

	public static void main(String[] args) {
		Five five = new Five();
		RainaCase raina = new RainaCase();
		soomin_func soomin = new soomin_func();
		sunwoo.Test tes=new sunwoo.Test();
		AlanFlie  alan = new AlanFlie();

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("1.강동원 2.김선우 3.박수민 4.김나현 5.김도윤");
			int num = sc.nextInt();
			switch(num) {
			case 1: 
				alan.alanTest();
				break;
			case 2:
				tes.dis();
				break;
			case 3: soomin.one(); break;
			case 4: raina.hi(); break;
			case 5: five.selectFive();
			
					break;
			}
		}
		
		
		
	}

}
