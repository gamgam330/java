package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준24479 {
	static ArrayList<Integer>[] list;
	static int N, M, R;
	static boolean[] visited;
	static int cnt;
	static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		cnt = 0;
		result = new int[N+1];
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
		for (int i = 1; i <= N; i++) { 
			Collections.sort(list[i]);
		}
		result[R] = 1;
		visited[R] = true;
		cnt++;
		DFS(R);
		
		for(int i = 1 ; i <= N; i++) { 
			System.out.println(result[i]);
		}
	}
	
	static void DFS(int idx) {
		for(int i:list[idx]) {
			if(!visited[i]) {
				result[i] = ++cnt;
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
