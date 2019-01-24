package com.ssafy.server4;

import java.net.*;
import java.io.*;

public class Client {
	Socket s;
	BufferedReader br, br1;
	PrintWriter pw;
	String str;
	public void go(){
		try{
			s = new Socket("127.0.0.1",5463);
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);

			ClientThread ct = new ClientThread(s);
			ct.start();

			while ( ( str = br.readLine() ) != null ){
				pw.println(str);
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String [] args){
		System.out.println("Client");
		Client c = new Client();
		c.go();
	}
}

class ClientThread extends Thread{
	Socket s;
	BufferedReader br1;		
	String str;
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	public void run(){
		try{
			while ( ( str = br1.readLine() ) != null){
				System.out.println(str);
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
	
