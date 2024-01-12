import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1138 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            int ex = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = 0 ; j < N ; j++){
                if(cnt == ex && arr[j] == 0) { 
                    arr[j] = i; 
                    break;
                }else if(arr[j] == 0){
                    cnt++;
                }
            }
        }
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
