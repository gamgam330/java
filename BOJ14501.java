package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N+1];
		int[] arr2 = new int[N+1];
		int[] arr3 = new int[N+2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = N; i > 0; i--) {
			if(i+arr1[i] > N+1)
				arr3[i] = arr3[i+1];
			else
				arr3[i] = Math.max(arr3[i+1], arr2[i] + arr3[i + arr1[i]]);
		}
		System.out.print(arr3[1]);
	}
}
