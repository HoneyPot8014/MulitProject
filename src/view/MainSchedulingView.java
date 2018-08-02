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
	Panel tablePanel;
	Panel rightPanel;
	
	public MainSchedulingView(String name) {
		setTitle("시간표 짜기 프로그램");
		setBounds(20,20,1000,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rightPanel = new Panel();
		Panel namePanel = new Panel();
		TextField nametext = setText(name, 12);
		namePanel.add(nametext);
		makeSchedule = setButton("시간표 추가하기");
		makeSchedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeScheduleFrame();
			}
		});
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(makeSchedule,"North");
		selectSchedule = setButton("시간표 조회하기");
		selectSchedule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Schedule selectQuery = new Schedule();
				selectQuery.showSchedule();
				jTable.repaint();
			}
		});
		buttonPanel.add(selectSchedule);
		JTable jTable = setTable();

		tablePanel = new Panel();
		tablePanel.add(jTable);
		rightPanel.add(namePanel,"North");
		rightPanel.add(buttonPanel,"Center");
		this.add(tablePanel, "West");
		this.add(rightPanel);
	}
	
	public void makeScheduleFrame() {
		final Frame FRAME = new Frame("시간표 작성");
		FRAME.setVisible(true);
		FRAME.setBounds(400,400,400,400);
		Panel panel = new Panel();
		
		TextField textField = setText("시간표를 추가할 요일을 선택하세요",12);
		final TextField textField2 = setText("월",12);
		TextField textField3 = setText("과목을 입력하시오",12);
		final TextField textField4 = setText("영어",12);
		textField4.setEditable(true);
		Button button = setButton("저장하기");
		final JList<String> list = new JList<>(listModeling());
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
		listModel.addElement("\t9시 ~ \n10시 15분");
		listModel.addElement("10시 30분 ~\n 11시 45분");
		listModel.addElement("  12시 ~\n 1시 15분");
		listModel.addElement(" 1시 30분 ~\n 2시 45분");
		listModel.addElement("  3시 ~\n 4시 15분");
		listModel.addElement("4시 30분 ~\n 5시 45분");
		listModel.addElement("  3시 ~\n 4시 15분");
		listModel.addElement("4시 30분 ~\n 5시 45분");
		listModel.addElement("  6시 ~\n 7시 15분");
		listModel.addElement("7시 30분 ~\n 8시 45분");
		return listModel;
	}
	
	public void Visible(Boolean state) {
		setVisible(state);
	}
	
	public TextField setText(String name, int size) {
		TextField userName = new TextField(size);
		userName.setEditable(false);
		userName.setText(name);
		return userName;
	}
	
	public TextArea setEditText(String name, int x, int y, int width, int height) {
		TextArea textArea = new TextArea();
		textArea.setEditable(true);
		textArea.setText(name);
		return textArea;
	}
	
	public JTable setTable() {
		String[] fieldName = {"","월","화","수","목","금","토","일"};
		String[] times = {"9 ~ 10:15","10:30 ~ 11:45","12 ~ 1:15","1:30 ~ 2:45","3 ~ 4:15",
				"4:30 ~ 5:45","3 ~ 4:15","4:30 ~ 5:45","6 ~ 7:15","7:30 ~ 8:45"};
		for(int i = 0; i <Schedule.schedule.length; i++) {
			Schedule.schedule[i][0] = times[i];
		}
		jTable = new JTable(Schedule.schedule, fieldName);
		jTable.setRowHeight(55);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
//		JScrollPane scrollpane = new JScrollPane(jTable);
//		scrollpane.setSize(800,800);
		return jTable;
	}
	public Button setButton(String buttonName) {
		Button button = new Button(buttonName);
		return button;
	}

	public static void main(String[] args) {
		MainSchedulingView main = new MainSchedulingView(Login.loginedId);
	}
}
