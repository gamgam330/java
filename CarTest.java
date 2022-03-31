
public class CarTest {
	public static void main (String[] args) {
		car myCar = new car();	//함수선언하기
		myCar.changeGear(1);	//매개변수 1을 가지고 myCar changeGear 메소드 진입.
		myCar.speedDown();		//매개변수 없이 myCar speedDown 메소드 진입.
		System.out.println(myCar);
	}
}