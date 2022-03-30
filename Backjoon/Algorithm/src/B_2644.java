import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2644 {
	static int map[][];
	static int N;
	static boolean visited[];
	static boolean check=false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++)
		{
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[to][from]=1;
			map[from][to]=1;	
		}
		visited = new boolean[N+1];
		dfs(start, 0, end);
		if(check==false)
			System.out.println(-1);
	}
	
	static void dfs(int start, int cnt, int end)
	{
		visited[start] = true;
		if(start==end)
		{
			System.out.println(cnt);
			check=true;
			return;
		}
		
		for(int i=1;i<=N;i++)
		if(map[start][i]==1)
			if(visited[i]==false)
				dfs(i, cnt+1, end);
	}

}
