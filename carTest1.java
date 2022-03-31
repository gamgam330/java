
public class carTest1 {
	public static void main(String args[]) {
		car1 c1 = new car1("S600", "white", 80);
		car1 c2 = new car1("E500", "blue", 20);
		//int n = car1.numbers; //이거 정적이라 못불러옴
		int n = car1.getNumberOfCars();
		System.out.println("지금까지 생성된 자동차 수 = "+n);
	}
}