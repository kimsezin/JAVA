package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2636 {
	static class location
	{
		int x;
		int y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int map[][], copy_map[][], dx[]= {-1,1,0,0}, dy[] = {0,0,-1,1},x,y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		map = new int[x][y];
		copy_map=new int[x][y]; //기존의 map과 비교할 copymap (map을 바꿔서 비교해버리면 의미가 없으므로)
		
		for(int i=0;i<x;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<y;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				copy_map[i][j] = map[i][j];
			}
		
		}
		
		solve();
	}
	static boolean check()
	{
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
			{
				if(map[i][j]==1)
					return false;
			}
		return true;
	}
	
	static boolean bfs(int X, int Y)
	{
		Queue<location> q = new LinkedList<>();
		q.offer(new location(X,Y));
		boolean visited[][] = new boolean[x][y];
		visited[X][Y]=true;
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			//4가지 꼭짓점에 다다르면 치즈가 치즈로 둘러쌓여 있지 않다는것을 확인할 수 있음.
			if(temp.x == x-1 && temp.y == y-1)
				return false;
			else if(temp.x == 1 && temp.y == 1)
				return false;
			else if(temp.x == 1 && temp.y == y-1)
				return false;
			else if(temp.x == x-1 && temp.y == 1)
				return false;
			
			//둘러쌓여 있지 않다면
			//주변 계속 탐색하며 체크하기
			for(int i=0;i<4;i++)
			{
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >= 0 && ny >= 0  && nx < x && ny <y && copy_map[nx][ny]==0)
				{
					if(visited[nx][ny]==false)
					{
						visited[nx][ny]=true;
						q.offer(new location(nx,ny));
					}
				}
			}
		}
		return true;
	}
	
	static void solve()
	{
		int chCnt=0; //치즈개수
		int cnt=0; //시간 카운트
		while(!check())
		{
			cnt++;
			chCnt=0;
			for(int i=0;i<x;i++)
			{
				for(int j=0;j<y;j++)
				{
					if(map[i][j]==1) //치즈를 만나서
					{
						if(!bfs(i,j)) //해당 치즈가 치즈로 둘러쌓여있는지 확인하기 위해 bfs로 주변뒤져 끝지점에 다다르는지 확인
						{
							chCnt++; // 치즈가 둘러쌓여있지 않으면 카운트 증가시키고
							map[i][j]=0; //치즈 공기로 바꿔주기
						}
					}
				}
			}
			for(int i=0;i<x;i++)
				for(int j=0;j<y;j++)
					copy_map[i][j] = map[i][j]; //copymap을 바뀐 map으로 다시설정
				
		}
		System.out.println(cnt);
		System.out.println(chCnt);
	}
}
