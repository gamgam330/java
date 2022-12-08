package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10];
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][1] % Long.MAX_VALUE;
				}
				else if(j==9) {
					dp[i][9] = dp[i-1][8] % Long.MAX_VALUE;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % Long.MAX_VALUE;
				}
			}
		}
		
		long total = 0;
		for(int i = 0; i < 10; i++) {
			total += dp[N][i];
		}
		System.out.print(total % Long.MAX_VALUE);
	}
}
