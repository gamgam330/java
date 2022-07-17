package ø¨Ω¿¥Î»∏;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ƒ≈»¶¥ı {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 1;
		
		for(int i = 0; i < N; i++) {
			char str1 = str.charAt(i);
			if(str1 == 'S')
				cnt++;
			else if(str1 == 'L') {
				i++;
				cnt++;
			}
		}
		
		if(cnt > N)
			System.out.print(N);
		else
			System.out.print(cnt);
	}
}
