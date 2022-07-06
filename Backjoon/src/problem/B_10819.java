package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10819 {
	static int arr[];
	static int result=0;
	static int totalcnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N];
		boolean[] visited = new boolean[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		dfs(0, N, new int[N],visited);
		System.out.println(result);
	}
	
	static void dfs(int cnt, int N, int[] temp, boolean[] visited)
	{
		if(cnt==N)
		{
			int sum=0;
			for(int i=0;i<N-1;i++)
				sum+=Math.abs(temp[i]-temp[i+1]);
			if(sum>result)
				result=sum;
			return;
		}
		for(int i=0;i<N;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				temp[cnt]=arr[i];
				dfs(cnt+1,N,temp,visited);
				temp[cnt]=0;
				visited[i]=false;
			}
		}
	}
	
	
}
