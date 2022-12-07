package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
	static int N, R, C, cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int n = (int) Math.pow(2, N);
		s(R, C, n);
		
	}
	public static void s(int r, int c, int size) {
		if(size == 1) {
			System.out.print(cnt);
			return;
		}
		int n = size / 2;
		if (r < n && c < n) {
			cnt += n * n * 0;
			s(r, c, n);
		} else if (r < n && c < n + n) {
			cnt += n * n * 1;
			s(r, c - n, n);
		} else if (r < n + n && c < n) {
			cnt += n * n * 2;
			s(r - n, c, n);
		} else if (r < n + n && c < n + n) {
			cnt += n * n * 3;
			s(r - n, c - n, n);
		}
	}
}
