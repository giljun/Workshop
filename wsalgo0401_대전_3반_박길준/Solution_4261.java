import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4261 {

	static char[][] cellphone = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	static ArrayList<Integer> key;
	static int nWord;
	static String[] word;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			key = new ArrayList<>();
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) { // 1. 키보드에 입력한 값을 저장.
				key.add(str.charAt(i) - '0');
			}

			nWord = sc.nextInt();
			word = new String[nWord];

			result = 0;

			int cnt;

			for (int i = 0; i < nWord; i++) { // 2. 문자열 저장.
				word[i] = sc.next();
				cnt = 0;
				if (key.size() == word[i].length()) {
					for (int j = 0; j < word[i].length(); j++) {
						char ch = word[i].charAt(j);
						int num = key.get(j);

						for (int k = 0; k < cellphone[num - 1].length; k++) {
							if (ch == cellphone[num - 1][k]) {
								cnt++;
							}
						}
					}
					if (cnt == word[i].length()) {
						result++;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

}
