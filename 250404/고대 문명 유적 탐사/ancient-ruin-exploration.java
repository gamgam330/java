import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    static int[] fx = {-1,-1,-1,0,0,1,1,1};
    static int[] fy = {-1,0,1,-1,1,-1,0,1};

	static List<Integer> scoreList;

    static int[] cx = {0,0,0,1,1,2,2,2};
    static int[] cy = {0,1,2,0,2,0,1,2};

    static int maxRoundScore;

	static Queue<Integer> spare;

	static List<int[]> temp;
	static List<int[]> list;
	
	static int[] rec;

	static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[5][5];

		rec = new int[M];

		spare = new ArrayDeque();

        for(int i = 0 ; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++){
			spare.add(Integer.parseInt(st.nextToken()));
		}
		simulation();

		for(int value : scoreList){
			sb.append(value + " ");
		}

		System.out.print(sb);
    }

	private static void simulation(){
		scoreList = new ArrayList<>();
		for(int t = 0; t < N; t++){
			maxRoundScore = 0;
			temp = new ArrayList<>();
			list = new ArrayList<>();
			//최대값 찾아서 좌표 + 각도 구하기 BFS까지 진행하기 
			//3이상인 유물 BFS로 삭제해야하니까 그것도 가져오기
			int[] expect = getExpectPosition();

			if(list.size() == 0){
				return;
			}

			map = rotate(expect[0], expect[1], expect[2]);


			for(int[] pos : list){
				removeR(pos[0], pos[1]);
			}
			drawR();
			
			while(true){
				visited = new boolean[5][5];
				int count = 0;
				temp.clear();
				for(int i = 0; i < 5; i++){
					for(int j = 0; j < 5; j++){
						count += BFS(i, j, map);
					}
				}

				if(temp.size() == 0){
					break;
				}

				visited = new boolean[5][5];
				for(int[] pos : temp){
					removeR(pos[0], pos[1]);
				}
				drawR();
				maxRoundScore += count;
				
			}
			scoreList.add(maxRoundScore);
		}
	}

	private static void drawR(){
		for(int i = 0; i < 5; i++){
			for(int j = 4; j >= 0; j--){
				if(map[j][i] == 0){
					map[j][i] = spare.poll();
				}
			}
		}
	}

	private static void removeR(int x, int y){
		visited = new boolean[5][5];
		visited[x][y] = true;
		int base = map[x][y];
		map[x][y] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x, y});

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			for(int i = 0; i < 4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny] && base == map[nx][ny]){
					visited[nx][ny] = true;
					map[nx][ny] = 0;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}

	private static int[] getExpectPosition(){
		int max = 0;	//유물 갯수
		int rx = -1;	//x좌표
		int ry = -1;	//y좌표
		int rd = -1;	//각도


		for(int k = 0; k < 3; k++){
			for(int j = 1; j <= 3; j++){
				for(int i = 1; i <= 3; i++){

					int[][] Map = rotate(i, j, k);
					
					//몇개 있는지 확인
					visited = new boolean[5][5];
					temp.clear();

					int total = 0;
					for(int z = 0; z < 5; z++){
						for(int q = 0; q < 5; q++){
							if(!visited[z][q]){
								total += BFS(z, q, Map);
							}
						}
					}

					if(total > max){
						list.clear();
						list.addAll(temp);
						max = total;
						rx = i;
						ry = j;
						rd = k;
					}
				}
			}
		}
		maxRoundScore += max;
		return new int[]{rx, ry, rd};
	}


    public static int[][] rotate(int x, int y, int d) {
		int[][] copy = new int[3][3];
		int[][] rotateArr = new int[5][5];

		for (int i = 0; i < 5; i++){
			rotateArr[i] = map[i].clone();
		}

		for (int i = 0; i < 8; i++) {
			int nx = x + fx[i];
			int ny = y + fy[i];
			copy[cx[i]][cy[i]] = map[nx][ny];
		}

		int[][] rotated = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (d == 0)
                    rotated[i][j] = copy[2 - j][i];     //시계방향 90도
				else if (d == 1)
                    rotated[i][j] = copy[2 - i][2 - j]; //시계방향 180도
				else if (d == 2)
					rotated[i][j] = copy[j][2 - i];     //시계방향 270도
			}
		}

		for (int i = 0; i < 8; i++) {
			int nx = x + fx[i];
			int ny = y + fy[i];

			rotateArr[nx][ny] = rotated[cx[i]][cy[i]];
		}

		return rotateArr;
	}

    
    private static int BFS(int x, int y, int[][] Map){
        Queue<int[]> q = new ArrayDeque<>();

		visited[x][y] = true;
		q.offer(new int[]{x, y});
		int result = 1;
		
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			for(int i = 0; i < 4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny] && Map[x][y] == Map[nx][ny]){
					visited[nx][ny] = true;
					q.offer(new int[]{nx, ny});
					result++;
				}
			}
		}

		if(result >= 3){
			temp.add(new int[] {x, y});
			return result;
		}

		return 0;
    }
}