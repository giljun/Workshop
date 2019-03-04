import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int[] num = new int[3];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			int result = 0;
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < num.length; j++) {
					if(num[i]==num[j]) {
						count++;
					}
				}
				if(count%2==1) {
					result = num[i];
					break;
				}else {
					count = 0;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
