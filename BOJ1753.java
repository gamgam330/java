package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
	
	static int N, M, R;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, length));
		}
		
		dijkstra();
		
		for(int i = 1; i <= N; i++) {
			if((Integer.MAX_VALUE - 1) != dist[i]) {
				sb.append(dist[i]).append("\n");
			}
			else {
				sb.append("INF").append("\n");
			}
		}
		System.out.print(sb);
	}
	
	private static void dijkstra() {
		Arrays.fill(dist, Integer.MAX_VALUE - 1);
		Arrays.fill(visited, false);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(R, 0));
		dist[R] = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int no = temp.no;
			
			if(visited[no]) continue;
			visited[no] = true;
			
			for(Node adj : list.get(no)) {
				if(dist[adj.no] > dist[no] + adj.length) {
					dist[adj.no] = dist[no] + adj.length;
					pq.offer(new Node(adj.no, dist[adj.no]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {	
		int no;
		int length;
		Node(int no, int length){
			this.no = no;
			this.length = length;
		}
		@Override
		public int compareTo(Node o) {
			return this.length - o.length;
		}
	}
}
