package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자체제작_윷놀이 {
    static int n;
    static int arr[] = new int[10];
    // 말이 이동 가능 한  경로, 100이면 도착기 벗어남
    static int nxt[][] = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}, {21, 22, 23, 24, 25}, {7, 8, 9, 10, 11},
            {8, 9, 10, 11, 12}, {9, 10, 11, 12, 13}, {10, 11, 12, 13, 14}, {26, 27, 28, 29, 30}, {12, 13, 14, 15, 16}, {13, 14, 15, 16, 17},
            {14, 15, 16, 17, 18}, {15, 16, 17, 18, 19}, {16, 17, 18, 19, 20}, {17, 18, 19, 20, 100}, {18, 19, 20, 100, 100}, {19, 20, 100, 100, 100},
            {20, 100, 100, 100, 100}, {100, 100, 100, 100, 100}, {22, 23, 24, 25, 15}, {23, 24, 25, 15, 16}, {29, 30, 20, 100, 100}, {25, 15, 16, 17, 18},
            {15, 16, 17, 18, 19}, {27, 28, 29, 30, 20}, {28, 29, 30, 20, 100}, {29, 30, 20, 100, 100}, {30, 20, 100, 100, 100}, {20, 100, 100, 100, 100}};

    public static int recur(int cur){
        int ret = 0;

        // 도착지를 벗어나는 경우
        if(cur == 100) return 1;

        // 전부 이동 해보기
        for(int i = 0; i < 5; i++){
            // 0일 경우 다시
            if(arr[i] == 0) {
                continue;
            }

            // 이동 한 경우 -
            arr[i]--;
            // 이동하는 재귀, 이동하는 칸 만큼 이동
            ret += recur(nxt[cur][i]);
            // +
            arr[i]++;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 테스트 횟수
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            // 윷 횟수 입력
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 5; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(recur(0)==0)
                System.out.println("#"+t+" False");
            else
                System.out.println("#"+t+" True");
            
        }
    }
}