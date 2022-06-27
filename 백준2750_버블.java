package 동아리;

import java.util.Scanner;

public class 백준2750_버블 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
