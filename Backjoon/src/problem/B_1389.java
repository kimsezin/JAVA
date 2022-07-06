package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N+1][N+1];
		
		for(int i=1;i<=M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to]=1;
			arr[to][from]=1;
		}
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
				if(arr[i][j]!=1)
					arr[i][j]=987654321;
		
		int result=Integer.MAX_VALUE;
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
			{
				if(i==k) continue;
				for(int j=1;j<=N;j++)
				{
					if(i==j || j == k) continue;
					if(arr[i][j]==0) 
						arr[i][j]=arr[i][k]+arr[k][j];
					else
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		int person=0;
		for(int i=1;i<=N;i++)
		{
			int temp = 0;
			for(int j=1;j<=N;j++)
				temp += arr[i][j];
			
			if(result > temp)
			{
				result = temp;
				person=i;
			}
		}
		
		System.out.println(person);
	}

}
