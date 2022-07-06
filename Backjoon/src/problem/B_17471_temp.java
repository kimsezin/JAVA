package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471_temp {
	static int area[][], population[];
	static int result0=0, result1=0;
	static int result=10001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++)
			population[i] = Integer.parseInt(st.nextToken());
		area = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++)
			{
				int adj = Integer.parseInt(st.nextToken());
				area[i][adj] = 1;
				area[adj][i] = 1;
			}
		}
		
		for(int i = 1; i < (1<<N)-1; i++)
		{
			String temp = "";
			int t = i;
			for(int j=0;j<6;j++)
			{
				if(t%2 == 0)
					temp+="0";
				else if(t%2 ==1)
					temp+="1";
				t/=2;
			}
			String check = "";
			for(int j=N-1;j>=0;j--)
				check+=temp.charAt(j);
			
			bfs(check);
		}
		if(result==10001)
			System.out.println(-1);
		else
			System.out.println(result);
	}
	
	static void bfs(String check)
	{
		result1 = 0;
		result0 = 0;
		ArrayList<Integer> area0 = new ArrayList<>();
		ArrayList<Integer> area1 = new ArrayList<>();
		
		for(int i=0;i<check.length();i++)
		{
			if(check.charAt(i) == '0')
				area0.add(i+1);
			else
				area1.add(i+1);
		}
		
		Queue<Integer> q0 = new LinkedList<>();
		Queue<Integer> q1 = new LinkedList<>();
		
		q0.offer(area0.get(0));
		q1.offer(area1.get(0));
		boolean visited0[] = new boolean[check.length()+1];
		boolean visited1[] = new boolean[check.length()+1];
		visited0[area0.get(0)] = true;
		visited1[area1.get(0)] = true;
		
		while(!q0.isEmpty())
		{
			int temp = q0.poll();
			for(int i=1;i<check.length()+1;i++)
			{
				if(area[temp][i] == 1)
				{
					visited0[i]=true;
					for(int be : area0)
						if(i==be && visited0[i]==false)							
							q0.offer(i);
				}
			}
		}
		
		while(!q1.isEmpty())
		{
			int temp = q1.poll();
			for(int i=1;i<check.length()+1;i++)
			{
				if(area[temp][i]==1)
				{
					visited1[i]=true;
					for(int be : area1)
						if(i== be && visited1[i]==false)
								q1.offer(i);
				}	
			}
		}
		
		boolean isok0 = false;
		boolean isok1 = false;
	
		
		for(int i=1;i<visited1.length;i++)
		{
			if(visited1[i]==true)
				for(int be : area1)
					if(be==i)
					{
						isok1=true;
						break;
					}
					else isok1=false;
		}
		for(int i=1;i<visited0.length;i++)
		{
			if(visited0[i]==true)
				for(int be : area0)
					if(be==i)
					{
						isok0=true;
						break;
					}
					else
						isok0=false;
		}
		if(isok0==true)
		{
			for(int be : area0)
				result0 += population[be];
		}
		else
			return;
		
		if(isok1 == true)
		{
			for(int be : area1)
				result1 += population[be];
		}
		else return;
		
		result = Math.min(result, Math.abs(result0 - result1));
		
	}

}
