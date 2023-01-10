package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1091 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		int[] S = new int[N];
		int[] result = new int[N];
		int[] arr = new int[N];
		int[] P1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st1.nextToken());
			result[i] = P[i];
			P1[i] = P[i];
			arr[i] = i % 3;
		}
		
		while(!Arrays.equals(arr, result)) {
			for(int i = 0; i < N; i++) {
				result[S[i]] = P[i]; 
			}
			for(int i = 0; i < N; i++) {
				P[i] = result[i];
			}
			if(Arrays.equals(P1, result)) {
				System.out.print("-1");
				return;
			}
			cnt++;
		}
		System.out.print(cnt);
	}
}
