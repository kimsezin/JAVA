package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4485 {
	static int N, map[][], result;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class location
	{
		int x,y;
		int distance;
		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=1;
		while(true)
		{
			N = Integer.parseInt(br.readLine());
			result = N*N*9;
			if(N==0)
				break;
			StringBuilder sb = new StringBuilder();
			sb.append("Problem ").append(tc+": ");
			tc++;
			map = new int[N][N];
			
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					map[i][j]=Integer.parseInt(st.nextToken());
			}
			
			int distance[][] = new int[N][N];
			boolean visited[][] = new boolean[N][N];
			PriorityQueue<location> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++)
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			pq.offer(new location(0,0));
			distance[0][0] = map[0][0];
			
			while(pq.isEmpty()==false)
			{
				location temp = pq.poll();
				if(visited[temp.x][temp.y]==true)
					continue;
				visited[temp.x][temp.y]=true;
				
				for(int i=0;i<4;i++)
				{
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N)
					{
						if(visited[nx][ny]==false)
						{
							if(map[nx][ny] + distance[temp.x][temp.y] < distance[nx][ny])
							{
								distance[nx][ny] = map[nx][ny] + distance[temp.x][temp.y];
								pq.offer(new location(nx,ny));
							}
						}
					}
				}
			}
			sb.append(distance[N-1][N-1]);
			System.out.println(sb);
		}

	}
	
	

}
