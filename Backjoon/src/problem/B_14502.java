package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502 {
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int N,M,map[][], dx[] = {-1,1,0,0}, dy[]= {0,0,-1,1}, result=0;
	static ArrayList<location> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					list.add(new location(i,j));
			}
		}
		boolean visited[][] = new boolean[N][M];
		permutation(0,visited);
		System.out.println(result);
	}
	private static void permutation(int cnt, boolean visited[][]) {
		if(cnt==3)
		{
			bfs(map);
			return;
		}
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if(map[i][j]==0 && visited[i][j]==false)
				{
					visited[i][j]=true;
					map[i][j]=1;
					permutation(cnt+1,visited);
					visited[i][j]=false;
					map[i][j]=0;
				}
			}
				
	}
	private static void bfs(int[][] map) {
		Queue<location> q = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		for(int i=0;i<list.size();i++)
			q.offer(list.get(i));
		
		int temp_map[][] = new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				temp_map[i][j] = map[i][j];
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			
			for(int i=0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M)
				{
					if(temp_map[nx][ny]==0)
					{
						temp_map[nx][ny]=1;
						q.offer(new location(nx,ny));
					}
				}
			}
		}
		
		int cnt=0;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(temp_map[i][j]==0)
					cnt++;
		
		result=Math.max(result, cnt);
	}

}
