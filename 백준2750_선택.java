package 동아리;

import java.util.Scanner;

public class 백준2750_선택 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
