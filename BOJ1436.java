package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 665;
		while (cnt != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			
		}
		System.out.print(num);
	}
}
