package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16236 {
	static int dx[] = new int[] {-1,1,0,0}; 
	static int dy[] = new int[] {0,0,-1,1};
	static int map[][], N, result=0;
	static int sharkX,sharkY,sharkWeight=2;
	static int cnt=0;
	static boolean eat = false;
	
	public static class shark
	{
		int x,y;
		int distance;
		
		public shark(int x, int y, int distance)
		{
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9)
				{
					sharkX = i;
					sharkY = j;
				}
			}
		}
		while(true)
		{
			bfs(sharkX,sharkY);
			if(eat==false)
				break;
			
			cnt++;
			if(cnt == sharkWeight)
			{
				cnt=0;
				sharkWeight+=1;
			}
		}
		System.out.println(result);
		
	}
	static void bfs(int x, int y)
	{
		Queue<shark> queue = new LinkedList<>();
		queue.offer(new shark(x,y,0));
		boolean visited[][] = new boolean[N][N];
		visited[x][y]=true;
		ArrayList<shark> canEat = new ArrayList<>();
		
		while(!queue.isEmpty())
		{
			shark temp = queue.poll();
			for(int i=0;i<4;i++) //상하좌우 탐색
			{
				int nx = temp.x + dx[i]; 
				int ny = temp.y + dy[i];
				if(nx >=0 && ny >=0 && nx<N && ny <N)
				{
					if(visited[nx][ny]==false) //상어가 방문하지 않은곳
					{
						visited[nx][ny]=true; //
						if(map[nx][ny] <= sharkWeight) //지나갈 수 있는곳
						{
							queue.offer(new shark(nx,ny,temp.distance+1));
							if(map[nx][ny]!=0 && map[nx][ny]<sharkWeight) //먹을 수 있는 곳
								canEat.add(new shark(nx,ny,temp.distance+1));
						}
					}
				}
			}
		}
		if(canEat.size()==0)
		{	
			eat=false;
			return;
		}
			Collections.sort(canEat,new Comparator<shark>() {

			@Override
			public int compare(shark o1, shark o2) {
				// TODO Auto-generated method stub
				if(o1.distance == o2.distance)
				{
					if(o1.x == o2.x)
						return o1.y - o2.y;
					else
						return o1.x - o2.x;
				}
				return o1.distance - o2.distance;
			}
		});
		
		result+=canEat.get(0).distance;
		sharkX = canEat.get(0).x;
		sharkY = canEat.get(0).y;
		map[sharkX][sharkY]=0;
		eat=true;
	}
}
