import java.util.Scanner;
/*
 * ���� ���α׷�
 * @version 1.0 2022-03-17
 * @author ��Թ�
 */


public class Lec2Ex1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2;
		System.out.print("�� ���� ������ �Է��ϼ��� : ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		if (num1<num2) {
			System.out.println(num2+"��(��) �� Ů�ϴ�.");
		}
		else if (num1>num2){
			System.out.println(num1+"��(��) �� Ů�ϴ�.");
		}
		else
			System.out.println("�� ���� �����ϴ�.");
	}
}
