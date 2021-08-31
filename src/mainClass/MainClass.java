package mainClass;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
		

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			ArrayList<DTO> list = new ArrayList<DTO>();
			String id, pw, email, addr;
			String checkid, checkpw;
			
			int age;
			while(true) {
				System.out.println("회원 가입 웹페이지 입니다");
				System.out.println("1.회원가입 2.회원전체 정보목록 3.회원 정보 4.회원 수정 5.회원 삭제 ");
				int num = sc.nextInt();
				switch(num) {
				case 1: 
				DTO dto = new DTO();
				boolean flag = true;
				if(list.size() != 0) {
					while(flag) {
						System.out.println("아이디 : ");
						id = sc.next();
						for(int i=0; i<list.size(); i++) {
							if(id.equals(list.get(i).getId())) {
								System.out.println("중복된 아이디가 있습니다.");
								break;
							}
							if(!id.equals(list.get(i).getId())){
							System.out.println("중복된아이디가 없어서 바로 저장합니다. ");
							dto.setId(id);
							flag = false;
							}
						}
					}
				}else {
					System.out.println("list가 비어있어서 학번을 바로저장합니다.");
					System.out.println("아이디 : ");
					id = sc.next(); dto.setId(id);
				}
				System.out.println("비밀번호 : ");
				pw = sc.next(); dto.setPw(pw);
				System.out.println("이메일 : ");		
				email = sc.next(); dto.setEmail(email);
				System.out.println("나이 :");
				age = sc.nextInt(); dto.setAge(age);
				System.out.println("주소 : ");
				addr = sc.next(); dto.setAddr(addr);
						
				list.add(dto);
				break;
				
				case 2: 
					System.out.println("-------회원 전체 정보 목록-------");
					for(int i=0; i<list.size(); i++) {
						
						System.out.println("아이디 : " + list.get(i).getId());
						System.out.println("비밀번호 : " + list.get(i).getPw());
						System.out.println("이메일 : " + list.get(i).getEmail());
						System.out.println("나이 : " + list.get(i).getAge());
						System.out.println("주소 : " + list.get(i).getAddr());
						System.out.println("---------------------------------");
					}
					break;
				case 3: 
					System.out.println("회원 아이디를 입력하세요 : ");
					String find = sc.next();
					for(int i=0; i<list.size(); i++) {
						
						if(find.equals(list.get(i).getId())) {
							System.out.println("찾으신 아이디 정보 : " + list.get(i).getId());
							System.out.println("- 비밀번호 : " + list.get(i).getPw());
							System.out.println("- 이메일 : " + list.get(i).getEmail());
							System.out.println("- 나이 : " + list.get(i).getAge());
							System.out.println("- 주소 : " + list.get(i).getEmail());
							break;
						}
						
					}
					
					break;
				case 4: 
					System.out.println("회원 수정 페이지 입니다. ");
					System.out.println("수정하실 아이디를 입력하세요!");
					String f = sc.next();

					for(int i=0; i<list.size(); i++) {
						
						if(f.equals(list.get(i).getId())) {
							
							System.out.println("변경할 비밀번호를 입력 : "); list.get(i).setPw(sc.next());
							System.out.println("변경할 이메일를 입력 : "); list.get(i).setEmail(sc.next());
							System.out.println("변경할 나이를 입력 : "); list.get(i).setAge(sc.nextInt());
							System.out.println("변경할 주소를 입력 : "); list.get(i).setAddr(sc.next());

							break;
						}
					}
					break;
				case 5: 
					System.out.println("회원 삭제 페이지 입니다.");
					System.out.println("삭제하실 아이디를 입력하세요 : ");
					String rem = sc.next();
					for(int i=0; i<list.size(); i++) {
						if(rem.equals(list.get(i).getId())) {
							list.remove(i);
						}
					}
					break;			
				}		
			}		
	}
	

}
