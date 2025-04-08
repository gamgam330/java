import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    static int[][] dist;
    static int[][] map;
    static boolean[][] visited;
    static int time;

    static List<Node> store;
    static List<Node> people;
    static List<Node> basecamp;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        store = new ArrayList<>();
        people = new ArrayList<>();
        basecamp = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    basecamp.add(new Node(i, j));
                }
            }
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            store.add(new Node(x, y));
        }

        time = 0;
        solution();
        System.out.println(time);
    }

    private static void solution(){
        while(true){
            time++;
            //격자내 사람이동
            if(time != 0){
                movePerson();
            }

            int tmp = 0;
            if(people.size() == M){
                for(int i = 0; i < M; i++){
                    Node person = people.get(i);
                    Node node = store.get(i);

                    if(person.x == node.x && person.y == node.y){
                        tmp++;
                    }
                }
            }

            if(tmp == M){
                return;
            }

            //사람 가까운 베이스 캠프로 이동
            if(time <= M){
                findBaseCamp();
            }
        }
    }
    

    //상좌우하
    private static void movePerson() {
        List<Node> arrived = new ArrayList<>();

        int len = people.size();

        for (int i = 0; i < len; i++) {
            Node person = people.get(i);
            Node target = store.get(i); // 해당 사람의 편의점

            if(person.x == target.x && person.y == target.y){
                continue;
            }

            int[][] localDist = new int[N + 1][N + 1];
            boolean[][] visited = new boolean[N + 1][N + 1];
            Queue<int[]> q = new ArrayDeque<>();

            q.offer(new int[]{target.x, target.y});
            visited[target.x][target.y] = true;
            localDist[target.x][target.y] = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                    if (visited[nx][ny] || map[nx][ny] == 3) continue;

                    visited[nx][ny] = true;
                    localDist[nx][ny] = localDist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }

            int minDist = Integer.MAX_VALUE;
            int nextX = person.x;
            int nextY = person.y;

            for (int d = 0; d < 4; d++) {
                int nx = person.x + dx[d];
                int ny = person.y + dy[d];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (map[nx][ny] == 3) continue;
                if (localDist[nx][ny] == 0 && !(nx == target.x && ny == target.y)) continue;

                if (localDist[nx][ny] < minDist) {
                    minDist = localDist[nx][ny];
                    nextX = nx;
                    nextY = ny;
                }
            }

            person.x = nextX;
            person.y = nextY;

            if (nextX == target.x && nextY == target.y) {
                arrived.add(person); // 이 턴에 도착한 사람 기록
            }
        }

        // 모두 이동한 뒤에 도착한 위치 막기
        for (Node p : arrived) {
            map[p.x][p.y] = 3;
        }
    }


    private static void findBaseCamp(){
        //time번째 편의점의 위치
        Node node = store.get(time-1);
        int x = node.x;
        int y = node.y;

        Queue<int[]> q = new ArrayDeque<>();

        int min = BFS(x, y);

        //min값 거리 가진 첫번째 베이스 캠프 찾기 그 위치에 사람 저장하기
        //그리고 map도 3으로 바꾸기
        boolean found = false;
        for(int i = 1; i <= N && !found; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == 1 && dist[i][j] == min){
                    people.add(new Node(i, j));
                    //System.out.println("사람 위치 : " + i + " " + j);
                    map[i][j] = 3;
                    found = true;
                    break;
                }
            }
        }


        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= N; j++){
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("가장 작은 값 : " + min);

    }

    private static int BFS(int x, int y){
        int min = Integer.MAX_VALUE - 1;

        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N+1][N+1];
        dist = new int[N+1][N+1];
        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int count = cur[2];
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(1 <= nx && nx <= N && 1 <= ny && ny <= N && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, count + 1});
                        dist[nx][ny] = count + 1;
                    }else if(map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, count + 1});
                        dist[nx][ny] = count + 1;
                        min = Math.min(min, count + 1);
                    }
                }
            }
        }
        return min;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}