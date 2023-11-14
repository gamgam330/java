import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2665 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] board;
    static int[][] dist;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        dist = new int[N+1][N+1];
        String str;
        for(int i = 0; i < N; i++){
            str = br.readLine();
            for(int j = 0; j < N; j++){
                dist[i][j] = Integer.MAX_VALUE-1;
                board[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(dist[N-1][N-1]);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        dist[0][0] = 0;

        while(!q.isEmpty()){
            int[] corrent = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = corrent[0] + dx[i];
                int ny = corrent[1] + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N && dist[nx][ny] > dist[corrent[0]][corrent[1]]){  //이거 제일 적게 벽을깨는 경우의 수를 구하는거라 이전값이 지금 나보다 더 많이 깻으면 걍 넘어가게 해야함. 그래서 마지막 조건이 붙은것임
                    if(board[nx][ny] == 0){
                        dist[nx][ny] = dist[corrent[0]][corrent[1]] + 1;
                    }else{
                        dist[nx][ny] = dist[corrent[0]][corrent[1]];
                    }
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
