package raina_;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreClass implements IScore {

	private ArrayList<Score_DTO> arr;
	private Scanner sc;
	private String stNum;
	int korSum=0;
	int mathSum=0;	
	int total = 0;
	int korAvg=0 ;
	int mathAvg=0 ;
	int index;
	Score_DTO d;
	
	// 은닉 관련?
	public ScoreClass() {
		arr = new ArrayList<Score_DTO>();
		sc = new Scanner(System.in);
	}

	// 학생 성적 등록
	public void register() {
		Score_DTO dto = new Score_DTO();
		System.out.println("   ============== || 성적 등록  || ==============    ");
		System.out.print("학번 : ");
		stNum = sc.next();

		if (arr.size() == 0) { // 리스트에 등록된게 아무것도 없으면 바로 등록 가능!
			regNum(stNum);
		} else {
			index = checkNum(stNum);
			if(index == -1) {
				regNum(stNum);				
			} else {
				System.out.println("이미 등록된 학번입니다.");	
			}			
		}
	}

	// 학생 검색
	public void search() {
		System.out.println("   ============== || 학생 성적 검색  || ==============    ");		
		for (int i = 0; i < arr.size(); i++) {
			d = arr.get(i);
			System.out.println("학번 : " + d.getStuNum()+" , 이름 : " + d.getName() );
		}
		System.out.print(" 검색할 학번 입력  >> ");
		index = checkNum(sc.next());
		if(index != -1) {
				d = arr.get(index);
				System.out.println("국어 : " + d.getKor());
				System.out.println("수학 : " + d.getMath());
				System.out.println("평균 : " + d.getAvg());			
		} else {
			System.out.println("등록되지 않은 학번입니다.");
		}
	}
	

	// 성적 수정
	public void modify() {
		System.out.println("   ============== || 학생 성적 수정  || ==============    ");
		System.out.print(" 수정할 학번 입력 >> ");	
		index = checkNum(sc.next());
		if(index != -1) {
			d = arr.get(index);
			System.out.println(d.getName()+" 학생");
			System.out.print("국어 점수 수정 : ");
			d.setKor(sc.nextInt());
			System.out.print("수학 점수 수정 : "  );
			d.setMath(sc.nextInt());
		} else {
			System.out.println("등록되지 않은 학번입니다.");
		}		
	}

	// 전체 과목별 평균
	public void avg() {
		System.out.println("   ============== || 전체 과목별 평균 || ==============    ");		
		stuAvg();
		korAvg = (korSum)/total;
		mathAvg = (mathSum)/total;
		System.out.println("총 인원 : "+total + "명");
		System.out.println("총 한국어 평균 : " + korAvg);
		System.out.println("총 수학 평균 : " + mathAvg );
	}

	// 우리반 일등 
	public void rank() {
		int big = 0;
		total = 0;
		for(int i = 0; i<arr.size(); i++) {
			if( big < arr.get(i).getAvg()) {
				big = arr.get(i).getAvg();
			}			
		}
		for(int i=0; i<arr.size(); i++) {
			if( big == arr.get(i).getAvg()) {
				System.out.println("3반 일등은 ~~바로바로!!");
				System.out.println("이름 : " + arr.get(i).getName()+", 총 평균 : " + arr.get(i).getAvg());
				break;
			}
		}		
	}
	
	//등록된 학번 확인하기 
	public int checkNum(String stNum) {
		int i;
		for (i = 0; i < arr.size(); i++) {
			if (stNum.equals(arr.get(i).getStuNum())) {
				return i;		
			}
		}
		return -1;
	}
	
	//등록하기 
	public void regNum(String stNum) {
		Score_DTO dto = new Score_DTO(); 
		dto.setStuNum(stNum);
		System.out.print("이름 : ");
		dto.setName(sc.next());
		System.out.print("국어 점수 : ");
		dto.setKor(sc.nextInt());
		System.out.print("수학 점수 : ");
		dto.setMath(sc.nextInt());
		
		arr.add(dto);		
	}
	
	//과목별 평균 내기 
	public void stuAvg() {		
		for(int i = 0; i<arr.size(); i++) {
			korSum = korSum+arr.get(i).getKor();
			mathSum = mathSum+arr.get(i).getMath();
			total ++;						
		}		
	}	
}
		
		
		
		
		
		
		
		
		
