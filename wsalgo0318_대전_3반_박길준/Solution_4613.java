import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution {

	static int N, M;
	static String[][] map;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new String[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.substring(j, j + 1);
				}
			}

			result = Integer.MAX_VALUE;

			for (int i = 1; i < N - 1; i++) {
				int second = N - i;
				for (int j = 1; j < second; j++) {
					int third = second - j;
//					System.out.println(i + " " + j + " " + third);
					int count = solve(i, j, third);
					if (result > count) {
						result = count;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	static int solve(int first, int second, int third) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			if (i < first) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j].equals("W")) {
						count++;
					}
				}
			} else if (i >= first && i < first+second) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j].equals("B")) {
						count++;
					}
				}
			} else {
				for (int j = 0; j < M; j++) {
					if (!map[i][j].equals("R")) {
						count++;
					}
				}
			}
		}

		return count;
	}
}
