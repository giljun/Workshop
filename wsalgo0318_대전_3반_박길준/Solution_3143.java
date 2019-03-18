import java.io.IOException;
import java.util.Scanner;
 
public class Solution {
 
    static int count;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            String A = sc.next();
            String B = sc.next();
 
            int len = A.length();
 
            count = 0;
 
            for (int i = 0; i < len; i++) {
                int idx = A.indexOf(B, i);
                if (idx != -1) {
                    count += idx - i + 1;
                    i = idx + B.length() - 1;
                } else {
                    count += A.length()-i;
                    break;
                }
            }
 
            System.out.println("#" + tc + " " + count);
        }
    }
}