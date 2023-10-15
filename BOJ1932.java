import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[i][j] += dp[i-1][j];    
                }else if(j == n-1){
                    dp[i][j] += dp[i-1][j-1];
                }else{
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;

        for(int arr : dp[n-1]){
            max = Math.max(max, arr);
        }

        System.out.print(max);
    }
}
