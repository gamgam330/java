import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] a = new int[26];

        str = str.toUpperCase();
        for(int i = 0; i < str.length(); i++){
            a[str.charAt(i) - 65]++;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < 26; i++){
            if(max < a[i]){
                max = a[i];
                index = i;
            }else if(max == a[i]){
                System.out.print("?");
                return;
            }
        }

        System.out.print((char) (index + 65));
    }
}
