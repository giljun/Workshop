import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4672 {

	static String str;
	static int[] alphabet;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine();

			alphabet = new int[26];
			
			for (int i = 0; i < str.length(); i++) {
				alphabet[str.charAt(i) - 97]++;
			}

			result = 0;

			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i] != 0) {
					for (int j = 0; j < alphabet[i]; j++) {
						result += (alphabet[i] - j);
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

}
