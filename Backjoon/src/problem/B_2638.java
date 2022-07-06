package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2638 {
	static class location
	{
		int x,y;
		
		location(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
	static int X,Y;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		for(int i=0;i<X;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<Y;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int result=0;
		while(!checkEmpty())
		{
			int[][] tempMap = bfs();
			for(int i=0;i<X;i++)
				for(int j=0;j<Y;j++)
					if(tempMap[i][j]>1) //바깥에 나와있는 치즈만 0으로 만들기
						map[i][j]=0;
			
			result++;
		}
		System.out.println(result);
	}

	private static void copy( int[][] tempMap) {
		for(int i=0;i<X;i++)
			for(int j=0;j<Y;j++)
				map[i][j]=tempMap[i][j];
		
	}

	static boolean checkEmpty()
	{
		for(int i=0;i<X;i++)
			for(int j=0;j<Y;j++)
				if(map[i][j]==1)
					return false;
		
		return true;
	}
	
	static int[][] bfs()
	{
		boolean visited[][] = new boolean[X][Y];
		Queue<location> q = new LinkedList<>();
		//왼쪽 가장 위부터
		q.offer(new location(0,0));
		visited[0][0]=true;
		
		int tempMap[][] = new int[X][Y];
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			
			for(int i=0;i<4;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && ny >=0 && nx < X && ny < Y)
				{
					if(visited[nx][ny]==false)
					{
						//치즈면 카운트 체크
						if(map[nx][ny]==1)
							tempMap[nx][ny]++;
						else //치즈아니면 bfs반복
						{
							visited[nx][ny]=true;
							q.offer(new location(nx,ny));
						}
					}
				}
			}
		}
		return tempMap;
		
	}
}
