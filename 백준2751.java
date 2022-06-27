package 동아리;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class 백준2751 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StringBuilder bb = new StringBuilder();
		
		int a = scan.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < a; i++) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
		
		for(Integer c : list) {
			bb.append(c).append("\n");
		}
		
		System.out.println(bb);
	}
}