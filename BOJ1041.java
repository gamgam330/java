package น้มุ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1041 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] dice = new long[6];
		int cnt = 1;
		long total = 0;
		for(int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		long[] minDice = new long[3];
        Arrays.fill(minDice,Integer.MAX_VALUE);
        minDice[0] = Math.min(dice[0],dice[5]);
        minDice[1] = Math.min(dice[1],dice[4]);
        minDice[2] = Math.min(dice[2],dice[3]);
        Arrays.sort(minDice);
        Arrays.sort(dice);
		while(cnt <= N) {
			if(N == 1) {
				total += dice[0]+dice[1]+dice[2]+dice[3]+dice[4];
				break;
			}
			if(cnt == N) {
				total += 4*(minDice[0] + minDice[1] + minDice[2]);
				total += 4 * (N-2) * (minDice[0] + minDice[1]);
				total += (N-2) * (N-2) * minDice[0];
			}else {
				total += 4 * (minDice[0] + minDice[1]);
				total += 4 * (N-2) * minDice[0];
			}
			cnt++;
		}
		System.out.print(total);
	}
}