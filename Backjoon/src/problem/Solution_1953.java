package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int N, M, startX, startY, time, map[][];
	static boolean visited[][];
	static int dx1[] = {-1,1,0,0}, dy1[]= {0,0,-1,1};
	static int dx2[] = {-1,1}, dy2[] = {0,0};
	static int dx3[] = {0,0}, dy3[] = {-1,1};
	static int dx4[] = {-1,0}, dy4[] = {0,1};
	static int dx5[] = {1,0}, dy5[]= {0,1};
	static int dx6[] = {1,0}, dy6[]= {0,-1};
	static int dx7[] = {-1,0}, dy7[] = {0,-1};
	static int result;
	static class location
	{
		int x,y,type,cnt;

		public location(int x, int y, int type,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			result=0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map=new int[N][M];
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			bfs(startX,startY,tc);
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(visited[i][j]==true)
						result++;
			
			System.out.println("#"+tc+" "+result);
		}

	}
	static void bfs(int x, int y,int tc)
	{
		Queue<location> q = new LinkedList<>();
		visited = new boolean[N][M];
		q.offer(new location(x,y,map[x][y],1));
		visited[x][y] = true;
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int cnt = temp.cnt;
			
			if(cnt==time)
				return;
			
			int curX = temp.x;
			int curY = temp.y;
			int type = temp.type;
			
			switch(type)
			{
				case 1:
					for(int i=0;i<4;i++)
					{
						int nx = curX+dx1[i];
						int ny = curY+dy1[i];
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=4 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=5 && map[nx][ny]!=6)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==2)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny] !=6 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==3)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny]!=4 && map[nx][ny]!=5)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 2:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx2[i];
						int ny = curY+dy2[i];
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=4 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=5 && map[nx][ny]!=6)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 3:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx3[i];
						int ny = curY+dy3[i];
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny] !=6 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny]!=4 && map[nx][ny]!=5)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 4:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx4[i];
						int ny = curY+dy4[i];
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=4 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny]!=4 && map[nx][ny]!=5)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 5:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx5[i];
						int ny = curY+dy5[i];
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=5 && map[nx][ny]!=6)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny]!=4 && map[nx][ny]!=5)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 6:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx6[i];
						int ny = curY+dy6[i];
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=5 && map[nx][ny]!=6)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny] !=6 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
					break;
				case 7:
					for(int i=0;i<2;i++)
					{
						int nx = curX+dx7[i];
						int ny = curY+dy7[i];
						
						if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
						{
							if(i==0)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=3 && map[nx][ny]!=4 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
							else if(i==1)
							{
								if(map[nx][ny]!=0 && map[nx][ny]!=2 && map[nx][ny] !=6 && map[nx][ny]!=7)
								{
									visited[nx][ny]=true;
									q.offer(new location(nx,ny,map[nx][ny],cnt+1));
								}
							}
						}
					}
			}
		}
	}
}
