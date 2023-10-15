import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10026 {
    static int N;
    static char[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static String str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count);

        count = 0;
        
        visited = new boolean[N+1][N+1];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }

         for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.print(" "+count);
    }

    public static void dfs(int n, int m){
        visited[n][m] = true;
        char tmp = arr[n][m];
        for(int i = 0; i < 4; i++){
            int newx = dx[i] + n;
            int newy = dy[i] + m;

            if(newx < 0 || newy < 0 || newx > N || newy > N){
                continue;
            }

            if(!visited[newx][newy] && arr[newx][newy] == tmp){
                dfs(newx, newy);
            }
        }
    }
}
