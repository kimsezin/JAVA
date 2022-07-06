package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1194 {
	public static class location
	{
		int x,y;
		int cnt=0;
		int keys;

		public location(int x, int y, int cnt, int keys) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.keys = keys;
		}
		
	}
	static int N,M, dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1};
	static char map[][];
	static boolean visited[][][];
	public static void main(String[] args) throws IOException {
		/**
		 * 빈 칸: 언제나 이동할 수 있다. ('.')
			벽: 절대 이동할 수 없다. ('#')
			열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
			문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
			민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
			출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
			달이 차오르는 기회를 놓치지 않기 위해서, 미로를 탈출하려고 한다. 한 번의 움직임은 현재 위치에서 수평이나 수직으로 한 칸 이동하는 것이다.
			
			민식이가 미로를 탈출하는데 걸리는 이동 횟수의 최솟값을 구하는 프로그램을 작성하시오.
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		location start = null;
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<M;j++)
			{
				map[i][j] = temp.charAt(j);
				if(map[i][j] == '0')
					start = new location(i,j,0,0);
			}
		}
		visited = new boolean[N][M][1<<6]; //000000 ~ 111111
		bfs(start);
	}
	
	public static void bfs(location start)
	{
		Queue<location> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y][0]=true;
		while(!q.isEmpty())
		{
			location temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int cnt = temp.cnt;
			int keys = temp.keys;

			for(int i=0;i<4;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny][keys]==false)
				{
					if(map[nx][ny] == '.' || map[nx][ny]=='0')
					{
						visited[nx][ny][keys]=true;
						q.offer(new location(nx,ny,cnt+1,keys));
					}
					else if('a' <= map[nx][ny] && map[nx][ny] <='f')
					{
						int tempkey = 1;
						for(int j=0;j<map[nx][ny] - 'a';j++) 
							tempkey = tempkey << 1; //알파벳 번호 수 만큼 시프트해서 자리맞추기
						
						tempkey |= keys; //현재 들고있는 키와 결합 하여 q에 넘기기
						visited[nx][ny][tempkey]=true;
						
						q.offer(new location(nx,ny,cnt+1,tempkey));
					}
					else if('A'<= map[nx][ny] && map[nx][ny] <='F')
					{
						if((keys & (1<<map[nx][ny]-'A')) != 0) //내 키와 현재 맞닥뜨린 문 (ex B -> 000010)과 and연산하면 열쇠있는지없는지 알수있음.
						{
							visited[nx][ny][keys]=true;
							q.offer(new location(nx,ny,cnt+1,keys));
						}
					}
					else if(map[nx][ny]=='1')
					{
						System.out.println(cnt+1);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(-1);
	}

}
