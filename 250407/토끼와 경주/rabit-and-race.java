import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Rabbit> q;
    static PriorityQueue<Position> pq;
    static PriorityQueue<Winner> wq;
    static Map<Long, Rabbit> rabbitMap;

    static int Q, N, M, P, K, command;
    static long S, L;

    static long[] dx = {-1, 1, 0, 0};
    static long[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        q = new PriorityQueue<>();
        rabbitMap = new HashMap<>();

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            command = Integer.parseInt(st.nextToken());

            if(command == 100){
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                P = Integer.parseInt(st.nextToken());

                for(int j = 0; j < P; j++){
                    long rabbitPid = Long.parseLong(st.nextToken());
                    long rabbitDist = Long.parseLong(st.nextToken());
                    Rabbit rabbit = new Rabbit(1, 1, 0, rabbitPid, rabbitDist, 0);
                    q.offer(rabbit);
                    rabbitMap.put(rabbit.pid, rabbit);
                }
            }else if(command == 200){
                K = Integer.parseInt(st.nextToken());
                S = Long.parseLong(st.nextToken());
                raceRabbit();
            }else if(command == 300){
                long id = Long.parseLong(st.nextToken());
                L = Long.parseLong(st.nextToken());
                growLength(id);
            }
        }

        long max = 0;
        for(Rabbit rabbit : q){
            max = Math.max(max, rabbit.score);
        }

        System.out.println(max);
    }

    private static void growLength(long id){
        Rabbit rabbit = rabbitMap.get(id);
        rabbit.dist = rabbit.dist * L;
    }

    private static void raceRabbit(){
        for(int i = 0; i < K; i++){
            Rabbit rabbit = q.poll();

            long dist = rabbit.dist;
            long x = rabbit.x;
            long y = rabbit.y;

            pq = new PriorityQueue<>();
            for(int j = 0; j < 4; j++){
                long nx = getNext(x, dx[j] * dist, N);
                long ny = getNext(y, dy[j] * dist, M);

                Position position = new Position(nx, ny);
                pq.offer(position);
            }

            Position position = pq.poll();

            rabbit.x = position.x;
            rabbit.y = position.y;

            rabbit.jump += 1;

            long curScore = position.x + position.y;

            for(Rabbit curRabbit : q){
                curRabbit.score += curScore;
            }

            q.offer(rabbit);
        }

        wq = new PriorityQueue<>();
        for(Rabbit curRabbit : q){
            Winner winner = new Winner(curRabbit.x, curRabbit.y, curRabbit.pid);
            wq.add(winner);
        }

        Winner winner = wq.poll();
        Rabbit winnerRabbit = rabbitMap.get(winner.pid);
        winnerRabbit.score += S;
    }

    private static long getNext(long cur, long dist, long bound) {
        long pos = cur - 1 + dist;
        long mod = 2 * bound - 2;
        pos = (pos % mod + mod) % mod;
        return (pos < bound) ? pos + 1 : 2 * bound - pos - 1;
    }

    static class Rabbit implements Comparable<Rabbit>{
        long x;
        long y;
        long jump;
        long pid;
        long dist;
        long score;

        public Rabbit(long x, long y, long jump, long pid, long dist, long score){
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
                return Long.compare(this.jump, o.jump);
            }
            if((o.x+o.y) != (this.x+this.y)){
                return Long.compare(this.x + this.y, o.x + o.y);
            }
            if(o.y != this.y){
                return Long.compare(this.y, o.y);
            }
            return Long.compare(this.pid, o.pid);
        }
    }

    static class Position implements Comparable<Position>{
        long x;
        long y;

        public Position(long x, long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o){
            if((this.x+this.y) != (o.x+o.y)){
                return Long.compare(o.x + o.y, this.x + this.y);
            }
            if(this.x != o.x){
                return Long.compare(o.x, this.x);
            }
            return Long.compare(o.y, this.y);
        }
    }

    static class Winner implements Comparable<Winner>{
        long x;
        long y;
        long pid;

        public Winner(long x, long y, long pid){
            this.x = x;
            this.y = y;
            this.pid = pid;
        }

        @Override
        public int compareTo(Winner o){
            if((this.x+this.y) != (o.x+o.y)){
                return Long.compare(o.x + o.y, this.x + this.y);
            }
            if(this.x != o.x){
                return Long.compare(o.x, this.x);
            }
            if(this.y != o.y){
                return Long.compare(o.y, this.y);
            }
            return Long.compare(o.pid, this.pid);
        }
    }
}
