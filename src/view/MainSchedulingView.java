package view;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

public class MainSchedulingView extends JFrame implements ActionListener{
	
	String[] fieldName = {"월","화","수","목","금","토","일"};
	Button makeSchedule;
	Button selectSchedule;
	
	public MainSchedulingView(String name) {
		setTitle("시간표 짜기 프로그램");
		setBounds(200,200,700,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(setUserText(name),"East");
		makeSchedule = setButton("시간표 추가하기", 570, 100, 100, 50);
		makeSchedule.getActionListeners();
		selectSchedule = setButton("시간표 조회하기", 570, 160, 100, 50);
		selectSchedule.getActionListeners();
		Panel panel = new Panel();
		panel.setBounds(10,10,500,650);
		panel.add(setTable());
		this.add(panel, "West");
		this.add(makeSchedule);
		this.add(selectSchedule);
		
	}
	
	public void Visible(Boolean state) {
		setVisible(state);
	}
	
	public TextField setUserText(String name) {
		TextField userName = new TextField();
		userName.setEditable(false);
		userName.setText(name);
		userName.setBounds(600,50,50,20);
		return userName;
	}
	
	public JTable setTable() {
		String[][] data = {
				{"1","2","3","4","5","6","7"},
				{"2","3","4","5","6","7","8"}
		};
		JTable jTable = new JTable(data, fieldName);
		jTable.setBounds(0,0,500,650);
		return jTable;
	}
	
	public Button setButton(String buttonName, int x,int y, int widht,int height) {
		Button button = new Button(buttonName);
		button.setBounds(x, y, widht, height);
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(makeSchedule)){
			//시간표 저장 기능
		}else if(object.equals(selectSchedule)){
			//시간표 조회 기능
		}
	}
	
	public static void main(String[] args) {
		MainSchedulingView main = new MainSchedulingView("ㅎ");
	}
}
