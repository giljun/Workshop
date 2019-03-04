import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5603 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] hay = new int[N];
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				hay[i] = Integer.parseInt(br.readLine());
				sum += hay[i];
			}
			
			sum /= N;
			
			int result = 0;
			for (int i = 0; i < hay.length; i++) {
				if(hay[i] < sum) {
					result += (sum-hay[i]);
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
