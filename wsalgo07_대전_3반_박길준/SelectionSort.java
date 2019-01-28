package ssafy0128;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bArray = new int[10];

		for (int i = 0; i < bArray.length; i++) {
			bArray[i] = (int) (Math.random() * 15 + 1);
		}

		print(bArray);

		// 1. 최소값을 구하고, 리스트의 맨 앞에 위치한 값과 교환한다.
		int min = 100;
		int min_i = 0;
		int temp = 0;

		for (int i = 0; i < bArray.length; i++) {
			for (int j = i; j < bArray.length; j++) {
				if (min > bArray[j]) {
					min = bArray[j]; // 인덱스를 저장한다.
					min_i = j;
				}
			}
			temp = bArray[i];
			bArray[i] = bArray[min_i];
			bArray[min_i] = temp;
			min = 100;
		}

		print(bArray);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
