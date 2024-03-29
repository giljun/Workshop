import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644 {

	static int M, A; // M : 이동시간 , A : BC의 개수
	static ArrayList<Person> p1, p2;
	static AP[] aps;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			// (0,0)이 시작 위치인 사람 // 0 : 이동하지 않음, 1: 상, 2: 우, 3: 하, 4: 좌
			p1 = new ArrayList<>();
			p1.add(new Person(1, 1));

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				int dir = Integer.parseInt(st.nextToken());
				if (dir == 0) {
					p1.add(new Person(p1.get(i - 1).x, p1.get(i - 1).y));
				} else if (dir == 1) {
					p1.add(new Person(p1.get(i - 1).x - 1, p1.get(i - 1).y));
				} else if (dir == 2) {
					p1.add(new Person(p1.get(i - 1).x, p1.get(i - 1).y + 1));
				} else if (dir == 3) {
					p1.add(new Person(p1.get(i - 1).x + 1, p1.get(i - 1).y));
				} else {
					p1.add(new Person(p1.get(i - 1).x, p1.get(i - 1).y - 1));
				}
			}

			// (0,0)이 시작 위치인 사람 // 0 : 이동하지 않음, 1: 상, 2: 우, 3: 하, 4: 좌
			p2 = new ArrayList<>();
			p2.add(new Person(10, 10));

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				int dir = Integer.parseInt(st.nextToken());
				if (dir == 0) {
					p2.add(new Person(p2.get(i - 1).x, p2.get(i - 1).y));
				} else if (dir == 1) {
					p2.add(new Person(p2.get(i - 1).x - 1, p2.get(i - 1).y));
				} else if (dir == 2) {
					p2.add(new Person(p2.get(i - 1).x, p2.get(i - 1).y + 1));
				} else if (dir == 3) {
					p2.add(new Person(p2.get(i - 1).x + 1, p2.get(i - 1).y));
				} else {
					p2.add(new Person(p2.get(i - 1).x, p2.get(i - 1).y - 1));
				}
			}

			// AP에 대한 정보 입력
			aps = new AP[A];

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				aps[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}

			result = 0;

			solve(0);

			System.out.println("#" + tc + " " + result);
		}
	}

	static void solve(int time) {
		if (time == M + 1) {
			return;
		}

		ArrayList<AP> p1ap = new ArrayList<>();
		ArrayList<AP> p2ap = new ArrayList<>();

		for (int i = 0; i < aps.length; i++) {
			AP a = aps[i];
			if (a.isCharge(p1.get(time).x, p1.get(time).y)) {
				p1ap.add(a);
			}
			if (a.isCharge(p2.get(time).x, p2.get(time).y)) {
				p2ap.add(a);
			}
		}

		int power = 0;

		// 1. 1번 사람이 충전지역에 포함되어 있지 않는 경우,
		if (p1ap.isEmpty()) {
			for (int i = 0; i < p2ap.size(); i++) { // 2번 사람에 대한 충전량 계산.
				AP a2 = p2ap.get(i);
				if (power < a2.power) {
					power = a2.power;
				}
			}
		}

		// 2. 1번 사람이 충전지역에 포함되어 있는 경우,
		for (int i = 0; i < p1ap.size(); i++) {
			AP a1 = p1ap.get(i);
			// 3. 2번 사람이 충전지역에 포함되어 있지 않는 경우,
			if (p2ap.isEmpty()) {
				if (power < a1.power) {
					power = a1.power;
				}
			}

			// 4. 2번 사람이 충전지역에 포함되어 있는 경우,(둘 다 충전 가능한 경우)
			for (int j = 0; j < p2ap.size(); j++) {
				AP a2 = p2ap.get(j);
				int p = 0;
				if (a1.num == a2.num) { //
					p = a1.power;
				} else {
					p += a1.power;
					p += a2.power;
				}
				if (power < p) {
					power = p;
				}
			}
		}

		result += power;

//		System.out.println( time + " : " + result);

		solve(time + 1);
	}

	static class Person {
		int x;
		int y;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class AP {
		int x, y;
		int cover;
		int power;
		int num; // 중계기를 구분할 수 있도록 번호를 부여한다.

		AP(int y, int x, int c, int p, int n) {
			this.y = y;
			this.x = x;
			this.cover = c;
			this.power = p;
			this.num = n;
		}

		boolean isCharge(int x, int y) {
			return cover >= (Math.abs(this.x - x) + Math.abs(this.y - y));
		}
	}
}
