package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = 0;
		int max = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int sum = 0;
			for(int a : arr) {
				if(a > mid) sum += (a - mid);
			}
			if(sum >= M) min = mid + 1;
			else max = mid-1;
		}
		
		System.out.print(max);
	}
}
