package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ10826 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(fibo(N));
	}
	
	public static BigInteger fibo(int N) {
		BigInteger[] arr = new BigInteger[10001];
		arr[0] = BigInteger.valueOf(0);
		arr[1] = BigInteger.valueOf(1);
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-2].add(arr[i-1]);
		}
		return arr[N];
	}
}