import java.util.Scanner;

/*
 * ���� ���α׷�
 * @version 1.0 2022-03-17
 * @author ��Թ�
 */

public class ifelse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Odd;
		System.out.print("�������� �Է��ϼ���. : ");
		Odd = input.nextInt();
		int a = Odd%2;
		if (a==1) {
			System.out.println("Ȧ���Դϴ�.");
		}
		else {
			System.out.println("¦���Դϴ�.");
		}
		
	}
}