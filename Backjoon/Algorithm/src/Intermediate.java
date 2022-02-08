import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Intermediate {

	static int homeCnt;
	static int N;
	static char map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++)
		{
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			visited = new boolean[N][N];
			StringTokenizer st;
			homeCnt=0;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for(int j=0;j<N;j++)
				{
					map[i][j]= temp.charAt(j);
					if(map[i][j]=='H')
						homeCnt++;
				}
			}
			solve();
			System.out.println("#"+t+" "+homeCnt);
		}
	}
	
	public static void solve()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(map[i][j]=='A')
				{
					if(map[i+1][j]=='H')
						homeCnt--;
						map[i+1][j]='X';
					if(map[i-1][j]=='H')
						homeCnt--;
						map[i-1][j]='X';
					if(map[i][j+1]=='H')
						homeCnt--;
						map[i][j+1]='X';
					if(map[i][j-1]=='H')
						homeCnt--;
						map[i][j-1]='X';
				}
				else if(map[i][j]=='B')
				{
					for(int k=1;k<=2;k++)
					{
						if(map[i+k][j]=='H')
							homeCnt--;
							map[i+k][j]='X';
						if(map[i-k][j]=='H')
							homeCnt--;
							map[i-k][j]='X';
						if(map[i][j+k]=='H')
							homeCnt--;
							map[i][j+k]='X';
						if(map[i][j-k]=='H')
							homeCnt--;
							map[i][j-k]='X';
					}
				}
				else if(map[i][j]=='C')
				{
					for(int k=1;k<=3;k++)
					{
						if(map[i+k][j]=='H')
							homeCnt--;
							map[i+k][j]='X';
						if(map[i-k][j]=='H')
							homeCnt--;
							map[i-k][j]='X';
						if(map[i][j+k]=='H')
							homeCnt--;
							map[i][j+k]='X';
						if(map[i][j-k]=='H')
							homeCnt--;
							map[i][j-k]='X';
					}
				}
			}
		}
	}
}
