package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15683 {
	static int N, M, map[][];
	static int result = Integer.MAX_VALUE;
	static ArrayList<cctv> cctvs;
	public static class cctv
	{
		int x,y;
		int type;
		
		public cctv(int x, int y, int type)
		{
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<cctv>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if(map[i][j]!=0 && map[i][j]!=6)
				{
					cctvs.add(new cctv(i,j,map[i][j]));
				}
			}
		}
		
		dfs(0, map);
		System.out.println(result);
	}
	
	static void dfs(int cnt, int[][] map)
	{
		// 기저조건 cctv 다 확인 했을 때
		if(cnt == cctvs.size())
		{
			int check_cnt = count(map);
			if(result > check_cnt)
				result = check_cnt;
			return;
		}
		cctv temp = cctvs.get(cnt);
		int[][] copy_map=copy(map);
		if(temp.type == 1)
		{
			map = copy(copy_map);
			map = moveDown(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			map = copy(copy_map);
			map = moveUp(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			map = copy(copy_map);
			map = moveLeft(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			
			map = copy(copy_map);
			map = moveRight(temp.x, temp.y,map);
			dfs(cnt+1,map);
		}
		else if(temp.type == 2)
		{
			map=copy(copy_map);
			moveLeft(temp.x,temp.y,map);
			moveRight(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
			
			map=copy(copy_map);
			moveUp(temp.x, temp.y,map);
			moveDown(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
		}
		else if(temp.type == 3)
		{
			map=copy(copy_map);
			moveUp(temp.x, temp.y,map);
			moveRight(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
			
			map = copy(copy_map);
			moveRight(temp.x, temp.y,map);
			moveDown(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
			
			map = copy(copy_map);
			moveDown(temp.x, temp.y,map);
			moveLeft(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
			
			map = copy(copy_map);
			moveLeft(temp.x, temp.y,map);
			moveUp(temp.x, temp.y,map);
			dfs(cnt+1,map);
			
		}
		
		else if(temp.type == 4)
		{
			map = copy(copy_map);
			moveLeft(temp.x,temp.y,map);
			moveUp(temp.x,temp.y,map);
			moveRight(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			map = copy(copy_map);
			moveUp(temp.x,temp.y,map);
			moveRight(temp.x,temp.y,map);
			moveDown(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			map = copy(copy_map);
			moveRight(temp.x,temp.y,map);
			moveDown(temp.x,temp.y,map);
			moveLeft(temp.x,temp.y,map);
			dfs(cnt+1,map);
			
			map = copy(copy_map);
			moveDown(temp.x,temp.y,map);
			moveLeft(temp.x,temp.y,map);
			moveUp(temp.x,temp.y,map);
			dfs(cnt+1,map);
		
		}
		
		else if(temp.type==5)
		{
			map = copy(copy_map);
			moveUp(temp.x,temp.y,map);
			moveRight(temp.x,temp.y,map);
			moveDown(temp.x,temp.y,map);
			moveLeft(temp.x, temp.y,map);
			dfs(cnt+1,map);
		}
	}
	static int[][] moveUp(int x, int y, int map[][])
	{
		for(int i=x-1;i>=0;i--)
		{
			if(map[i][y]==6)
				break;
			else if(map[i][y]==0)
				map[i][y]=9;
		}
		return map;
	}

	static int[][] moveDown(int x, int y, int map[][])
	{
		for(int i=x+1;i<N;i++)
		{
			if(map[i][y]==6)
				break;
			else if(map[i][y]==0)
				map[i][y]=9;
		}
		return map;
	}

	static int[][] moveLeft(int x, int y, int map[][])
	{
		for(int i=y-1;i>=0;i--)
		{
			if(map[x][i]==6)
				break;
			else if(map[x][i]==0)
				map[x][i]=9;
		}
		return map;
	}

	static int[][] moveRight(int x, int y, int map[][])
	{
		for(int i=y+1;i<M;i++)
		{
			if(map[x][i]==6)
				break;
			else if(map[x][i]==0)
				map[x][i]=9;
		}
		return map;
	}

	static int count(int[][] map)
	{
		int cnt=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]==0)
					cnt++;
		return cnt;
	}
	static int[][] copy(int map[][])
	{
		int copy_map[][] = new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
					copy_map[i][j]=map[i][j];
		
		return copy_map;
	}
	
}
