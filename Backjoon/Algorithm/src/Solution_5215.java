import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {

	static int N, target;
	static int[] cal;
	static int[] score;
	static int result;
	static int max;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			cal = new int[N];
			score = new int[N];
			visited = new boolean[N];
			result=0;
			max=0;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
				
			}
			dfs(0,0,0);
			System.out.println("#"+t + " "+max);
		}
	}
	
	public static void dfs(int temp_score, int calo, int idx)
	{
		if(calo > target)
			return;
		else
			max = Math.max(temp_score, max);
		
		
		for(int i=0;i<N;i++)
		{
			if(i>=idx)
			{
				if(visited[i]!=true)
				{
					temp_score+=score[i];
					calo += cal[i];
					visited[i]=true;
					dfs(temp_score,calo,i);
					temp_score-=score[i];
					calo -= cal[i];
					visited[i]=false;
				}
			}
		}
	}

}
