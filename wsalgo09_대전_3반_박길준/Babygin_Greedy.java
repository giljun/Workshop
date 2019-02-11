import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Babygin_Greedy {

	static int[] count = new int[10]; // 0 ~ 9까지

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		ArrayList<Integer> data = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			data.add(str.charAt(i) - '0');
		}
		int max_num = 0;
		for (int i = 0; i < data.size(); i++) {
			if (max_num < data.get(i)) {
				max_num = data.get(i);
			}
		}

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < count.length; j++) {
				if (j == data.get(i)) {
					count[j]++;
				}
			}
		}

		BabyGin();
	}

	public static void BabyGin() {
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			// triple의 경우
			if (count[i] >= 3) {
				result++;
				count[i] -= 3;
			}
			// run의 경우
			if (count[i] >= 1 && i+2 < count.length) {
				if( count[i+1] >=1 && count[i+2] >= 1 ) {
					result++;
					count[i] -= 1;
					count[i+1] -= 1;
					count[i+2] -= 1;
				}
			}
		}
		
		if( result == 2 ) {
			System.out.println("Baby-Gin!!");
		} else {
			System.out.println("Baby-Gin Noob!!!");
		}

	}
}
