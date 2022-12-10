package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N,1,3,2);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static void hanoi(int N, int from, int to, int temp) {
		if(N == 1) {
			cnt++;
			sb.append(from + " " + to).append("\n");
		}
		else {
			hanoi(N-1, from, temp, to);
			cnt++;
			sb.append(from + " " + to).append("\n");
			hanoi(N-1, temp, to, from);
		}
	}
}
