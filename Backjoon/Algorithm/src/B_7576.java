import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N,M,map[][];
	static Queue<location> tomatos;
	static int visited[][];
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatos = new LinkedList<>();
		visited = new int[N][M];
		map = new int[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
				{
					tomatos.offer(new location(i,j));
					visited[i][j]++;
				}
			}
		}
		
		bfs();
		int max=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]==-1)
					continue;
				if(visited[i][j]==0)
				{
					System.out.println(-1);
					return;
				}
				else
					if(max < visited[i][j])
						max = visited[i][j];
			}
		}
		System.out.println(max-1);
	}

	static void bfs()
	{
		while(!tomatos.isEmpty())
		{
			location tomato = tomatos.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				int cnt = visited[tomato.x][tomato.y];
				
				if(nx >=0 && ny >= 0 && nx < N && ny < M)
				{
					if(visited[nx][ny]==0 && map[nx][ny]!=-1)
					{
						visited[nx][ny] = cnt+1;
						tomatos.offer(new location(nx,ny));
					}
				}
			}
		}
	}
}
