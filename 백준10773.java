package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준10773 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		int result = 0;
		int cnt = stack.size();
		
		for(int i = 0; i < cnt; i++) {
			result += stack.pop();
		}
		
		System.out.print(result);
	}
}
