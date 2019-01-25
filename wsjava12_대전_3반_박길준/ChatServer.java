package com.ssafy.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket ss;
	Socket s;
	ArrayList<ServerThread> list;
	private int port = 5786;

	public ChatServer() {
		list = new ArrayList<>();
	}

	public void addThread(ServerThread st) {
		list.add(st);
	}

	public void removeClient(ServerThread st) {
		list.remove(st);
	}

	public void broadcast(String str) {
		for (int i = 0; i < list.size(); i++) {
			ServerThread st1 = list.get(i);
			try {
				st1.send(str);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public void go() {
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			System.out.println("1. ready");
			while (true) {
				s = ss.accept();
				ServerThread st = new ServerThread(this, s);
				this.addThread(st);
				st.start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.go();
	}

}

class ServerThread extends Thread {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	ChatServer server;

	public ServerThread(ChatServer server, Socket s) throws IOException {
		this.server = server;
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
		System.out.println(s.getInetAddress() + "가 붙음");
	}

	public void send(String msg) throws IOException {
		pw.println(msg);
	}

	public void run() {
		try {
			while ((str = br.readLine()) != null) {
				server.broadcast(str);
			}
		} catch (IOException e) {
			System.out.println(s.getInetAddress() + "가 닫힘");
			server.removeClient(this);
			try {
				s.close();
			} catch (IOException e1) {
			}
		}
	}
}
