package raina_;

public class Score_DTO {

	private String name;
	private String stuNum;
	private int kor;
	private int math;
	private int sum ;
	private int avg; 
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return (kor+math);
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return (kor+math)/2;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}


	

	
	
	
}
