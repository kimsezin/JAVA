package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247 {
	
	static int map[][], N;
	static location company, home, customer[];
	static boolean visited[];
	static int result = Integer.MAX_VALUE;
	static public class location
	{
		int x,y;
		
		public location(int x,int y)
		{
			this.x=x;
			this.y=y;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			int company_x = Integer.parseInt(st.nextToken());
			int company_y = Integer.parseInt(st.nextToken());
			company = new location(company_x,company_y);
			
			int home_x = Integer.parseInt(st.nextToken());
			int home_y = Integer.parseInt(st.nextToken());
			home = new location(home_x,home_y);
			
			customer= new location[N];
			
			for(int i=0;i<N;i++)
			{
				int customer_x = Integer.parseInt(st.nextToken());
				int customer_y = Integer.parseInt(st.nextToken());
				customer[i] = new location(customer_x, customer_y);
			}
			
			dfs(company.x, company.y,0,visited,0);
			System.out.println("#"+ tc + " " + result);
		}
	}
	static void dfs(int nx, int ny, int distance, boolean[] visited, int cnt)
	{
		if(cnt==N)
		{
			distance+=(Math.abs(nx-home.x) + Math.abs(ny-home.y));
			if(distance < result)
				result = distance;
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				int temp_distance = (Math.abs(nx - customer[i].x) + Math.abs(ny - customer[i].y));
				dfs(customer[i].x,customer[i].y,distance+temp_distance,visited,cnt+1);
				visited[i]=false;
			}
		}
	}
}
