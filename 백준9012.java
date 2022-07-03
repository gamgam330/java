package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class 백준9012 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			sb.append(result(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static String result(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			
			char pl = str.charAt(i);
			
			if (pl == '(') stack.push(pl);
			else if (!stack.empty()) stack.pop(); 
			else return "NO";
			
		}
		if (!stack.empty()) return "NO";
		else return "YES";
	}
}