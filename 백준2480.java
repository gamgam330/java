package 백준;

import java.util.Scanner;

public class 백준2480 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		if(a == b) {
			if(a == c) {
				System.out.print(10000 + (a * 1000));
			}
			else if(a != c){
				System.out.print(1000 + (a * 100));
			}
		}
		else{
			if(a == c || b == c) {
				System.out.print(1000 + (c * 100));
			}
			else if(a != c && b != c) {
				if(a < b) {
					if(b < c) {
						System.out.print(c * 100);
					}
					else {
						System.out.print(b * 100);
					}
				}
				else {
					if(a < c) {
						System.out.print(c * 100);
					}
					else {
						System.out.print(a * 100);
					}
				}
			}
		}
	}
}
