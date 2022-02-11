import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2011 {

	static int map[][];
	static int result;
	static int min;
	static int N;
	static boolean visited[][];
	
	//상하좌우 검사용
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++)
		{
			N = Integer.parseInt(br.readLine());
			map= new int[N][N];
			visited = new boolean[N][N];
			StringTokenizer st;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					map[i][j] = Integer.parseInt(st.nextToken()); 
			}
			//입력 끝
			result=1;
			min=map[0][0];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
				{
					dfs(i,j,1,map[i][j]);
				}
			System.out.println("#"+tc+" "+min +" "+result);
		}
		
	}
	
	static void dfs(int x, int y, int cnt, int start)
	{
		if(cnt == result) // 같은 거리일 때 최소값 출력해야하므로 최소값 바꿔주기
			if(min > start)
				min=start;
		
		if(cnt > result) // 더 많이 진행했을때
		{
			result=cnt;
			min=start;
		}
		for(int i=0;i<4;i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >=0 && ny >=0 && nx < N && ny < N)
			{
				if(visited[nx][ny]==false)
				{
					visited[nx][ny]=true;
					if(map[nx][ny] == map[x][y] + 1) // 들리지 않은 곳이며, 현재값보다 1보다 클 시 그 방으로 넘어가 다시 dfs
					{
						cnt++;
						dfs(nx,ny,cnt,start);
					}
					visited[nx][ny]=false;
				}
			}
		}
	}

}
