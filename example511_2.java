package µ¿¾Æ¸®;
import java.util.Scanner;
public class example511_2 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int value = (scan.nextInt() * scan.nextInt() * scan.nextInt());
		String str = Integer.toString(value);
		
		for(int i = 0; i < 10; i++) {
			int cnt = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) - '0' == i) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}