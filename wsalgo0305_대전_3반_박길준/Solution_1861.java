import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861 {

	static int[] dx = { 0, 1, 0, -1 }; // 시계방향. 상 좌 하 우
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] room;
	static Player res;
	static Player max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			room = new int[N][N];

			for (int i = 0; i < room.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < room.length; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			res = new Player(0, 0);
			max = new Player(0, 0);

			for (int i = 0; i < room.length; i++) {
				for (int j = 0; j < room.length; j++) {
					res.start = room[i][j];
					res.count = 1;
					dfs(i, j);
				}
			}

			System.out.println("#" + tc + " " + max.start + " " + max.count);
		}
	}

	static void dfs(int i, int j) {
		int cnt = 0;
		for (int r = 0; r < 4; r++) {
			if (i + dy[r] >= 0 && i + dy[r] < room.length && j + dx[r] >= 0 && j + dx[r] < room.length
					&& room[i + dy[r]][j + dx[r]] - room[i][j] == 1) {
				res.count++;
				dfs(i + dy[r], j + dx[r]);
			} else {
				cnt++;
			}
		}
		if (cnt == 3) { // 반복문을 다 돌렸는데, 이동할 곳이 없다는 것을 의미한다.
			if (res.count > max.count) {
				max.start = res.start;
				max.count = res.count;
			} else if (res.count == max.count) {
				if (res.start < max.start) {
					max.start = res.start;
					max.count = res.count;
				}
			}
		}
	}

	static class Player {
		int start;
		int count;

		Player(int s, int c) {
			start = s;
			count = c;
		}
	}
}
