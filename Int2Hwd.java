import java.util.Scanner;

/*
 * ���� ���α׷�
 * @version 1.0 2022-03-17
 * @author ��Թ�
 */

public class Int2Hwd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1;
		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		num1 = input.nextInt();
		
		switch(num1) {
		case 0:
			System.out.println("����");
			break;
		case 1:
			System.out.println("�ϳ�");
			break;
		case 2:
			System.out.println("��");
			break;
		case 3:
			System.out.println("��");
			break;
		default:
			System.out.println("����");
			break;
		}
	}
}
