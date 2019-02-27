import java.io.IOException;
import java.util.Scanner;

public class Solution_4408 {

	static int N; // 돌아가야할 학생의 수
	static Room[] room;
	static int[] aisle;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			room = new Room[N];
			aisle = new int[200]; // 200개의 복도가 존재함.
			result = 0;

			for (int i = 0; i < room.length; i++) {
				room[i] = new Room(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < room.length; i++) {
				if (room[i].first < room[i].last) {
					int start;
					int end;
					if (room[i].first % 2 == 1) {
						start = room[i].first / 2;
					} else {
						start = room[i].first / 2 - 1;
					}
					if (room[i].last % 2 == 1) {
						end = room[i].last / 2 + 1;
					} else {
						end = room[i].last / 2;
					}
					for (int j = start; j < end; j++) {
						aisle[j]++;
					}
				} else {
					int start;
					int end;
					if (room[i].last % 2 == 1) {
						start = room[i].last / 2;
					} else {
						start = room[i].last / 2 - 1;
					}
					if (room[i].first % 2 == 1) {
						end = room[i].first / 2 + 1;
					} else {
						end = room[i].first / 2;
					}
					for (int j = start; j < end; j++) {
						aisle[j]++;
					}
				}
			}

			for (int i = 0; i < aisle.length; i++) {
				if (result < aisle[i]) {
					result = aisle[i];
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	static class Room {
		int first;
		int last;

		Room(int f, int l) {
			first = f;
			last = l;
		}
	}
}
