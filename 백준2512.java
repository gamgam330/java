package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2512 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		long total = Integer.parseInt(br.readLine());
		long result2 = 0, max = 0, result = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			result += arr[i];
			max = Math.max(max, arr[i]);
		}
		
		if(result <= total) System.out.print(max);
		else {
			long mid = 0;
			long start = 0;
			while(true) {
				mid = (max + start) / 2;
				result = 0;
				if(mid == start) break;
				for(int i = 0; i < N; i++) {
					if(mid < arr[i]) result += mid;
					else result += arr[i];
				}
				if(result <= total) { 
					start = mid;
					
				}
				else max = mid;
			}
			System.out.println(mid);
		}
	}
}
