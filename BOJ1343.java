import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] arr = str.split("\\.");

        for(int i = 0; i < arr.length; i++){
            String a = arr[i];

            if(a.length() % 2 != 0){
                System.out.print("-1");
                return;
            }else if(a.length() % 4 == 0){
                sb.append("AAAA".repeat(a.length() / 4));
            }else{
                sb.append("AAAA".repeat(a.length() / 4));
                sb.append("BB");
            }

            if(i != arr.length - 1){
                sb.append(".");
            }
        }
        String result = sb.toString();
        sb.append(".".repeat(str.length() - sb.toString().length()));
        System.out.print(sb);
    }
}
