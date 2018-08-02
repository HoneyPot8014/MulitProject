package view;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelcontrol.Login;


public class SignUpView extends JFrame implements ActionListener{
	
	Panel northPanel;
	Panel mainPanel;
	Panel bottomPanel;
	Panel namePanel, idPanel, passwordPanel, schoolPanel, majorPanel, snumPanel;
	TextField inputId;
	TextField inputname;
	TextField inputPassword;
	TextField inputSchool;
	TextField inputMajor;
	TextField inputSnum;
	public static void main(String[] args) {
		SignUpView signUpView = new SignUpView();
	}
	
	public SignUpView() {
		setVisible(true);
		setBounds(200,200,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원가입");
		northPanel = new Panel();
		TextField title = setTextField("회원가입",12);
		title.setEditable(false);
		northPanel.add(title);
		this.add(northPanel, "North");
		
		mainPanel = new Panel();
		namePanel = new Panel();
		TextField name = setTextField("이름",12);
		name.setEditable(false);
		namePanel.add(name);
		inputname = setTextField("",12);
		inputname.setEditable(true);
		namePanel.add(inputname);
		
		idPanel = new Panel();
		TextField id = setTextField("id",12);
		id.setEditable(false);
		idPanel.add(id);
		inputId = setTextField("",12);
		inputId.setEditable(true);
		idPanel.add(inputId);
		
		passwordPanel = new Panel();
		TextField password = setTextField("password",12);
		password.setEditable(false);
		passwordPanel.add(password);
		inputPassword = setTextField("", 12);
		inputPassword.setEditable(true);
		passwordPanel.add(inputPassword);
		
		schoolPanel = new Panel();
		TextField school  = setTextField("School", 12);
		school.setEditable(false);
		schoolPanel.add(school);
		inputSchool = setTextField("", 12);
		inputSchool.setEditable(true);
		schoolPanel.add(inputSchool);
		
		majorPanel = new Panel();
		TextField major  = setTextField("major", 12);
		major.setEditable(false);
		majorPanel.add(major);
		inputMajor = setTextField("", 12);
		inputMajor.setEditable(true);
		majorPanel.add(inputMajor);
		
		snumPanel = new Panel();
		TextField snum  = setTextField("School Number", 12);
		snum.setEditable(false);
		snumPanel.add(snum);
		inputSnum = setTextField("", 12);
		inputSnum.setEditable(true);
		snumPanel.add(inputSnum);
		
		mainPanel.add(namePanel);
		mainPanel.add(idPanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(schoolPanel);
		mainPanel.add(majorPanel);
		mainPanel.add(snumPanel);
		
		this.add(mainPanel, "Center");
		
		bottomPanel = new Panel();
		Button button = new Button("회원가입 하기");
		button.addActionListener(this);
		bottomPanel.add(button);
		this.add(bottomPanel, "South");
//		this.add(mainPanel);
	}
	
	private TextField setTextField(String tilte, int size) {
		TextField textField = new TextField(size);
		textField.setText(tilte);
		return textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Login control = new Login();
		String id = inputId.getText();
		String name = inputname.getText();
		String password = inputPassword.getText();
		String school = inputSchool.getText();
		String major = inputSchool.getText();
		String snum = inputSnum.getText();
		control.signUp(id, name, password, school, major, snum);
		setVisible(false);
	}
}
