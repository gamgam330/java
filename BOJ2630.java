import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int w = 0;
    static int b = 0;
    static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);

        System.out.println(w);
        System.out.println(b);
    }

    static void recur(int row, int col, int size){
        if(colorCheck(row, col, size)){
            if(graph[row][col] == 0){
                w++;
            }else{
                b++;
            }
            return;
        }
        int newsize = size / 2;

        recur(row, col, newsize);
        recur(row + newsize, col, newsize);
        recur(row, col + newsize, newsize);
        recur(row + newsize, col + newsize, newsize);
    }

    public static boolean colorCheck(int row, int col, int size) {
	
		int color = graph[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(graph[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
