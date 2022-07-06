package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//사용자 관점
//사용자 이동위치에서 충전 가능한 충전기들을 확인
public class Solution_5644 {

	static int dx[] = {0,-1,0,1,0};
	static int dy[] = {0,0,1,0,-1};
	static int M, aCnt;
	static int[] pathA, pathB, playerA,playerB,ap[];


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		playerA = new int[2];
		playerB = new int[2];
		for(int tc=1;tc<=T;tc++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //사용자 이동시간
			aCnt = Integer.parseInt(st.nextToken()); //충전기 개수
			
			pathA = new int[M+1]; //A의 이동경로
			pathB = new int[M+1]; //B의 이동경로
			ap = new int[aCnt][4]; // 각 충전기의 정보 저장(충전기 x좌표, y좌표, 충전거리, 처리량)
			
			String[] charsA = br.readLine().split(" ");
			String[] charsB = br.readLine().split(" ");
			
			

		}

	}
//
//	static int move()
//	{
//		ArrayList<Integer> apListA, apListB; //A,B 충전 가능한 배터리들을 담을 List
//		int totalSum=0;
//		int time=0;
//		while(time<=M)
//		{
//			//위치이동
//			playerA[0]+=dx[pathA[time]];
//			playerA[1]+=dy[pathA[time]];
//			playerB[0]+=dx[pathB[time]];
//			playerB[1]+=dy[pathB[time]];
//			
//			//현 위치에서 충전 가능한 두 플레이어의 배터리 리스트 넣어주기
//			
//		}
//	}
}
