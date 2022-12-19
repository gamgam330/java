package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ1302 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] name = new String[N];
		String maxName = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			name[i] = br.readLine();
		}
		
		Arrays.sort(name);
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(map.containsKey(name[i])) map.replace(name[i], map.get(name[i])+1);
			else map.put(name[i], 1);
			
			if(max < map.get(name[i])) {
				max = map.get(name[i]);
				maxName = name[i];
			}
		}	
		System.out.print(maxName);
	}
}
