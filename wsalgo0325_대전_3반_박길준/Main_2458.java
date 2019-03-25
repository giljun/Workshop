import java.io.IOException;
import java.util.Scanner;

public class Main_2458 {

	static int[][] matrix;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		matrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			matrix[a][b] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (matrix[i][k] == 1 && matrix[k][j] == 1) {
						matrix[i][j] = 1;
					}
				}
			}
		}

		result = 0;

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				if (matrix[i][j] == 1 || matrix[j][i] == 1) {
					cnt++;
				}
			}
			if (cnt == N - 1) {
				result++;
			}
		}

		System.out.println(result);
	}
}
