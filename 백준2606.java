package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2606 {
	static ArrayList<Integer>[] list;
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		BFS(1);
	}
	
	static void BFS(int S) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		
		q.add(S);
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i:list[n]) {
				if(!visited[i]) {
				cnt++;
				visited[i] = true;
				q.add(i);
				}
			}
		}
		System.out.print(cnt);
	}
}
