import java.util.Scanner;

/*
 * ���� ���α׷�
 * @version 1.0 2022-03-17
 * @author ��Թ�
 */

public class DaysInMonth {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month;
		System.out.print("���� �Է��Ͻÿ� : ");
		month = input.nextInt();
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31�� �Դϴ�.");
			break;
		case 2:
			System.out.println("28�� �Դϴ�.");
		default:
			System.out.println("30�� �Դϴ�.");
			break;
		}
	}
}