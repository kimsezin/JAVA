import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16926 {
	static int map[][];
	static int copy_map[][];
	static int N;
	static int M;
	static int direction[] = {0,0,0,0};
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		copy_map= new int[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				String temp = st.nextToken();
				map[i][j]=Integer.parseInt(temp);
				copy_map[i][j]=Integer.parseInt(temp);
			}
		}
		for(int k=0;k<cnt;k++)
		{
			rolling();
			/*for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					copy_map[i][j]=map[i][j];
				}
			}*/
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void rolling()
	{
		int cnt = Math.min(N,M)/2;
		for(int i=0;i<cnt;i++)
		{
			int x = i;
			int y = i;
			
			int temp = map[i][i];
			int direction=0;
			while(direction<4)
			{
				int nx = x +dx[direction];
				int ny = y +dy[direction];
				
				if(nx >= i && ny >= i && nx < N-i && ny < M-i)
				{
					map[x][y]=map[nx][ny];
					x=nx;
					y=ny;
				}
				else
					direction++;
			}
			map[i+1][i]=temp;
		}
		/*if(N <= M)
		{
			int cnt = N/2;
			for(int i=1;i<=cnt-1;i++)
			{
				for(int x=0;x<N;x++)
				{
					for(int y=0;y<M;y++)
					{
						if(x==0)
						{
							if(y+1 == M)
								map[x][y] = copy_map[x+1][y];
							else
								if(y+1 < M)
								map[x][y] = copy_map[x][y+1];
							
						}
						else if(x==N-i)
						{
							if(y==0)
								map[x][y] = copy_map[x-1][y];
							else
								if(y-1 >= 0)
								map[x][y] = copy_map[x][y-1];
						}
						else
						{
							if(y==i-1)
							{
								map[x][y] = copy_map[x-1][y];
							}
							else if(y==M-1)
							{
								if(x+1 < N)
								map[x][y] = copy_map[x+1][y];
							}
						}
					}
				}
			}
			for(int x=cnt-1;x<=cnt;x++)
			{
				for(int y=cnt-1;y<=M-cnt;y++)
				{
					if(x==cnt-1 && y==M-cnt)
					{
						if(x+1 < N)
						map[x][y] = copy_map[x+1][y];
					}
					else if(x==cnt && y==cnt-1)
					{
						if(x-1 >= 0)
						map[x][y] = copy_map[x-1][y];
					}
					else if(x==cnt-1 && y!=M-cnt )
					{
						if(y+1 < M)
						map[x][y] = copy_map[x][y+1];
					}
					else if(x==cnt && y!=cnt-1)
					{
						if(y-1 >= 0)
						map[x][y] = copy_map[x][y-1];
					}
				}
			}
		}
		else
		{
			int cnt = M/2;
			for(int i=1;i<=cnt-1;i++)
			{
				for(int x=0;x<N;x++)
				{
					for(int y=0;y<M;y++)
					{
						if(x==0)
						{
							if(y+1 == M)
								map[x][y] = copy_map[x+1][y];
							else
								if(y+1 < M)
								map[x][y] = copy_map[x][y+1];
							
						}
						else if(x==N-i)
						{
							if(y==0)
								map[x][y] = copy_map[x-1][y];
							else
								if(y-1 >= 0)
								map[x][y] = copy_map[x][y-1];
						}
						else
						{
							if(y==i-1)
							{
								map[x][y] = copy_map[x-1][y];
							}
							else if(y==M-1)
							{
								if(x+1 < N)
								map[x][y] = copy_map[x+1][y];
							}
						}
					}
				}
			}
			for(int x=cnt-1;x<=N-cnt;x++)
			{
				for(int y=cnt-1;y<=cnt;y++)
				{
					if(x==cnt-1 && y==cnt-1)
					{
						if(y+1 < M)
						map[x][y] = copy_map[x][y+1];
					}
					else if(x!=cnt-1 && y==cnt-1)
					{
						if(x-1 >= 0)
						map[x][y] = copy_map[x-1][y];
					}
					else if(x==N-cnt && y==cnt )
					{
						if(y-1 >= 0)
						map[x][y] = copy_map[x][y-1];
					}
					else if(x!=N-cnt && y==cnt)
					{
						if(x+1 < N)
						map[x][y] = copy_map[x+1][y];
					}
				}
			}
		}*/
	}
}
