import java.util.Scanner;

public class Lec2Ex5 {
	public static void main (String args[]) {
		int curcle;
		double sum=0;
		Scanner input = new Scanner(System.in);
		System.out.printf("�ݺ�Ƚ���� �Է��Ͻÿ� : ");
		curcle = input.nextInt();
		
		for (int i = 1; i < curcle+1; i++) {
				sum += (Math.pow(-1, i+1))*(4.0/(2*i-1));
		}
		System.out.println("���̴�"+sum+"�Դϴ�.");
	}
}
