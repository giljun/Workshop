import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3289 {

	static int N, M;
	static int[] nParent, nRank;
	static int op, first, second;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			nParent = new int[N + 1]; // 1 ~ n������ �ڿ���
			nRank = new int[N + 1];

			for (int i = 0; i < nParent.length; i++) { // ó�� �� ���Ҵ� �ڱ� �ڽ��� �θ�� ������ �ִ´�.
				nParent[i] = i;
				nRank[i] = 1;
			}

			
			for (int i = 0; i < M; i++) {
				op = sc.nextInt();
				first = sc.nextInt();
				second = sc.nextInt();

				if (op == 0) { // ������ ���� 0�� ������ ���, ù��° ���ҿ� �ι�° ���ҿ� ���� ������ ������ �����Ѵ�.
					union(first, second);
				} else {
					first = find(first); // ù��° ���ҿ� �ι�° ������ �θ� ��带 ã�Ƽ� ���Ѵ�.
					second = find(second);

					if (first == second) { // �θ� ������ ���� �����̶�� ���� �ǹ�
						result.add(1);
					} else {
						result.add(0);
					}
				}
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i));
			}
			System.out.println();
			result.clear();
		}
	}

	// ������ ����
	static void union(int x, int y) {
		// ù��° ���ҿ� �ι�° ������ �θ� ã�´�.
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (nRank[x] < nRank[y]) {
			int tmp = 0;
			tmp = x;
			x = y;
			y = tmp;
		}

		nParent[y] = x; // y�� x�� �̾���δ�.

		if (nRank[x] == nRank[y]) {
			nRank[x]++;
		}
	}

	static int find(int x) {
		if (x == nParent[x]) { // �ڱ� �ڽ��� �θ��� ���, �ڽ��� ���� ��ȯ���ش�.
			return x;
		} else {
			return nParent[x] = find(nParent[x]);
		}
	}

}
