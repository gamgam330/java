import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] map;
    static ArrayList<int[]> vitaminMap;
    static int N, M, D, P;
    static boolean[][] vitamin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        vitaminMap = new ArrayList<>();
        vitamin = new boolean[N][N];

        vitaminMap.add(new int[]{N-2, 0});
        vitaminMap.add(new int[]{N-2, 1});
        vitaminMap.add(new int[]{N-1, 0});
        vitaminMap.add(new int[]{N-1, 1});

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(true){
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            count++;

            movePosition();
            inputVitamin();
            findOverTwo();
           
            vitamin = new boolean[N][N];
            if(count >= M){
                break;
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result += map[i][j];
            }
        }
        

        System.out.println(result);
    }

    private static void movePosition(){
        for(int i = 0; i < vitaminMap.size(); i++){
            for(int j = 0; j < P; j++){
                int[] cur = vitaminMap.get(i);
                int x = cur[0];
                int y = cur[1];

                int nx = x + dx[D-1];
                int ny = y + dy[D-1];

                if(nx == N){
                    nx = nx % N;
                }
                if(ny == N){
                    ny = ny % N;
                }
                if(nx == -1){
                    nx = N-1;
                }
                if(ny == -1){
                    ny = N-1;
                }
                vitaminMap.set(i, new int[]{nx, ny});
            }
        }

        for(int i = 0; i < vitaminMap.size(); i++){
            int[] cur = vitaminMap.get(i);
            int x = cur[0];
            int y = cur[1];

            map[x][y]++;
        }
    }

    private static void inputVitamin(){
        for(int i = 0; i < vitaminMap.size(); i++){
            int[] cur = vitaminMap.get(i);
            
            int x = cur[0];
            int y = cur[1];

            if((x - 1) >= 0 && (y - 1) >= 0 && map[x-1][y-1] >= 1){
                map[x][y]++;
            }
            if((x - 1) >= 0 && (y + 1) < N && map[x-1][y+1] >= 1){
                map[x][y]++;
            }
            if((x + 1) < N && (y - 1) >= 0 && map[x+1][y-1] >= 1){
                map[x][y]++;
            }
            if((x + 1) < N && (y + 1) < N && map[x+1][y+1] >= 1){
                map[x][y]++;
            }
        }
    }

    private static void findOverTwo(){
        ArrayList<int[]> tmp = new ArrayList<>();
        
        for(int i = 0; i < vitaminMap.size(); i++){
            int[] cur = vitaminMap.get(i);
            int x = cur[0];
            int y = cur[1];

            vitamin[x][y] = true;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] >= 2 && !vitamin[i][j]){
                    map[i][j] -= 2;
                    tmp.add(new int[]{i, j});
                }
            }
        }

        vitaminMap = tmp;
    }
}