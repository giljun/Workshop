package com.ssafy;

import com.ssafy.BinaryTreeY.TreeNode;

// 2. 이진탐색트리( Binary Search Tree) 구현하기 - 탐색, 삽입 필수, 삭제 선택 
public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	// 삽입기능 구현
	// 1. 선탐색 후, 탐색을 성공하면 삽입 연산을 수행하지 않는다.
	// 2. 탐색을 실패하면 해당 노드의 위치에 원소가 없는 것이므로 그 자리에 원소를 삽입한다.
	public TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		} else if (root.data > data) {
			root.left = insert(root.left, data);
		} else if (root.data < data) {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	// 탐색 기능 구현.
	// 탐색은 항상 루트 노드에서 시작한다.
	private void search(TreeNode root, int data) {
		if (root == null) {
			System.out.println("탐색 실패!! 찾으시는 값이 없습니다.");
		} else {
			if (root.data == data) {
				System.out.println("탐색 성공 : " + root.data);
			} else if (root.data > data) {
				search(root.left, data);
			} else if (root.data < data) {
				search(root.right, data);
			}
		}
	}

	private void search(int data) {
		search(root, data);
	}

	private void print(TreeNode parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.data + " ");
		print(parent.left);
		print(parent.right);
	}

	private void print() {
		if (root != null) {
			print(root);
		}
	}

	// 이진탐색트리를 구성하는 트리노드 클래스 구현
	class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;

		public TreeNode(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// 2 3 5 8 10 14 11 16
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(8);
		bst.insert(3);
		bst.insert(2);
		bst.insert(5);
		bst.insert(10);
		bst.insert(14);
		bst.insert(11);
		bst.insert(16);

		bst.search(8);
		bst.search(3);
		bst.search(4);
		
		System.out.println("------전위순회-------");
		bst.print();
	}

}
