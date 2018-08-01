package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelcontrol.Login;
import modelcontrol.Schedule;

public class MainSchedulingView extends JFrame{
	
	Button makeSchedule;
	Button selectSchedule;
	Schedule controller = new Schedule();
	String[][] datas = controller.schedule;
	JTable jTable;
	
	public MainSchedulingView(String name) {
		setTitle("시간표 짜기 프로그램");
		setBounds(200,200,700,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(setText(name,600,50,50,20),"East");
		makeSchedule = setButton("시간표 추가하기", 570, 100, 100, 50);
		makeSchedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeScheduleFrame();
				
			}
		});
		selectSchedule = setButton("시간표 조회하기", 570, 160, 100, 50);
		selectSchedule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Schedule selectQuery = new Schedule();
				selectQuery.showSchedule();
				jTable.repaint();
			}
		});
		Panel panel = new Panel();
		panel.setBounds(10,10,500,650);
		panel.add(setTable());
		this.add(panel, "West");
		this.add(makeSchedule);
		this.add(selectSchedule);
	}
	
	public void makeScheduleFrame() {
		final Frame FRAME = new Frame("시간표 작성");
		FRAME.setVisible(true);
		FRAME.setBounds(400,400,400,400);
		Panel panel = new Panel();
		panel.setBounds(100,100,300,300);
		TextField textField = setText("시간표를 추가할 요일을 선택하세요", 50, 100, 200, 30);
		final TextField textField2 = setText("월", 250, 80, 50, 30);
		TextField textField3 = setText("과목을 입력하시오", 50, 150, 150, 30);
		final TextField textField4 = setText("영어", 250, 80, 50, 30);
		textField4.setEditable(true);
		Button button = setButton("저장하기", 150, 250, 100, 50);
		final JList<String> list = new JList<>(listModeling());
		list.setBounds(200, 200, 200, 200);
		Panel panel2 = new Panel();
		panel2.add(list);
		button.setSize(100,100);
		textField2.setEditable(true);
		
		panel.add(textField);
		panel.add(textField2);
		panel.add(textField3);
		panel.add(textField4);
		FRAME.add(button,"South");
		FRAME.add(panel,"North");
		FRAME.add(panel2,"Center");
		FRAME.setResizable(false);
		
		FRAME.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FRAME.setVisible(false);
				FRAME.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String day = textField2.getText();
				int time = list.getSelectedIndex();
				String subject = textField4.getText();
				Schedule insertQuery = new Schedule();
				insertQuery.makeSchedule(day, time, subject);
//				controller.makeSchedule(day, time);
				FRAME.setVisible(false);
			}
		});
	}
	
	public DefaultListModel<String> listModeling(){
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("9시 ~ \n10시 15분");
		listModel.addElement("10시 30분 ~\n 11시 45분");
		listModel.addElement("12시 ~\n 1시 15분");
		listModel.addElement("1시 30분 ~\n 2시 45분");
		listModel.addElement("3시 ~\n 4시 15분");
		listModel.addElement("4시 30분 ~\n 5시 45분");
		listModel.addElement("3시 ~\n 4시 15분");
		listModel.addElement("4시 30분 ~\n 5시 45분");
		listModel.addElement("6시 ~\n 7시 15분");
		listModel.addElement("7시 30분 ~\n 8시 45분");
		return listModel;
	}
	
	public void Visible(Boolean state) {
		setVisible(state);
	}
	
	public TextField setText(String name, int x, int y, int width, int height) {
		TextField userName = new TextField();
		userName.setEditable(false);
		userName.setText(name);
		userName.setBounds(x,y,width,height);
		return userName;
	}
	
	public TextArea setEditText(String name, int x, int y, int width, int height) {
		TextArea textArea = new TextArea();
		textArea.setEditable(true);
		textArea.setText(name);
		textArea.setBounds(x,y,width,height);
		return textArea;
	}
	
	public JScrollPane setTable() {
		String[] fieldName = {"","월","화","수","목","금","토","일"};
		String[] times = {"9 ~ 10:15","10:30 ~ 11:45","12 ~ 1:15","1:30 ~ 2:45","3 ~ 4:15",
				"4:30 ~ 5:45","3 ~ 4:15","4:30 ~ 5:45","6 ~ 7:15","7:30 ~ 8:45"};
		for(int i = 0; i <Schedule.schedule.length; i++) {
			Schedule.schedule[i][0] = times[i];
		}
		jTable = new JTable(Schedule.schedule, fieldName);
		jTable.setBounds(50,50,500,650);
		jTable.setRowHeight(55);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		JScrollPane scrollpane = new JScrollPane(jTable);
		scrollpane.setBounds(0, 0, 500, 650);
		return scrollpane;
	}
	public Button setButton(String buttonName, int x,int y, int widht,int height) {
		Button button = new Button(buttonName);
		button.setBounds(x, y, widht, height);
		return button;
	}
	public static void main(String[] args) {
		MainSchedulingView main = new MainSchedulingView(Login.loginedId);
	}
}
