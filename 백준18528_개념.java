package 백준;

import java.util.StringTokenizer;

public class 백준18528_개념 {
	public static void main(String[] args) {
		String str = "this$my%string^";
		StringTokenizer st = new StringTokenizer(str,"$%^");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
