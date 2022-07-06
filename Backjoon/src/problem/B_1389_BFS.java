package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1389_BFS {
	static int distance=Integer.MAX_VALUE;
	static int person=0;
	static int N, arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for(int i=1;i<=M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to]=1;
			arr[to][from]=1;
		}
		
		for(int i=1;i<=N;i++)
		{
			int visited[] = new int[N+1];
			bfs(i, visited);
		}
		
		System.out.println(person);
	}
	
	static void bfs(int cur, int visited[])
	{
		Queue<Integer> q = new LinkedList<Integer>();
		visited[cur] = 0;
		q.offer(cur);
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			
			for(int i=1;i<=N;i++)
			{
				if(temp==i)
					continue;
				
				if(visited[i]==0 && arr[temp][i]==1)
				{
					visited[i] = visited[temp]+1;
					q.offer(i);
				}
				
			}
		}
		int result=0;
		for(int i=1;i<=N;i++)
			result += visited[i];
		
		if(distance > result)
		{
			distance =result;
			person = cur;
		}
	}
	

}
