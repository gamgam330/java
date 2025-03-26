import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int count;
    static int N, M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        count = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTracking(0);

        System.out.println(count);
    }

    private static void backTracking(int wall){
        if(wall == 3){
            BFS();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    backTracking(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        int[][] fireMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                fireMap[i][j] = map[i][j];
                if(fireMap[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && fireMap[nx][ny] == 0){
                    fireMap[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(fireMap[i][j] == 0){
                    result++;
                }
            }
        }
        count = Math.max(count, result);
    }
}