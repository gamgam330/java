import java.util.*;
import java.io.*;

public class Main {
    static int result;

    static int N, M, K;
    static int[][] map;

    static List<int[]> people;
    static int[] exit;

	static int[] plzRotate;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = 0;

        map = new int[N+1][N+1];
        people = new ArrayList<>();
        exit = new int[2];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            people.add(new int[]{x, y});
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        exit[0] = x;
        exit[1] = y;

        solution();

        System.out.println(result);
		System.out.println(exit[0] + " " + exit[1]);
    }

    private static void solution(){
        for(int i = 0; i < K; i++){

            moveAllPeople();

            if(people.size() == 0){
                break;
            }

            plzRotate = new int[3];
			findExitAndPeople();
            subWall(plzRotate);
            rotate(plzRotate);
        }
    }

    private static void moveAllPeople(){
        int len = people.size();
        for(int i = 0; i < len; i++){
            int exitX = exit[0];
            int exitY = exit[1];

            int[] curPeople = people.get(i);
            int peopleX = curPeople[0];
            int peopleY = curPeople[1];


            if(exitX != peopleX){
                int nx = peopleX;
                if(exitX > peopleX){
                    nx++;
                }else{
                    nx--;
                }

                //벽일때
                if(map[nx][peopleY] == 0){
					result++;
                	people.get(i)[0] = nx;
					if(nx == exitX && peopleY == exitY){
						people.remove(i);
						len--;
						i--;
					}
                    continue;
                }
            }
			
			if(exitY != peopleY){
                int ny = peopleY;
                if(exitY > peopleY){
                    ny++;
                }else{
                    ny--;
                }

                //벽일때
                if(map[peopleX][ny] == 0){
					result++;
                	people.get(i)[1] = ny;
					//출구일때
					if(peopleX == exitX && ny == exitY){
						people.remove(i);
						len--;
						i--;
					}
                    continue;
                }
            }
        }
    }

    private static void findExitAndPeople(){
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N - k; i++){
                for(int j = 1; j <= N - k; j++){
                    if(findPeople(i, j, k) && findExit(i, j, k)){
                        plzRotate[0] = i;
						plzRotate[1] = j;
						plzRotate[2] = k;
						return;
                    }
                }
            }
        }
    }

    private static boolean findPeople(int x, int y, int size){
        for(int[] curPeople : people){
            int nx = curPeople[0];
            int ny = curPeople[1];

            if(x <= nx && nx <= (x+size) && y <= ny && ny <= (y+size)){
                return true;
            }
        }
        return false;
    }

    private static void subWall(int[] position){
        int x = position[0];
        int y = position[1];
        int size = position[2];

        for(int i = x; i <= x+size; i++){
            for(int j = y; j <= y+size; j++){
                if(map[i][j] != 0){
                    map[i][j]--;
                }
            }
        }
    }

    private static boolean findExit(int x, int y, int size){
        if(x <= exit[0] && exit[0] <= (x+size) && y <= exit[1] && exit[1] <= (y+size)){
            return true;
        }
        return false;
    }

    private static void rotate(int[] position){
		int x = position[0];
		int y = position[1];
		int size = position[2];

		int[][] copyMap = new int[size+1][size+1];

		for(int i = 0; i < size+1; i++){
			for(int j = 0; j < size+1; j++){
				copyMap[i][j] = map[x + i][y + j];
			}
		}

		for(int i = 1; i <= size+1; i++){
			for(int j = 1; j <= size+1; j++){
				map[x + j - 1][y + size - (i-1)] = copyMap[i-1][j-1];
			}
		}

		for(int[] person : people){
			int cx = person[0];
			int cy = person[1];

			if(x <= cx && cx <= x+size && y <= cy && cy <= y+size){
				int nx = cx - x;
				int ny = cy - y;

				person[0] = x + ny;
				person[1] = y + size - nx;
			}
		}

		if (x <= exit[0] && exit[0] <= x + size && y <= exit[1] && exit[1] <= y + size) {
			int nx = exit[0] - x;
			int ny = exit[1] - y;

			exit[0] = x + ny;
			exit[1] = y + size - nx;
		}
    }
}
