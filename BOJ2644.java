import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2644 {
    static ArrayList<Integer> arr[];
    static int a, b;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        arr = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }
        int cnt = 0;
        dfs(a, cnt);

        if(count == 0) System.out.print(-1);
        else System.out.print(count);
    }

    static void dfs(int n, int cnt){
        visited[n] = true;
        for(int i : arr[n]){
            if(!visited[i]){
                if(i == b){
                    count = cnt + 1;
                    return;
                }
                dfs(i, cnt+1);
            }
        }
    }
}
