import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        visited = new boolean[N];
        result = Integer.MAX_VALUE - 1;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        backTracking(0, 0, N/2);

        System.out.println(result);
    }

    private static void backTracking(int start, int depth, int r) {
        if(depth == r) {
            calculate();
            return;
        }

        for(int i = start; i < N; i++) {
            visited[i] = true;
            backTracking(i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    private static void calculate(){
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> f = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(visited[i]){
                t.add(i);
            }else{
                f.add(i);
            }
        }

        int tTmp = 0;
        int fTmp = 0;
        for(int i = 0; i < N/2; i++){
            for(int j = i+1; j < N/2; j++){
                tTmp += map[t.get(i)][t.get(j)];
                tTmp += map[t.get(j)][t.get(i)];
                fTmp += map[f.get(i)][f.get(j)];
                fTmp += map[f.get(j)][f.get(i)];
            }
        }

        result = Math.min(Math.abs(tTmp - fTmp), result);
    }
}