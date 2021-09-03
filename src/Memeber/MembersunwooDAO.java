package Memeber;

import java.util.Scanner;

public class MembersunwooDAO {
MembersunwooDB db=new MembersunwooDB();
MainClass main=new MainClass();
int num,password,result=0;
String id,name,addr,reply=null;
public void display() {
	Scanner sc=new Scanner(System.in);
	System.out.println("아이디입력");
	id=sc.next();
	System.out.println("수정할이름");
	name=sc.next();
	System.out.println("수정할비번");
	password=sc.nextInt();
	System.out.println("수정할주소");
	addr=sc.next();
	System.out.println("수정할 댓글");
	reply=sc.next();
	result=db.updateData(id,name,password,addr,reply);
	if(result==1) {
		System.out.println("수정이완료되었습니다");
	}else {
		System.out.println("없는계정입니다(수정실패)");
	}
}
}
