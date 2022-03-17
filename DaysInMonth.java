import java.util.Scanner;

/*
 * 예제 프로그램
 * @version 1.0 2022-03-17
 * @author 김규민
 */

public class DaysInMonth {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month;
		System.out.print("월을 입력하시오 : ");
		month = input.nextInt();
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일 입니다.");
			break;
		case 2:
			System.out.println("28일 입니다.");
		default:
			System.out.println("30일 입니다.");
			break;
		}
	}
}