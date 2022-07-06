package problem;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	static int input[];
	static int limit;
	static int max;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			max=0;
			
			input = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
				input[i]=Integer.parseInt(st.nextToken());
			
			dfs(0,0,0);
			if(max==0)
				max=-1;
			System.out.println("#"+t+ " " + max);
		}
	}
	
	public static void dfs(int weight,int cnt, int idx)
	{
		if(cnt==2)
		{
			if(weight <= limit)
				if(max < weight)
					max = weight;
			return;
		}	
		
		for(int i=idx;i<N;i++)
			dfs(weight+input[i],cnt+1,i+1);
	}

}
