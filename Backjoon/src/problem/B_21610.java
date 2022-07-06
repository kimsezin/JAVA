package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_21610 {
	static int N,M;
	
	static int dx[] = {0,-1,-1,-1,0,1,1,1}, dy[]= {-1,-1,0,1,1,1,0,-1};
	static class basket //바구니에는 물의양과 현재 구름이 있는지 없는지
	{
		int water;
		boolean cloud;
		public basket(int water, boolean cloud) {
			super();
			this.water = water;
			this.cloud = cloud;
		}
	}
	
	static class cloud //구름의 좌표
	{
		int x,y;
		public cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int direction, speed;
	static basket map[][];
	static ArrayList<cloud> cloudList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new basket[N][N];
		
		for(int i=0;i<N;i++) //물, 구름여부 넣기
		{	
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j] = new basket(Integer.parseInt(st.nextToken()),false);
		}		
		
		st = new StringTokenizer(br.readLine(), " ");
		direction = Integer.parseInt(st.nextToken()) - 1; //방향 0~7
		speed = Integer.parseInt(st.nextToken());
		cloudList.add(new cloud(N-1,0)); //왼쪽아래 4칸 구름 초기설정
		cloudList.add(new cloud(N-1,1));
		cloudList.add(new cloud(N-2,0));
		cloudList.add(new cloud(N-2,1));
		
		
		
		for(int i=0;i<M-1;i++) //초기 구름은 설정 했으므로 M-1번 반복하고 마지막에 move, copyRain만 하면 됨
		{
			move();
			copyRain();
			
			st = new StringTokenizer(br.readLine()," ");
			direction = Integer.parseInt(st.nextToken())-1;
			speed = Integer.parseInt(st.nextToken());
		}
		//마지막 명령 수행
		move(); 
		copyRain();
		
		int result = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				result+=map[i][j].water;
		
		System.out.println(result);
	}

	private static void copyRain() {
		for(int i=0;i<cloudList.size();i++)
		{
			cloud temp = cloudList.get(i); //각각의 구름마다
			
			for(int j=1;j<8;j+=2) //대각선에 있는 바구니에 물이 있으면 현재 칸에 물 +1
			{
				int nx = temp.x + dx[j];
				int ny = temp.y + dy[j];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N)
				{
					if(map[nx][ny].water>0)
						map[temp.x][temp.y].water++;
					
				}
			}
		}
		
		int existSize = cloudList.size(); //기존에있던 구름들 삭제하기위해 개수 기록 (기존에 있던 구름은 삭제하고 다시만들어야함)
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				if(map[i][j].water>=2 && map[i][j].cloud==false) //전체 맵 탐색해서 물의양이 2이상이고 구름이 현재 없으면
				{
					map[i][j].water -=2;
					map[i][j].cloud = true;
					cloudList.add(new cloud(i,j));
				}
			}
		
		for(int i=0;i<existSize;i++) //기존에 있던 구름들 삭제
		{
			cloud exist = cloudList.get(0); //젤 앞에거를 기존에 있던 구름만큼 삭제하면 기존에 있던것들 다 삭제됨.
			map[exist.x][exist.y].cloud = false; //기존 바구니에 있던 구름 true들도 false로 바꾸기
			cloudList.remove(exist);// 구름 리스트에서 삭제
		}
	}

	private static void move() {
		ArrayList<cloud> newList = new ArrayList<>(); //새로운 구름 넣어줄 리스트
		
		for(int i=0;i<cloudList.size();i++)
		{
			cloud temp = cloudList.get(i);
			
			int nx = temp.x;
			int ny = temp.y;
			map[nx][ny].cloud = false; //구름 해제
			
			nx += dx[direction] * (speed % N); //구름 이동시키기 칸 넘어가면 초기로 돌아오므로 % N
			ny += dy[direction] * (speed % N);
			
			if(nx < 0)
				nx+=N;
			if(nx > N-1)
				nx-=N;
			if(ny < 0)
				ny+=N;
			if(ny > N-1)
				ny-=N;
			
			
			newList.add(new cloud(nx,ny)); //새로운 구름 리스트에 넣어주기
			map[nx][ny].water++; //물 하나씩 내리기
		}
		for(int i=0;i<newList.size();i++)
		{
			cloud temp = newList.get(i); //구름 리스트에 있는것들 바구니에도 표시해주기
			map[temp.x][temp.y].cloud=true;
		}
		cloudList = newList; //구름리스트 새거로 바꾸기
	}

}
