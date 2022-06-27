package 백준;

import java.util.Scanner;

public class 백준11021 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        
		int a = scan.nextInt(); 

        for(int i= 1; i<=a; i++){ 
            int b = scan.nextInt(); 
            int c = scan.nextInt();
            int d = b+c;
            System.out.println("Case #"+i+": "+d);
        }
	}
}
