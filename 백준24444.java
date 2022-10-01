package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준24444 {
	static ArrayList<Integer>[] list;
	static int N, M, S;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
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
		DFS(S);
	}
	static void DFS(int S) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		int[] result = new int[N+1];
		for (int i = 1; i <= N; i++) { 
			Collections.sort(list[i]);
		}
		System.out.print(list[1]);
		q.add(S);
		visited[S] = true;
		while(!q.isEmpty()) {
			int Q = q.poll();
			result[Q] = ++cnt;
			for(int i:list[Q]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		for(int i = 1 ; i <= N; i++) { 
			System.out.println(result[i]);
		}
	}
}
