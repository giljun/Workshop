package com.ssafy.edu3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class WeatherMain {
	JFrame f = new JFrame("날씨 정보");
	JButton b = new JButton("날씨 부르기");
	JList li = new JList();
	WeatherDAO2 dao;

	public WeatherMain() {
		dao = new WeatherDAO2();
		createGUI();
		addEvent();
	}
	//이벤트
	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		java.util.List<Weather> datas = dao
				.getNewsList("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
		li.removeAll();
		li.setListData(datas.toArray());
	}
	// 화면 구현
	private void createGUI() {
		f.add(b, "North");
		f.add(li);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}

}
