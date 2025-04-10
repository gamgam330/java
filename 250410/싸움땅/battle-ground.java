import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static ArrayList<Integer>[][] map;
    static List<Person> people;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] personMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1][N+1];
        personMap = new int[N+1][N+1];

        people = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                ArrayList<Integer> gun = new ArrayList<>();
                gun.add(Integer.parseInt(st.nextToken()));
                map[i][j] = gun;
            }
        }


        
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            personMap[x][y] = i;

            people.add(new Person(x, y, s, d, 0, 0));
        }

        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= N; j++){
        //         System.out.print(personMap[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        for(int i = 0; i < K; i++){
            //System.out.println("라운드 : " + i);
            solution();
        }

        for(Person person : people){
            sb.append(person.score).append(" ");
        }
        System.out.print(sb);
    }

    private static void solution(){
        for(int i = 1; i <= M; i++){
            movePerson(i);
        }
    }

    private static void movePerson(int personIndex){
        Person person = people.get(personIndex-1);
        int x = person.x;
        int y = person.y;
        int dir = person.dir;

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(1 > nx || nx > N || 1 > ny || ny > N){
            person.dir = (person.dir + 2) % 4;
            movePerson(personIndex);
        }

        if(1 <= nx && nx <= N && 1 <= ny && ny <= N){
            person.x = nx;
            person.y = ny;
            //사람 있으면 fight
            if(personMap[nx][ny] > 0){
                //System.out.println("만난 위치 : " + nx + " " + ny + " 만난 애 : " + personMap[nx][ny]);
                personMap[x][y] = 0;
                fight(personIndex, personMap[nx][ny]);
            }else{  //사람 없을때
                //총 들고 있을때 먼저 놓기
                if(person.gun > 0){
                    map[nx][ny].add(person.gun);
                    person.gun = 0;
                }
                //총 안들고 있을때는 그냥 들기
                findMaxGun(nx, ny, person);
                personMap[x][y] = 0;
                personMap[nx][ny] = personIndex;
            }
        }
        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= N; j++){
        //         System.out.print(personMap[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }

    private static void fight(int personIndex, int person2Index){
        //System.out.println("이동한 애 index : " + personIndex + " 만난애 index : " + person2Index);
        //이동한 애 좌표
        Person person = people.get(personIndex-1);
        int cx = person.x;
        int cy = person.y;

        Person p = people.get(person2Index-1);


        //대결하기
        //이동한애
        int person1Damage = person.damage + person.gun;
        //System.out.println("이동한애 능력치 : " + person.damage + " 든 총 : " + person.gun);
        
        //이동하기 전의 애
        int person2Damage = p.damage + p.gun;
         //System.out.println("만난애 능력치 : " + p.damage + " 든 총 : " + p.gun);

        if(person1Damage > person2Damage){
            person.score += (person1Damage - person2Damage);
            //System.out.println("socer 추가 : " + person.score);

            person.x = cx;
            person.y = cy;

            personMap[cx][cy] = personIndex;

            //진애는 총내려놓고 이긴애는 총 바꾸기
            switchGun(cx, cy, person, p);
            
            //도망
            runAwayPerson(p, person2Index);
        }else if(person1Damage < person2Damage){
            p.score += (person2Damage - person1Damage);
            //System.out.println("socer 추가 : " + p.score);

            personMap[cx][cy] = person2Index;

            //진애는 총내려놓고 이긴애는 총 바꾸기
            switchGun(cx, cy, p, person);

            runAwayPerson(person, personIndex);
        }else{
            //이경우에는 0점 획득임 걍
            if(person.damage > p.damage){
                //진애는 총내려놓고 이긴애는 총 바꾸기
                switchGun(cx, cy, person, p);

                personMap[cx][cy] = personIndex;

                runAwayPerson(p, person2Index);
            }else{
                //진애는 총내려놓고 이긴애는 총 바꾸기
                switchGun(cx, cy, p, person);

                personMap[cx][cy] = person2Index;

                runAwayPerson(person, personIndex);
            }
        }
    }

    private static void switchGun(int cx, int cy, Person winner, Person loser){
        if(loser.gun > 0){
            map[cx][cy].add(loser.gun);
            loser.gun = 0;
        }

        //승자는 총 중 가장 큰거 다시 들어야함
        if(winner.gun > 0){
            map[cx][cy].add(winner.gun);
            winner.gun = 0;
        }
        //승자 총 다시 들기
        findMaxGun(cx, cy, winner);
    }

    private static void findMaxGun(int x, int y, Person person){
        if(!map[x][y].isEmpty()){
            int max = Collections.max(map[x][y]);
            person.gun = max;
            map[x][y].remove(Integer.valueOf(max));
        }
    }

    private static void runAwayPerson(Person person, int personIndex){
        int nx = person.x + dx[person.dir];
        int ny = person.y + dy[person.dir];

        //범위 바깥이거나 사람이 있으면
        if(1 > nx || nx > N || 1 > ny || ny > N || personMap[nx][ny] > 0){
            //회전
            person.dir = (person.dir + 1) % 4;
            runAwayPerson(person, personIndex);
        }else{
            person.x = nx;
            person.y = ny;
            personMap[person.x][person.y] = 0;
            personMap[nx][ny] = personIndex;

            findMaxGun(person.x, person.y, person);

            return;
        }
    }

    static class Person{
        int x;
        int y;
        int damage;
        int dir;
        int gun;
        int score;

        public Person(int x, int y, int damage, int dir, int gun, int score){
            this.x = x;
            this.y = y;
            this.damage = damage;
            this.dir = dir;
            this.gun = gun;
            this.score = score;
        }
    }
}