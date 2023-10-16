import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0){
                System.exit(0);
            }
            count = 0;
            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(visited[i][j] == false && arr[i][j] == 1){
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny] && arr[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
}
