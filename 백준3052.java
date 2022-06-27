package 백준;

import java.util.HashSet;
import java.util.Scanner;

public class 백준3052 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        HashSet<Integer> h = new HashSet<Integer>();

        for(int i = 0; i  < 10 ; i++){
            h.add(scan.nextInt()%42);
        }
        System.out.println(h.size());
	}
}