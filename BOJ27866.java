import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        System.out.print(str.charAt(N-1));
    }
}