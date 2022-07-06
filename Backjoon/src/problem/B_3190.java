package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_3190 {
	static int N, K, map[][], L, cnt;
	static int dir=1;
	static int dx[]= {-1,0,1,0}, dy[]= {0,1,0,-1}; //상우하좌
	
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
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<K;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			map[x][y]=1; //사과
		}
		
		L = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> m = new HashMap<>();
		
		for(int i=0;i<L;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken()); //시간
			char C = st.nextToken().charAt(0); //방향회전
			
			m.put(X, C); // map에다 시간, 방향회전 넣기
		}
		
		int time=1;
		int x=0, y=0;
		ArrayList<location> list = new ArrayList<>(); //뱀 좌표 순서대로
		
		list.add(new location(x,y));
		while(true)
		{
			if(m.get(time)==null) //방향 전환 없이 전진
			{
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				if(nx<0 || ny<0 || nx >= N || ny >=N) //벽에 나갔을 때
				{
					System.out.println(time);
					return;
				}
				
				for(int i=0;i<list.size();i++) //자기 몸에 닿았을 때
				{
					location temp = list.get(i);
					if(nx == temp.x && ny == temp.y)
					{
						System.out.println(time);
						return;
					}
				}
				
				if(map[nx][ny]==0)
				{
					list.remove(0); // 젤 뒤에 꼬리 자르기
					list.add(new location(nx,ny)); //앞에 한칸 추가
				}
				else
				{
					map[nx][ny]=0;
					list.add(new location(nx,ny)); //앞에 한칸 추가
				}
				x=nx;
				y=ny;
			}
			
			else
			{
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				if(nx<0 || ny<0 || nx >= N || ny >=N) //벽에 나갔을 때
				{
					System.out.println(time);
					return;
				}
				
				for(int i=0;i<list.size();i++) //자기 몸에 닿았을 때
				{
					location temp = list.get(i);
					if(nx == temp.x && ny == temp.y)
					{
						System.out.println(time);
						return;
					}
				}
				
				
				if(map[nx][ny]==0)
				{
					list.remove(0); // 젤 뒤에 꼬리 자르기
					list.add(new location(nx,ny)); //앞에 한칸 추가
				}
				else
				{
					map[nx][ny]=0;
					list.add(new location(nx,ny)); //앞에 한칸 추가
				}
				
				if(m.get(time) =='L') //왼쪽으로 90도
				{
					dir-=1;
					if(dir<0) //상 -> 좌로 움직일 때 dir이 음수가 되므로
						dir=3;
				}
				else
				{
					dir+=1;
					if(dir>3) //좌-> 상으로 움직일때 dir이 3을 초과하므로
						dir=0;
				}
				
				x=nx;
				y=ny;
			}
			time++;
		}
		
	}
	
	

}
