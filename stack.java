package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack {

   public static void main(String[] args) throws IOException {
      int n;
      String s;
      
      Scanner scan = new Scanner(System.in);
      Stack <Integer> s1 = new Stack<Integer>();
      
      System.out.println("N: ");
      n=scan.nextInt();
      
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      
      for(int i=0; i<n; i++) {
         StringTokenizer ss = new StringTokenizer(bf.readLine());
         String str = ss.nextToken();
         
         if(str.equals("push")) {
            String s2 = ss.nextToken();
            int x = Integer.parseInt(s2);
            s1.push(x);
         }
         else if(str.equals("pop")) {
            if(s1.empty()==true) {
               System.out.println("-1");
            }
            else {
               System.out.println(s1.pop());
            }
         }
         else if(str.equals("size")) {
            System.out.println(s1.size());
         }
         else if(str.equals("empty")) {
            if(s1.empty()==true)
               System.out.println("0");
            else
               System.out.println("1");
         }
         else if(str.equals("top")) {
            if(s1.empty()==true) {
               System.out.println("-1");
            }
            else {
               System.out.println(s1.peek());
            }
         }

   }
   }
}