
public class KDT_3 {

	static boolean[] visited;
	static int result=0;
	static int last_station=0;
	public static void main(String[] args) {
		
		int result[] = solution(6, new int[] {1,1,1,1,1,1}, new int[][] {{1,2},{1,3},{1,4},{3,5},{3,6}});
		System.out.println(result[0]+","+result[1]);
		result = solution(6, new int[] {2,1,2,2}, new int[][] {{1,2},{1,3},{2,4}});
		System.out.println(result[0]+","+result[1]);
		result = solution(6, new int[] {1,1,2,3,4}, new int[][] {{1,2},{1,3},{1,4},{1,5}});
		System.out.println(result[0]+","+result[1]);
		
	}

	public static int[] solution(int n, int[] passenger, int[][] train)
	{
		result=0;
		last_station=0;
		visited = new boolean[n];
		
		int map[][] = new int[n][n];
		for(int i=0;i<train.length;i++)
		{
			int start = train[i][0];
			int end = train[i][1];
			
			map[start-1][end-1]=1;
			map[end-1][start-1]=1;
		}
		
		visited[0]=true;
		dfs(n,0,visited,map,passenger[0],passenger);
		
		int answer[] = new int[2];
		answer[0]=last_station;
		answer[1]=result;
		return answer;
	}

	static void dfs(int n, int start, boolean[] visited, int[][] map, int distance, int[] passenger)
	{
		if(result == distance)
			if(last_station < start+1)
				last_station = start+1;
		if(result < distance)
		{
			last_station = start+1;
			result = distance;
		}
		
		for(int i=0;i<n;i++)
		{
			if(map[start][i]==1)
			{
				if(visited[i]==false)
				{
					visited[i]=true;
					distance += passenger[i];
					dfs(n,i,visited,map,distance,passenger);
					distance -= passenger[i];
					visited[i]=false;
				}
			}
		}
	}
}
