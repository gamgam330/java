package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1083 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int moveCnt = 0, changeIdx = 0;
        while (moveCnt < S && changeIdx < N - 1) {
            int maxNum = arr.get(changeIdx), maxIdx = -1;

            int idx = changeIdx + 1, count = 1;
            while (moveCnt + count <= S && idx < N) {
                int num = arr.get(idx);
                if (num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }

            if (maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx++;
        }

		for(int i = 0; i < N; i++) {
			sb.append(arr.get(i)).append(" ");
		}
		System.out.print(sb);
	}
}
