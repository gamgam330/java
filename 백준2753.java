package 백준;

import java.util.Scanner;

public class 백준2753 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		
		if (a % 4 == 0 && a % 100 != 0) {
			System.out.print("1");
		}
		else if(a%400 == 0) {
			System.out.print("1");
		}
		else {
			System.out.print("0");
		}
	}
}
