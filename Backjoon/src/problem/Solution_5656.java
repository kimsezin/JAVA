package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS
public class Solution_5656 {
	static class Point
	{
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
	static int N,W,H,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[H][W];
			
			for(int i=0;i<H;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<W;j++)
					map[i][j]  = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			go(0,map);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	
	static boolean go(int count, int map[][]) //구슬 던지기 (중복 순열 이용해 구슬 던지는 순서 정하기), 벽돌이 다 부서졌다면 true 아니면 false return
	{
		int result = getRemain(map);
		if(result == 0 )
		{
			min=0;
			return true;
		}
		if(count == N) //모든 구슬을 다 던졌다면
		{
			min = Math.min(min, result);
			return false;
		}
		
		int newMap[][] = new int[H][W];
		//0열부터 W-1열 까지 구슬 던져보기
		for(int c = 0; c < W; c++)
		{
			//구슬에 맞는 벽돌 찾기
			int r = 0;
			while(r<H && map[r][c]==0) ++r;
			
			//해당 열은 벽돌이 없음
			if(r==H) continue;
			
			
			//배열의 상태를 백업
			copy(map,newMap);
			
			boom(newMap,r,c); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄처리
			
			down(newMap); // 부서진 벽돌 정리
			
			if(go(count+1, newMap)) break; // 다음 구슬 던지러 go
		}
		return false;
	}
	
	static void boom(int map[][], int r, int c) //r,c 위치에서 주변의 가능한 모든 벽돌도 함께 제거처리
	{
		Queue<Point> queue = new LinkedList<>();
		if(map[r][c]>1)
		{
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c]=0; // 자기자신은 제거처리
		
		while(!queue.isEmpty())
		{
			Point p = queue.poll();
			for(int i=0;i<4;i++)
			{
				int nx = p.x;
				int ny = p.y;
				
				for(int k=1;k<p.cnt;k++) //벽돌의 크기-1만큼 반복
				{
					nx += dx[i];
					ny += dy[i];
					if(nx>=0 && ny >= 0 && nx < H && ny < W)
						{
							if(map[nx][ny]>1)
								queue.offer(new Point(nx,ny,map[nx][ny]));
							map[nx][ny] = 0;
						}
				}
			}
		}
	}
	
	static void down(int map[][]) // 부서진 벽돌 정리 (공중에 떠있는 벽돌 내리기)
	{
		for(int c=0;c<W;c++)
		{
			int r = H-1;
			while(r>0)
			{
				if(map[r][c]==0) // 빈칸이면 내릴 벽돌 찾기
				{
					int nr = r-1;
					while(nr>0 && map[nr][c] == 0 ) nr--;
					
					map[r][c]  = map[nr][c];
					map[nr][c] = 0;
				}
				r--;
			}
		}
	}
	
	static int getRemain(int map[][]) //남은 벽돌 수 return
	{
		int count = 0;
		for(int i=0;i<H;i++)
			for(int j=0;j<W;j++)
				if(map[i][j] > 0)
					count++;
		
		return count;
	}
	
	static void copy(int map[][], int newMap[][])
	{
		for(int i=0;i<H;i++)
			for(int j=0;j<W;j++)
				newMap[i][j] = map[i][j];
	}

	
}
