import java.util.*;
import java.io.*;

public class Main {
    static int L, N, Q;
    static int[][] map;
    static List<Node> player;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result;

    static boolean[] visited;

    static Stack<Integer> s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        map = new int[L+1][L+1];

        player = new ArrayList<>();

        result = 0;

        for(int i = 1; i <= L; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= L; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Node firstDummyData = new Node(-1, -1, -1, -1, -1);
        player.add(firstDummyData);

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Node node = new Node(x, y, h, w, k);
            player.add(node);
        }

        //기사 이동
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            
            //System.out.println("index : " + index + " dir : " + dir);
            solution(index, dir);
        }

        System.out.println(result);
    }

    private static void solution(int index, int dir){
        //피가 0이면 건너뛰기
        if(player.get(index).k == 0){
            return;
        }
        
        s = new Stack<>();
        visited = new boolean[N + 1];
        if(!isCanMove(index, dir)){
            return;
        }

        movePlayer(dir);
    }

    private static boolean isCanMove(int index, int dir){
        if(visited[index]) return true;
        visited[index] = true;
        s.push(index);
        //좌상단 좌표
        int x = player.get(index).x;
        int y = player.get(index).y;


        //밀린 후 좌상단 좌표
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        //기본적으로 player.get(index).x 는 좌상단 좌표임.
        //아래와 같이 구해주면 우하단 좌표가 나옴.
        int startX = x + (player.get(index).h - 1);
        int startY = y + (player.get(index).w - 1);

        //이 end좌표는 밀린 후의 우하단 좌표임
        int endX = startX + dx[dir];
        int endY = startY + dy[dir];

        //즉 startX <= 타겟의X <= endX && startY <= 타깃의Y <= endY이면 연쇄적으로 밀려야함

        //밀린게 범위에서 벗어나면 false;
        if(1 > nx || nx > L || 1 > ny || ny > L || 1 > endX || endX > L || 1 > endY || endY > L){
            return false;
        }


        //벽을 만나도 false;
        for(int i = nx; i <= endX; i++){
            for(int j = ny; j <= endY; j++){
                if(map[i][j] == 2){
                    return false;
                }
            }
        }

        //사이에 사람이 있다면?
        for (int i = 1; i <= N; i++) {
            if (i == index || player.get(i).k <= 0) continue;

            if (isInRange(nx, ny, endX, endY, i, index)) {
                if (!isCanMove(i, dir)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private static void movePlayer(int dir){
        int len = s.size();
        //System.out.println("len : " + len);
        //System.out.println("len : " + len);
        for(int i = 1; i <= len; i++){
            int index = s.pop();
            //System.out.println("stack index : " + index);

            //움직이기 전 좌상단 좌표
            int x = player.get(index).x;
            int y = player.get(index).y;

            //움직인 후 좌상단 좌표
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //System.out.println("움직이기 전 후 : " + x + " " + y + " " + nx + " " + ny);

            player.get(index).x = nx;
            player.get(index).y = ny;

            if(i < len){
                addDamege(nx, ny, index);
            }
        }
    }

    private static void addDamege(int cx, int cy, int index){
        int damage = 0;
        //움직인 후 우하단 좌표
        int nextX = cx + (player.get(index).h - 1);
        int nextY = cy + (player.get(index).w - 1);
        for (int i = cx; i <= nextX; i++) {
            for (int j = cy; j <= nextY; j++) {
                if (map[i][j] == 1) {
                    //System.out.println("트랩 : " + i + " " + j);
                    player.get(index).k--;
                    damage++;
                }
            }
        }

        if(player.get(index).k > 0){
            result += damage;
        }
        //System.out.println("result : " + result);
    }


    private static boolean isInRange(int startX, int startY, int endX, int endY, int index, int pullPlayer){
        int[][] playerMap = new int[L+1][L+1];

        //startX, startY는 민애의 밀린 후 좌상단 좌표
        //endX, endY는 민애의 밀린 후 우하단 좌표
        for(int i = startX; i <= endX; i++){
            for(int j = startY; j <= endY; j++){
                playerMap[i][j] = pullPlayer;
            }
        }

        //검사할 target의 좌상단 좌표
        int x = player.get(index).x;
        int y = player.get(index).y;

        //검사할 target의 우하단 좌표
        int ex = x + (player.get(index).h - 1);
        int ey = y + (player.get(index).w - 1);


        for(int i = x; i <= ex; i++){
            for(int j = y; j <= ey; j++){
                if(playerMap[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }

    static class Node{
        int x;
        int y;
        int h;
        int w;
        int k;

        public Node(int x, int y, int h, int w, int k){
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
            this.k = k;
        }
    }
}