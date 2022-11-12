package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1647 {
	static int[] parent;
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		parent = new int[N+1];
		int temp = 0, cost = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end, weight));
		}
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			Node tmp = list.get(i);
			if(find(tmp.start) != find(tmp.end)) {
				temp += tmp.weight;
				union(tmp.start, tmp.end);
				cost = tmp.weight;
			}
		}
		System.out.print(temp - cost);
	}
	
	public static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int weight;
		
		Node(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}