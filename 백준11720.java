package 백준;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.Console;
import java.util.*;
import java.io.*;

public class 백준11720 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int sum = 0;
		String str = scan.next();
		int[] arr = new int[a];
		
		for(int i = 0; i < a; i++) {
			arr[i] = str.charAt(i) - '0';
			sum += arr[i];
		}
		System.out.print(sum);
	}
}
