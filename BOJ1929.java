package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] p = new boolean[N+1];
		p[0] = true;
		p[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N+1); i++) {
			for(int j = i*i; j < N+1; j+=i) {
				p[j] = true;
			}
		}
		
		for(int i = M; i < N+1; i++) {
			if(p[i] == false) System.out.println(i);
		}
	}
}
