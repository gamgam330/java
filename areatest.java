/*
 *  ��° ���� ���α׷�
 * @version 1.0 2022-03-10
 * @author ��Թ�
 */
import java.util.Scanner;
public class areatest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double radius;
		
		System.out.print("�������� �Է��Ͻÿ�. : ");
		radius = input.nextDouble();
		
		double PI = 3.141592;
		double area = (radius*radius*PI);
		System.out.println("��������" +radius+ "�� ���� ������" + area + "�Դϴ�.");
	}
}