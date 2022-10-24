package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1764 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> map = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, str);
		}
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				arr.add(str);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(String a : arr) {
			System.out.println(a);
		}
	}
}
