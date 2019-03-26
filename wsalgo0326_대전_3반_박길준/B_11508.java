import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 백준 11508 2+1할인 문제

public class B_11508 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		ArrayList<Integer> yogurt = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			yogurt.add(sc.nextInt());
		}

		yogurt.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int ans = 0;

		for (int i = 1; i < yogurt.size() + 1; i++) {
			if (i % 3 == 0) {
				continue;
			}
			ans += yogurt.get(i-1);
		}
		System.out.println(ans);
	}
}
