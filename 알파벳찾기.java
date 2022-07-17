package 연습대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		String str = br.readLine();
		for(int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		for(int i = 0; i < str.length(); i++) {
			char str1 = str.charAt(i);
			if(arr[str1 - 'a']  == -1) {
				arr[str1 - 'a'] = i;
			}
		}
		for(int result : arr) {
			System.out.print(result + " ");
		}
	}
}