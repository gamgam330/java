package 백준;

import java.util.Scanner;

public class 백준10871 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int[] arr = new int[a];
		for(int i = 0; i < a; i++) {
			int c = scan.nextInt();
			if(b > c) {
				System.out.print(c+" ");
			}
		}
		
	}
}
