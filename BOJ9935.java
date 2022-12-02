package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str1 = br.readLine();
		StringBuilder sb = new StringBuilder();
		int length = str1.length();
		Stack<Character> s = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			
			if(s.size() >= length) {
				boolean b = true;
				for(int j = 0; j < length; j++) {
					if(s.get(s.size() - length + j) != str1.charAt(j)) {
						b = false;
						break;
					}
				}
				if(b) {
					for(int x = 0; x < length; x++) {
						s.pop();
					}
				}
			}
		}
		if(s.size() == 0) {
			System.out.println("FRULA");
		}
		else {
			for(char a : s) {
				sb.append(a);
			}
		}
		System.out.print(sb);
	}
}
