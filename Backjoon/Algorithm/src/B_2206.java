import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
	static int N,M;
	static int dx[] = {-1,1,0,0}, dy[]= {0,0,-1,1};
	static char map[][];
	static boolean visited[][][];
	static class location
	{
		int x,y,cnt;
		boolean wall;
		public location(int x, int y, boolean wall, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][2]; //0 -> 벽 안부순거 / 1 -> 벽 부순거
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<M;j++)
				map[i][j] = temp.charAt(j);
		}
		
		bfs();
		
	}

	static void bfs()
	{
		Queue<location> queue = new LinkedList<>();
		queue.offer(new location(0,0,false,1));
		visited[0][0][0]=true;
		visited[0][0][1]=true;
		
		while(!queue.isEmpty())
		{
			location temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			boolean wall = temp.wall;
			int cnt = temp.cnt;
			if(x==N-1 && y == M-1)
			{
				System.out.println(cnt);
				System.exit(0);
			}
			
			for(int i=0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M)
				{
					if(map[nx][ny]=='1')//벽 만났을떄
					{
						if(wall == false && visited[nx][ny][0]==false) //해당칸을 들린적이 없을떄
						{
							visited[nx][ny][1]=true;
							queue.offer(new location(nx,ny,true,cnt+1));
						}
					}
					else //벽이 아닐 때
					{
						if(wall == true) //벽을 부순 적이 있을 떄
						{
							if(visited[nx][ny][1]==false)
							{
								visited[nx][ny][1]=true;
								queue.offer(new location(nx,ny,wall,cnt+1));
							}
						}
						else //벽을 부순적이 없을 때
						{
							if(visited[nx][ny][0]==false)
							{
								visited[nx][ny][0]=true;
								queue.offer(new location(nx,ny,wall,cnt+1));
							}
						}
					}
//					if(wall==false && map[nx][ny]=='0' && visited[nx][ny][0]==false)
//					{
//						//벽이 아니고 들린적이 없으며 벽을 한번도 안부신경우
//						queue.add(new location(nx,ny,false,cnt+1));
//						visited[nx][ny][0]=true;
//					}
//					if(wall==true && map[nx][ny]=='0' && visited[nx][ny][0]==false)
//					{
//						//벽이 아니면서 들린적이 없으며 벽을 한번 부시며 온 경우
//						queue.add(new location(nx,ny,true,cnt+1));
//						visited[nx][ny][1]=true;
//					}
//					if(map[nx][ny]=='1' && wall==false && visited[nx][ny][0]==false)
//					{
//						//벽인 구간을 만났을 때 한번도 부신적이 없는경우
//						queue.offer(new location(nx,ny,true,cnt+1));
//						visited[nx][ny][1]=true;
						
					
				}
			}
		}
		
		System.out.println("-1");
	}
}
