package 백준;

import java.util.Scanner;

public class 백준10950 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		
		for(int i = 0; i < a; i++) {
			int b = scan.nextInt();
			int c = scan.nextInt();
			
			System.out.println(b+c);
		}
	}
}
