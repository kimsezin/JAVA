import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T;test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[N][N];
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max_value = 0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					int target = 0;
					
					for(int x=i;x<M+i;x++)
					{
						for(int y=j;y<M+j;y++)
						{
							if(x<N && y<N)
							{
								target+=map[x][y];
							}
							else
								target=0;
						}
					}
					
					if(max_value < target)
						max_value = target;
					
				}
			}
			
			System.out.println("#"+test_case+" "+max_value);
		}

	}

}
