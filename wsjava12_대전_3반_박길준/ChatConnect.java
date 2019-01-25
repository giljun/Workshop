package com.ssafy.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatConnect {
	private String ip;
	private int port;
	private String name;
	private Socket s;
	private BufferedReader br;
	private BufferedReader br2;
	private PrintWriter pw;
	private String str;
	private ChatClient cl; // frame
	
	public ChatConnect(ChatClient cl, String ip, int port, String name) {
		this.cl = cl;
		this.ip = ip;
		this.port = port;
		this.name = name;
	}
	
	public void go() {
		try {
			s = new Socket(ip, port);
			br = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력 받고
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true); // 입력받은거 전송해주고
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			
			ClientThread ct = new ClientThread(s);
			ct.start();
			
			while((str = br.readLine())!=null) {
				pw.println(str);
			}
			while((str = br2.readLine())!=null) {
				cl.show(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void send(String msg) {
//		
//	}
	
}

class ClientThread extends Thread{
	Socket s;
	BufferedReader br;
	String str;
	
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	public void run() {
		try {
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
