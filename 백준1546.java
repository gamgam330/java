package 백준;

import java.util.Scanner;

public class 백준1546 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int a = scan.nextInt();
	
		float[] arr = new float[a];
		float sum = 0;
		for(int i = 0; i < a; i++){
			arr[i] = scan.nextFloat();
			sum += arr[i];
		}
		System.out.print(sum / a);
	}
}