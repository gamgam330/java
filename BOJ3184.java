import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3184 {
    static int R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Character[][] arr;
    static boolean[][] visited;
    static int wolf, sheep;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        visited = new boolean[R][C];
        int cntWolf = 0;
        int cntSheep = 0;
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'v'){
                    cntWolf++;
                }else if(arr[i][j] == 'o'){
                    cntSheep++;
                }
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j]){
                    wolf = 0;
                    sheep = 0;
                    dfs(i, j);
                    if(wolf >= sheep){
                        cntSheep -= sheep;
                    }else if(wolf < sheep){
                        cntWolf -= wolf;
                    }
                }
            }
        }
        System.out.print(cntSheep + " " + cntWolf);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        if(arr[x][y] == 'v'){
            wolf++;
        }else if(arr[x][y] == 'o'){
            sheep++;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] != '#' && !visited[nx][ny]){       //이거 방문처리 안하면 같은곳 왔다갔다 거림 앞뒤 양옆으로..
                dfs(nx, ny);
            }
        }
    }
}
