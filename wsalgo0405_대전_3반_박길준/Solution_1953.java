import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Tunnel> queue;
	// 상, 우, 하, 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			queue = new LinkedList<Tunnel>();

			bfs(queue, R, C, 1);

			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == true) {
						result++;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	static void bfs(Queue<Tunnel> queue, int r, int c, int time) {
		// 초기 위치를 큐에 담는다.
		queue.add(new Tunnel(map[r][c], r, c));
		visited[r][c] = true;

		while (time < L) {

			time++;

			int cnt_tunnel = queue.size();

			for (int i = 0; i < cnt_tunnel; i++) {
				Tunnel t = queue.poll();

				switch (t.num) {
				case 1:
					// 상, 우, 하, 좌
					for (int j = 0; j < 4; j++) {
						if (t.row + dx[j] >= 0 && t.row + dx[j] < N && t.col + dy[j] >= 0 && t.col + dy[j] < M
								&& map[t.row + dx[j]][t.col + dy[j]] != 0 && !visited[t.row + dx[j]][t.col + dy[j]]) {
							if (j == 0) {
								if (map[t.row + dx[j]][t.col + dy[j]] == 1 || map[t.row + dx[j]][t.col + dy[j]] == 2
										|| map[t.row + dx[j]][t.col + dy[j]] == 5
										|| map[t.row + dx[j]][t.col + dy[j]] == 6) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 1) {
								if (j == 1 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 3
										|| map[t.row + dx[j]][t.col + dy[j]] == 6
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 2) {
								if (j == 2 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 2
										|| map[t.row + dx[j]][t.col + dy[j]] == 4
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 3) {
								if (j == 3 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 3
										|| map[t.row + dx[j]][t.col + dy[j]] == 4
										|| map[t.row + dx[j]][t.col + dy[j]] == 5) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							}
						}
					}
					break;
				case 2:
					// 상, 하
					for (int j = 0; j < 2; j++) {
						if (t.row + dx[j * 2] >= 0 && t.row + dx[j * 2] < N && map[t.row + dx[j * 2]][t.col] != 0
								&& !visited[t.row + dx[j * 2]][t.col]) {
							if (j == 0) {
								if (map[t.row + dx[j * 2]][t.col] == 1 || map[t.row + dx[j * 2]][t.col] == 2
										|| map[t.row + dx[j * 2]][t.col] == 5 || map[t.row + dx[j * 2]][t.col] == 6) {
									visited[t.row + dx[j * 2]][t.col] = true;
									queue.add(new Tunnel(map[t.row + dx[j * 2]][t.col], t.row + dx[j * 2], t.col));
								}
							} else if (j == 1) {
								if (map[t.row + dx[j * 2]][t.col] == 1 || map[t.row + dx[j * 2]][t.col] == 2
										|| map[t.row + dx[j * 2]][t.col] == 4 || map[t.row + dx[j * 2]][t.col] == 7) {
									visited[t.row + dx[j * 2]][t.col] = true;
									queue.add(new Tunnel(map[t.row + dx[j * 2]][t.col], t.row + dx[j * 2], t.col));
								}
							}
						}
					}
					break;
				case 3:
					// 우, 좌
					for (int j = 0; j < 2; j++) {
						if (t.col + dy[(2 * j) + 1] >= 0 && t.col + dy[(2 * j) + 1] < M
								&& map[t.row][t.col + dy[(2 * j) + 1]] != 0
								&& !visited[t.row][t.col + dy[(2 * j) + 1]]) {
							if (j == 0) {
								if (map[t.row][t.col + dy[(2 * j) + 1]] == 1 || map[t.row][t.col + dy[(2 * j) + 1]] == 3
										|| map[t.row][t.col + dy[(2 * j) + 1]] == 6
										|| map[t.row][t.col + dy[(2 * j) + 1]] == 7) {
									visited[t.row][t.col + dy[(2 * j) + 1]] = true;
									queue.add(new Tunnel(map[t.row][t.col + dy[(2 * j) + 1]], t.row,
											t.col + dy[(2 * j) + 1]));
								}
							} else if (j == 1) {
								if (j == 1 && map[t.row][t.col + dy[(2 * j) + 1]] == 1
										|| map[t.row][t.col + dy[(2 * j) + 1]] == 3
										|| map[t.row][t.col + dy[(2 * j) + 1]] == 4
										|| map[t.row][t.col + dy[(2 * j) + 1]] == 5) {
									visited[t.row][t.col + dy[(2 * j) + 1]] = true;
									queue.add(new Tunnel(map[t.row][t.col + dy[(2 * j) + 1]], t.row,
											t.col + dy[(2 * j) + 1]));
								}
							}
						}
					}
					break;
				case 4:
					// 상, 우
					for (int j = 0; j < 2; j++) {
						if (t.row + dx[j] >= 0 && t.row + dx[j] < N && t.col + dy[j] >= 0 && t.col + dy[j] < M
								&& map[t.row + dx[j]][t.col + dy[j]] != 0 && !visited[t.row + dx[j]][t.col + dy[j]]) {
							if (j == 0) {
								if (map[t.row + dx[j]][t.col + dy[j]] == 1 || map[t.row + dx[j]][t.col + dy[j]] == 2
										|| map[t.row + dx[j]][t.col + dy[j]] == 5
										|| map[t.row + dx[j]][t.col + dy[j]] == 6) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 1) {
								if (j == 1 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 3
										|| map[t.row + dx[j]][t.col + dy[j]] == 6
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							}
						}
					}
					break;
				case 5:
					// 우, 하
					for (int j = 1; j < 3; j++) {
						if (t.row + dx[j] >= 0 && t.row + dx[j] < N && t.col + dy[j] >= 0 && t.col + dy[j] < M
								&& map[t.row + dx[j]][t.col + dy[j]] != 0 && !visited[t.row + dx[j]][t.col + dy[j]]) {
							if (j == 1) {
								if (j == 1 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 3
										|| map[t.row + dx[j]][t.col + dy[j]] == 6
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 2) {
								if (j == 2 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 2
										|| map[t.row + dx[j]][t.col + dy[j]] == 4
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							}
						}
					}
					break;
				case 6:
					// 하, 좌
					for (int j = 2; j < 4; j++) {
						if (t.row + dx[j] >= 0 && t.row + dx[j] < N && t.col + dy[j] >= 0 && t.col + dy[j] < M
								&& map[t.row + dx[j]][t.col + dy[j]] != 0 && !visited[t.row + dx[j]][t.col + dy[j]]) {
							if (j == 2) {
								if (j == 2 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 2
										|| map[t.row + dx[j]][t.col + dy[j]] == 4
										|| map[t.row + dx[j]][t.col + dy[j]] == 7) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							} else if (j == 3) {
								if (j == 3 && map[t.row + dx[j]][t.col + dy[j]] == 1
										|| map[t.row + dx[j]][t.col + dy[j]] == 3
										|| map[t.row + dx[j]][t.col + dy[j]] == 4
										|| map[t.row + dx[j]][t.col + dy[j]] == 5) {
									visited[t.row + dx[j]][t.col + dy[j]] = true;
									queue.add(new Tunnel(map[t.row + dx[j]][t.col + dy[j]], t.row + dx[j],
											t.col + dy[j]));
								}
							}
						}
					}
					break;
				case 7:
					// 상, 좌
					for (int j = 0; j < 2; j++) {
						if (t.row + dx[j * 3] >= 0 && t.row + dx[j * 3] < N && t.col + dy[j * 3] >= 0
								&& t.col + dy[j * 3] < M && map[t.row + dx[j * 3]][t.col + dy[j * 3]] != 0
								&& !visited[t.row + dx[j * 3]][t.col + dy[j * 3]]) {
							if (j == 0) {
								if (j == 0 && map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 1
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 2
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 5
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 6) {
									visited[t.row + dx[j * 3]][t.col + dy[j * 3]] = true;
									queue.add(new Tunnel(map[t.row + dx[j * 3]][t.col + dy[j * 3]], t.row + dx[j * 3],
											t.col + dy[j * 3]));
								}
							} else if (j == 1) {
								if (j == 1 && map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 1
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 3
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 4
										|| map[t.row + dx[j * 3]][t.col + dy[j * 3]] == 5) {
									visited[t.row + dx[j * 3]][t.col + dy[j * 3]] = true;
									queue.add(new Tunnel(map[t.row + dx[j * 3]][t.col + dy[j * 3]], t.row + dx[j * 3],
											t.col + dy[j * 3]));
								}
							}
						}
					}
					break;
				}
			}
		}
	}

	static class Tunnel {
		int num;
		int row;
		int col;

		Tunnel(int n, int r, int c) {
			num = n;
			row = r;
			col = c;
		}
	}

}
