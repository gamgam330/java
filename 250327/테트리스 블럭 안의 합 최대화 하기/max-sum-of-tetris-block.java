import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                backTracking(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkExceptionShape(i, j);
            }
        }

        System.out.println(result);
    }

    private static void backTracking(int x, int y, int sum, int count){
        if(count == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M&& !visited[nx][ny]){
                visited[nx][ny] = true;
                backTracking(nx, ny, sum + map[nx][ny], count + 1);
                visited[nx][ny] = false;
            }
        }
    }

    private static void checkExceptionShape(int x, int y) {
        if (x >= 0 && x < N - 1 && y > 0 && y < M - 1) {
            int sum = map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1];
            result = Math.max(result, sum);
        }
        if (x > 0 && x < N - 1 && y >= 0 && y < M - 1) {
            int sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1];
            result = Math.max(result, sum);
        }
        if (x > 0 && x < N && y > 0 && y < M - 1) {
            int sum = map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1];
            result = Math.max(result, sum);
        }
        if (x > 0 && x < N - 1 && y > 0 && y < M) {
            int sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
            result = Math.max(result, sum);
        }
    }
}