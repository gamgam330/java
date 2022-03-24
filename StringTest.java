import java.util.Scanner;

public class StringTest {
	public static void main (String[] args) {
		String tem;
		Scanner input = new Scanner(System.in);
		System.out.print("문자열을 입력하시오 : ");
		tem = input.next();
		
		while (true) {
			if(tem.equals("quit") == true)
				break;
			if(tem.contains("www.")) {
				System.out.println(tem+"은 www로 시작합니다.");
				break;
			}
			else
				System.out.println(tem+"은 www로 시작하지 않습니다.");
			break;
		}		
	}
}
