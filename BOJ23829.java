package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ23829 {
	static int N, Q;
	static int[] P;
	static long [] sumP;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		P = new int[N+1];
		sumP = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		for(int i = 1; i <= N; i++) {
			if(i == 1) sumP[i] = P[i];
			else sumP[i] = sumP[i-1] + P[i];
		}
		
		for(int i = 0; i < Q; i++) {
			long X = Integer.parseInt(br.readLine());
			int mid = bs(X);
			long sum = 0;
			
			if (P[mid] <= X) {
				sum += (mid * X) - sumP[mid];
				sum += (sumP[N] - sumP[mid]) - ((N - mid) * X);
			}
			else {
				sum += ((mid - 1) * X) - sumP[mid - 1];
				sum += (sumP[N] - sumP[mid - 1]) - ((N - mid + 1) * X);
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int bs(long a) {
		int left = 1;
		int right = N;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(P[mid] > a)
				right = mid - 1;
			else if(P[mid] < a) {
				left = mid + 1;
			}
			else
				break;
		}
		return mid;
	}
}
