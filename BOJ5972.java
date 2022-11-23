package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972 {
	static boolean[] visited;
	static int[] dist;
	static int N, M;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}
		
		dijkstra(1);
		
		System.out.print(dist[N]);
	}
	private static void dijkstra(int start) {
		Arrays.fill(visited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodePoint = node.end;
			
			if(visited[nodePoint]) continue;
			visited[nodePoint] = true;
			
			for(Node temp : list.get(nodePoint)) {
				if(dist[nodePoint] + temp.weight < dist[temp.end]) {
					dist[temp.end] = dist[nodePoint] + temp.weight;
					pq.offer(new Node(temp.end, dist[temp.end]));
				}
			}
			
		}
	}
	static class Node implements Comparable<Node>{
		int end, weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
