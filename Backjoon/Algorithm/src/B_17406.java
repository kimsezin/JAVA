import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17406 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int map[][];
	static int min = 2500001;
	
	static int N;
	static int M;
	static int K;
	static String input[];
	static boolean visited[];
	static int[][] copy_map;
	static String operator[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[K];
		copy_map = new int[N][M];
		operator = new String[K];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				int temp=Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				copy_map[i][j] = temp;
			}
		}
		
		input = new String[K];
		for(int i=0;i<K;i++)
		{
			input[i] = br.readLine();
		}
		
		dfs(0);
		
		System.out.println(min);

	}
	public static void dfs(int cnt)
	{
		if(cnt==K)
		{
			for(int i=0;i<K;i++)
			{
				String temp[] = operator[i].split(" ");
				rolling(Integer.parseInt(temp[0])-1,Integer.parseInt(temp[1])-1,Integer.parseInt(temp[2]));
			}
			for(int i=0;i<N;i++)
			{
				int temp=0;
				for(int j=0;j<M;j++)
				{
					temp+=map[i][j];
				}
				if(temp < min)
					min=temp;
			}
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					map[i][j]=copy_map[i][j];
			return;
		}
		
		for(int i=0;i<K;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				operator[cnt]=input[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
		
		
	}
	public static void rolling(int r, int c, int s)
	{
		for(int i=0;i<s;i++)
		{
			int x = r+i-s;
			int y = c+i-s;
			int temp = map[x][y];
			int direction=0;
			while(direction<4)
			{
				int nx = x +dx[direction];
				int ny = y +dy[direction];
				
				if(nx >= r-s+i && ny >= c+i-s && nx <= r+s-i && ny <= c+s-i )
				{
					if(nx == i && ny ==c-s)
						direction++;
					else
					{
						map[x][y]=map[nx][ny];
						x=nx;
						y=ny;
					}
				}
				else
					direction++;
			}
			map[x][y+1]=temp;
		}

	}
}
