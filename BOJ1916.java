package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
	static boolean[] visited;
	static int N, M;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		//도시의 수
		M = Integer.parseInt(br.readLine());		//버스의 수
		StringTokenizer st;
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, money));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dist, Integer.MAX_VALUE - 1);
		
		dijkstra(startPoint, endPoint);
		System.out.print(dist[endPoint]);
	}
	
	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodePoint = node.end;
			int c = node.cost;
			
			if(visited[nodePoint]) continue;
			
			visited[nodePoint] = true;
			
			for(Node temp : graph.get(nodePoint)) {
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
