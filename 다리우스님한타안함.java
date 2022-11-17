package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리우스님한타안함 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		if(D == 0 || K + A < D) {
			System.out.print("hasu");
		}
		else {
			System.out.print("gosu");
		}
	}
}
