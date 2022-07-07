package problem.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20057 {
    static int dx[] = {0,1,0,-1}, dy[] = {-1,0,1,0};

    static int percent[] = {1,1,7,7,10,10,2,2,5};
    //1,1,7,7,10,10,2,2,5,a에 맞춰서 각각 왼쪽,아래,오른쪽,위에 맞게 좌표 설정
    static int tornadoX[][] = {{-1,1,-1,1,-1,1,-2,2,0,0},{0,0,1,1,2,2,1,1,3,2},{-1,1,-1,1,-1,1,-2,2,0,0},{0,0,-1,-1,-2,-2,-1,-1,-3,-2}};
    static int tornadoY[][] = {{0,0,-1,-1,-2,-2,-1,-1,-3,-2},{-1,1,-1,1,-1,1,-2,2,0,0},{0,0,1,1,2,2,1,1,3,2},{-1,1,-1,1,-1,1,-2,2,0,0}};

    static int N;
    static int map[][];
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N=Integer.parseInt(st.nextToken()); //격자 크기
        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        move();
        System.out.println(result);

    }

    private static void move() {
        int centerX = N/2, centerY = N/2;
        int dir = 0;
        int cnt = 1; //1,2,3...N-1번씩 2번 움직이고 마지막에 한번 N-1번 움직이면 됨.

        for(int i=0;i<N-1;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<cnt;k++)
                {
                    //cnt만큼 움직이고 움직일 때마다 흩뿌리기
                    tornado(centerX, centerY, dir); //흩뿌리기
                    centerX += dx[dir];
                    centerY += dy[dir];
                }
                dir+=1;
                if(dir == 4)
                    dir=0;
            }



            cnt++;
        }
        for(int i=0;i<N-1;i++) {
            tornado(centerX, centerY, dir); //한칸씩 움직이면서 흩뿌리기
            centerX += dx[dir];
            centerY += dy[dir];
        }
    }

    private static void tornado(int x, int y, int dir) {
        //가고자 하는 방향에 있던 거 기준으로
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(map[nx][ny]==0) return; // 모래값이 0인경우

        int value = map[nx][ny];
        int sand = value;

        for(int i=0;i<9;i++)
        {
            //토네이도가 한칸 이동하면 해당하는 칸에 있는 모래를 흩뿌림
            int tX = x + tornadoX[dir][i]; //1,1,7,7,10,10,2,2,5 자리 탐색하면서 퍼센트에 맞게 배분
            int tY = y + tornadoY[dir][i];
            int per = percent[i];
            int newSand = (sand * per) / 100;

            if(tX >= 0 && tY >= 0 && tX < N && tY < N) //흩뿌려지는 곳이 맵 안에 있을 경우 기존 모래에 더해준다
                map[tX][tY] += newSand;
            else
                result+=newSand; //맵 바깥인 경우 격자밖으로 나갔으므로 결과값에 더해주기

            value -= newSand; //기존 모래값에서 흩뿌려진거 뺴주기
        }

        //가장 마지막인 a에 남은 값 넣어주기
        int tX = x + tornadoX[dir][9];
        int tY = y + tornadoY[dir][9];

        if(tX >= 0 && tY >= 0 && tX < N && tY < N) //흩뿌려지는 곳이 맵 안에 있을 경우 기존 모래에 더해준다
            map[tX][tY] += value;
        else
            result+=value; //맵 바깥인 경우 격자밖으로 나갔으므로 결과값에 더해주기

        map[nx][ny] = 0; //다 흩뿌렸으므로 0으로 만들기 !
    }

}
