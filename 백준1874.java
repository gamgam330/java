package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		int first = 0;
		
		while(N-- > 0) {	
			int t = Integer.parseInt(br.readLine());
			
			if(t > first) {
				for(int i = first + 1; i <= t; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				first = t;
			}
			else if(stack.peek() != t) {
				System.out.println("NO");
				System.exit(0);
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}