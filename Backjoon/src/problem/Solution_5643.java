package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643 {
	static int result=0, N, map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++)
		{
			result=0;
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			for(int i=0;i<M;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			
			for(int i=1;i<=N;i++)
			{
				bfs(i);
				dfs(i,new boolean[N+1]);
			}
			System.out.println("#"+tc+" " + result);
		}
	}
	static int cnt=0;
	static void dfs(int cur, boolean[] visited)
	{
		visited[cur]=true;
		
		for(int i=1;i<=N;i++)
		{
			if(map[cur][i]==1 && visited[i]==false)
			{
				cnt++;
				dfs(cur, visited);
			}
		}
	}
	
	void dfs2(int cur,  boolean[] visited)
	{
		visited[cur]=true;
		
		for(int i=1;i<=N;i++)
		{
			if(map[i][cur]==1 && visited[i]==false)
			{
				cnt++;
				dfs(cur, visited);
			}
		}
	}
	
	private static void bfs(int height) {
		int cnt=0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited0[] = new boolean[N+1];
		for(int i=1;i<=N;i++)
			if(map[i][height]==1)
			{
				cnt++;
				visited0[i]=true;
				q.offer(i);
			}
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int i=1;i<=N;i++)
				if(map[i][temp]==1 && visited0[i]==false)
				{
					cnt++;
					visited0[i]=true;
					q.offer(i);
				}
		}
		
		boolean visited1[] = new boolean[N+1];
		for(int i=1;i<=N;i++)
			if(map[height][i]==1)
			{
				cnt++;
				visited1[i]=true;
				q.offer(i);
			}
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int i=1;i<=N;i++)
				if(map[temp][i]==1 && visited1[i]==false)
				{
					cnt++;
					visited1[i]=true;
					q.offer(i);
				}
		}
		
		if(cnt== N-1)
			result++;
	}

}
