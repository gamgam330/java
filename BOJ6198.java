import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                stack.push(num);
            }else if(!stack.isEmpty() && stack.peek() > num){
                result += stack.size();
                System.out.println(stack);
                stack.push(num);
            }else if(!stack.isEmpty() && stack.peek() <= num){
                while(!stack.isEmpty()){
                    if(stack.peek() > num){
                        result += stack.size();
                        break;
                    }
                    stack.pop();
                }
                stack.push(num);
            }
        }
        System.out.print(result);
    }
}
