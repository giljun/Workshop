package com.ssafy.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.CharConversionException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener {
	private JTextArea ta;
	private JTextField tf;
	private JButton bSend, bExit;
	private JPanel panel;
	private ChatConnect cc;

	public ChatClient() {
		
	}
	public ChatClient(String ip, int port, String name) {
		createGUI();
		cc = new ChatConnect(this, ip, port, name);
		cc.go();
	}

	public void createGUI() {
		ta = new JTextArea(10, 20);
		tf = new JTextField(20);
		bSend = new JButton("Send");
		bExit = new JButton("Exit");
		panel = new JPanel();

		// this : actionPerformed를 구현한 객체를 가리키는...
		tf.addActionListener(this);
		bSend.addActionListener(this);
		bExit.addActionListener(this);

		ta.setEditable(false);
		ta.setBackground(Color.LIGHT_GRAY);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(bSend);
		panel.add(bExit);

		add(panel, BorderLayout.LINE_END);
		add(new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		add(tf, BorderLayout.SOUTH);

		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void show(String input_msg) {
		ta.append(input_msg + "\n");
		tf.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bSend) {
			String input_msg = tf.getText();
			show(input_msg);
		} else if (e.getSource() == bExit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		ChatClient cl = new ChatClient("127.0.0.1", 5786, "박길준");
	}
}
