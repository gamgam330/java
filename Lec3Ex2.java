import java.util.Scanner;

public class Lec3Ex2 {
	public static void main (String args[]) {
		
		Scanner input = new Scanner(System.in);
		System.out.printf("���� ������ �Է��Ͻÿ� : ");
		int num = input.nextInt();
		System.out.println(num+"�� ����� ������ �����ϴ�.");
		
		for(int i = 1; i < num; i++) {
			if((num % i) == 0) {
				System.out.printf(i+" ");
			}
		}
	}
}