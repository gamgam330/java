package ����;

import java.util.StringTokenizer;

public class ����18528_���� {
	public static void main(String[] args) {
		String str = "this$my%string^";
		StringTokenizer st = new StringTokenizer(str,"$%^");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
