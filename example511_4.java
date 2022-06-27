package µ¿¾Æ¸®;

import java.util.Scanner;

public class example511_4 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				arr[i][j] = 0;
			}
		}
		
		int num = scan.nextInt();
		int a, b;
		for(int i = 0; i < num; i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			
			arr[a-1][b-1] = 1;
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
}