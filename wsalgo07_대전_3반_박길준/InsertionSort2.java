package ssafy0128;

import java.util.LinkedList;

public class InsertionSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// linked list 버전
		LinkedList<Integer> data = new LinkedList<>();

		for (int i = 0; i < 100; i++) {
			data.add((int) ((Math.random() * 120) + 1));
		}

		int len = data.size();
		for (int i = 0; i < len; i++) {
			System.out.print(data.get(i) + " ");
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

		// linked list - InsertionSort
		InsertionSort(data);

		for (int i = 0; i < len; i++) {
			System.out.print(data.get(i) + " ");
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
		}
	}

	public static void InsertionSort(LinkedList<Integer> data) {
		int len = data.size();
		int temp;

		for (int i = 0; i < len-1; i++) {
			if (data.get(i) > data.get(i + 1)) {
				for (int j = i+1; j >= 1; j--) {
					if (data.get(j) < data.get(j - 1)) {
						temp = data.get(j);
						data.set(j, data.get(j - 1));
						data.set(j - 1, temp);
					}
				}
			}
		}
	}

}
