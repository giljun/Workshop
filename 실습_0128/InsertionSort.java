package ssafy0128;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array 버젼

		int[] data = new int[100];
		int[] result_data = new int[100];

		for (int i = 0; i < data.length; i++) {
			data[i] = (int) ((Math.random() * 120) + 1);
		}

		for (int i = 0; i < result_data.length; i++) {
			System.out.print(data[i] + " ");
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

		result_data = InsertionSort(data);

		for (int i = 0; i < result_data.length; i++) {
			System.out.print(result_data[i] + " ");
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
		}
	}

	public static int[] InsertionSort(int[] data) {
		int temp;
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) {
				for (int j = 0; j < i; j++) {
					if (data[j] > data[i + 1]) {
						temp = data[j];
						data[j] = data[i + 1];
						data[i + 1] = temp;
					}
				}
			}
		}
		return data;
	}

	public static void swap(int n1, int n2) {
		int temp;
		temp = n1;
		n1 = n2;
		n2 = temp;
	}
}
