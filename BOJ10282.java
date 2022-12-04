package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10282 {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			dist = new int[n+1];
			visited = new boolean[n+1];
			
			for(int j = 1; j <= n; j++) {
				dist[j] = Integer.MAX_VALUE;
				list[j] = new ArrayList<>();
			}
			for(int j = 0; j < x; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[to].add(new Node(from, weight));
			}
			int sum = 0;
			int total = 0;
			dijkstra(y);
			for(int j = 1; j <= n; j++) {
				if(dist[j] != Integer.MAX_VALUE) {
					sum++;
					total = Math.max(total, dist[j]);
				}
			}
			System.out.println(sum+" "+total);
		}
	}
		
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodePoint = node.end;
			
			if(visited[nodePoint]) continue;
			visited[nodePoint] = true;
			
			for(Node temp : list[nodePoint]) {
				if(dist[nodePoint] + temp.cost < dist[temp.end]) {
					dist[temp.end] = dist[nodePoint] + temp.cost;
					pq.offer(new Node(temp.end, dist[temp.end]));
				}
			}
			
		}
	}
	static class Node implements Comparable<Node>{
		int end, cost;
		
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
