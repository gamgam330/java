package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for(int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			for(int j = coin; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin]+1);
			}
		}
		System.out.println(dp[K] == Integer.MAX_VALUE - 1 ? -1 : dp[K]);
	}
}