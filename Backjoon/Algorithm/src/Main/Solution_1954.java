package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		for(int test_case = 1; test_case<=T;test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			int value = 2;
			int direction = 0;
			int nx = 0;
			int ny = 0;
			map[0][0]=1;
			for(int i=1;i<N*N;i++)
			{
				nx +=dx[direction];
				ny +=dy[direction];
				if(nx >= 0 && ny >= 0 && nx <N && ny <N && map[nx][ny]==0)
				{
						map[nx][ny]=value++;
				}
				else
				{
					nx -= dx[direction];
					ny -= dy[direction];
					direction+=1;
					direction%=4;
					
					nx += dx[direction];
					ny += dy[direction];
					
					if(map[nx][ny]==0)
						map[nx][ny] = value++;
				}
			}
			System.out.println("#"+test_case);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
