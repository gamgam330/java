import java.util.Scanner;

public class Lec3Ex3 {
	public static void main (String args[]) {
		int j, num;
		System.out.println("1~1000사이 소수 현황입니다.");
		for(num = 1; num <= 1000; num++) {
				for(j = 2; j < num; j++) {
					if (num % j == 0) {
						break;
					}
				}
				if(num == j) {
					System.out.printf(num+" ");
			}
		}
	}
}