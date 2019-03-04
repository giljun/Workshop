import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] matrix = new int[N][N];

			for (int i = 0; i < matrix.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 입출력 테스트 완료.

			ArrayList<Point> result = new ArrayList<>();
			int col, row;

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] != 0 && matrix[i][j] != -1) {
						col = col_search(i, j, matrix);
						row = row_search(i, j, matrix);
						result.add(new Point(col, row));
						erase_matrix(i, j, col, row, matrix);
					} else {
						continue;
					}
				}
			}

			result.sort(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					if (o1.col * o1.row > o2.col * o2.row) {
						return 1;
					} else if (o1.col * o1.row < o2.col * o2.row) {
						return -1;
					} else {
						if (o1.row < o2.row) {
							return 1;
						} else {
							return -1;
						}
					}
				}
			});

			System.out.print("#" + tc + " " + result.size());
			for (int i = 0; i < result.size(); i++) {
				System.out.print(" " + result.get(i).col + " " + result.get(i).row);
			}
			System.out.println();
		}
	}

	static void erase_matrix(int i, int j, int col, int row, int[][] m) {
		for (int k = i; k < i + col; k++) {
			for (int l = j; l < j + row; l++) {
				m[k][l] = -1;
			}
		}
	}

	static int col_search(int col, int row, int[][] m) {
		int count = 1;
		for (int i = col; i < m.length; i++) {
			if (i + 1 < m.length && m[i + 1][row] != 0) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	static int row_search(int col, int row, int[][] m) {
		int count = 1;
		for (int i = row; i < m.length; i++) {
			if (i + 1 < m.length && m[col][i + 1] != 0) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

	static class Point {
		int col;
		int row;

		Point(int c, int r) {
			col = c;
			row = r;
		}
	}
}