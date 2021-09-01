package loginSecond;

import java.util.ArrayList;
import java.util.Scanner;

import loginDTO.DTO;

public class DAO {
	private String id;
	private String pw;
	private String email;
	private String addr;
	private int age;
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		ArrayList<loginSecond.DTO> list = new ArrayList<loginSecond.DTO>();
		int num;
		int index =0;
		while(true) {
			System.out.println("회원가입 기능입니다.");
			System.out.println("1.회원가입 2.회원 전체 목록 조회 3.회원 조회 4.회원 수정 5.회원 삭제");
			num = sc.nextInt();
			
			switch(num) {
			case 1: 
				loginSecond.DTO dto = new loginSecond.DTO();
				boolean flag = true;
				if(list.size() != 0) {
					while(flag) {
						System.out.println("아이디 : ");
						id = sc.next();
						index = serchId(id);
						if(index == -1) {
							System.out.println("중복된 아이디가 있습니다.");
							break;
						}
						if(index == 1) {
							flag = false;
						}
					}
				} else {
					System.out.println("객체가 안만들어져서 아이디 : ");
					id = sc.next(); 
				}
				
				
				dto.setId(id);
				System.out.println("비밀번호 : ");
				pw = sc.next(); dto.setPw(pw);
				System.out.println("주소 : ");
				addr = sc.next(); dto.setAddr(addr);
				System.out.println("나이 : ");
				age = sc.nextInt(); dto.setAge(age);
				System.out.println("이메일 : ");
				email = sc.next(); dto.setEmail(email);
				list.add(dto);
				break;
			
			case 2: 
				for(int i=0; i< list.size(); i++) {
					System.out.println("아이디 : " + list.get(i).getId()); 
					System.out.println("비밀번호 : "+ list.get(i).getPw()); 
					System.out.println("주소 : "+list.get(i).getAddr()); 
					System.out.println("나이 : "+list.get(i).getAge()); 
					System.out.println("이메일 : "+list.get(i).getEmail());
				}
				
				break;
				
			case 3: 
				System.out.println("검색할 아이디를 입력하세요 :");
				id = sc.next(); 
				for(int i=0; i<list.size(); i++) {
					if(id.equals(list.get(i).getId())) {
						System.out.println("아이디 : " + list.get(i).getId()); 
						System.out.println("비밀번호 : "+ list.get(i).getPw()); 
						System.out.println("주소 : "+list.get(i).getAddr()); 
						System.out.println("나이 : "+list.get(i).getAge()); 
						System.out.println("이메일 : "+list.get(i).getEmail());
					}
				}
				
				
				
				break;
			case 4: break;
			case 5: break;
			}
			
		}
		
	}
	
	public int serchId(String id) {
		ArrayList<DTO> list = new ArrayList<DTO>();
		for(int i=0; i<list.size(); i++) {
			if(id.equals( list.get(i).getId())) {
				return i;
			}
		}
		return 1;
		
	}

}
