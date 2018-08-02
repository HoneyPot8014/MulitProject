package view;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javafx.scene.text.Font;
import modelcontrol.Login;

public class SignInView extends JFrame{
	
	public static void main(String[] args) {
		SignInView signInView = new SignInView();
	}
	Panel panel;
	
	public SignInView() {
		setTitle("로그인");
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextField title = setTextField("시간표 작성 프로그램", 140, 20, 125, 30);
		title.setEditable(false);
		this.add(title);
		TextField loginId = setTextField("아이디", 90, 80, 60, 30);
		loginId.setEditable(false);
		TextField inputId = setTextField("", 180, 80, 150, 30);
		inputId.setEditable(true);
		TextField loginPassword = setTextField("비밀번호", 90, 130, 60, 30);
		loginPassword.setEditable(false);
		TextField inputPassword = setTextField("", 180, 130, 150, 30);
		inputPassword.setEditable(true);
		this.add(loginId);
		this.add(inputId);
		this.add(loginPassword);
		this.add(inputPassword);
		panel = new Panel();
		Button signIn = setButton("로그인", 110, 200, 80, 50);
		signIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login control = new Login();
				String id = inputId.getText();
				String password = inputPassword.getText();
				int result = control.singIn(id, password);
				System.out.println(result);
				if(result == 1) {
					MainSchedulingView main = new MainSchedulingView(id);
				}
			}
		});
		this.add(signIn);
		Button signUp = setButton("회원가입", 210, 200, 80, 50);
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpView signUp = new SignUpView();
			}
		});
		this.add(signUp);
//		this.add(panel, "Center");
		
	}
	
	private TextField setTextField(String title, int x, int y, int width, int height) {
		TextField textField = new TextField();
		textField.setText(title);
		textField.setBounds(x, y, width, height);
		return textField;
	}
	
	private Button setButton(String title, int x, int y, int width, int height) {
		Button button = new Button(title);
		button.setBounds(x, y, width, height);
		return button;
	}

	
}
