import java.io.*;
import java.util.*;

public class Main {
    static int rSize, cSize;
    static int k;
    static int[][] forest;
    static int[] dy = {-1 ,0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] draw = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};   //상, 하, 좌, 우, 중앙

    static int[][] golem = {{2, 1, 1, 1, 3},
                            {1, 1, 1, 2, 3},
                            {1, 2, 1, 1, 3},
                            {1, 1, 2, 1, 3}};

    static int x, y, ndir;
    static boolean[][] visited;

    //아래로, 왼쪽아래, 오른쪽아래 체크해야할 것들
    static int[][] southCheck = {{1,-1},{2,0},{1,1}};
    static int[][] westCheck = {{-1,-1},{0,-2},{1,-1},{1,-2},{2,-1}};
    static int[][] eastCheck = {{0,2},{-1,1},{1,1},{1,2},{2,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rSize = Integer.parseInt(st.nextToken());
        cSize = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        forest = new int[rSize+3][cSize  ];
        
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException{
        int sum = 0;
        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            //x, y는 중앙값
            x = 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            ndir = Integer.parseInt(st.nextToken());

            if(moveGolem()){
                visited = new boolean[rSize+3][cSize];
                int bottom = dfs(x, y) - 2;

                sum += bottom;
            }else{
                clearForest();
            }
        }

        System.out.println(sum);
    }


    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int max = x;
        if(forest[x][y] == 1){
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(check(nx, ny) && forest[nx][ny] == 3 && !visited[nx][ny]){
                    max = Math.max(max, dfs(nx, ny));
                }
            }
        }else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(check(nx, ny) && forest[nx][ny] != 0 && !visited[nx][ny]){
                    max = Math.max(max, dfs(nx, ny));
                }
            }
        }
        return max;
    }

    private static boolean moveGolem(){
        while(true){
            if(canMove(southCheck)){
            } else if (canMove(westCheck)) {
                y -= 1;
                ndir = (ndir + 3) % 4;
            } else if (canMove(eastCheck)) {
                y += 1;
                ndir = (ndir + 1) % 4;
            } else{
                break;
            }
            x += 1;
        }
        if(x <= 3) return false;
    
        for(int i = 0; i < 5; i++){
            int nx = x + draw[i][0];
            int ny = y + draw[i][1];

            forest[nx][ny] = golem[ndir][i];
        }

        return true;
    }

    private static boolean canMove(int[][] position) {
        for (int[] next : position) {
            int nx = x + next[0];
            int ny = y + next[1];

            if(!check(nx,ny) || forest[nx][ny] != 0){
                return false;
            }
        }
        return true;
    }

    static boolean check(int x, int y){
        return 0 <= x && x < rSize+3 && 0 <= y && y < cSize;
    }

    private static void clearForest() {
        for (int i = 0; i < rSize + 3; i++) {
            for (int j = 0; j < cSize; j++) {
                forest[i][j] = 0;
            }
        }
    }
}