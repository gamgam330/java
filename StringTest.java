import java.util.Scanner;

public class StringTest {
	public static void main (String[] args) {
		String tem;
		Scanner input = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��Ͻÿ� : ");
		tem = input.next();
		
		while (true) {
			if(tem.equals("quit") == true)
				break;
			if(tem.contains("www.")) {
				System.out.println(tem+"�� www�� �����մϴ�.");
				break;
			}
			else
				System.out.println(tem+"�� www�� �������� �ʽ��ϴ�.");
			break;
		}		
	}
}
