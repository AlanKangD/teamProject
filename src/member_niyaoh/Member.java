package member_niyaoh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Member extends MemberDTO {

	private ArrayList<MemberDTO> memberList;
	private String id, pw, name, email, addr;
	private String nowId;
	private int birth;
	private Scanner sc;
	private int index;
	private int admin;
	
	public String getNowId() {
		return nowId;
	}
	
	public String getAdmin() {
		if(admin == 1) {
			return "관리자";
		} else {
			return "일반";
		}
	}
	
	public Member() {
		memberList = new ArrayList<MemberDTO>();
		sc = new Scanner(System.in);
		nowId = "비회원";
		admin = 0;
	}
	
	
	public void registerFunc() {
		System.out.println("=================================");
		System.out.println("(1) 회원가입");
		System.out.println("---------------------------------");
		MemberDTO member = new MemberDTO();
		System.out.print("아이디 : ");
		id = sc.next();
		if(id.equals("비회원")) {
			System.out.println("사용 불가능한 아이디입니다.");
			return;
		}
		member.setId(id);
		index = IdCheck(id);
		if(index != -1) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		} else {
			System.out.print("비밀번호 : ");
			pw = sc.next(); member.setPw(pw);
			System.out.print("생년월일(예 : 980818) : ");
			birth = sc.nextInt(); member.setBirth(birth);
			System.out.print("이름 : ");
			name = sc.next(); member.setName(name);
			System.out.print("주소 : ");
			addr = sc.next(); member.setAddr(addr);
			
			memberList.add(member);
			System.out.println("회원가입이 정상적으로 처리되었습니다.");
		}
	}
	
	
	public void loginFunc() {
		System.out.println("=================================");
		System.out.println("(2) 로그인");
		System.out.println("---------------------------------");
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		pw = sc.next();
		index = IdCheck(id);
		if(index == -1) {
			System.out.println("존재하지 않는 아이디입니다.");
		} else {
			if(memberList.get(index).getPw().equals(pw) == true) {
				System.out.println("로그인에 성공하였습니다.");
				nowId(id);
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
	}
	
	
	public void modifyInfo() {
		System.out.println("=================================");
		System.out.println("(3) 정보수정");
		System.out.println("---------------------------------");
		if(nowId == "비회원") {
			System.out.println("로그인을 먼저 해주세요.");
		} else {
			index = IdCheck(nowId);
			System.out.println("현재 접속한 아이디의 비밀번호를 입력해주세요.");
			System.out.print("비밀번호 : ");
			pw = sc.next();
			if(memberList.get(index).getPw().equals(pw) == true) {
				MemberDTO memberModify = memberList.get(index);
				System.out.println("수정 전 생년월일 : " + memberList.get(index).getBirth());
				System.out.print("수정 후 생년월일 : ");
				birth = sc.nextInt();
				memberModify.setBirth(birth);
				System.out.println("수정 전 이름 : " + memberList.get(index).getName());
				System.out.print("수정 후 이름 : ");
				name = sc.next();
				memberModify.setName(name);
				System.out.println("수정 전 주소 : " + memberList.get(index).getAddr());
				System.out.print("수정 후 주소 : ");
				addr = sc.next();
				memberModify.setAddr(addr);
				System.out.println("정보수정이 정상적으로 처리되었습니다.");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
	}
	
	
	public void deleteInfo() {
		System.out.println("=================================");
		System.out.println("(4) 정보삭제");
		System.out.println("---------------------------------");
		if(nowId == "비회원") {
			System.out.println("로그인을 먼저 해주세요.");
		} else {
			index = IdCheck(nowId);
			System.out.println("현재 접속한 아이디의 비밀번호를 입력해주세요.");
			System.out.print("비밀번호 : ");
			pw = sc.next();
			if(memberList.get(index).getPw().equals(pw) == true) {
				System.out.println("---------------------------------");
				System.out.println(nowId + "의 모든 정보가 삭제됩니다.");
				System.out.println("정말 삭제하시겠습니까? (Y/N)");
				System.out.print(">>> ");
				String select = sc.next();
				if(select.equals("Y")) {
					memberList.remove(index);
					nowId("비회원");
					System.out.println("정보삭제가 정상적으로 처리되었습니다.");
				} else {
					System.out.println("선택 페이지로 되돌아갑니다.");
					return;
				}
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
	}
	
	
	public void infoPrint() {
		System.out.println("=================================");
		System.out.println("(5) 정보목록 (관리자)");
		System.out.println("---------------------------------");
		if(admin != 1) {
			System.out.println("관리자만 접근할 수 있습니다.");
		} else {
			for(int i = 0; i < memberList.size(); i++) {
				id = memberList.get(i).getId();
				pw = memberList.get(i).getPw();
				birth = memberList.get(i).getBirth();
				name = memberList.get(i).getName();
				addr = memberList.get(i).getAddr();
				System.out.println("[" + id + "의 회원정보]");
				System.out.println("  비밀번호 : " + pw);
				System.out.println("  생년월일 : " + birth);
				System.out.println("  이름 : " + name);
				System.out.println("  주소 : " + addr);
				System.out.println("---------------------------------");
			}
		}
	}
	
	
	public void logoutFunc() {
		System.out.println("=================================");
		System.out.println("(6) 로그아웃");
		System.out.println("---------------------------------");
		if(nowId == "비회원") {
			System.out.println("이미 비회원 상태입니다.");
		} else {
			nowId("비회원");
			System.out.println("로그아웃 처리되었습니다.");
		}
	}
	
	
	public void adminConfirm() {
		System.out.println("=================================");
		System.out.println("(7) 관리자 인증");
		System.out.println("---------------------------------");
		System.out.println("일반 → 관리자로 변경 (코드 : 0000)");
		System.out.println("관리자 → 일반으로 변경 (코드 : 1010)");
		System.out.print(">>> ");
		String answer = sc.next();
		if(answer.equals("0000")) {
			if(admin == 1) {
				System.out.println("이미 관리자 권한입니다.");
			} else {
				admin = 1;
				System.out.println("관리자 권한으로 변경되었습니다.");
			}
		} else if(answer.equals("1010")) {
			if(admin == 0) {
				System.out.println("이미 일반 권한입니다.");
			} else {
				admin = 0;
				System.out.println("일반 권한으로 변경되었습니다.");
			}
		} else {
			System.out.println("ERROR. 선택 페이지로 되돌아갑니다.");
		}
	}
	
	
	public void endProgram() {
		System.out.println("=================================");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("=================================");
		System.exit(0);
	}
	
	
	public int IdCheck(String id) {
		int i;
		for(i = 0; i < memberList.size(); i++) {
			MemberDTO dto = memberList.get(i);
			if(dto.getId().equals(id)) {
				return i;	// 중복된 아이디가 몇 번째 인덱스에 있는지 반환
			}
		}
		return -1;	// 중복된 아이디가 없다면 -1을 반환
	}
	
	
	public String nowId(String id) {
		nowId = id;
		if(nowId.equals("비회원")) {
			return "비회원";
		} else {
			return nowId;
		}
	}
	
	
	

	
}
