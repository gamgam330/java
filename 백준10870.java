package 백준;

import java.util.Scanner;

public class 백준10870 {
	public static int fibo(int num) {
		if(num == 0)
			return 0;
		if(num == 1)
			return 1;
		return fibo(num-1) + fibo(num-2);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.print(fibo(num));
	}
}
