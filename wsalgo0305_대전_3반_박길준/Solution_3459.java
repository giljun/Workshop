import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			String pivot = "1001";
			if (N == 1) {
				System.out.println("#" + tc + " " + "Bob");
			} else {
				while (Long.valueOf(pivot, 2) < N) {
					// 맨앞의 값에 4배 한 값을 기존의 값에 더한다.
					pivot = "10"+pivot;
				}
				// 오른쪽으로 한칸 쉬프트하는 것을 문자열로 표현
				String val = pivot.substring(0, 1) + pivot.substring(2, pivot.length());
				if(Long.valueOf(val, 2) < N) {
					System.out.println("#" + tc + " " + "Bob");
				}else {
					System.out.println("#" + tc + " " + "Alice");
				}
			}
		}
	}
}