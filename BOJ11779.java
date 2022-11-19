package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11779 {
	static int N, M;
	static boolean[] visited;
	static int[] dist;
	static int[] route;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		visited = new boolean[N+1];
		route = new int[N+1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		Arrays.fill(visited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(startPoint);
		
		System.out.println(dist[endPoint]);
		
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(endPoint);
		while (route[endPoint] != 0) {
			cnt += 1;
			stack.push(route[endPoint]);
			endPoint = route[endPoint];
		}
		System.out.println(cnt + 1);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	static public void dijkstra(int startPoint) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startPoint, 0));
		dist[startPoint] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodePoint = node.end;
			
			if(visited[nodePoint]) continue;
			visited[nodePoint] = true;
			
			for(Node temp : list.get(nodePoint)) {
				if(dist[nodePoint] + temp.weight < dist[temp.end]) {
					dist[temp.end] = dist[nodePoint] + temp.weight;
					pq.offer(new Node(temp.end, dist[temp.end]));
					route[temp.end] = nodePoint;
					for(int i = 1; i <= N; i++) {
						System.out.print(route[i] + " ");
					}
				}
				System.out.println("");
			}
			
		}
	}
	
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
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
