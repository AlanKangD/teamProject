package raina_;

public interface IScore {

	//학생 성적 등록
	public abstract void register();
	
	//학생 검색
	public abstract void search();
	
	//성적 수정
	public abstract void modify();	
	
	//전체 과목별 평균
	public abstract void avg();
	
	//학생 석차 
	public abstract void rank();
	
	
	
	
}
