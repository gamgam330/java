import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] arr = S.split("0");
        String[] arr2 = S.split("1");

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("1")){
                System.out.println(arr[i]);
                count1++;
            }
        }
        for(int i = 0; i < arr2.length; i++){
            if(arr2[i].contains("0")){
                count2++;
            }
        }

        System.out.println(count1 > count2 ? count2 : count1);
    }
}
