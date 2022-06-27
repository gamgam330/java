package µ¿¾Æ¸®;

import java.util.Scanner;

public class example511_3 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int cnt = 1;
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = cnt++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println(" ");
		}
	}
}