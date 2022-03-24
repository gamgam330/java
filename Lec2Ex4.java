import java.util.Scanner;

/*
 * 예제 프로그램
 * @version 1.0 2022-03-17
 * @author 김규민
 */

public class Lec2Ex4 {
	public static void main (String args[]) {
		int num1, num2;
		Scanner input = new Scanner(System.in);
		System.out.printf("사각형의 가로 길이를 입력하시오 : ");
		num1 = input.nextInt();
		System.out.printf("사각형의 세로 길이를 입력하시오 : ");
		num2 = input.nextInt();
		for (int i = 0; i < num2; i++) {
			for(int j = 0; j < num1; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
	}
}