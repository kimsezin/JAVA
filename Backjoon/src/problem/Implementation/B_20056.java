package problem.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_20056 {

	static int N,M,K;
	static class fireBall
	{
		int x,y;
		int m,s,d;
		public fireBall(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
			
		}
	}
	
	static int dx[]= {-1,-1,0,1,1,1,0,-1}, dy[] = {0,1,1,1,0,-1,-1,-1};
	
	static ArrayList<fireBall>[][] map;
	static ArrayList<fireBall> fireBallList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		fireBallList = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = new ArrayList<fireBall>();
		
		for(int i=0;i<M;i++) //파이어볼 개수만큼 생성
		{
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());// 질량
			int s = Integer.parseInt(st.nextToken());// 속도
			int d = Integer.parseInt(st.nextToken());// 방향
			
			fireBall newFireBall = new fireBall(x,y,m,s,d);
			fireBallList.add(newFireBall); //파이어볼 리스트에 넣기
		}
		
		for(int i=0;i<K;i++) //K번만큼 move, fire실행
		{
			move();
			fire();
		}
		
		int result=0;
		for(int i=0;i<fireBallList.size();i++)
			result += fireBallList.get(i).m;
		System.out.println(result);
	}
	private static void fire() {
		//map을 뒤져가면서 파이어볼이 2개이상인것은 합쳐서 나누고, 1개만 있는거는 그대로 유지해야함.
		ArrayList<fireBall> list = new ArrayList<>(); //파이어볼 새로 갱신하기 위한 list
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int size = map[i][j].size();
				if(size == 0) //파이어볼이 없을 땐 건너뛰기
					continue;
				if(size == 1) //한개 밖에 없을 땐 그대로 유지해야 하므로 list에 넣어주기
					list.add(map[i][j].get(0));
				else //2개 이상일 때
				{
					boolean even = false;
					boolean odd = false;
					
					int m = 0;
					int s = 0;
					int dir = 0; //dir == 0이면 모두 짝수, 홀수 0246 / dir == 1 이면 1357
					for(int k=0;k<size;k++)
					{
						m += map[i][j].get(k).m; //질량 더해주기
						s += map[i][j].get(k).s;
						
						if(k==0)
						{
							if(map[i][j].get(k).d % 2 == 0) //처음 체크한 파이어볼의 방향이 짝수
								even = true;
							else
								odd = true;
						}
						else if(dir == 0)
						{
							if(map[i][j].get(k).d % 2 == 0) //파이어볼의 방향이 짝수
							{
								if(even) // 처음 짝수 였으면
									dir = 0;
								else //처음이 홀수 였으면
									dir = 1;
							}
							else //파이어볼의 방향이 홀수
							{
								if(even) //처음 짝수 였으면
									dir = 1;
								else // 처음 홀수 였으면
									dir = 0;
							}
						}
					}
					
					if(m/5 == 0) //0이면 넣지 않고 걍 버림
						continue; 
					if(dir == 0)
						for(int k=0;k<8;k+=2)
							list.add(new fireBall(i,j,m/5,s/size,k)); //0,2,4,6 방향으로 질량/5, 속도/개수 파이어볼 넣기
					else
						for(int k=1;k<8;k+=2)
							list.add(new fireBall(i,j,m/5,s/size,k)); //1,3,5,7 방향으로 질량/5, 속도/개수 파이어볼 넣기
				}
			}
		}
		fireBallList = list; //새로운 파이어볼 리스트로 갱신
	}
	private static void move() {
		//기존에 있던 파이어볼들 다 삭제하고 fireBallList에서 파이어볼 움직인후 다시 넣기
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j].clear(); //기존 파이어볼 다 삭제
		
		for(int i=0;i<fireBallList.size();i++)
		{
			fireBall temp = fireBallList.get(i);
			
			int nx = temp.x + dx[temp.d] * (temp.s % N); //어차피 한계 칸 넘어가면 돌아오기 때문에 N으로 나눈 나머지칸만 진행한다고 생각해도 무방.
			int ny = temp.y + dy[temp.d] * (temp.s % N);
			
			if(nx > N-1) //x축 벗어나면 N만큼 빼주면 돌아오는것임
				nx -= N;
			if(nx < 0) //음수가 됐을 땐 가장 끝으로 가야하므로 N만큼 더해주기
				nx += N;
			if(ny > N-1)
				ny -= N;
			if(ny < 0)
				ny += N;
			
			map[nx][ny].add(new fireBall(nx,ny,temp.m,temp.s,temp.d)); //지도에 움직인 파이어볼 넣기.
			fireBallList.get(i).x = nx; //파이어볼 위치 바꿔주기
			fireBallList.get(i).y = ny;
		}
	}

}
