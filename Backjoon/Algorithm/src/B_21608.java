import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21608 {
	static int N, map[][];
	static int dx[]= {-1,1,0,0}, dy[] = {0,0,-1,1};
	static int favorite[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		favorite = new int[N*N][4]; //좋아하는 학생
		for(int i=0;i<N*N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int student = Integer.parseInt(st.nextToken()); //학생
			
			for(int j=0;j<4;j++)
				favorite[student-1][j]=Integer.parseInt(st.nextToken());
			
	
			solve(student, favorite[student-1]);
		}
		int result=0;
		for(int x=0;x<N;x++)
			for(int y=0;y<N;y++)
			{
				int cnt=0;
				for(int i=0;i<4;i++)
				{
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N)
					{
						for(int j=0;j<4;j++)
							if(favorite[map[x][y]-1][j] == map[nx][ny])
								cnt++;
					}
					
				}
				if(cnt==0)
					continue;
				else
					result+=Math.pow(10, cnt-1);
			}
			System.out.println(result);

	}
	private static void solve(int student, int[] favorite) {
		int adj_favorite_cnt = 0;
		int adj_zero_cnt=0;
		int r=0,c=0;
		boolean check=false;
		for(int x=0;x<N;x++)
			for(int y=0;y<N;y++)
			{
				if(map[x][y]==0)
				{
					if(check==false)
					{
						r=x;
						c=y;
						check=true;
					}
					int favorite_cnt = 0;
					int zero_cnt=0;
					for(int i=0;i<4;i++)
					{
						int nx = x+dx[i];
						int ny = y+dy[i];
						
						if(nx >=0 && ny >= 0 && nx < N && ny < N)
						{
							if(map[nx][ny]==0)
								zero_cnt++;
							else
							{
								for(int j=0;j<4;j++)
								{
									if(favorite[j]==map[nx][ny])
										favorite_cnt++;
								}
							}
							if(adj_favorite_cnt < favorite_cnt)
							{
								adj_favorite_cnt=favorite_cnt;
								adj_zero_cnt = zero_cnt;
								r = x;
								c = y;
							}
							else if(adj_favorite_cnt == favorite_cnt)
							{
								if(adj_zero_cnt < zero_cnt)
								{
									adj_zero_cnt = zero_cnt;
									r=x;
									c=y;
								}
							}
						}
						
					}
				}
			}
		
		map[r][c] = student;
		
	}

}
