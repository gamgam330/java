import java.util.Scanner;

/*
 * 예제 프로그램
 * @version 1.0 2022-03-24
 * @author 김규민
 */

public class Lec2Ex7 {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		int[] s= {0,11,18,29,35,49,62,68,73,88,100};
		int serch=0;
		int found;
		System.out.printf("찾고자 하는 수를 입력하시오 : ");
		found = input.nextInt();
		
		for(int i = 0; i < s.length; i++) {
			if(found < s[i]) {
				serch = i;
				break;
			}
			else if(found == s[i]) {
				System.out.printf(found+"는 "+s[i]+"와 같습니다.");
				System.exit(0);
			}
		}
		System.out.printf(found+"는 "+s[serch-1]+"보다 크고 "+s[serch]+"보다 작습니다");
	}
}