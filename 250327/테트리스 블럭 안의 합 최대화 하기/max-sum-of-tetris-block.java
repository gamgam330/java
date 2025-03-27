import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int[][] visited = new int[N][M];
        result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = 1;
                backTracking(i, j, 1, visited);
                visited[i][j] = 0;
            }
        }

        System.out.println(result);
    }

    private static void backTracking(int x, int y, int count, int[][] visited){
        if(count == 4){
            findVisitedBox(visited);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M){
                if(visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    backTracking(nx, ny, count + 1, visited);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    private static void findVisitedBox(int[][] visited){
        int tmp = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 1){
                    tmp += map[i][j];
                }
            }
        }

        result = Math.max(result, tmp);
    }
}