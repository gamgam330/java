import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);

        System.out.println(result);
    }

    private static void backTracking(int count){
        if(count == 4){
            findVisitedBox();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 0){
                    visited[i][j] = 1;
                    backTracking(count + 1);
                    visited[i][j] = 0;
                }
            }
        }
    }

    private static void findVisitedBox(){
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