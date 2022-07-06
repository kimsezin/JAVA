package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249_Dijkstra {
	static int map[][], N, result;
	static int dx[]= {-1,1,0,0}, dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<N;i++)
			{
				String input = br.readLine();
				for(int j=0;j<N;j++)
					map[i][j] = input.charAt(j) - '0';
			}

			System.out.println(dijkstra(0,0));
		}
	}
	private static int dijkstra(int startX, int startY) {
		
		boolean visited[][] = new boolean[N][N];
		int minTime[][] = new int[N][N]; //출발지에서 자신까지 복구시간
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				minTime[i][j] = Integer.MAX_VALUE;
			
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		}); //정점의정보, 자신까지의 시간

		minTime[startX][startY]=0;
		pq.offer(new int[] {startX, startY, minTime[startX][startY]});
		
		int x,y,minCost,nx,ny,current[];
		while(true)
		{
			current = pq.poll(); //pq안의 정점 중 출발지부터 자신까지 최소인 정점의 정보
			x = current[0];
			y = current[1];
			minCost = current[2];
			
			if(visited[x][y]) continue;
			visited[x][y]=true;

			if(x==N-1 && y== N-1)
				return minCost;
			
			//현 정점의 인접정점 들여다보며 최소비용 갱신
			for(int i=0;i<4;i++)
			{
				nx = x+dx[i];
				ny = y+dy[i];
				if(nx>=0 && ny >= 0 && nx < N && ny < N && minTime[nx][ny] > minCost+map[nx][ny])
				{
					minTime[nx][ny] = minCost+map[nx][ny];
					pq.offer(new int[] {nx,ny,minTime[nx][ny]});
				}
			}
		}
	}
}
