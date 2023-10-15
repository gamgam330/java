import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            dp[i] = 1;
            for(int j = 1; j <= i; j++){
                if(seq[j] < seq[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int arr : dp){
            if(max <= arr){
                max = arr;
            }
        }

        System.out.print(max);
    }
}