import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; // 상좌우하
    static int[] dy = {0, -1, 1, 0};

    static class Person {
        int curX = -1, curY = -1;
        int storeX, storeY;
        boolean arrived = false;

        Person(int storeX, int storeY) {
            this.storeX = storeX;
            this.storeY = storeY;
        }

        boolean isOnMap() {
            return curX != -1;
        }

        void setStart(int x, int y) {
            curX = x;
            curY = y;
        }

        boolean isArrived() {
            return arrived || (curX == storeX && curY == storeY);
        }
    }

    static List<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people.add(new Person(x, y));
        }

        int time = 0;
        while (true) {
            time++;

            // 1. 이동
            List<Person> arrivedThisTurn = new ArrayList<>();
            for (Person p : people) {
                if (!p.isOnMap() || p.isArrived()) continue;
                int[][] dist = bfs(p.storeX, p.storeY);

                int min = Integer.MAX_VALUE;
                int nextX = p.curX, nextY = p.curY;

                for (int d = 0; d < 4; d++) {
                    int nx = p.curX + dx[d];
                    int ny = p.curY + dy[d];

                    if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                    if (map[nx][ny] == 3) continue;

                    if (dist[nx][ny] < min) {
                        min = dist[nx][ny];
                        nextX = nx;
                        nextY = ny;
                    }
                }

                p.curX = nextX;
                p.curY = nextY;

                if (p.curX == p.storeX && p.curY == p.storeY) {
                    p.arrived = true;
                    arrivedThisTurn.add(p);
                }
            }

            for (Person p : arrivedThisTurn) {
                map[p.curX][p.curY] = 3;
            }


            // 2. time번째 사람 베이스캠프 진입
            if (time <= M) {
                Person p = people.get(time - 1);
                int[][] dist = bfs(p.storeX, p.storeY);

                int min = Integer.MAX_VALUE;
                int bx = -1, by = -1;

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (map[i][j] == 1) {
                            // 거리 더 작거나, 거리가 같으면 (행,열) 우선순위 비교
                            if (dist[i][j] < min
                                || (dist[i][j] == min && (i < bx || (i == bx && j < by)))) {
                                min = dist[i][j];
                                bx = i;
                                by = j;
                            }
                        }
                    }
                }

                p.setStart(bx, by);
                map[bx][by] = 3;
            }


            // 3. 종료 조건
            boolean done = true;
            for (Person p : people) {
                if (!p.isArrived()) {
                    done = false;
                    break;
                }
            }

            if (done) {
                System.out.println(time);
                return;
            }
        }
    }

    static int[][] bfs(int sx, int sy) {
        int[][] dist = new int[N + 1][N + 1];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        boolean[][] visited = new boolean[N + 1][N + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (visited[nx][ny] || map[nx][ny] == 3) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return dist;
    }
}
