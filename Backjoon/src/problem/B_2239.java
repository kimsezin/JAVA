package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2239 {
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int map[][];
	static ArrayList<location> list = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for(int i=0;i<9;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<9;j++)
			{
				map[i][j] = temp.charAt(j)-'0';
				if(map[i][j]==0)
					list.add(new location(i,j)); //채워야 할 부분 list에 넣기
			}
		}	
		dfs(0);
	}

	static void dfs(int cnt)
	{
		if(list.size() == cnt) // cnt의 개수가 list와 같으면 모든 0을 바꾼것.
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			System.exit(0);
		}
		
		int x = list.get(cnt).x;
		int y = list.get(cnt).y;
		
		for(int i=1;i<=9;i++)
		{
			if(check(x,y,i)) // 들어갈 수 있는지 확인
			{
				map[x][y] = i;
				dfs(cnt+1);
				map[x][y] = 0;
			}
		}
	}
	
	static boolean check(int x, int y, int value) {
		for(int i=(x/3)*3; i < (x/3)*3+3; i++) // 3x3
		{
			for(int j=(y/3)*3; j < (y/3)*3+3; j++)
			{
				if(map[i][j]==value)
					return false;
			}
		}
		for(int i=0;i<9;i++) //세로
		{
			if(map[x][i]==value)
				return false;
		}
		for(int i=0;i<9;i++) //가로
		{
			if(map[i][y]==value)
				return false;
		}
		return true;
	}
}
