package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] length = new long[N-1];
		long[] cost = new long[N];
		for(int i = 0; i < N-1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cost[i] =  Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		long minCost = cost[0];
		
		for(int i = 0; i < N-1; i++) {
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			sum += minCost * length[i];
		}
		System.out.print(sum);
	}
}
