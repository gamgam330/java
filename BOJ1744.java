import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
        int answer = 0;
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int minusIdx = 0;
		while (minusIdx < N && arr[minusIdx] < 1) {
			if (minusIdx + 1 < N && arr[minusIdx + 1] < 1) {
				answer += (arr[minusIdx] * arr[minusIdx + 1]);
				minusIdx += 2;
			}
			else {
				answer += arr[minusIdx++];
			}
		}
		
		int plusIdx = N - 1;
		while (plusIdx >= minusIdx && arr[plusIdx] > 0) {
			if (plusIdx - 1 >= minusIdx && arr[plusIdx - 1] > 1) {
				answer += (arr[plusIdx] * arr[plusIdx - 1]);
				plusIdx -= 2;
			}
			else {
				answer += arr[plusIdx--];
			}
		}
		System.out.println(answer);
	}
}