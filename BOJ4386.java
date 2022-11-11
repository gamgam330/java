package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386 {
	static int N;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static boolean[] visited;
	static double[] dist;
	static Star[] stars;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		dist = new double[N+1];
		stars = new Star[N+1];
		StringTokenizer st;
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
			for(int j = 1; j <= i; j++) {
				double dist = calDist(stars[i], stars[j]);
				list.get(i).add(new Node(j, dist));
				list.get(j).add(new Node(i, dist));
			}
		}
		
		double sum = 0;
		Arrays.fill(visited, false);
		Arrays.fill(dist, Double.MAX_VALUE - 1);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int no = temp.end;
			double length = temp.length;
			if(visited[no]) continue;
			sum += length;
			visited[no] = true;
			
			for(Node adj : list.get(no)) {
				if(!visited[adj.end]) {
					pq.offer(adj);
				}
			}
		}
		System.out.print(sum);
	}
	
	public static class Star {
		double x;
		double y;

		Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Node implements Comparable<Node>{
		int end;
		double length;
		Node(int end, double length){
			this.end = end;
			this.length = length;
		}
		@Override
		public int compareTo(Node o) {
			if(this.length < o.length) return -1;
			return 1;
		}
	}
	public static double calDist(Star a, Star b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
}
