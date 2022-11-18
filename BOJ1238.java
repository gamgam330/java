package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
	static int N, M, X;
	static int[] item;
	static ArrayList<ArrayList<Node>> list1 = new ArrayList<>();
	static ArrayList<ArrayList<Node>> list2 = new ArrayList<>();
	static boolean[] visited;
	static int[] dist1; 
	static int[] dist2; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			list1.add(new ArrayList<>());
			list2.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list1.get(from).add(new Node(to, weight));
			list2.get(to).add(new Node(from, weight));
		}
		dist1 = dijkstra(list1);
		dist2 = dijkstra(list2);
		
		int tmp = 0;
        for (int i = 1; i <= N; i++) {
            tmp = Math.max(tmp, dist1[i] + dist2[i]);
        }
        System.out.print(tmp);
	}
	
	public static int[] dijkstra(ArrayList<ArrayList<Node>> a)  {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));
		
		visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int tmp = node.end;
			
			if(!visited[tmp]) {
				visited[tmp] = true;
				
				for(Node adj : a.get(tmp)) {
					if(!visited[adj.end] && dist[adj.end] > dist[tmp] + adj.length) {
						dist[adj.end] = dist[tmp] + adj.length;
						pq.add(new Node(adj.end, dist[adj.end]));
					}
				}
			}
		}
		return dist;
	}
	
	static class Node implements Comparable<Node>{
		int end, length;
		
		Node(int end, int length){
			this.end = end;
			this.length = length;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.length - o.length;
		}
	}
}
