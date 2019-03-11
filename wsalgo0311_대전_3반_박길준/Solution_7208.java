import java.util.Scanner;

public class Solution_7208 {

	static int N;
	static int[][] map;
	static int[] color;
	static int min;
	static int[] fill;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			color = new int[N];
			fill = new int[N];

			for (int i = 0; i < color.length; i++) {
				color[i] = sc.nextInt();
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			min = Integer.MAX_VALUE;
			
			dfs(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static boolean isOk() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && fill[i] == fill[j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void dfs(int cnt) {
		if (cnt == N) { // 뽑은 색깔의 갯수
			if (isOk()) { // 국가의 수만큼 뽑아놓은 색깔을 써도 괜찮은지 검사
				int tmp = 0; // 써도 되는 경우 몇개의 국가 색깔을 변경해야 하는지 계산
				for (int i = 0; i < N; i++) {
					if (color[i] != fill[i]) {
						tmp++;
					}
				}
				min = Math.min(tmp, min); // 예전에 계산해놓은 변경 횟수랑 비교해서 작은 카운트 선택
			}
			return;
		}

		for (int i = 1; i <= 4; i++) { // 사용가능한 색깔은 1번부터 4번까지임
			fill[cnt] = i;
			dfs(cnt + 1);
		}
	}
}
