package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준4949 {
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Stack<Character> stack = new Stack<Character>();
      String str = br.readLine();
      StringBuilder sb = new StringBuilder();
      while(!str.equals(".")) {
         for(int i = 0; i < str.length(); i++) {
            switch(str.charAt(i)) {
            case '(':{
               stack.push(str.charAt(i));
               break;
            }
            case '[':{
               stack.push(str.charAt(i));
               break;
            }
            case ')':{
               if(stack.isEmpty()) {
                  stack.push(str.charAt(i));
               }
               else if(stack.peek().equals('(')) {
                  stack.pop();
               }
               else
                  stack.push(str.charAt(i));
               break;
            }
            case ']':{
               if(stack.isEmpty()) {;
                  stack.push(str.charAt(i));
               }
               else if(stack.peek().equals('[')) {
                  stack.pop();
               }
               else
                  stack.push(str.charAt(i));
               break;
            }
            }
         }
         str = br.readLine();
         if(stack.isEmpty()) {
            sb.append("yes").append("\n");
         }
         else {
            sb.append("no").append("\n");
         }
         stack.clear();
      }
      System.out.println(sb);
   }
}