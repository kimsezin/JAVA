package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11403 {
	static int map[][], ans[][], N;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		ans = new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) //i번째 행부터 bfs 시작
			bfs(i);
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(ans[i][j]+" ");
			System.out.println();
		}
	}

	private static void bfs(int x)
	{
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N];
		q.offer(x);
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i=0;i<N;i++)
				if(map[cur][i]==1 && visited[i]==false) //현재 cur에서 다른곳으로 갈 수 있을시 처음 입력한 x에서도 갈 수 있음. visited가 true면 이미 그곳은 갈 수 있으므로
				{
					visited[i]=true;
					q.offer(i);
					ans[x][i]=1;
				}
		}
	}
}


