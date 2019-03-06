import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493 {

	static Node p, q;
	static int[][] board;
	static Node result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		board = new int[1000][1000];
		initBoard();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			p = new Node(0, 0, Integer.parseInt(st.nextToken()));
			q = new Node(0, 0, Integer.parseInt(st.nextToken()));

			int count = 0;
			result = new Node(0, 0, 0);
			for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board.length; j++) {
					if (p.value == board[i][j]) {
						p.y = j;
						p.x = i;
						count++;
					}
					if (q.value == board[i][j]) {
						q.y = j;
						q.x = i;
						count++;
					}
					if (count == 2) {
						result.x = p.x + q.x;
						result.y = p.y + q.y;
						result.value = board[result.x][result.y];
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + result.value);
		}
	}

	static void initBoard() {
		int count = 1;
		// yÃà
		for (int i = 1; i < board.length; i++) {
			int y_index = i;
			// xÃà
			for (int j = 1; j <= i; j++) {
				int x_index = 0;
				board[j + x_index][y_index] = count;
				count++;
				x_index++;
				y_index--;
			}
		}
	}

	static class Node {
		int x;
		int y;
		int value;

		Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.value = v;
		}
	}
}
