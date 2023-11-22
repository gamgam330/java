import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N > 0){
            if(N % 5 == 0){
                cnt += N / 5;
                System.out.print(cnt);
                return;
            }
            if(N < 3){
                System.out.print(-1);
                return;
            }
            N -= 3;
            cnt++;
        }
        System.out.print(cnt);
    }
}
