import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][4];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= 3; j++){
                if(j == 1){
                    dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + dp[i][j];
                }else if(j == 2){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j+1]) + dp[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-2], dp[i-1][j-1]) + dp[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int a : dp[N]){
            if(min > a && a != 0){
                min = a;
            }
        }
        System.out.print(min);
    }
}
