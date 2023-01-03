package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25587 {
	static int[] parent;
	static int[] arr1;
	static int[] arr2;
	static int ans;
	static int[] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		arr1 = new int[N+1];
		arr2 = new int[N+1];
		cnt = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
			cnt[i] = 1;
			parent[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
			if(arr1[i] < arr2[i]) ans++;						//ȫ���� ���� ������ ����
		}
		
		while(M > 0) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if(q == 1) {
				int x, y;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				union(x, y);
			}else {
				System.out.println(ans);
			}
			M--;
		}
	}
	public static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		else {
			return parent[a] = find(parent[a]);
		}
	}
	public static void union(int a, int b) {
		int pa = find(a), pb = find(b);							//����Ǿ��ִ��� Ȯ��.
		if (pa != pb) {											//����Ǿ����� �ʴٸ�
			if (arr1[pa] < arr2[pa]) {
				ans -= cnt[pa];
			}
			if (arr1[pb] < arr2[pb]) {
				ans -= cnt[pb];
			}													//���� ������ �ٸ��� ���ļ� �ذ��ߴ� �����ϰ� �ϴܻ�.
			arr1[pa] += arr1[pb];
			arr2[pa] += arr2[pb];
			cnt[pa] += cnt[pb];
			if (arr1[pa] < arr2[pa]) {							//�ٵ� ���� ��ϱ� �ƴϸ� �ٽ� �氰�� ������ ������ŭ +���ִ°�.
				ans += cnt[pa];
			}
			parent[pb] = pa;
		}
	}
}
