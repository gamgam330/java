package 백준;

import java.util.Scanner;

public class 백준2675 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a= scan.nextInt();
		
		for(int i = 0; i < a; i++) {
			int b = scan.nextInt();
			String str = scan.next();
			for(int j = 0; j < str.length(); j++) {
				for(int z = 0; z < b; z++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println("");
		}
	}
}
