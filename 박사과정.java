package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박사과정 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< N; i++) {
			String str = br.readLine();
			if(str.equals("P=NP")) {
				sb.append("skipped").append("\n");
			}
			else {
				StringTokenizer st = new StringTokenizer(str, "+");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sb.append(a+b).append("\n");
			}
		}
		System.out.print(sb);
	}
}
