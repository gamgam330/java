package ����;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ����1152 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer str_a = new StringTokenizer(str, " ");
		System.out.print(str_a.countTokens());
	}
}