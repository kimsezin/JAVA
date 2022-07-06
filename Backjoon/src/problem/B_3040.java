package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3040 {

	static int input[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[9];
		for(int i=0;i<9;i++)
			input[i]=Integer.parseInt(br.readLine());
		visited = new boolean[9];
		int arr[] = new int[7];
		dfs(0,arr);
	}

	static void dfs(int cnt, int arr[])
	{
		if(cnt==7)
		{
			int sum=0;
			for(int i=0;i<7;i++)
			{
				sum+=arr[i];
			}
			if(sum==100)
			{
				for(int i=0;i<7;i++)
					System.out.println(arr[i]);
				
				System.exit(0);
			}
			return;
		}
		
		for(int i=0;i<9;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				arr[cnt]=input[i];
				dfs(cnt+1,arr);
				visited[i]=false;
			}
		}
	}
}
