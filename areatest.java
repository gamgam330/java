/*
 *  번째 예제 프로그램
 * @version 1.0 2022-03-10
 * @author 김규민
 */
import java.util.Scanner;
public class areatest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double radius;
		
		System.out.print("반지름을 입력하시오. : ");
		radius = input.nextDouble();
		
		double PI = 3.141592;
		double area = (radius*radius*PI);
		System.out.println("반지름이" +radius+ "인 원의 면적은" + area + "입니다.");
	}
}