import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteOrder;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;
        while(A != B){
            if(B < A){
                System.out.print(-1);
                return;
            }

            if(B%10 == 1){
                B /= 10;
                count++;
            }else if(B % 2 == 0){
                B /= 2;
                count++;
            }else{
                System.out.print(-1);
                return;
            }
        }

        System.out.print(count);
    }
}
