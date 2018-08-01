package modelcontrol;

public class Schedule implements SchedulingControl{
	
	Login loginData = new Login();
	String id = loginData.loginedId;
	String[][] schedule = new String[7][15];
	
	@Override
	public void memberInformation() {
		//id	<-ㅅㅏㅇㅛㅇㅎㅐㅅㅓ, ㅂㅠㅇㅔ ㅃㅜㄹㅣㅁㅕㄴ ㄷㅗㅐㅁ.
	}

	@Override
	public void makeSchedule() {
		//배열의 1,1 부터 월요일 9시...
		String day[] = {"월","화","수","목","금","토","일"};
		int time[] = {9, 10, 11, 12, 01, 02, 03, 04, 05, 06, 07};
		
		for(int i = 0; i < schedule[0].length; i++) {
			schedule[0][i] = day[i];
		}
		for(int i = 0; i < schedule.length; i++) {
			schedule[i][0] = String.format("%d", time[i]);
		}
		
		
	}

	@Override
	public void showSchedule() {
	}

}
