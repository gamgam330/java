package 백준;

import java.util.Scanner;

public class 백준2884 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();
		
		if(m < 45) {
			if(h==0)
				h=24;
			System.out.println((h-1)+" "+(m+15));
		}
		else {
			System.out.println(h+" "+(m-45));
		}
	}
}
