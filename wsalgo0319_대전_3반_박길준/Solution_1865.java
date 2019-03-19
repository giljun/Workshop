import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static double max_result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			double[][] p = new double[N][N];

			visited = new boolean[N]; // 해당 직원이 작업을 했는지를 확인하는 BOOLEAN형 배열 선언

			for (int i = 0; i < p.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < p.length; j++) {
					p[i][j] = Double.parseDouble(st.nextToken()) * 0.01;
				}
			}

			// 입력완료.
			max_result = 0;

			DFS(0, N, p, 1);

			max_result = max_result * 100;

			System.out.printf("#%d %.6f\n", tc, max_result);
		}
	}

	static void DFS(int depth, int N, double[][] p, double tot) {
		if (tot <= max_result) {
			return;
		}

		if (depth == N) {
			max_result = Math.max(max_result, tot);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(depth + 1, N, p, tot * p[depth][i]);
				visited[i] = false;
			}
		}
	}
}
