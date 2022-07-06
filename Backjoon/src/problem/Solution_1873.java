package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1873 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int H,W;
	static char map[][] = new char[20][20];
	static void shoot(int x, int y, int H, int W, int direction)
	{
		int nx=x+dx[direction];
		int ny=y+dy[direction];
		if(nx >= 0 && ny >= 0 && nx < H && ny < W)
		{
			if(map[nx][ny]=='*')
			{
				map[nx][ny]='.';
				return;
			}
			else if(map[nx][ny]=='#')
			{
				return;
			}
			shoot(nx, ny,H,W, direction);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T =Integer.parseInt(br.readLine());
		
		for(int test_case = 1;test_case<=T;test_case++)
		{
			String size[] = br.readLine().split(" ");
			int H = Integer.parseInt(size[0]);
			int W = Integer.parseInt(size[1]);
					
			int tank_x=0;
			int tank_y=0;
			
			int direction=0;
			for(int i=0;i<H;i++)
			{
				String temp = br.readLine();
				for(int j=0;j<W;j++)
				{
					map[i][j] = temp.charAt(j);
					if(map[i][j]=='<' || map[i][j]=='>' || map[i][j]=='^' || map[i][j]=='v')
					{
						tank_x=i;
						tank_y=j;
						switch(map[i][j])
						{
						case '^' : direction = 0; break;
						case 'v' : direction = 1; break;
						case '<' : direction = 2; break;
						case '>' : direction = 3; break;
						}
					}
				}
			}
			
			int cnt = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i)=='U')
				{
					map[tank_x][tank_y] = '^';
					if (tank_x - 1 >= 0)
					{
						if (map[tank_x - 1][tank_y] == '.')
						{
							tank_x -= 1;
							map[tank_x][tank_y] = '^';
							map[tank_x+1][tank_y] = '.';
						}
					}
					direction=0;
				}
				else if(input.charAt(i)=='D')
				{
					map[tank_x][tank_y] = 'v';
					if (tank_x +1 < H)
					{
						if (map[tank_x+1][tank_y] == '.')
						{
							tank_x += 1;
							map[tank_x][tank_y] = 'v';
							map[tank_x - 1][tank_y] = '.';
						}
					}
					direction=1;
				}
				else if(input.charAt(i)=='L')
				{
					map[tank_x][tank_y] = '<';
					if (tank_y - 1 >= 0)
					{
						if (map[tank_x][tank_y-1] == '.')
						{
							tank_y -= 1;
							map[tank_x][tank_y] = '<';
							map[tank_x][tank_y+1] = '.';
						}
					}
					direction=2;
				}
				else if(input.charAt(i)=='R')
				{
					map[tank_x][tank_y] = '>';
					if (tank_y + 1 < W)
					{
						if (map[tank_x][tank_y+1] == '.')
						{
							tank_y += 1;
							map[tank_x][tank_y] = '>';
							map[tank_x][tank_y-1] = '.';
						}
					}
					direction=3;
				}
				else if(input.charAt(i)=='S')
				{
					shoot(tank_x,tank_y,H,W,direction);
				}
				}
				System.out.print("#"+test_case+" ");
				for(int i=0;i<H;i++)
				{
					for(int j=0;j<W;j++)
					{
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
			}
			
		}

	}
