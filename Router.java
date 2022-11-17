package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Router {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1) {
				break;
			}
			if(cnt == N) {
				if(n == 0) {
					q.poll();
					cnt--;
				}
				continue;
			}
			if(n > 0) {
				q.add(n);
				cnt++;
			}
			else if(n == 0) {
				q.poll();
				cnt--;
			}
		}
		if(q.isEmpty()) {
			System.out.print("empty");
		}else {
			while(!q.isEmpty()) {
				System.out.print(q.poll()+ " ");
			}
		}
	}
}
