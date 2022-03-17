import java.util.Scanner;

/*
 * 예제 프로그램
 * @version 1.0 2022-03-17
 * @author 김규민
 */

public class ifelse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Odd;
		System.out.print("정수값을 입력하세요. : ");
		Odd = input.nextInt();
		int a = Odd%2;
		if (a==1) {
			System.out.println("홀수입니다.");
		}
		else {
			System.out.println("짝수입니다.");
		}
		
	}
}