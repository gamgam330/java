package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준10845 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		
		int num = -1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push":{
					int last = Integer.parseInt(st.nextToken());
					q.add(last);
					num = last;
					break;
				}
				case "pop":{
					if(!q.isEmpty()) sb.append(q.poll()).append("\n");
					else sb.append(-1).append("\n");
					break;
				}
				case "size":{
					sb.append(q.size()).append("\n");
					break;
				}
				case "empty":{
					if(!q.isEmpty()) sb.append(0).append("\n");
					else sb.append(1).append("\n");
					break;
				}
				case "front":{
					if(!q.isEmpty()) sb.append(q.peek()).append("\n");
					else sb.append(-1).append("\n");
					break;
				}
				case "back":{
					if(!q.isEmpty()) sb.append(num).append("\n");
					else sb.append(-1).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}
