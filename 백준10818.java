package ����;

import java.util.Arrays;
import java.util.Scanner;


public class ����10818 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int[] arr = new int[a];
		int max = 0, min = 1000;
		
		for(int i = 0; i < a; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		System.out.print(arr[0]+" "+arr[a-1]);
	}
}