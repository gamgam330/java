import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("-");

		int total = 0;

		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			String[] arr2 = arr[i].split("\\+");
			for(int j = 0; j < arr2.length; j++) {
				sum += Integer.parseInt(arr2[j]);
			}
			if(i==0) {
				total += sum;
			}else {
				total -= sum;
			}
		}
		System.out.println(total);
	}
}