package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ5639 {
	static ArrayList<Integer> tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new ArrayList<Integer>();
		while(true) {
			String N = br.readLine();
			if(N == null || N.equals("")) break;
			tree.add(Integer.parseInt(N));
		}
		postOrder(0, (tree.size() - 1));
	}
	
	public static void postOrder(int cnt, int right) {
		if(cnt>right) return;
		int mid = cnt+1;
		while(mid <= right && tree.get(mid) < tree.get(cnt)) {
			mid++;
		}
		postOrder(cnt+1, mid-1);
		postOrder(mid, right);
		System.out.println(tree.get(cnt));
	}
}
