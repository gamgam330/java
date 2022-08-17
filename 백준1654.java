package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1654 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[K];
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long last = arr[K-1];
		long first = 1;
		long mid = 0;
		while(first <= last) {
			long cnt = 0;
			mid = (first+last) / 2;
			for(int i = 0; i < K; i++) {
				cnt += arr[i]/mid;
			}
			if(cnt < N)
				last = mid - 1;
			else if(cnt >= N)
				first = mid + 1;
		}
		System.out.print(first - 1);
	}
}