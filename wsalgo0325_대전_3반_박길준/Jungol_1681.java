import java.util.Scanner;

public class Jungol_1681 {

	static int N;
	static int[][] matrix;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		matrix = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		result = Integer.MAX_VALUE;

		int cost = 0;

		// 시작점은 항상 1부터 시작한다.
		dfs(1, cost, 0);

		System.out.println(result);
	}

	static void dfs(int i, int cost, int depth) {
		if (result < cost) {
			return;
		}
		// 종료조건
		if (depth == N - 1) {
			if (matrix[i][1] == 0) {
				return;
			}
			cost += matrix[i][1];

			if (result > cost) {
				result = cost;
			}
			return;
		}

		for (int j = 2; j <= N; j++) {
			if (!visited[j] && matrix[i][j] != 0) {
				visited[j] = true;
				dfs(j, cost + matrix[i][j], depth + 1);
				visited[j] = false;
			}
		}
	}
}
