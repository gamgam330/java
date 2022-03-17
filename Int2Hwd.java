import java.util.Scanner;

/*
 * 예제 프로그램
 * @version 1.0 2022-03-17
 * @author 김규민
 */

public class Int2Hwd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1;
		System.out.print("숫자를 입력하시오 : ");
		num1 = input.nextInt();
		
		switch(num1) {
		case 0:
			System.out.println("없음");
			break;
		case 1:
			System.out.println("하나");
			break;
		case 2:
			System.out.println("둘");
			break;
		case 3:
			System.out.println("셋");
			break;
		default:
			System.out.println("많음");
			break;
		}
	}
}
