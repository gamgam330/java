package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준1339 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String arr;
		int[] pp = new int[26];
		
		for(int i = 0; i < N; i++) {
			arr = br.readLine();
			int tmp = (int)Math.pow(10, arr.length()-1);
			for(int j = 0; j < arr.length(); j++) {
				pp[arr.charAt(j)-65] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(pp);
		
		int result = 0;
		for(int i = 25; i > 15; i--) {
			result += pp[i] * (i - 16);
		}
		System.out.print(result);
	}
}
