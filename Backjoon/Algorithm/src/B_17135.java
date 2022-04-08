import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17135 {
	
	static class location
	{
		int x,y,cnt;

		public location(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int N, M, D, map[][], dx[] = {0,-1,0}, dy[]= {-1,0,1};
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for(int i=0;i<N;i++)
		{	
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(result);
	}
	static int[][] copy(int[][] map, int[][] map2)
	{
		for(int i=0;i<=N;i++)
			for(int j=0;j<M;j++)
				map[i][j]=map2[i][j];
		
		return map;
	}
	static void permutation(int cnt)
	{
		if(cnt==3)
		{
			int tempResult=0;
			int temp_map[][] = new int[N+1][M];
			temp_map = copy(temp_map,map);
			
			for(int k=0;k<D;k++)
			{
				boolean visited[][] = new boolean[N][M];
				for(int i=0;i<M;i++)
					if(temp_map[N][i]==2)
					{
						visited = bfs(temp_map,N,i,visited);
					}
				temp_map = traslate(temp_map,visited);
				
				for(int i=N-1;i>k;i--)
					for(int j=0;j<M;j++)
						temp_map[i][j] = temp_map[i-1][j];
				for(int i=0;i<=k;i++)
					Arrays.fill(temp_map[i], 0);
				
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++)
						if(visited[i][j]==true)
							tempResult++;
			}
			
			
			result = Math.max(result, tempResult);
			return;
		}
		
		for(int i=0;i<M;i++)
		{
			if(map[N][i]==0)
			{
				map[N][i]=2;
				permutation(cnt+1);
				map[N][i]=0;
			}
		}
	}
	
	private static int[][] traslate(int[][] temp_map, boolean[][] visited) {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(visited[i][j])
					temp_map[i][j]=0;
		
		return temp_map;
		
	}
	private static boolean[][] bfs(int[][] temp_map, int x, int y, boolean visited[][]) 
	{
		Queue<location> q = new LinkedList<>();
		q.offer(new location(x,y,0));
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int cnt = temp.cnt;
			if(cnt >= D)
				return visited;
			int tx = temp.x;
			int ty = temp.y;
			
			for(int i=0;i<3;i++)
			{
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if(nx>=0 && ny>=0 && nx < N && ny < M)
				{
					if(temp_map[nx][ny]==1)
					{
						visited[nx][ny]=true;
						return visited;
					}
					else
						q.offer(new location(nx,ny,cnt+1));
				}
			}
		}
		return visited;
		
		
	}

}
