package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1261 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static class location implements Comparable<location>
	{
		int x,y,value;

		public location(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public int compareTo(location o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<M;j++)
				map[i][j] = temp.charAt(j)-'0';
		}
		
		PriorityQueue<location> pq = new PriorityQueue<>();
		int distance[][] = new int[N][M];
		///거리 큰 수로 채워놓기
		for(int i=0;i<N;i++)
			Arrays.fill(distance[i], 987654321);
		
		
		distance[0][0]=0;
		pq.add(new location(0,0,0));
		
		while(!pq.isEmpty())
		{
			location temp = pq.poll();
			int x = temp.x;
			int y = temp.y;
			int dis = temp.value;
			for(int i=0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M )
				{
					//지금까지 nx,ny로 간 거리보다 현재에서 nx,ny를 거치는것이 더 짧은 경우
					//distance[nx][ny]에 지금까지의 최소값이 들어가게 됨
					if(distance[nx][ny] > dis + map[nx][ny])
					{
						distance[nx][ny] = dis+map[nx][ny];
						pq.add(new location(nx,ny,distance[nx][ny]));
					}
				}
			}
		}
		
		System.out.println(distance[N-1][M-1]);
		
	}

}
