/*
 * �ټ� ��° ���� ���α׷�
 * @version 1.0 2022-03-10
 * @author ��Թ�
 */
import java.util.Scanner;
public class QuadraticEq {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double b;
		double c;
		System.out.print("b���� �Է��ϼ���. : ");
		b = input.nextDouble();
		System.out.print("c���� �Է��ϼ���. : ");
		c = input.nextDouble();
		double result1 = (-b+(Math.sqrt((b*b)-(4*c))))/2; 
		double result2 = (-b-(Math.sqrt((b*b)-(4*c))))/2;
		
		boolean jurge;
		double result3 = ((b*b)-(4*c));
		jurge = result3 > 0;
		System.out.println("ù ��° ����"+result1+"�� ��° ����"+result2+"�Դϴ�. �׸��� �� ���� �� ���� ���������� ���δ�"+jurge+"�Դϴ�.");
	}
}