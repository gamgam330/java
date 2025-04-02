import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N, L;
    static int count;
    static Stack<Integer> s;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        count = 0;
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            findLine(map[i]);
        }
        
        for(int j = 0; j < N; j++){
            int[] col = new int[N];
            for(int i = 0; i < N; i++){
                col[i] = map[i][j];
            }
            findLine(col);
        }

        System.out.println(count);
    }

    private static void findLine(int[] map){
        visited = new boolean[N];
        boolean flag = true;
        for(int i = 0; i < N-1; i++){
            int cur = map[i];
            int next = map[i+1];

            //1 커지는 경우(오르막)
            if(cur + 1 == next){
                for(int j = 0; j < L; j++){
                    int index = i-j;
                    if(index < 0 || visited[index] || map[index] != cur){
                        flag = false;
                        break;
                    }
                    visited[index] = true;
                }
            }else if (cur - 1 == next){         //1 작아지는 경우 내리막
                for(int j = 1; j <= L; j++){
                    int index = i+j;
                    if(index >= N || visited[index] || map[index] != next){
                        flag = false;
                        break;
                    }
                    visited[index] = true;
                }
                i += L - 1;
            }else if(Math.abs(cur - next) >= 2){                         //2이상 차이나는 경우
                flag = false;
            }
        }
        if(flag){
            count++;
        }           
    }
}