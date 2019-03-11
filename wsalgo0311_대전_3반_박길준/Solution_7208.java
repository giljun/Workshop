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
		if (cnt == N) { // ���� ������ ����
			if (isOk()) { // ������ ����ŭ �̾Ƴ��� ������ �ᵵ �������� �˻�
				int tmp = 0; // �ᵵ �Ǵ� ��� ��� ���� ������ �����ؾ� �ϴ��� ���
				for (int i = 0; i < N; i++) {
					if (color[i] != fill[i]) {
						tmp++;
					}
				}
				min = Math.min(tmp, min); // ������ ����س��� ���� Ƚ���� ���ؼ� ���� ī��Ʈ ����
			}
			return;
		}

		for (int i = 1; i <= 4; i++) { // ��밡���� ������ 1������ 4��������
			fill[cnt] = i;
			dfs(cnt + 1);
		}
	}
}
