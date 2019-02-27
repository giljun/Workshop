import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {

	static char[][] map;
	static int H, W;
	static char[] commands;
	static Tank player;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			String str = "";
			for (int i = 0; i < map.length; i++) {
				str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			int N = Integer.parseInt(br.readLine());
			commands = new char[N];

			str = br.readLine();
			for (int i = 0; i < commands.length; i++) {
				commands[i] = str.charAt(i);
			}

			player = new Tank(new Point(0, 0), 0);

			// 탱크의 초기 위치 찾기( 방향은 시계방향으로 1,2,3,4 )
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						player.pos.x = j;
						player.pos.y = i;
						if (map[i][j] == '<') {
							player.dir = 1;
						} else if (map[i][j] == '^') {
							player.dir = 2;
						} else if (map[i][j] == '>') {
							player.dir = 3;
						} else {
							player.dir = 4;
						}
					}
				}
			}

			for (int i = 0; i < commands.length; i++) {
				switch (commands[i]) {
				case 'L':
					Move(1);
					map[player.pos.y][player.pos.x] = '<';
					break;
				case 'U':
					Move(2);
					map[player.pos.y][player.pos.x] = '^';
					break;
				case 'R':
					Move(3);
					map[player.pos.y][player.pos.x] = '>';
					break;
				case 'D':
					Move(4);
					map[player.pos.y][player.pos.x] = 'v';
					break;
				case 'S':
					Shoot();
					break;
				}
			}

			System.out.print("#"+tc+" ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void Move(int dir) {
		player.dir = dir;
		if (dir == 1) { // 1. 왼쪽
			if (player.pos.x - 1 >= 0) {
				if (map[player.pos.y][player.pos.x - 1] == '.') {
					map[player.pos.y][player.pos.x - 1] = '<'; // 이동한 위치에 표시
					map[player.pos.y][player.pos.x] = '.'; // 전에 있던 곳은 .으로 변경
					// 플레이어 위치 변경
					player.pos.x = player.pos.x - 1;
				}
			}
		} else if (dir == 2) { // 2. 위쪽
			if (player.pos.y - 1 >= 0) {
				if (map[player.pos.y - 1][player.pos.x] == '.') {
					map[player.pos.y - 1][player.pos.x] = '^'; // 이동한 위치에 표시
					map[player.pos.y][player.pos.x] = '.'; // 전에 있던 곳은 .으로 변경
					// 플레이어 위치 변경
					player.pos.y = player.pos.y - 1;
				}
			}
		} else if (dir == 3) { // 3. 오른쪽
			if (player.pos.x + 1 < W) {
				if (map[player.pos.y][player.pos.x + 1] == '.') {
					map[player.pos.y][player.pos.x + 1] = '>'; // 이동한 위치에 표시
					map[player.pos.y][player.pos.x] = '.'; // 전에 있던 곳은 .으로 변경
					// 플레이어 위치 변경
					player.pos.x = player.pos.x + 1;
				}
			}
		} else {
			if (player.pos.y + 1 < H) { // 4. 아래쪽
				if (map[player.pos.y + 1][player.pos.x] == '.') {
					map[player.pos.y + 1][player.pos.x] = 'v'; // 이동한 위치에 표시
					map[player.pos.y][player.pos.x] = '.'; // 전에 있던 곳은 .으로 변경
					// 플레이어 위치 변경
					player.pos.y = player.pos.y + 1;
				}
			}
		}
	}

	static void Shoot() {
		if (player.dir == 1) { // 1. 왼쪽
			int i = 1;
			while (true) {
				if (player.pos.x - i >= 0) {
					if (map[player.pos.y][player.pos.x - i] == '#') {
						break;
					} else if (map[player.pos.y][player.pos.x - i] == '*') {
						map[player.pos.y][player.pos.x - i] = '.';
						break;
					}
				} else {
					break;
				}
				i++;
			}
		} else if (player.dir == 2) { // 2. 위쪽
			int i = 1;
			while (true) {
				if (player.pos.y - i >= 0) {
					if (map[player.pos.y - i][player.pos.x] == '#') {
						break;
					} else if (map[player.pos.y - i][player.pos.x] == '*') {
						map[player.pos.y - i][player.pos.x] = '.';
						break;
					}
				} else {
					break;
				}
				i++;
			}
		} else if (player.dir == 3) { // 3. 오른쪽
			int i = 1;
			while (true) {
				if (player.pos.x + i < W) {
					if (map[player.pos.y][player.pos.x + i] == '#') {
						break;
					} else if (map[player.pos.y][player.pos.x + i] == '*') {
						map[player.pos.y][player.pos.x + i] = '.';
						break;
					}
				} else {
					break;
				}
				i++;
			}
		} else {
			int i = 1;
			while (true) {
				if (player.pos.y + i < H) { // 4. 아래쪽
					if (map[player.pos.y + i][player.pos.x] == '#') {
						break;
					} else if (map[player.pos.y + i][player.pos.x] == '*') {
						map[player.pos.y + i][player.pos.x] = '.';
						break;
					}
				} else {
					break;
				}
				i++;
			}
		}
	}

	static class Tank {
		Point pos;
		int dir;

		Tank(Point p, int d) {
			pos = p;
			dir = d;
		}
	}
}