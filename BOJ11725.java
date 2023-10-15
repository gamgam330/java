import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> graph[];
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int n){
        visited[n] = true;
        for(int i : graph[n]){
            if(!visited[i]){
                parent[i] = n;
                dfs(i);
            }
        }
    }
}
