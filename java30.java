package �ڹ�;

public class java30 {
	public static void main(String[] args) {
		Test test = new Test();
		
		try {
			test.test("1", "��");
		} catch(NumberFormatException e) {
			System.out.println("�Է��Ͻ� ���� ���ڰ� �ƴմϴ�.");
		}
	}
}

class Test{
	public void test(String a, String b) throws NumberFormatException{
		try {
			int sum = Integer.parseInt(a) + Integer.parseInt(b);
			System.out.println("���ڷ� �Է¹���" +a+","+b+"�� ����" +sum+"�Դϴ�.");
			
		}catch(NumberFormatException e) {
			System.out.println("������ ���ڰ� �ƴմϴ�. ����ȯ�� �� �� �����ϴ�.");
			throw e;
		}
	}
}
