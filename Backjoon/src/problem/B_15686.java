package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15686 {
	static class chicken
	{
		int x,y;

		public chicken(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}
	static int N, M, result=Integer.MAX_VALUE;
	static int map[][];
	static chicken[] selectChicken;
	static ArrayList<chicken> Home;
	static int dx[] = new int[] {-1,1,0,0};
	static int dy[] = new int[] {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selectChicken = new chicken[M];
		map = new int[N][N];
		Home = new ArrayList<>();
		ArrayList<chicken> chickens = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				if(temp==2)
					chickens.add(new chicken(i,j));
				else if(temp==1)
				{
					map[i][j]=temp;
					Home.add(new chicken(i,j));
				}
			}
		}
		
		permutation(chickens,0,0);
		System.out.println(result);
	}

	static void permutation(ArrayList<chicken> chickens, int cnt, int start)
	{
		if(cnt == M)
		{
			result = Math.min(result, find_Mindistance());
			copy();
			return;
		}
		
		for(int i=start;i<chickens.size();i++)
		{
			selectChicken[cnt] = chickens.get(i);
			permutation(chickens,cnt+1,i+1);
		}
	}
	
	static int find_Mindistance()
	{
		for(int n=0;n<M;n++)
			map[selectChicken[n].x][selectChicken[n].y]=2;
		int sum=0;
		
		for(int i=0;i<Home.size();i++)
		{
			int distance=Integer.MAX_VALUE;
			int x=Home.get(i).x;
			int y=Home.get(i).y;
			
			for(int j=0;j<M;j++)
			{
				int ch_x = selectChicken[j].x;
				int ch_y = selectChicken[j].y;
				
				if(distance > Math.abs(x-ch_x)+Math.abs(y-ch_y))
					distance = Math.abs(x-ch_x)+Math.abs(y-ch_y);
			}	
			sum+=distance;
		}
		return sum;
	}
	
	static void copy()
	{
		for(int i=0;i<M;i++)
			map[selectChicken[i].x][selectChicken[i].y]=0;
	}
}
