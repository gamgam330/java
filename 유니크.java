package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유니크 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		int[] score = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sum = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < N; j++) {
                for(int x = 0; x < N; x++) {
                    if(j==x) continue;
                    if(arr[j][i] != arr[x][i]) sum = arr[j][i];
                    else {
                    	sum = 0; 
                    	break;
                    }
                }
                score[j] += sum;
                sum = 0;
            }
        }
        for(int i=0; i<N; i++)
            System.out.println(score[i]);
	}
}