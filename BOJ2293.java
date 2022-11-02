package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K+1];
		for(int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			for(int j = 0; j <= K; j++) {
				if(j - coin > 0) {
					dp[j] += dp[j-coin];
				}
				else if (j - coin == 0) {
					dp[j]++;
				}
			}
		}
		System.out.print(dp[K]);
	}
}
