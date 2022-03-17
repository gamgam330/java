import java.util.Scanner;
/*
 * 예제 프로그램
 * @version 1.0 2022-03-17
 * @author 김규민
 */


public class Lec2Ex1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2;
		System.out.print("두 개의 정수를 입력하세요 : ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		if (num1<num2) {
			System.out.println(num2+"이(가) 더 큽니다.");
		}
		else if (num1>num2){
			System.out.println(num1+"이(가) 더 큽니다.");
		}
		else
			System.out.println("두 값이 같습니다.");
	}
}
