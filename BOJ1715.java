package น้มุ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		while(pq.size() > 1) {
			int sum1 = pq.poll();
			int sum2 = pq.poll();
			
			result += sum1 + sum2;
			pq.add(sum1 + sum2);
		}
		
		System.out.print(result);
	}
}