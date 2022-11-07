package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int len = a.length();
		int cnt = 0;
		for(int i = 0; i <= b.length()-a.length(); i++) {
			cnt = 0;
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j)) {
					cnt++;
				}
			}
			len = Math.min(cnt, len);
		}
		System.out.print(len);
	}
}
