package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1094 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i <= 6; i++) {
			if((N & (1<<i)) > 0) cnt++;
		}
		System.out.print(cnt);
	}
}
