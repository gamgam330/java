import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = new char[N];
        boolean[] ate = new boolean[N];
        String str = br.readLine();

        for(int i = 0; i < N; i++){
            arr[i] = str.charAt(i);
        }

        for(int i = 0; i < str.length(); i++){
            if(arr[i] == 'P'){
                int start = Math.max(i-K, 0);
                int end = Math.min(i+K, N-1);
                for(int j = start; j <= end; j++){
                    if(arr[j] == 'H' && !ate[j]){
                        ate[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}
