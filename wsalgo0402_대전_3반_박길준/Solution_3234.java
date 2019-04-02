import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {

	static int N;
	static int[] weight;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			weight = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < weight.length; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			
			permutation(weight, 0);
			
			System.out.println("#" + tc + " " + result);
		}
	}

	static void dfs(int[] w, int depth, int left, int right) {
		if (depth == N) {
			result++;
			return;
		}
		if (left >= right + w[depth]) {
			dfs(w, depth + 1, left + w[depth], right);
			dfs(w, depth + 1, left, right + w[depth]);
		} else { //
			dfs(w, depth + 1, left + w[depth], right);
		}
	}

	static void permutation(int[] w, int p) {
		if (p == w.length) {
			dfs(w, 1, w[0], 0);
		}

		for (int i = p; i < w.length; i++) {
			swap(weight, p, i);
			permutation(w, p + 1);
			swap(weight, p, i);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = 0;

		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
