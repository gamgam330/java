package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ12788 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int member = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list, Collections.reverseOrder());
		int cnt = 0;
		int count = 0;
		while(member > 0 && count != N) {
			member -= list.get(cnt++);
			count++;
		}
		if(member <= 0) {
			System.out.print(count);
		}
		else {
			System.out.print("STRESS");
		}
	}
}