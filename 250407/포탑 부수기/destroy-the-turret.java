import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static List<Turrets> turrets;

    static int[] bx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] by = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][][] path;
    static boolean[][] visited;
    static Turrets[][] turretMap;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        turrets = new ArrayList<>();
        turretMap = new Turrets[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    Turrets turret = new Turrets(i, j, map[i][j], 0, 0);
                    turrets.add(turret);
                    turretMap[i][j] = turret;
                }
            }
        }

        for(int i = 1; i <= K; i++){
            solution(i);
            // for(int j = 1; j <= N; j++){
            //     for(int z = 1; z <= M; z++){
            //         System.out.print(map[j][z] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }


        int result = 0;
        for(int i = 0; i < turrets.size(); i++){
            result = Math.max(result, turrets.get(i).damage);
        }

        System.out.println(result);
    }

    private static void solution(int count){
        // 생존 포탑 리스트 구성
        List<Turrets> aliveTurrets = new ArrayList<>();
        for (Turrets t : turrets) {
            if (t.damage > 0 && map[t.x][t.y] > 0) {
                aliveTurrets.add(t);
            }
        }

        if (aliveTurrets.size() <= 1) return;

        // 정렬
        Collections.sort(aliveTurrets);
        
        Turrets attackTurret = aliveTurrets.get(0);
        Turrets damageTurret = aliveTurrets.get(aliveTurrets.size() - 1);

        path = new int[N+1][M+1][2];
        visited = new boolean[N+1][M+1];

        Collections.sort(turrets);

        //공격하는 포탑 좌표
        int attackerX = attackTurret.x;
        int attackerY = attackTurret.y;

        attackTurret.damage += N+M;
        map[attackerX][attackerY] += N+M;

        //공격받는 포탑 좌표
        int damageX = damageTurret.x;
        int damageY = damageTurret.y;

        int turretDamage = attackTurret.damage;
        
        if(isCanLaserAttack(attackerX, attackerY, damageX, damageY)){
            //System.out.println("레이저 공격자와 공격받는자의 좌표 : " + attackerX + " " + attackerY + " " + damageX + " " + damageY);
            attackTurret.lastAttack = count;
            laserAttack(attackerX, attackerY, damageX, damageY, turretDamage, damageTurret, count);
        }else{
            //System.out.println("폭탄 공격자와 공격받는자의 좌표 : " + attackerX + " " + attackerY + " " + damageX + " " + damageY);
            attackTurret.lastAttack = count;
            bombAttack(attackerX, attackerY, damageX, damageY, turretDamage, damageTurret, count);
        }

        //포탑정비
        healTurret(count);
    }

    private static void healTurret(int count){
        int len = turrets.size();

        for(int i = 0; i < len; i++){
            Turrets turret = turrets.get(i);

            if (turret.damage > 0 && map[turret.x][turret.y] > 0 &&
                turret.lastDamage < count && turret.lastAttack < count) {
                turret.damage += 1;
                map[turret.x][turret.y] += 1;
            }
        }
    }

    private static boolean isCanLaserAttack(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N + 1][M + 1];
        path = new int[N + 1][M + 1][2];

        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == endX && y == endY) return true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1) nx = N;
                else if (nx > N) nx = 1;
                if (ny < 1) ny = M;
                else if (ny > M) ny = 1;

                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    path[nx][ny][0] = x;
                    path[nx][ny][1] = y;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }


    private static void laserAttack(int startX, int startY, int endX, int endY, int turretDamage, Turrets damageTurret, int count){
        int realDamage = turretDamage;

        damageTurret.damage -= realDamage;
        map[endX][endY] -= realDamage;

        damageTurret.lastDamage = count;
        
        if(damageTurret.damage <= 0){
            map[endX][endY] = 0;
            int len = turrets.size();
            turrets.remove(len-1);
        }

        while(true){
            int nextX = path[endX][endY][0];
            int nextY = path[endX][endY][1];
            //System.out.println("레이저 공격 루트 : " + nextX + " " + nextY);
            if(nextX == startX && nextY == startY){
                break;
            }

            findTurret(nextX, nextY, realDamage / 2, count);

            endX = nextX;
            endY = nextY;
        }
    }

    //처리 해야함
    private static void bombAttack(int attackerX, int attackerY, int endX, int endY, int turretDamage, Turrets damageTurret, int count){
        int realDamage = turretDamage;
        damageTurret.damage -= realDamage;
        map[endX][endY] -= realDamage;
        damageTurret.lastDamage = count;

        if(damageTurret.damage <= 0){
            map[endX][endY] = 0;
            int len = turrets.size();
            turrets.remove(len-1);
        }

        for(int i = 0; i < 8; i++){
            int nx = endX + bx[i];
            int ny = endY + by[i];

            if (nx < 1) nx = N;
            else if (nx > N) nx = 1;
            if (ny < 1) ny = M;
            else if (ny > M) ny = 1;

            if(nx == attackerX && ny == attackerY) continue;

            if(map[nx][ny] != 0){
                findTurret(nx, ny, realDamage/2, count);
            }
        }
    }

    private static void findTurret(int x, int y, int realDamage, int count){
        Turrets turret = turretMap[x][y];
        if (turret == null) return;

        turret.damage -= realDamage;
        map[x][y] -= realDamage;
        turret.lastDamage = count;

        if (turret.damage <= 0) {
            map[x][y] = 0;
            turretMap[x][y] = null;
        }
    }

    
    static class Turrets implements Comparable<Turrets>{
        int x;
        int y;
        int damage;
        int lastAttack;
        int lastDamage;

        public Turrets(int x, int y, int damage,int lastAttack, int lastDamage){
            this.x = x;
            this.y = y;
            this.damage = damage;
            this.lastAttack = lastAttack;
            this.lastDamage = lastDamage;
        }

       @Override
        public int compareTo(Turrets o) {
            if (this.damage != o.damage)
                return this.damage - o.damage;

            if (this.lastAttack != o.lastAttack)
                return o.lastAttack - this.lastAttack;

            int thisSum = this.x + this.y;
            int otherSum = o.x + o.y;
            if (thisSum != otherSum)
                return otherSum - thisSum;

            return o.y - this.y;
        }
    }
}