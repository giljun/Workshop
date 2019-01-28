package ssafy0128;

public class MergeSort {
	// 재귀를 반복하면서 가장 작은 부분집합으로 쪼개질때까지 나누기 작업 전담하는 메소드
	static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2; // 두 부분으로 쪼갤 중간 인덱스 구하고

			sort(arr, left, middle); // 왼쪽 부분
			sort(arr, middle + 1, right); // 오른쪽 부분

			// 부분이 나눠졌으면 두 부분집합을 병합하는 작업을 할 차례
			merge(arr, left, middle, right);
		}
	}

	// 나눠진 부분집합 두개를 병합해서 점차 큰 집합을 만들어 가는 메소드
	static void merge(int[] arr, int left, int middle, int right) {
		int leftSize = middle - left + 1; // 병합할 왼쪽 부분집합의 크기 계산
		int rightSize = right - middle; // 병합할 오른쪽 부분집합의 크기 계산

		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];

		// 원본 arr에서 일단 두 부분집합 각각 복사해보기
		for (int i = 0; i < leftSize; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int i = 0; i < rightSize; i++) {
			rightArr[i] = arr[middle + i + 1];
		}

		int left_i = 0, right_i = 0; // 두 부분집합에서 각각 원소 빼내서 병합 배열 만들 예정이라 그때 사용할 인덱스 변수
		int arr_i = left; // 두 집합 중에서 원소를 하나 빼서 원본 arr의 left부터 채워넣으면 됨.
		
		while(left_i < leftSize && right_i < rightSize) {
			if(leftArr[left_i] < rightArr[right_i]) {
				arr[arr_i] = leftArr[left_i];
				left_i++;
			} else {
				arr[arr_i] = rightArr[right_i];
				right_i++;
			}
			arr_i++;
		}
		// 왼쪽 부분집합에 숫자가 남아있다면 어차피 정렬된 큰 숫자들이니 결과배열에 순차적으로 넣기
		while(left_i < leftSize) { 
			arr[arr_i] = leftArr[left_i];
			arr_i++;
			left_i++;
		}
		// 오른쪽 부분집합에 숫자가 남아있다면 어차피 정렬된 큰 숫자들이니 결과배열에 순차적으로 넣기
		while(right_i < rightSize) {
			arr[arr_i] = rightArr[right_i];
			arr_i++;
			right_i++;
		}
	}

	public static void main(String[] args) {

	}

}
