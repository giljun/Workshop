
import java.util.Scanner;

public class Solution {

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int T=sc.nextInt();
      int mod=1234567891;
      for (int i = 1; i <=T; i++) {
         int N=sc.nextInt();
         int R=sc.nextInt();
         System.out.println("#"+i+" "+nCr(N,R,mod));
      }
      
   }
   static long power(long x,long y, long p) {
         long res = 1L;
         x = x % p;
         while(y > 0) {
            if(y % 2 == 1)
               res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
         }
         return res;
      }
   static long modInverse(long n,long p) {
      return power(n,p-2,p);
   }
   static long nCr(int n,int r,int p) {
      if(r==0) {
         return 1L;
      }
      long[] fac=new long[n+1];
      fac[0]=1;
      for (int i = 1; i <=n; i++) {
         fac[i]=fac[i-1]*i%p;
      }
      return (fac[n]*modInverse(fac[r],p)%p*modInverse(fac[n-r],p)%p)%p;
   }
}