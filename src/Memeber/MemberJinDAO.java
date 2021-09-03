package Memeber;

import java.util.*;

public class MemberJinDAO {
	
	public void dispDeleteMem() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 id 입력 : ");
		String id = scan.next();
		MemberJinDB md = new MemberJinDB();
		int result = md.deleteMem(id);
		if(result == 1) {
			System.out.println("삭제가 정상적으로 완료되었습니다.\n");
		}else {
			System.out.println("삭제할 id가 없습니다. (삭제 실패)");
		}
	}
	
}
