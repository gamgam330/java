package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11918 {
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 long N = Integer.parseInt(st.nextToken());
		 long L = Integer.parseInt(st.nextToken());
		 ArrayList<Light> arr = new ArrayList<>();
		 st = new StringTokenizer(br.readLine());
		 
		 for(int i = 0; i < N; i++) {
			 int light = Integer.parseInt(st.nextToken());
			 arr.add(new Light(light - L, light + L));
		 }
		 
		 arr.add(new Light(1000000001,1000000001));
		 long ans = 0;
		 Collections.sort(arr);
		 if(N <= 1) {
			 System.out.print(ans);
			 System.exit(0);
		 }
		 
		 Light first = arr.get(1);
		 Light second = arr.get(0);
		 long start = first.sLight;
		 long end = second.eLight;
		 for(int i = 2; i <= N; i++) {				//2 3 4 5까지 4번 돔 사이클
			 if(start < end) {
				 ans += Math.abs(start - end);
			 }
			 first = arr.get(i);		//3
			 second = arr.get(i-1);		//2
			 
			 start = Math.max(first.sLight, end);		//-2
			 end = second.eLight;						//1
		 }
		 System.out.print(ans);
	 }
	 
	 static class Light implements Comparable<Light>{
	        long sLight;
	        long eLight;

	        public Light(long sLight, long eLight) {
	            this.sLight = sLight;
	            this.eLight = eLight;
	        }
	        
	        @Override
			public int compareTo(Light o) {
				if(this.sLight - o.sLight > 0) return 1;
				else return -1;
			}
	    }
}