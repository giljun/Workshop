package com.ssafy.server4;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public Server(){
		v = new Vector<>(10,10);
	}
	public synchronized void addThread(ServerThread st){
		v.add(st); // vector는 생략해도 상관없지만, arraylist의 경우 반드시, 동기화 키워드 사용해야된다.
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);
	}
	public synchronized void broadcast(String str){
		for ( int i = 0 ; i < v.size() ; i++ ){
			ServerThread st1 = v.get(i); // 10명을 보장해줄 것이다.
			st1.sendMessage(str);
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5436);
			ss.setReuseAddress(true);
			System.out.println("1. Ready");
			while ( true ){
				s = ss.accept();
				ServerThread st = new ServerThread(this, s); // this 자체를 넘겨주면, server 클래스 안에 있는 모든 것들에 접근 할 수 있다.
				this.addThread(st);
				st.start();
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		Server server = new Server();
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	Server server;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server; // 서버에 있는 방을 사용하기 위해.
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		System.out.println(s.getInetAddress()+"가 붙음");
	}
	public void sendMessage(String string){
		pw.println(string);
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){
				server.broadcast(str);
			}
		}catch (IOException e){
			System.out.println(s.getInetAddress()+"가 닫힘");
			server.removeThread(this);
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
