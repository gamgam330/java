package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ27522 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] arr = new String[8][2];
		int[] score = {10, 8, 6, 5, 4, 3, 2, 1, 0};
		StringTokenizer st;
		for(int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].toString().contentEquals(o2[0].toString()))
					return o1[1].toString().compareTo(o2[1].toString());
				else
					return o1[0].toString().compareTo(o2[0].toString());
			}
		});
		
		int red = 0, blue = 0;
		for(int i = 0; i < 8; i++) {
			if(arr[i][1].equals("B")) {
				blue += score[i];
			}
			else {
				red += score[i];
			}
		}
		if(red < blue) System.out.print("Blue");
		else System.out.print("Red");
	}
}
