package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_10026 {
	public static class picture
	{
		int x,y;

		public picture(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = new int[] {-1,1,0,0};
	static int dy[] = new int[] {0,0,-1,1};
	public static char map[][];
	public static int N;
	public static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String temp = st.nextToken();
			for(int j=0;j<N;j++)
				map[i][j]=temp.charAt(j);
		}
		
		int result=0;
		visited= new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(visited[i][j]==false)
				{
					dfs(i,j,map[i][j]);
					result++;
				}
			}
		}
		System.out.print(result + " ");
		result=0;
		visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(map[i][j]=='G')
					map[i][j]='R';
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(visited[i][j]==false)
				{
					dfs(i,j,map[i][j]);
					result++;
				}
			}
		}
		System.out.println(result);
	}

	public static void dfs(int x, int y, char current)
	{
		visited[x][y]=true;
		for(int i=0;i<4;i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >=0 && ny>=0 && nx < N && ny < N)
			{
				if(visited[nx][ny]==false)
				{
					if(current == map[nx][ny])
					{
						visited[nx][ny]=true;
						dfs(nx,ny,current);
					}
				}
			}
		}
	
	}
}
