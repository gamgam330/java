/*
 * 세 번째 예제 프로그램
 * @version 1.0 2022-03-10
 * @author 김규민
 */

public class areatest1 {
	public static void main(String[] args) {
		double radius = 3.0;
		final double PI = 3.141592;
		double area = (radius*radius*PI);
		System.out.println("반지름이" +radius+ "인 원의 면적은" + area + "입니다.");
	}
}