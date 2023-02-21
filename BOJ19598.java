package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19598 {
	public void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = 0, end = 0;
		int count = 1;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sTime = Integer.parseInt(st.nextToken());
			int eTime = Integer.parseInt(st.nextToken());
			if(start < sTime && end > eTime) {
				start = sTime;
				end = eTime;
				count++;
			}
		}
		System.out.print(count);
	}
}