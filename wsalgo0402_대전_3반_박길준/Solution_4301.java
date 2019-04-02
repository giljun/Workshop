import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301 {

	static int row, col;
	static int[][] map;
	static int[] dx = { -2, 0, 2, 0 };
	static int[] dy = { 0, 2, 0, -2 };
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			map = new int[row][col];

			result = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 0) {
						result++;
						for (int k = 0; k < 4; k++) {
							if (i + dx[k] >= 0 && i + dx[k] < row && j + dy[k] >= 0 && j + dy[k] < col
									&& map[i + dx[k]][j + dy[k]] == 0) {
								map[i + dx[k]][j + dy[k]] = 1;
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

}
