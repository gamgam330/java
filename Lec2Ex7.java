import java.util.Scanner;

/*
 * ���� ���α׷�
 * @version 1.0 2022-03-24
 * @author ��Թ�
 */

public class Lec2Ex7 {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		int[] s= {0,11,18,29,35,49,62,68,73,88,100};
		int serch=0;
		int found;
		System.out.printf("ã���� �ϴ� ���� �Է��Ͻÿ� : ");
		found = input.nextInt();
		
		for(int i = 0; i < s.length; i++) {
			if(found < s[i]) {
				serch = i;
				break;
			}
			else if(found == s[i]) {
				System.out.printf(found+"�� "+s[i]+"�� �����ϴ�.");
				System.exit(0);
			}
		}
		System.out.printf(found+"�� "+s[serch-1]+"���� ũ�� "+s[serch]+"���� �۽��ϴ�");
	}
}