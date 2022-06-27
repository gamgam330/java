package µ¿¾Æ¸®;

import java.util.Scanner;

public class example511_1 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] a = new int[num];
		int max = 1000;
		
		for(int i = 0; i < num; i++) {
			a[i] = scan.nextInt();
			if(max > a[i]) {
				max = a[i];
			}
		}
		
		System.out.println(max);
	}
}
