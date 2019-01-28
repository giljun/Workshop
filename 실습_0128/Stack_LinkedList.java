package ssafy0128;

import javax.xml.soap.Node;

// 연결 리스트 구조를 활용한 스택 구현해보기
public class Stack_LinkedList {
	private Node top;

	public Stack_LinkedList() {
		top = new Node(0); // top 노드는 스택에 push될때 맨 위 노드의 주소만 저장하면 됨.
		// 현재 top.next 에는 null이 저장되어 있음. 즉 스택에 아무도 없음.
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			top.next = newNode;
		} else {
			newNode.next = top.next;
			top.next = newNode;
		}
	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			Node temp;
			temp = top.next;
			top.next = temp.next;
			return temp.data;
		}
	}

	public boolean isEmpty() {
		if (top.next == null) {
			return true;
		} else {
			return false;
		}
	}

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		Stack_LinkedList stl = new Stack_LinkedList();

		stl.push(1);
		stl.push(2);
		stl.push(3);
		System.out.println(stl.pop());
		System.out.println(stl.pop());
		System.out.println(stl.isEmpty());
		stl.push(4);
		stl.push(5);
		System.out.println(stl.pop());
		System.out.println(stl.pop());
		System.out.println(stl.pop());
		System.out.println(stl.isEmpty());
	}
}
