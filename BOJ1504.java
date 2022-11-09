package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
	static int N, M;
	static boolean[] visited;
	static int[] dist;
	static final int INF = 200_000_000;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, len));
			list.get(to).add(new Node(from, len));
		}
		st = new StringTokenizer(br.readLine());
		int node1 = Integer.parseInt(st.nextToken());
		int node2 = Integer.parseInt(st.nextToken());
		int ans1 = 0;
		int ans2 = 0;
		ans1 += dijkstra(1, node1);
		ans1 += dijkstra(node1, node2);
		ans1 += dijkstra(node2, N);
		
		ans2 += dijkstra(1, node2);
		ans2 += dijkstra(node2, node1);
		ans2 += dijkstra(node1, N);
		
		if(Math.min(ans1, ans2) >= INF) {
			System.out.print("-1");
			return;
		}
		System.out.print(Math.min(ans1, ans2));
		
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(visited, false);
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
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
		return dist[end];
	}
	
	public static class Node implements Comparable<Node>{
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
