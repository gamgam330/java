package 백준;

import java.math.BigInteger;
import java.util.Scanner;

public class 백준1271 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		BigInteger num = scan.nextBigInteger();
		BigInteger num1 = scan.nextBigInteger();
		
		System.out.println(num.divide(num1));
		System.out.println(num.remainder(num1));
	}
}