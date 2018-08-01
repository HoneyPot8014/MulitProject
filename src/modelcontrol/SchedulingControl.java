package modelcontrol;

public interface SchedulingControl {
	
	//실제, 시간표 프로그램의 로직을 담당하는 부분은, SchedulingContrl을
	//상속받아서, 구현 해야함
	
	//회원의 정보를 보여주는 로직. 회원의 이름이 나타나야 함.
	//1.DB에서, 로그인 한 회원의 이름을 조회한 후, GUI창에 표현하기
	public void memberInformation();
	
	//시간표 작성하기 버튼을 누를 시, GUI창에, 새로운 시간표화면이 띄어져야함.
	//밑에, 강의 추가하기 버튼을 누르면, 새로운 창이 뜨며,
	//강의 명, 교수명, 요일, 강의 시간을 입력 받을 수 있어야 함.
	//각 정보들을 GUI창에 띄어야 하며
	//시간표 저장하기를 누를 시, 시간표이름으로 한, DB TABLE을 만들어야함.
	public void makeSchedule();
	
	//시간표 불러오기 버튼을 누를시, GUI창에 이때까지 만들었던,
	//시간표명들을 띄워주고, 그 중 하나를 클릭시,
	//해당 시간표를 조회해서 GUI에 보여지게 해야함.
	public void showSchedule();

}
