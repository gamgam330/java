import java.util.Scanner;

public class Lec2Ex5 {
	public static void main (String args[]) {
		int curcle;
		double sum=0;
		int j = -1;
		Scanner input = new Scanner(System.in);
		System.out.printf("반복횟수를 입력하시오 : ");
		curcle = input.nextInt();
		
		for (int i = 1; i < curcle+1; i++) {
				j *= -1;
				sum += j*(4.0/(2*i-1));
		}
		System.out.println("파이는"+sum+"입니다.");
	}
}
