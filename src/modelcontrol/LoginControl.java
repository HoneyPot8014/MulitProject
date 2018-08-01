package modelcontrol;

public interface LoginControl {
	
	//로그인에 관한 것은 LoginControl인터페이스를 상속해 구현.
	
	//로그인 클릭시, jdbc와 연동하는 메소드 구현 해야함
	//1. db에서 ID를 키값으로, 조회 한 후,
	//2. 입력창의 ID, PW가 일치한다면, 로그인,
	//3. 아닐 시, 에러 창 띄워줘야 함.
	public void singIn(String id, String password);
	
	//회원 가입 클릭시, 새로운 창을 띄우는 로직 구현 해야함
	//1. GUI새로운 창 띄워 야 함( View에서 SingUp 클래스 이용)
	//2. 학교, 학과, 학번, 이름, ID, PW 입력 받을 수 있는 창이 있어야 함.
	//3. 회원가입 완료 버튼을 클릭시, DB에 새로운 테이블 생성해야함.
	public void signUp(String id, String name, String password, String school, String major, String snum);

}
