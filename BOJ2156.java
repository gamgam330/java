import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] cost = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cost[1];
        dp[2] = cost[1] + cost[2];
        
        for(int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + cost[i-1])+cost[i]);
        }

        System.out.println(dp[N]);
    }
}
