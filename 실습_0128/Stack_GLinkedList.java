package ssafy0128;

import java.util.Stack;

public class Stack_GLinkedList<T> {
	private Node<T> top;

	public Stack_GLinkedList() {
		top = new Node(null); // top 노드는 스택에 push될때 맨 위 노드의 주소만 저장하면 됨.
		// 현재 top.next 에는 null이 저장되어 있음. 즉 스택에 아무도 없음.
	}

	public void push(T data) {
		Node<T> newNode = new Node<>(data);

		if (isEmpty()) {
			top.next = newNode;
		} else {
			newNode.next = top.next;
			top.next = newNode;
		}
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			Node<T> temp;
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

	private class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_GLinkedList<Integer> stgl = new Stack_GLinkedList<>();
		Stack_GLinkedList<Character> stgl2 = new Stack_GLinkedList<>();

		stgl.push(1);
		stgl.push(2);
		stgl.push(3);
		System.out.println(stgl.pop());
		System.out.println(stgl.pop());
		System.out.println(stgl.isEmpty());
		stgl.push(4);
		stgl.push(5);
		System.out.println(stgl.pop());
		System.out.println(stgl.pop());
		System.out.println(stgl.pop());
		System.out.println(stgl.isEmpty());

		stgl2.push('a');
		stgl2.push('b');
		stgl2.push('c');
		System.out.println(stgl2.pop());
		System.out.println(stgl2.pop());
		System.out.println(stgl2.isEmpty());
		stgl2.push('d');
		stgl2.push('e');
		System.out.println(stgl2.pop());
		System.out.println(stgl2.pop());
		System.out.println(stgl2.pop());
		System.out.println(stgl2.isEmpty());
	}

}
