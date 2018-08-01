package modelcontrol;

import java.sql.SQLException;

public class Login implements LoginControl{
	
	UserModelControl signInControl = new UserModelControl();
	String loginedId;
	
	//로그인 기능
	@Override
	public void singIn(String id, String password) {
		try {
			signInControl.select(id, password);
			loginedId = signInControl.selectedId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(signInControl.selectedId == null) {
			System.out.println("회원 정보가 없습니다.");
		}else if(loginedId.equals(id) && signInControl.selectedPassword.equals(password)) {
			//go to main View
		}else if(loginedId.equals(id) && !signInControl.selectedPassword.equals(password)) {
			System.out.println("비밀번호가 틀립니다.");
			//틀렸을 때 처리..?
		}
	}
	//회원가입 기능
	@Override
	public void signUp(String id, String name, String password, String school, String major, String snum) {
		try {
			signInControl.insert(id, name, password, school, major, snum);
			//complete singUp message
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
