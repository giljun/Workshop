import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1256 {

	static int K;
	static String result;
	static String[] suffixs;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			str = br.readLine().trim();

			int N = str.length();

			suffixs = new String[N];
			for (int i = 0; i < N; i++) {
				suffixs[i] = str.substring(i);
			}

			Arrays.sort(suffixs);

			if (suffixs.length < K) {
				System.out.println("#" + tc + " " + "none");
			} else {
				System.out.println("#" + tc + " " + suffixs[K - 1]);
			}
		}
	}

}
