import java.util.*;

public class Solution_1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TestCase
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 세로
			int N = sc.nextInt();
			// 가로에 대한 정수 입력값은 저장할 필요가 없으므로, 저장하지 않음.
			sc.next();
			String row = null;

			// 가로 전부를 저장할 필요는 없음. 왜냐하면 다 똑같은 순서로 암호코드가 저장되어 있기 때문에...
			// 따라서 "1"이 있는 한 줄만 찾아내서 저장하여 그 값을 사용하여 문제를 해결할 수 있다.
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				if (row == null && s.contains("1"))
					row = s;
			}

			// 모든 암호코드의 끝은 1로 끝난다는 사실을 알고 있음.
			// 따라서 오른쪽 끝에 1의 위치를 찾아 내면 암호코드를 감싸고 있는,
			// 쓸모없는 값들을 정리할 수 있다.
			int lastIndex = row.lastIndexOf('1');
			row = row.substring(lastIndex - 55, lastIndex + 1);

			// 각 암호에 대해, switch로 조건문을 만든다.
			int[] cryp_num = new int[8];
			for (int i = 0; i < 8; i++) {
				switch (row.substring(i * 7, i * 7 + 7)) {
				case "0001101":
					cryp_num[i] = 0;
					break;
				case "0011001":
					cryp_num[i] = 1;
					break;
				case "0010011":
					cryp_num[i] = 2;
					break;
				case "0111101":
					cryp_num[i] = 3;
					break;
				case "0100011":
					cryp_num[i] = 4;
					break;
				case "0110001":
					cryp_num[i] = 5;
					break;
				case "0101111":
					cryp_num[i] = 6;
					break;
				case "0111011":
					cryp_num[i] = 7;
					break;
				case "0110111":
					cryp_num[i] = 8;
					break;
				case "0001011":
					cryp_num[i] = 9;
					break;
				default:
					cryp_num[i] = -1;
				}
			}
			int result = 0;
			int check = (cryp_num[0] + cryp_num[2] + cryp_num[4] + cryp_num[6]) * 3 + cryp_num[1] + cryp_num[3]
					+ cryp_num[5] + cryp_num[7];
			if (check > 9 && check % 10 == 0) {
				result = cryp_num[0] + cryp_num[1] + cryp_num[2] + cryp_num[3] + cryp_num[4] + cryp_num[5] + cryp_num[6]
						+ cryp_num[7];
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}