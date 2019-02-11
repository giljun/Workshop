import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 회의의 수
		int meeting_num = Integer.parseInt(br.readLine());

		int[][] conferences = new int[meeting_num][2];

		// 회의의 수만큼 반복한다.
		for (int i = 0; i < meeting_num; i++) {
			// 시작시간, 종료시간
			st = new StringTokenizer(br.readLine());
			conferences[i][0] = Integer.parseInt(st.nextToken());
			conferences[i][1] = Integer.parseInt(st.nextToken());
		}

		// 종료시간을 기준으로 정렬한다.
		Arrays.sort(conferences,
				(conferences1, conferences2) -> conferences1[1] == conferences2[1] ? conferences1[0] - conferences2[0]
						: conferences1[1] - conferences2[1]);

		// 입력종료. 회의실 배정 시작.
		int result = 0;
		int endTime = -1;
		for (int i = 0; i < conferences.length; i++) {
			if( conferences[i][0] > endTime) {
				result++;
				endTime = conferences[i][1];
			}
		}
		
		System.out.println(result);
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
