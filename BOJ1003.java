package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
	static Integer[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new Integer[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			fibo(n);
			sb.append(arr[n][0] + " " + arr[n][1]).append("\n");
		}
		System.out.print(sb);
	}
	static Integer[] fibo(int n) {
		if(arr[n][0] == null || arr[n][1] == null) {
			arr[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			arr[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
			
		}
		return arr[n];
	}
}