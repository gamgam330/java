import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2565 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][2];
        int[] count = new int[N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dp, (o1, o2) -> {
            return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
        });

        for(int i = 1; i <= N; i++){
            count[i] = 1;
            for(int j = 1; j <= i; j++){
                if(dp[i][1] > dp[j][1]){
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int arr : count){
            if(arr >= max){
                max = arr;
            }
        }
        System.out.print(N - max);
    }
}
