import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17070 {
	static int map[][];
	static boolean visited[][];
	static class location
	{
		int x,y;
		int direction;

		public location(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction=direction;
		}
		
	}
	static int dx[]= {0,1,1};
	static int dy[]= {1,0,1};
	static int N;
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
		System.out.println(result);
	}
	static void bfs()
	{
		Queue<location> q = new LinkedList<>();
		q.offer(new location(0,1,0));
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int dir = temp.direction;
			
			if(x == N-1 && y==N-1)
			{
				result++;
				continue;
			}
			
			if(dir==0) //오른쪽일떄
			{
				//바로 오른쪽 한칸이동
				int nx = x+dx[0];
				int ny = y+dy[0];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0)
					{
						q.offer(new location(nx,ny,0));
					}
				}
				// 대각선 아래 이동
				nx = x+dx[2];
				ny = y+dy[2];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N)
				{
					if(map[nx][ny]==0 && map[x+1][y] == 0 && map[x][y+1] == 0)
					{
						q.offer(new location(nx,ny,2));
					}
				}
			}
			else if(dir==1) //아래로 향할때
			{
				//바로 아래로 한칸
				int nx = x+dx[1];
				int ny = y+dy[1];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0)
					{
						q.offer(new location(nx,ny,1));
					}
				}
				// 대각선 이동
				nx = x+dx[2];
				ny = y+dy[2];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0 && map[x+1][y]==0 &&map[x][y+1]==0)
					{
						q.offer(new location(nx,ny,2));
					}
				}
			}
			else if(dir==2) //대각선으로 향할때
			{
				//대각선 이어서
				int nx = x+dx[2];
				int ny = y+dy[2];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0 && map[x+1][y]==0 &&map[x][y+1]==0)
					{
						q.offer(new location(nx,ny,2));
					}
				}
				// 오른쪽
				nx = x+dx[0];
				ny = y+dy[0];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0)
					{
						q.offer(new location(nx,ny,0));
					}
				}
				//아래로
				nx = x+dx[1];
				ny = y+dy[1];
				if(nx >= 0 && ny >= 0 && nx<N && ny < N)
				{
					if(map[nx][ny]==0)
					{
						q.offer(new location(nx,ny,1));
					}
				}
			}
			
		}
	}
}
