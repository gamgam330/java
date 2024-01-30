import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int a, b, cnt = 1;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[a][b];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < a; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < b; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r,c,d);
        System.out.print(cnt);
    }

    public static void dfs(int x, int y, int d){
        arr[x][y] = -1;
        for(int i = 0; i < 4; i++){
            d = (d + 3) % 4;            //방향 자체는 90도 회전해야함.
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0 <= nx && nx < a && 0 <= ny && ny < b && arr[nx][ny] == 0){
                cnt++;
                dfs(nx, ny, d);
                return;
            }
        }

        int back = (d + 2) % 4;         //같은방향 바라보고 뒤로 후진해야하니까 d자체를 빠구는게 아니라 back이라는 변수 사용
        int by = y + dy[back];
        int bx = x + dx[back];

        if(0 <= by && by < b && 0 <= bx && bx < a && arr[bx][by] != 1){
            dfs(bx, by, d);
        }
    }
}
