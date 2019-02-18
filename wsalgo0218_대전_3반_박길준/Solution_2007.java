import java.util.Scanner;
 
public class Solution_2007{
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int ct=1;ct<=T;ct++) {
            String str = sc.next();
            int size = str.length();
            int j=0;
            for(int i=1;i<size;i++) {
                if(str.charAt(j)==str.charAt(i))
                    j++;
                else
                    j=0;
            }
             
            System.out.println("#"+ct+" "+(size-j));
        }
    }
 
}