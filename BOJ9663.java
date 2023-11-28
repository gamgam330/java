import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    static int[] arr;
    static int N;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new int[N];       //체스가 놓인 열을 저장함
        dfs(0);

        System.out.print(cnt);
    }

    public static void dfs(int deep){
        if(deep == N){
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++){
            arr[deep] = i;                  //아 이거 지금 deep가 행이고 들어가는 i가 열이네. 즉, deep가 2고 i가 1이면 2행에는 1번열에 체스말이 있단소리.
            if(valid(deep)){
                dfs(deep + 1);
            }
        }
    }

    public static boolean valid(int deep){
        for(int i = 0; i < deep; i++){
            if(arr[deep] == arr[i]){
                return false;
            }
            if(Math.abs(deep - i) == Math.abs(arr[deep] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
