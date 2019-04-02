import java.util.Scanner;

public class Solution_4014 {

	static int[][] map;
	static int X;
	static boolean[][] installed;
	static int no;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			X = sc.nextInt();

			map = new int[N][N];
			installed = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			no = 0;

			for (int i = 0; i < N; i++) {
				// 1. ���ΰ˻�
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] - map[i][j + 1] == 1) { // ���� ��ġ���� ���� ������ ���
						int cnt = 1;
						for (int k = 0; k < X - 1; k++) { // ������ ���̸�ŭ
							int y = (j + 1) + k;
							int num = j + 1;
							if (y < map.length && !installed[i][y] && y + 1 < map.length && !installed[i][y + 1]
									&& map[i][num] == map[i][y + 1]) {
								cnt++;
								installed[i][y] = true;
								installed[i][y + 1] = true;
							}
							if (k < X - 2 && y < map.length - 1) {
								if (installed[i][y + 1] == true) {
									installed[i][y + 1] = false;
								}
							}
						}
						if (cnt < X) { // �ȵǴ� ���, no�� ���� ����� 1���������ش�.
							no++;
							break;
						}
					} else if (map[i][j] - map[i][j + 1] == -1) {
						int cnt = 1;
						for (int k = 0; k < X - 1; k++) { // ������ ���̸�ŭ
							int y = j - k;
							int num = j;
							if (y >= 0 && !installed[i][y] && y - 1 >= 0 && !installed[i][y - 1]
									&& map[i][num] == map[i][y - 1]) {
								cnt++;
								installed[i][y - 1] = true;
							}
							if (k < X - 2 && y >= 1) {
								if (installed[i][y - 1] == true) {
									installed[i][y - 1] = false;
								}
							}
						}
						if (cnt < X) { // �ȵǴ� ���, no�� ���� ����� 1���������ش�.
							no++;
							break;
						}
					} else if (map[i][j] - map[i][j + 1] > 1 || map[i][j] - map[i][j + 1] < -1) {
						no++;
						break;
					}
				}

				// ���� �ߺ���ġ�� ���� �˻� boolean�� �迭 �ʱ�ȭ
				for (int j = 0; j < installed.length; j++) {
					installed[i][j] = false;
				}

				// 1. ���ΰ˻�
				for (int j = 0; j < N - 1; j++) {
					if (map[j][i] - map[j + 1][i] == 1) { // ���� ��ġ���� ���� ������ ���
						int cnt = 1;
						for (int k = 0; k < X - 1; k++) { // ������ ���̸�ŭ
							int y = (j + 1) + k;
							int num = j + 1;
							if (y < map.length && !installed[y][i] && y + 1 < map.length && !installed[y + 1][i]
									&& map[num][i] == map[y + 1][i]) {
								cnt++;
								installed[y + 1][i] = true;
							}
							if (k < X - 2 && y < map.length - 1) {
								if (installed[y + 1][i] == true) {
									installed[y + 1][i] = false;
								}
							}
						}
						if (cnt < X) { // �ȵǴ� ���, no�� ���� ����� 1���������ش�.
							no++;
							break;
						}
					} else if (map[j][i] - map[j + 1][i] == -1) {
						int cnt = 1;
						for (int k = 0; k < X - 1; k++) { // ������ ���̸�ŭ
							int y = j - k;
							int num = j;
							if (y >= 0 && !installed[y][i] && y - 1 >= 0 && !installed[y - 1][i]
									&& map[num][i] == map[y - 1][i]) {
								cnt++;
								installed[y - 1][i] = true;
							}
							if (k < X - 2 && y >= 1) {
								if (installed[y - 1][i] == true) {
									installed[y - 1][i] = false;
								}
							}
						}
						if (cnt < X) { // �ȵǴ� ���, no�� ���� ����� 1���������ش�.
							no++;
							break;
						}
					} else if (map[j][i] - map[j + 1][i] > 1 || map[j][i] - map[j + 1][i] < -1) {
						no++;
						break;
					}
				}

				// ���� �ߺ���ġ�� ���� �˻� boolean�� �迭 �ʱ�ȭ
				for (int j = 0; j < installed.length; j++) {
					installed[j][i] = false;
				}
			}

			System.out.println("#" + tc + " " + ((2 * N) - no));
		}
	}

}
