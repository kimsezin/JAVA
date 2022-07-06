package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Softeer_장애물인식프로그램 {
	static int N,map[][];
	static boolean visited[][];
	static int dx[]= {-1,1,0,0}, dy[]= {0,0,-1,1};
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++)
		{
			String input = br.readLine();
			for(int j=0;j<N;j++)
				map[i][j] = input.charAt(j)-'0';
		}
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(visited[i][j]==false && map[i][j]!=0)
					result.add(bfs(i,j));
		
		System.out.println(result.size());
		Collections.sort(result);
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
		
	}
	private static int bfs(int x, int y) {

		visited[x][y] = true;
		Queue<location> queue = new LinkedList<>();
		queue.offer(new location(x,y));
		int cnt=1; //제일 첨 들어간거 하나 추가
		
		while(!queue.isEmpty())
		{
			location temp = queue.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N)
				{
					if(visited[nx][ny]==false && map[nx][ny]!=0)
					{
						queue.offer(new location(nx,ny));
						visited[nx][ny]=true;
						cnt++;
					}
				}
			}
		}
		return cnt;
		
//		visited[x][y]=true;
//		int cnt=1;
//		
//		for(int i=0;i<4;i++)
//		{
//			int nx = x+dx[i];
//			int ny = y+dy[i];
//			
//			if(nx >= 0 && ny >= 0 && nx < N && ny < N)
//				if(visited[nx][ny]==false && map[nx][ny]!=0)
//					cnt+=dfs(nx,ny);
//		}
//		return cnt;
	}
}
