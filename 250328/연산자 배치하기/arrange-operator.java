import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] command;
    static int N;
    static long max, min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        command = new int[3];
        
        max = 0;
        min = Integer.MAX_VALUE - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++){
            command[i] = Integer.parseInt(st.nextToken());
        }
        
        backTracking(arr[0], 1);

        System.out.println(min + " " + max);
    }

    private static void backTracking(int result, int cnt){
        if(cnt == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i < 3; i++){
            if(command[i] > 0){
                command[i]--;
                switch (i){
                    case 0:
                        backTracking(result + arr[cnt], cnt + 1);
                        break;
                    case 1:
                        backTracking(result - arr[cnt], cnt + 1);
                        break;
                    case 2:
                        backTracking(result * arr[cnt], cnt + 1);
                        break;
                }
                command[i]++;
            }
        }

    }
}