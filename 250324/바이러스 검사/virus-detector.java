import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int reader = Integer.parseInt(st.nextToken());
        int member = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                if(arr[i] <= 0){
                    break;
                }
                if(j == 0){
                    count++;
                    arr[i] -= reader;
                }else{
                    int tmp = arr[i];
                    if(tmp % member == 0){
                        tmp /= member;
                    }else{
                        tmp /= member;
                        tmp += 1;
                    }
                    count += tmp;
                }
            }
        }

        System.out.println(count);
    }
}