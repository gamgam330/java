import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, max, itemSum;
	static int[] item;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static boolean[] visited;
	static int[] dist; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());				//지역의 개수
		M = Integer.parseInt(st.nextToken());				//수색범위
		R = Integer.parseInt(st.nextToken());				//길의 개수
		st = new StringTokenizer(br.readLine());
		
		item = new int[N+1];
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, road));
			list.get(to).add(new Node(from, road));
		}
		max = 0;
		dijkstra();
		System.out.print(max);
	}
	
	static void dijkstra() {
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 1; i <= N; i++) {
			itemSum = 0;
			Arrays.fill(visited, false);
			Arrays.fill(dist, Integer.MAX_VALUE - 1);
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(i, 0));
			dist[i] = 0;
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int pos = node.end;
				if(visited[pos]) continue;
				visited[pos] = true;
				for(Node temp : list.get(pos)) {
					if(dist[temp.end] > dist[pos] + temp.length) {
						dist[temp.end] = dist[pos] + temp.length;
						pq.add(new Node(temp.end, dist[temp.end]));
					}
				}
			}
			for(int j = 1; j <= N; j++) {
				if(dist[j] <= M) {
					itemSum += item[j];
				}
			}
			if(itemSum > max) {
				max = itemSum;
			}
		}
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
