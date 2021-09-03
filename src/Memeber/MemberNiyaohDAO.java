package Memeber;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberNiyaohDAO {
	
	private Scanner sc;
	private MemberNiyaohDB db;
	private ArrayList<MemberDTO> list;
	private String id, pw, name, addr, reply;
	private int result;
	
	public MemberNiyaohDAO() {
		sc = new Scanner(System.in);
		db = new MemberNiyaohDB();
		list = null;
		result = 0;
	}
	
	//회원가입 메서드
	public void register() {
		System.out.println("==============================");
		System.out.println("회원가입을 시작합니다.");
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		pw = sc.next();
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("주소 : ");
		addr = sc.next();
		System.out.print("댓글 : ");
		reply = sc.next();
		
		result = db.registerFunc(id, pw, name, addr, reply);
		
		if(result == 1) {
			System.out.println("회원가입에 성공하였습니다.");
		} else {
			System.out.println("동일한 아이디가 존재하거나, 오류가 발생하였습니다.");
		}
		System.out.println("==============================");
	}
	

}
