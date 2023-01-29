package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ1082 {
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      BigInteger ten = BigInteger.TEN;
      int[] p = new int[N];
      
      for(int i = 0; i < N; i++) {
         p[i] = Integer.parseInt(st.nextToken());
      }
      int M = Integer.parseInt(br.readLine());
      
      BigInteger[] dp = new BigInteger[M+1];
      
      for(int i = 0; i <= M; i++) {
         dp[i] = BigInteger.valueOf(-1);
      }
      
      for(int i = N-1; i >= 0; i--) {
         int x = p[i];
         for(int j = x; j <= M; j++) {
            BigInteger a = dp[j-x].multiply(ten);
            BigInteger b = BigInteger.valueOf(i);
            BigInteger c = a.add(b);
            dp[j] = dp[j].max(c.max(b));
         }
      }
      System.out.print(dp[M]);
   }
}