package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class k번째수 {
	public static void main(String[] args) throws IOException{
		  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int X = Integer.parseInt(st.nextToken());
	        int Y = Integer.parseInt(st.nextToken());
	        
	        int[] arr = new int[X];
	        st = new StringTokenizer(br.readLine());
	        for(int i = 0; i < X; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        Arrays.sort(arr);
	        System.out.println(arr[Y-1]);
	}
}
