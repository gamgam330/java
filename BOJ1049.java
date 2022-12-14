package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1049 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int[] one = new int[M];
		int[] six = new int[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			six[i] = Integer.parseInt(st.nextToken());
			one[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(six);
		Arrays.sort(one);
		min = Math.min(((N/6)+1)*six[0], N*one[0]);
		min = Math.min(min, (N/6)*six[0] + (N%6)*one[0]);
		System.out.print(min);
	}
}
