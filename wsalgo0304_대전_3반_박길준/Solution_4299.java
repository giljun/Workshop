import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4299{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int day = Integer.parseInt(st.nextToken());
			int hour = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());

			int result = 0;

			if (min >= 11) {
				result += (min - 11);
			} else {
				result += (min + 60 - 11);
				hour -= 1;
			}
			if (hour >= 11) {
				result += (hour - 11) * 60;
			} else {
				result += (hour + 24 - 11) * 60;
				day -= 1;
			}
			result += ((day - 11) * 24 * 60);
			
			if( result < 0) {
				result = -1;
			}

			System.out.println("#" + tc + " " + result);
		}
	}
}