import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static Rudolf rudolf;
    static List<Santa> santas;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] dist;

    static int N, M, P, C, D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        santas = new ArrayList<>();
        dist = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());

        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());

        rudolf = new Rudolf(rx, ry);
        map[rx][ry] = -1;

        santas.add(new Santa(-100, -100, 0, false,0,false,0));

        List<Santa> tempList = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            map[sx][sy] = num;
            tempList.add(new Santa(num, sx, sy, false, 0,true, 0));
        }

        tempList.sort(Comparator.comparingInt(s -> s.num));

        santas.addAll(tempList);

        solution();

        for(Santa santa : santas){
            // System.out.println(santa.num);
            if(santa.x != -100 && santa.y != -100){
                // System.out.println(santa.num);
                sb.append(santa.score).append(" ");
            }
        }
        System.out.print(sb);
    }

    private static void solution(){
        for(int i = 0; i < M; i++){
            // for(int j = 1; j <= N; j++){
            //     for(int k = 1; k <= N; k++){
            //         System.out.print(map[j][k] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            
            for(int j = 1; j <= N; j++){
                Arrays.fill(dist[j], Integer.MAX_VALUE - 1);
            }

            boolean flag = false;
            for(Santa santa : santas){
                if(santa.isAlive()){
                    flag = true;
                }
            }

            if(!flag){
                return;
            }

            //루돌프 거리계산
            int min = findShortRoot();

            //루돌프 이동
            moveRudolf(min);

            //산타 이동
            moveSanta();
        
            for(Santa santa : santas){
                if(santa.isAlive()){
                    santa.score += 1;
                }
            }
            for(Santa santa : santas){
                santa.subSternCount();
            }
        }
    }

    private static void moveSanta() {
        for (Santa santa : santas) {
            if (!santa.isAlive() || santa.isStern()) continue;

            int x = santa.x, y = santa.y;
            int rx = rudolf.x, ry = rudolf.y;

            // 현재 위치의 거리
            int curDist = (x - rx)*(x - rx) + (y - ry)*(y - ry);
            // 최소 거리는 현재 거리로 시작
            int minDist = curDist;
            int cx = x, cy = y;
            int dirx = 0, diry = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (map[nx][ny] > 0) continue;  // 다른 산타가 있으면 건너뛰기

                int d2 = (nx - rx)*(nx - rx) + (ny - ry)*(ny - ry);
                // 새 칸이 반드시 더 가까워질 때만 후보로
                if (d2 < minDist) {
                    minDist = d2;
                    cx = nx;  cy = ny;
                    dirx = dx[i];  diry = dy[i];
                }
            }

            // 원래 칸 비우기
            map[x][y] = 0;

            // 충돌 체크(여전히 cx,cy==x,y라면 이동 안 함)
            if (map[cx][cy] == -1) {
                santa.score += D;
                santa.startStern();
                int bx = cx - dirx * D;
                int by = cy - diry * D;
                if (bx < 1 || bx > N || by < 1 || by > N) {
                    santa.alive = false;
                    continue;
                }
                if (map[bx][by] > 0) {
                    pullAtherSanta(-dirx, -diry, map[bx][by]);
                }
                cx = bx;  cy = by;
            }

            // 새 위치에 배치 (cx,cy가 x,y면 제자리)
            map[cx][cy] = santa.num;
            santa.x = cx;
            santa.y = cy;
        }
    }



    private static void moveRudolf(int min){
        int x = 0;
        int y = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(dist[i][j] == min){
                    x = i;
                    y = j;
                }
            }
        }
        
        int rx = rudolf.x;
        int ry = rudolf.y;

        //이동해야할 좌표 예) 1, -1
        int ax = Integer.signum(x - rudolf.x);
        int ay = Integer.signum(y - rudolf.y);

        //루돌프 좌표에서 이동한 좌표
        int nx = rx + ax;
        int ny = ry + ay;

        //이동했는데 만약 산타가 있으면
        if(map[nx][ny] > 0){
            //산타가 밀려나야할 좌표
            int kx = ax * C;
            int ky = ay * C;
            // System.out.println("루돌프 파워 : " + C);
            // System.out.println("날아가는 파워 x좌표 : " + kx + " y좌표 : " + ky);

            //산타 날려버리기위해 산타의 정보 index로 가져오기
            //System.out.println("검출된 산타 : "+ map[nx][ny]);
            Santa santa = santas.get(map[nx][ny]);
            int sx = santa.x;
            int sy = santa.y;


            //날아가서 좌표 초기화
            santa.startStern();

            //System.out.println("날아가기 전 sx, sy : " + sx + " " + sy);
            //날아가기
            sx = sx + kx;
            sy = sy + ky;
            //System.out.println("날아간 후 sx, sy : " + sx + " " + sy);
            

            //만약 범위 밖으로 나갔으면 탈락
            if(1 > sx || sx > N || 1 > sy || sy > N){
                //System.out.println("탈락 : " + sx + " "+ sy);
                santa.alive = false;
            }

            //범위 안이고 날아간곳에 산타가 있으면?
            if(1 <= sx && sx <= N && 1 <= sy && sy <= N && map[sx][sy] > 0){
                pullAtherSanta(ax, ay, map[sx][sy]);
                map[sx][sy] = map[nx][ny];
            }else if(1 <= sx && sx <= N && 1 <= sy && sy <= N && map[sx][sy] == 0){
                map[sx][sy] = map[nx][ny];
            }
            
            //산타 점수 획득
            santa.score += C;
            //System.out.println("점수를 획득한 산타 : " + santa.num + " 점수 : " + C);
            santa.x = sx;
            santa.y = sy;
        }

        //루돌프 자리 안착
        rudolf.x = nx;
        rudolf.y = ny;
        map[rx][ry] = 0;
        map[nx][ny] = -1;
    }

    private static void pullAtherSanta(int dx, int dy, int idx) {
        Santa santa = santas.get(idx);
        int oldX = santa.x;
        int oldY = santa.y;
        int newX = oldX + dx;
        int newY = oldY + dy;

        // 이전 위치 비우기
        map[oldX][oldY] = 0;

        // 새 위치가 범위 밖이면 탈락 처리 후 즉시 종료
        if (newX < 1 || newX > N || newY < 1 || newY > N) {
            santa.alive = false;
            return;
        }

        // 새 위치에 다른 산타가 있으면 먼저 밀어주기
        if (map[newX][newY] > 0) {
            pullAtherSanta(dx, dy, map[newX][newY]);
        }

        // 자기 자신 배치
        map[newX][newY] = idx;
        santa.x = newX;
        santa.y = newY;
    }


    private static int findShortRoot(){
        int min = Integer.MAX_VALUE - 1;
        for(Santa santa : santas){
            if(!santa.alive){
                continue;
            }
            int rx = rudolf.x;
            int ry = rudolf.y;

            int sx = santa.x;
            int sy = santa.y;

            int result = (rx - sx) * (rx - sx) + (ry - sy) * (ry - sy);
            dist[sx][sy] = result;

            min = Math.min(min, result); 
        }
        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= N; j++){
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return min;
    }

    static class Santa{
        int num;
        int x;
        int y;
        boolean stern;
        int sternCount;
        boolean alive;
        int score;

        public Santa(int num, int x, int y, boolean stern, int sternCount, boolean alive, int score){
            this.num = num;
            this.x = x;
            this.y = y;
            this.stern = stern;
            this.sternCount = sternCount;
            this.alive = alive;
            this.score = score;
        }

        public boolean isStern(){
            return this.stern;
        }

        public boolean isAlive(){
            return this.alive;
        }

        public void startStern(){
            this.sternCount = 2;
            this.stern = true;
        }

        public void subSternCount(){
            if (!this.stern) return;
            this.sternCount--;
            if (this.sternCount <= 0) {
                this.stern = false;
            }
        }
    }

    static class Rudolf{
        int x;
        int y;

        public Rudolf(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}