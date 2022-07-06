package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17143 {
	static int dx[]= {0,-1,1,0,0}, dy[] = {0,0,0,1,-1};
	static int X,Y;
	static int result=0;
	static class location
	{
		int speed;
		int direction;
		int size;
		public location(int speed, int direction, int size) {
			super();
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}
	
	static location map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M==0) //No shark
		{
			System.out.println(0);
			return;
		}
		
		
		map = new location[X][Y];
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int speed  = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			map[x][y] = new location(speed, direction, size);
		}
		
		
		for(int y=0;y<Y;y++)
		{
			catchShark(y); //가장 가까운 상어 잡기
			moveShark();
		}
		System.out.println(result);
		
	}
	private static void moveShark() {
		location new_map[][] = new location[X][Y];
		location copy_map[][] = new location[X][Y];
		copy_map = copy2();
		for(int x=0;x<X;x++)
		{
			for(int y=0;y<Y;y++)
			{
				if(map[x][y]!=null)
				{
					location temp = map[x][y];
					int sharkX = x;
					int sharkY = y;
					int speed = temp.speed;
					int direction = temp.direction;
					int size = temp.size;
					int nx=sharkX, ny=sharkY;
					for(int i=0;i<speed;i++)
					{
						nx = sharkX+dx[direction];
						ny = sharkY+dy[direction];
						if(nx>=0 && ny >= 0 && nx < X && ny < Y)
						{
							sharkX = nx;
							sharkY = ny;
						}
						else
						{
							nx-=dx[direction];
							ny-=dy[direction];
							if(direction==1)
								direction=2;
							else if(direction==2)
								direction=1;
							else if(direction==3)
								direction=4;
							else direction=3;
							nx+=dx[direction];
							ny+=dy[direction];
							sharkX = nx;
							sharkY = ny;
						}
					}
					if(new_map[nx][ny]==null)
						new_map[nx][ny] = new location(speed,direction,size);
					else
						if(new_map[nx][ny].size < size)
							new_map[nx][ny] = new location(speed,direction,size);
				}
			}
		}
		copy(new_map);
	}
	private static location[][] copy2() {
		location copy_map[][] = new location[X][Y];
		for(int i=0;i<X;i++)
			for(int j=0;j<Y;j++)
				copy_map[i][j] = map[i][j];
		
		return copy_map;
		
	}
	private static void catchShark(int y) {
			for(int x=0;x<X;x++)
				if(map[x][y]!=null)
				{
					result+=map[x][y].size;
					map[x][y]=null;
					return;
				}
	}
	private static void copy(location[][] copy_map) {
		for(int i=0;i<X;i++)
			for(int j=0;j<Y;j++)
				map[i][j] = copy_map[i][j];
	}

	
}
