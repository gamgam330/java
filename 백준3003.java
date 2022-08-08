package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준3003 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = {1,1,2,2,2,8};
		int[] result = new int[6];
		
		for(int i = 0; i < 6; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			result[i] = arr[i] - cnt;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
