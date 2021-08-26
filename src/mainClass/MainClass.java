package mainClass;

import java.util.Scanner;
import soomin.*;

import alanFile.AlanFlie;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.강동원 2.김선우 3.박수민 4.김나현 5.김도윤");
		int num = sc.nextInt();
		AlanFlie  alan = new AlanFlie();
		switch(num) {
		case 1: alan.alanTest(); break;
		case 2: break;
		case 3: soomin.soomin_func.one(); break;
		case 4: break;
		case 5: break;
		
		}
		
		
		
	}

}
