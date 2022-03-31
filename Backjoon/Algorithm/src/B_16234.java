import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16234 {
	public static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N,L,R,map[][];
	static int copy_map[][];
	static int result=0;
	static Queue<location> q = new LinkedList<>();
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		copy_map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				copy_map[i][j] = map[i][j];
			}
		}
		
		while(solve())
		{
			
		}
		System.out.println(result-1);
		
		
	}
	
	private static boolean solve() {
		result++;
		boolean check = false;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<4;k++)
				{
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
					{
						int gap = Math.abs(map[i][j]- map[nx][ny]);
						if(L <= gap && gap <= R)
						{
							q.offer(new location(i,j));
							bfs();
							check= true;
						}
					}
				}
			}
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = copy_map[i][j];
		return check;
	}

	public static void bfs()
	{
		
		boolean checked[][] = new boolean[N][N];
		int cnt = 0;
		int sum = 0;
		while(!q.isEmpty())
		{
			location temp = q.poll();
			visited[temp.x][temp.y]=true;
			checked[temp.x][temp.y]=true;
			cnt++;
			sum+=copy_map[temp.x][temp.y];
			for(int i=0;i<4;i++)
			{
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
				{
					
					int gap = Math.abs(copy_map[temp.x][temp.y]- copy_map[nx][ny]);
					if(L <= gap && gap <= R)
					{
						visited[nx][ny]=true;
						checked[nx][ny]=true;
						q.offer(new location(nx,ny));
					}
				}
			}
		}
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(checked[i][j]==true)
					copy_map[i][j] = sum/cnt;
			}
		}
	}

}
