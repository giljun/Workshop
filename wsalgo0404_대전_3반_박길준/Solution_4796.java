import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_4796 {

	static int result;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// n : ���� ������ ����
			N = sc.nextInt();

			// n���� �迭�� �����ϰ�, �־��� �����͸� �Է¹޴´�.
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// �迭�� �� ���� �����ϰ�, �˻����.
			int left_cnt, right_cnt;
			left_cnt = right_cnt = 0;
			result = 0;

			for (int index = 0; index < arr.length - 1;) {
				if (arr[index] < arr[index + 1]) {
					left_cnt++;
					index++;
				} else {
					while (index < arr.length - 1) {
						if (arr[index] > arr[index + 1]) {
							right_cnt++;
							index++;
						} else {

							break;
						}
					}
					if (left_cnt != 0 && right_cnt != 0) {
						result += left_cnt * right_cnt;
					}
					left_cnt = 0;
					right_cnt = 0;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}