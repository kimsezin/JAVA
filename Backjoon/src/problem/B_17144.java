package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17144 {
	static int R,C,T;
	static int map[][], copy_map[][];
	static int dx[]= {-1,1,0,0}, dy[]= {0,0,-1,1};
	static int bottomX, bottomY;
	
	static int mvtopX[] = {0,-1,0,1}, mvtopY[] = {1,0,-1,0};
	static int mvbottomX[] = {0,1,0,-1}, mvbottomY[]= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		copy_map = new int[R][C];
		for(int i=0;i<R;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++)
			{
				copy_map[i][j] = Integer.parseInt(st.nextToken());
				if(copy_map[i][j]==-1)
				{
					bottomX = i;
					bottomY = j;
				}
			}
		}
		
		for(int i=0;i<T;i++)
		{
			spread();
			clean();
			copy_map[bottomX][bottomY]=-1;
			copy_map[bottomX-1][bottomY]=-1;
			map[bottomX][bottomY]=-1;
			map[bottomX-1][bottomY]=-1;
		}
		int result=0;
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(copy_map[i][j]>0)
					result+=copy_map[i][j];
			}
		}
		System.out.println(result);
	}
	
	static void spread()
	{
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(copy_map[i][j]>0)
				{
					int cnt=0;
					for(int k=0;k<4;k++)
					{
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx >= 0 && ny >= 0 && nx < R && ny < C && !(nx==bottomX-1 && ny==bottomY) && !(nx==bottomX && ny==bottomY))
						{
							cnt++;
							map[nx][ny] += copy_map[i][j]/5;
						}
					}
					map[i][j] += copy_map[i][j]-(copy_map[i][j]/5)*cnt;
				}
			}
		}
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				copy_map[i][j] = map[i][j];
	}
	static void clean()
	{
		int topX = bottomX-1;
		int topY = bottomY;
		int x=topX, y=topY+1, idx=0;
		map[x][y]=0;
		while(true)
		{
			int nx = x+mvtopX[idx];
			int ny = y+mvtopY[idx];
			if(nx < 0)
			{
				nx+=1;
				idx++;
				ny-=1;
			}
			else if(ny < 0)
			{
				ny+=1;
				idx++;
				nx+=1;
			}
			else if(ny==C)
			{
				ny-=1;
				idx++;
				nx-=1;
			}
			if(nx == topX && ny==topY)
			{
				map[x][y]=0;
				break;
			}
			map[nx][ny] = copy_map[x][y];
			x=nx; y=ny;
		}
		
		x = bottomX;
		y = bottomY+1;
		map[x][y]=0;
		idx=0;
		while(true)
		{
			int nx = x+mvbottomX[idx];
			int ny = y+mvbottomY[idx];
			if(nx == R)
			{
				nx-=1;
				idx++;
				ny-=1;
			}
			else if(ny == C)
			{
				ny-=1;
				idx++;
				nx+=1;
			}
			else if(ny<0)
			{
				ny+=1;
				idx++;
				nx-=1;
			}
			if(nx == bottomX && ny==bottomY)
			{
				map[x][y]=0;
				break;
			}
			map[nx][ny] = copy_map[x][y];
			x=nx; y=ny;
		}
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				copy_map[i][j] = map[i][j];
		for(int i=0;i<R;i++)
			Arrays.fill(map[i], 0);
	}

}
