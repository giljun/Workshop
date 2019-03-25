import java.util.Scanner;

public class Jungol_1077 {

	static int N, W;
	static int[] DP = new int[10001];
	static int[] gem;
	static int[] gem_price;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		gem = new int[N+1];
		gem_price = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			gem[i] = sc.nextInt();
			gem_price[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = gem[i]; j <= W; j++) {
				DP[j] = Math.max(DP[j], DP[j-gem[i]]+gem_price[i]);
			}
		}
		System.out.println(DP[W]);
	}
}
