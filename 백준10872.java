package 백준;

import java.util.Scanner;

public class 백준10872 {
	
	public static int factorial(int num) {
		if(num <= 1)
			return 1;
		else
			return num * factorial(num - 1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int result = factorial(num);
		System.out.print(result);
	}
	
}
