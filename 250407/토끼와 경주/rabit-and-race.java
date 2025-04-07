import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] map;
    static PriorityQueue<Rabbit> q;
    static PriorityQueue<Position> pq;
    static PriorityQueue<Winner> wq;
    static Map<Integer, Rabbit> rabbitMap;

    static int Q, command, N, M, P, K, S, L;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        q = new PriorityQueue<>();
        map = new int[N+1][M+1];
        rabbitMap = new HashMap<>();

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            command = Integer.parseInt(st.nextToken());

            if(command == 100){
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                P = Integer.parseInt(st.nextToken());
                for(int j = 0; j < P; j++){
                    int rabbitPid = Integer.parseInt(st.nextToken());
                    int rabbitDist = Integer.parseInt(st.nextToken());
                    Rabbit rabbit = new Rabbit(1, 1, 0, rabbitPid, rabbitDist, 0);
                    q.offer(rabbit);
                    rabbitMap.put(rabbit.pid, rabbit);
                }
            }else if(command == 200){
                K = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
                raceRabbit();
            }else if(command == 300){
                int id = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                growLength(id);
            }else{

            }
        }

        int max = 0;
        for(Rabbit rabbit : q){
            max = Math.max(max, rabbit.score);
        }

        System.out.println(max);
    }

    private static void growLength(int id){
        Rabbit rabbit = rabbitMap.get(id);
        rabbit.dist = rabbit.dist * L;
    }

    private static void raceRabbit(){
        for(int i = 0; i < K; i++){
            Rabbit rabbit = q.poll();

            int dist = rabbit.dist;
            int x = rabbit.x;
            int y = rabbit.y;
            
            pq = new PriorityQueue<>();
            //이렇게하면 제일 우선순위가 높은 토끼가 4방향으로 다가게됨.
            for(int j = 0; j < 4; j++){
                int nx = getNext(x, dx[j] * dist, N);
                int ny = getNext(y, dy[j] * dist, M);
                
                Position position = new Position(nx, ny);

                pq.offer(position);
            }

            //전체 토끼한테 0번 인덱스의 x+y를 score에 다 집어넣기
            Position position = pq.poll();
            
            rabbit.x = position.x;
            rabbit.y = position.y;

            rabbit.jump += 1;

            int curScore = position.x + position.y;

            for(Rabbit curRabbit : q){
                //System.out.println("add score : " + curScore);
                curRabbit.score += curScore;
            }

            q.offer(rabbit);
        }

        wq = new PriorityQueue<>();
        //S 더하기
        //현재 서있는 행 번호 + 열 번호가 큰 토끼 -> 행 번호가 큰 토끼 -> 열 번호가 큰 토끼
        for(Rabbit curRabbit : q){
            Winner winner = new Winner(curRabbit.x, curRabbit.y, curRabbit.pid);
            wq.add(winner);
        }
        
        //현재 큰 토끼
        Winner winner = wq.poll();
        Rabbit winnerRabbit = rabbitMap.get(winner.pid);

        winnerRabbit.score += S;
    }

    private static int getNext(int cur, int dist, int bound) {
        int pos = cur - 1 + dist;
        int mod = 2 * bound - 2;
        pos = (pos % mod + mod) % mod;
        return (pos < bound) ? pos + 1 : 2 * bound - pos - 1;
    }

    static class Rabbit implements Comparable<Rabbit>{
        int x;
        int y;
        int jump;
        int pid;
        int dist;
        int score;

        public Rabbit(int x, int y, int jump, int pid, int dist, int score){
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.pid = pid;
            this.dist = dist;
            this.score = score;
        }

        @Override
        public int compareTo(Rabbit o){
            if(o.jump != this.jump){
                return this.jump - o.jump;
            }
            if((o.x+o.y) != (this.x+this.y)){
                return (this.x+this.y) - (o.x+o.y);
            }
            if(o.y != this.y){
                return this.y - o.y;
            }
            return this.pid - o.pid;
        }
    }

    static class Position implements Comparable<Position>{
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o){
            if((this.x+this.y) != (o.x+o.y)){
                return (o.x+o.y) - (this.x+this.y);
            }
            if(this.x != o.x){
                return o.x - this.x;
            }
            return o.y - this.y;
        }
    }

    static class Winner implements Comparable<Winner>{
        int x;
        int y;
        int pid;

        public Winner(int x, int y, int pid){
            this.x = x;
            this.y = y;
            this.pid = pid;
        }

        @Override
        public int compareTo(Winner o){
            if((this.x+this.y) != (o.x+o.y)){
                return (o.x+o.y) - (this.x+this.y);
            }
            if(this.x != o.x){
                return o.x - this.x;
            }
            if(this.y != o.y){
                return o.y - this.y;
            }
            return o.pid - this.pid;
        }
    }
}