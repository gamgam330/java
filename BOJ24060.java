package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24060 {
	static int[] tmp;
	static int N, K;
	static int cnt = 0;
	static int result = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, N-1);
		System.out.print(result);
		
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(cnt > K) return;
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start, j = mid + 1, t = 0;
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			}
			else {
				tmp[t++] = arr[j++];
			}
		}
		while (i <= mid) tmp[t++] = arr[i++];
		while (j <= end) tmp[t++] = arr[j++];
		
		i = start;
		t = 0;
		while (i <= end) {
			cnt++;
			if(cnt == K) {
				result = tmp[t];
				break;
			}
			arr[i++] = tmp[t++];
		}
	}
}
