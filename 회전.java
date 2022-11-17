package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회전 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int N = num.length();
		long sum = 0;
		for(int i = 0; i < N; i++) {
			char a = num.charAt(N-1);
			String b = num.substring(0, N-1);
			String c = a + b;
			num = c;
			sum += Integer.parseInt(num);
		}
		System.out.print(sum);
	}
}
