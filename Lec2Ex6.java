/*
 * 예제 프로그램
 * @version 1.0 2022-03-24
 * @author 김규민
 */
public class Lec2Ex6 {
	public static void main (String args[]) {
		int[] s = {12, 3, 19, 6, 18, 8, 12, 4, 1, 19};
		int less = 20;
		for (int i = 0; i < s.length; i++) {
			if(less > s[i])
				less = s[i];
		}
		System.out.printf("가장작은 수는"+less+"입니다.");
	}
	
}
