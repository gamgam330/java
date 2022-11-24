package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17396 {
	static int N, M;
	static int[] wad;
	static boolean[] visited;
	static long[] dist;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wad = new int[N];
		dist = new long[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			wad[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}
		dijkstra(0);
		if(dist[N-1] == Long.MAX_VALUE) {
			System.out.print("-1");
		}else {
			System.out.print(dist[N-1]);
		}
	}
	
	private static void dijkstra(int start) {
		Arrays.fill(visited, false);
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodePoint = node.end;
			
			if(visited[nodePoint]) continue;
			visited[nodePoint] = true;
			
			for(Node temp : list.get(nodePoint)) {
				
				if((temp.end != (N-1)) && (wad[temp.end] == 1)) continue;
				if(dist[nodePoint] + temp.weight < dist[temp.end]) {
					dist[temp.end] = dist[nodePoint] + temp.weight;
					pq.offer(new Node(temp.end, dist[temp.end]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int end;
		long weight;
		
		Node(int end, long weight){
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.weight - o.weight > 0) return 1;
			else return -1;
		}
	}
}
