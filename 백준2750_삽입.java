package 동아리;

import java.util.Scanner;

public class 백준2750_삽입 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}