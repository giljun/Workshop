import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			StringBuffer sb = new StringBuffer(str);
			
			int N = Integer.parseInt(br.readLine());
			
			int index = 0;
			int count = 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				index = Integer.parseInt(st.nextToken());
				for (int j = 0; j < sb.length(); j++) {
					if(index != 0) {
						if(sb.charAt(j)!='-') {
							if(count == index) {
								sb.insert(j+1, '-');
								break;
							}else {
								count++;
							}
						}	
					}else {
						sb.insert(index, '-');
						break;
					}
				}
				count = 1;
			}
			
			System.out.println("#"+tc+" "+sb);
		}
	}
}