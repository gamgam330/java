package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr1 = new int[M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			function1(Integer.parseInt(st.nextToken()), arr);
			
		}
		
	}
	
	public static void function1(int n, int[] arr) {
		int first = 0;
		int last = arr.length - 1;
		int mid = 0;
		
		while(first <= last) {
			mid = (first + last) / 2;
			if(n == arr[mid]) {
				System.out.println("1");
				return;
			}
			if(n > arr[mid]) {
				first = mid + 1;
			}
			else {
				last = mid - 1;
			}
		}
		System.out.println("0");
	}
}