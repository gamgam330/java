package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Node> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			int M = Integer.parseInt(st.nextToken());
			
			if(s.isEmpty()) {
				System.out.print("0 ");
				s.add(new Node(i, M));
			}
			else {
				while(true) {
					if(s.isEmpty()) {
						System.out.print("0 ");
						s.add(new Node(i, M));
						break;
					}
					Node top = s.peek();
					if(top.height < M) {
						s.pop();
					}
					else {
						System.out.print((top.num)+" ");
						s.push(new Node(i, M));
						break;
					}
				}
			}
		}
	}
	
	static class Node {
		int num;
		int height;
		
		Node(int num, int height){
			this.num = num;
			this.height = height;
		}
	}
}
