import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][11];

        for(int i = 0; i <= N; i++){
            for(int j = 1; j <= 10; j++){
                if(i == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
                }
            }
        }
        System.out.print(dp[N][10]);
    }
}
