package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욱제는효도쟁이야 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			int st1 = Integer.parseInt(st.nextToken());
			result += st1;
			if(st1 > max) {
				max = st1;
			}
		}
		result = result - max;
		System.out.print(result);
	}
}
