import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T = 10;
	static int N, S;
	static int[][] mContact;
	static ArrayList<Contact> contacts;
	static boolean[] contacted;
	static Queue<Integer> queue;
	static int max_value;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			mContact = new int[N + 1][N + 1];
			contacted = new boolean[N + 1];
			contacts = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				contacts.add(new Contact(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// ������� ����
			for (int i = 0; i < contacts.size(); i++) {
				int from = contacts.get(i).num;
				int to = contacts.get(i).to;
				mContact[from][to] = 1;
			}

			queue = new LinkedList<>();

			// ���� �������� ť�� �ִ´�.
			queue.add(S);
			contacted[S] = true;

			while (!queue.isEmpty()) {
				int cnt = queue.size();
				max_value = 0;
				for (int i = 0; i < cnt; i++) {
					int curr = queue.poll();

					for (int j = 1; j < mContact.length; j++) {
						if (mContact[curr][j] == 1 && !contacted[j]) {
							queue.add(j);
							contacted[j] = true;
						}
					}

					if (max_value < curr) {
						max_value = curr;
					}
				}
			}

			System.out.println("#" + tc + " " + max_value);
		}
	}

	static class Contact {
		int num;
		int to;

		Contact(int n, int t) {
			num = n;
			to = t;
		}
	}
}
