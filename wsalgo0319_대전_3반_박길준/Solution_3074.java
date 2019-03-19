import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution {
 
    static ArrayList<Long> time;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Integer.parseInt(st.nextToken());
 
            time = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                time.add(Long.parseLong(br.readLine()));
            }
 
            Collections.sort(time);
 
            // 최악의 시간
            long l_time = M * time.get(time.size()-1);
 
            long left = 0;
            long right = l_time;
            long ans = l_time;
 
            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = 0;
 
                for (long ck : time) {
                    sum += mid / ck;
                }
                 
                if (M <= sum) { // 현재 미드가 m명을 처리하기에 충분한 시간인 경우,
                    if(mid<ans) { // ans에 있는 값보다 작은 mid이네? M명 처리는 가능한고 그렇다면 갱신.
                        ans = mid;
                    }
                    right = mid-1; // 시간이 충분하니까.
                } else {
                    left = mid+1; // 시간이 부족하니까. 시간을 늘려보자.
                }
            }
             
            System.out.println("#"+tc+" "+ans);
        }
    }
}