import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] cal;
    static int max, min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        cal = new int[3];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(min + " " + max);
    }

    static void dfs(int num, int cnt){
        if(cnt == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 3; i++){
            if(cal[i] > 0){
                cal[i]--;
                switch (i) {
                    case 0:
                    dfs(num + arr[cnt], cnt + 1);
                    break;
                    case 1:
                    dfs(num - arr[cnt], cnt + 1);
                    break;
                    case 2:
                    dfs(num * arr[cnt], cnt + 1);
                    break;
                }
                cal[i]++;
            }
        }
    }
}