package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준2164 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
        
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		for(int i = 0; i < N-1; i++) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.print(queue.poll());
	}
}
