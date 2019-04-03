import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_4013 {

	static int K;
	static int score;
	static int[][] magnetic;
	static boolean[] moved;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());

			// 1. �ǿ��� 8���� ���� �޸� 4���� �ڼ��� �����Ѵ�.
			magnetic = new int[5][8];
			moved = new boolean[5];

			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					// 2. 0�� ���, N�� and 1�� ���, S��
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 3. ȸ�� ��ų �ڼ��� ��ȣ�� ������ �Է¹޴´�. ( 1 : �ð����, -1 : �ݽð���� )
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int wise = Integer.parseInt(st.nextToken());

				move(num, wise);
				for (int j = 0; j < 5; j++) {
					moved[j] = false;
				}
			}

			result = (magnetic[1][0] * 1) + (magnetic[2][0] * 2) + (magnetic[3][0] * 4) + (magnetic[4][0] * 8);

			System.out.println("#" + tc + " " + result);
		}
	}

	static void move(int num, int wise) {
		moved[num] = true;

		// ������
		if (num < 4 && magnetic[num][2] != magnetic[num + 1][6] && !moved[num + 1]) {
			move(num + 1, -1 * wise);
		}

		// ����
		if (num > 1 && magnetic[num][6] != magnetic[num - 1][2] && !moved[num - 1]) {
			move(num - 1, -1 * wise);
		}
		rotate(num, wise);
	}

	static void rotate(int num, int wise) {
		// clockwise
		if (wise == 1) {
			int last = magnetic[num][7];
			for (int i = 7; i > 0; i--) {
				magnetic[num][i] = magnetic[num][i - 1];
			}
			magnetic[num][0] = last;
		} else { // counterclockwise
			int start = magnetic[num][0];
			for (int i = 0; i < 7; i++) {
				magnetic[num][i] = magnetic[num][i + 1];
			}
			magnetic[num][7] = start;
		}
	}
}
