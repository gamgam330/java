import java.util.Scanner;

/*
 * ���� ���α׷�
 * @version 1.0 2022-03-17
 * @author ��Թ�
 */

public class Lec2Ex4 {
	public static void main (String args[]) {
		int num1, num2;
		Scanner input = new Scanner(System.in);
		System.out.printf("�簢���� ���� ���̸� �Է��Ͻÿ� : ");
		num1 = input.nextInt();
		System.out.printf("�簢���� ���� ���̸� �Է��Ͻÿ� : ");
		num2 = input.nextInt();
		for (int i = 0; i < num2; i++) {
			for(int j = 0; j < num1; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
	}
}