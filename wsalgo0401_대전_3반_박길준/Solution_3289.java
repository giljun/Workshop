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

			nParent = new int[N + 1]; // 1 ~ n이하의 자연수
			nRank = new int[N + 1];

			for (int i = 0; i < nParent.length; i++) { // 처음 각 원소는 자기 자신을 부모로 가지고 있는다.
				nParent[i] = i;
				nRank[i] = 1;
			}

			
			for (int i = 0; i < M; i++) {
				op = sc.nextInt();
				first = sc.nextInt();
				second = sc.nextInt();

				if (op == 0) { // 연산의 값이 0이 들어왔을 경우, 첫번째 원소와 두번째 원소에 대해 합집합 연산을 수행한다.
					union(first, second);
				} else {
					first = find(first); // 첫번째 원소와 두번째 원소의 부모 노드를 찾아서 비교한다.
					second = find(second);

					if (first == second) { // 부모가 같으면 같은 집합이라는 것을 의미
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

	// 합집합 연산
	static void union(int x, int y) {
		// 첫번째 원소와 두번째 원소의 부모를 찾는다.
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

		nParent[y] = x; // y를 x에 이어붙인다.

		if (nRank[x] == nRank[y]) {
			nRank[x]++;
		}
	}

	static int find(int x) {
		if (x == nParent[x]) { // 자기 자신이 부모인 경우, 자신의 값을 반환해준다.
			return x;
		} else {
			return nParent[x] = find(nParent[x]);
		}
	}

}
