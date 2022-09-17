package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준4158 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int posA = 0, posB = 0, cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break;
			int[] arr = new int[n];
			int[] arr2 = new int[m];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(br.readLine());
			}
			while(true) {
				if(posA == n || posB == m) break;
				if(arr[posA] < arr2[posB]) posA++;
				else if(arr[posA] > arr2[posB]) posB++;
				else {
					posA++;
					posB++;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}