package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1600 {
	static int map[][], dx[] = {-1,1,0,0}, dy[]= {0,0,-1,1}, H,W,K;
	static int hdx[]= {-1,-2,-2,-1,1,2,2,1};
	static int hdy[]= {-2,-1,1,2,-2,-1,1,2};
	static boolean visited[][][];
	
	static class location
	{
		int x;
		int y;
		int cnt;
		int jump;
		
		public location(int x, int y, int cnt, int jump) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W][H];
		visited = new boolean[W][H][K+1];
		for(int i=0;i<W;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<H;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
	}
	
	static void bfs()
	{
		Queue<location> q = new LinkedList<>();
		q.offer(new location(0,0,0,0));
		visited[0][0][0]=true;
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int cnt = temp.cnt;
			int jump = temp.jump;
			
			if(x==W-1 && y ==H-1)
			{
				System.out.println(cnt);
				return;
			}
			
			if(jump < K)
			{
				for(int i=0;i<8;i++)
				{
					int nx = x + hdx[i];
					int ny = y + hdy[i];
					if(nx>=0 && ny >= 0 && nx < W && ny < H && map[nx][ny]==0)
					{
						if(visited[nx][ny][jump+1]==false)
						{
							visited[nx][ny][jump+1]=true;
							q.offer(new location(nx,ny,cnt+1,jump+1));
						}
					}
				}
			}
			
			for(int i=0;i<4;i++)
			{
				int nx = x +dx[i];
				int ny = y +dy[i];
				if(nx>=0 && ny >= 0 && nx < W && ny < H && map[nx][ny]==0)
				{
					if(visited[nx][ny][jump]==false)
					{
						visited[nx][ny][jump]=true;
						q.offer(new location(nx,ny,cnt+1,jump));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
