
public class carTest1 {
	public static void main(String args[]) {
		car1 c1 = new car1("S600", "white", 80);
		car1 c2 = new car1("E500", "blue", 20);
		//int n = car1.numbers; //�̰� �����̶� ���ҷ���
		int n = car1.getNumberOfCars();
		System.out.println("���ݱ��� ������ �ڵ��� �� = "+n);
	}
}