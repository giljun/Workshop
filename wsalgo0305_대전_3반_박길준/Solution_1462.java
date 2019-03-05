import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1462 {

	static int row, col;
	static char[][] land;
	static boolean[][] visit;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_data = br.readLine().trim().split(" ");

		row = Integer.parseInt(input_data[0]);
		col = Integer.parseInt(input_data[1]);

		String mData = "";
		land = new char[row][col];
		visit = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			mData = br.readLine();
			for (int j = 0; j < col; j++) {
				land[i][j] = mData.charAt(j);
			}
		}

		int distance = 0;
		int res = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (land[i][j] != 'W') {
					distance = bfs(i, j);
				}
				if (distance > res) {
					res = distance;
				}
			}
		}
		System.out.println(res);
	}

	public static int bfs(int i, int j) { // 세로, 가로

		initVisit();

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j));

		// i, j지점의 노드를 방문.
		visit[i][j] = true;

		int count = -1;
		int queue_size = 0;
		while (!queue.isEmpty()) {
			count++;
			queue_size = queue.size();

			for (int k = 0; k < queue_size; k++) {
				Node pos = queue.poll();
				for (int l = 0; l < 4; l++) {
					int y = pos.y + dy[l]; // 세로
					int x = pos.x + dx[l]; // 가로
					if (x >= 0 && x < col && y >= 0 && y < row && land[y][x] == 'L' && !visit[y][x]) {
						queue.add(new Node(y, x));
						visit[y][x] = true;
					}
				}
			}
		}
		return count;
	}

	public static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void initVisit() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visit[i][j] = false;
			}
		}
	}
}
