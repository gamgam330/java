
public class CarTest {
	public static void main (String[] args) {
		car myCar = new car();	//�Լ������ϱ�
		myCar.changeGear(1);	//�Ű����� 1�� ������ myCar changeGear �޼ҵ� ����.
		myCar.speedDown();		//�Ű����� ���� myCar speedDown �޼ҵ� ����.
		System.out.println(myCar);
	}
}