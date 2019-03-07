import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7234 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 행렬은 1부터 시작할 것이므로, n+1
			int[][] map = new int[N + 1][N + 1];
			Bunker[] bunkers = new Bunker[B];
			for (int i = 0; i < B; i++) {
				st = new StringTokenizer(br.readLine());
				bunkers[i] = new Bunker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				if (bunkers[i].x - 1 >= 1) {
					map[bunkers[i].x - 1][bunkers[i].y] += 1;
				}
				if (bunkers[i].x - 2 >= 1) {
					map[bunkers[i].x - 2][bunkers[i].y] += 1;
				}
				if (bunkers[i].x + 1 < map.length) {
					map[bunkers[i].x + 1][bunkers[i].y] += 1;
				}
				if (bunkers[i].x + 2 < map.length) {
					map[bunkers[i].x + 2][bunkers[i].y] += 1;
				}
				if (bunkers[i].y - 1 >= 1) {
					map[bunkers[i].x][bunkers[i].y - 1] += 1;
				}
				if (bunkers[i].y - 2 >= 1) {
					map[bunkers[i].x][bunkers[i].y - 2] += 1;
				}
				if (bunkers[i].y + 1 < map.length) {
					map[bunkers[i].x][bunkers[i].y + 1] += 1;
				}
				if (bunkers[i].y + 2 < map.length) {
					map[bunkers[i].x][bunkers[i].y + 2] += 1;
				}
			}
			
			int max_count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if( max_count < map[i][j]) {
						max_count = map[i][j];
					}
				}
			}
			
			System.out.println("#"+tc+" "+max_count);
		}
	}

	static class Bunker {
		int x;
		int y;

		Bunker(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
