import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLClientInfoException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12100 {
	static int N, map[][], max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int direction[] = {0,1,2,3}; //상하좌우
		permutation(0, new int[5]); // 모든 순열에 대해 움직이기
		System.out.println(max);
	}

	static void permutation(int cnt, int sequence[])
	{
		if(cnt==5)
		{
			//System.out.println(Arrays.toString(sequence));
			int copy_map[][] = new int[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					copy_map[i][j] = map[i][j];
			move(sequence, copy_map);
			return;
		}
		
		for(int i=0;i<4;i++)
		{
			sequence[cnt]=i;
			permutation(cnt+1,sequence);
		}
	}
	
	static void move(int sequence[], int map[][])
	{
		for(int i=0;i<N;i++)
		{
			if(sequence[0]==3)
				if(sequence[1]==1)
					if(sequence[2]==1)
						if(sequence[3]==0)
							if(sequence[4]==3)
									System.out.println();
			int direction = sequence[i];
			switch(direction)
			{
				case 0:
					map = moveUp(map);
					break;
				case 1:
					map = moveDown(map);
					break;
				case 2:
					map = moveLeft(map);
					break;
				case 3:
					map = moveRight(map);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				if(map[i][j]>=max)
					max = map[i][j];
		}
	}
	
	static int[][] moveRight(int map[][])
	{
		for(int i=0;i<N;i++)
		{
			int cnt=0; // 옆으로 몇개 밀건지
			for(int j=N-1;j>0;j--)
			{
				if(map[i][j]==map[i][j-1] && map[i][j]!=0)
				{
					int temp = map[i][j];
					map[i][j]=0;
					map[i][j-1]=0;
					map[i][N-cnt-1]=temp*2;
					cnt++;
				}
			}
			for(int j=0;j<N-cnt;j++)
			{
				if(map[i][j]!=0)
				{
					int temp = map[i][j];
					map[i][N-cnt-1-j]=temp;
					map[i][j]=0;
				}
			}
		}
		return map;
	}
	static int[][] moveLeft(int map[][])
	{
		for(int i=0;i<N;i++)
		{
			int cnt=0;
			for(int j=0;j<N-1;j++)
			{
				if(map[i][j]==map[i][j+1])
				{
					int temp=map[i][j];
					map[i][j]=0;
					map[i][j+1]=0;
					map[i][0+cnt]=temp*2;
					cnt++;
				}
			}
		}
		return map;
	}
	static int[][] moveUp(int map[][])
	{
		for(int i=0;i<N;i++)
		{
			int cnt=0;
			for(int j=N-1;j>0;j--)
			{
				if(map[j][i]==map[j-1][i])
				{
					int temp = map[j][i];
					map[j][i]=0;
					map[j-1][i]=0;
					map[N-1-cnt][i] = temp*2;
					cnt++;
				}
			}
		}
		return map;
	}
	static int[][] moveDown(int map[][])
	{
		for(int i=0;i<N;i++)
		{
			int cnt=0;
			for(int j=0;j<N-1;j++)
			{
				if(map[j][i]==map[j+1][i])
				{
					int temp = map[j][i];
					map[j][i]=0;
					map[j+1][i]=0;
					map[j+cnt][i]=temp*2;
					cnt++;
				}
			}
		}
		return map;
	}
}
