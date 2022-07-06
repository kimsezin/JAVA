package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int max, length,map[][],N;
	static ArrayList<location> core;
	static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
					{
						if(i!=0 && j!=0 && i!=N-1 && j!=N-1) //외곽은 바로니까 없애기
						core.add(new location(i,j));
					}
				}
			}
			max=0;
			length = Integer.MAX_VALUE;
			dfs(0,0,0);
			System.out.println("#"+tc+ " " + length);
		}
	}
	private static void dfs(int size, int len, int c) {
		if(size == core.size())
		{
			if(c > max)
			{
				length = len;
				max = c;
			}
			else if(c==max)
			{
				length = Math.min(length, len);
			}
			return;
		}
		
		for(int i=0;i<4;i++)
		{
			int nx = core.get(size).x;
			int ny = core.get(size).y;
			int cnt=0;
			
			while(true)
			{
				nx+=dx[i];
				ny+=dy[i];
				cnt++;
				if(map[nx][ny] == 1 || map[nx][ny] == 2) // 전선,core
				{
					cnt=0;
					break;
				}
				if(map[nx][ny]==0 && (nx == 0 || ny == 0 || nx == N-1 || ny == N-1))
				{
					break;
				}
			}
			
			if(cnt > 0)
			{
				nx = core.get(size).x;
				ny = core.get(size).y;
				while(true)
				{
					nx +=dx[i];
					ny +=dy[i];
					if(nx< 0 || ny < 0 || nx > N-1 || ny > N-1)
						break;
					map[nx][ny]=2; //전선은 2
				}
				dfs(size+1, len+cnt,c+1);
				nx = core.get(size).x;
				ny = core.get(size).y;
				while(true)
				{
					nx +=dx[i];
					ny +=dy[i];
					if(nx<0 || ny <0 || nx > N-1 || ny > N-1)
						break;
					map[nx][ny]=0;
				}
			}
		}
		dfs(size+1,len,c);
	}

}
