package ssafy0128;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bArray = new int[10];

		for (int i = 0; i < bArray.length; i++) {
			bArray[i] = (int) (Math.random() * 15 + 1);
		}

		print(bArray);

		int max = 0;
		// 1. 배열에 저장된 값 중, 최대 정수를 구한다.
		for (int i = 0; i < bArray.length; i++) {
			if (max < bArray[i]) {
				max = bArray[i];
			}
		}

		// 2. 최대 정수를 이용해서, Counts배열 생성
		int[] counts = new int[max + 1];

		// 3. data에 저장된 각각의 값의 발생 회수를 세고, 그 값들을 counts배열에 저장한다.
		for (int i = 0; i < bArray.length; i++) {
			counts[bArray[i]]++;
		}

		print(counts);

		// 4. 정렬된 집합에서 각 항목의 앞에 위치할 항목의 개수를 반영하기 위해 counts의 원소를 조정한다.
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				for (int j = i; j >= 0; j--) {
					if (j != i && counts[j] != 0) {
						counts[i] += counts[j];
						break;
					}
				}
			}
		}

		print(counts);

		// 5. counts배열의 원소 값을 하나씩 지워가면서, 정렬을 수행한다.
		int[] temp = new int[10];

		for (int i = bArray.length-1; i >= 0; i--) {
			for (int j = 0; j < counts.length; j++) {
				if (bArray[i] == j) {
					temp[counts[j]-1] = bArray[i];
					counts[j]--;
				}
			}
		}
		
		print(temp);

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
