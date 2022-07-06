package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16935 {

	static int map[][];
	static int N,M,R;
	static boolean check=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken()); 
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<R;i++)
		{
			switch(st.nextToken())
			{
				case "1":
					operator_1();
					break;
				case "2":
					operator_2();
					break;
				case "3":
					operator_3();
					break;
				case "4":
					operator_4();
					break;
				case "5":
					operator_5();
					break;
				case "6":
					operator_6();
					break;
			}
		}
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void operator_1()
	{
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<M;j++)
			{
				int temp = map[i][j];
				map[i][j] = map[N-1-i][j];
				map[N-1-i][j] = temp;
			}
		}
	}
	static void operator_2()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				int temp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = temp;
			}
		}
	}
	static void operator_3()
	{
		int map_rotate[][] = new int[M][N];
		int temp=0;
		for(int i=N-1;i>=0;i--)
		{
			for(int j=0;j<M;j++)
			{
				map_rotate[j][i] = map[temp][j];
			}
			temp++;
		}
		map=map_rotate;
		temp=N;
		N=M;
		M=temp;
	}
	static void operator_4()
	{
		int map_rotate[][] = new int [M][N];
		int temp=M-1;
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				map_rotate[i][j] = map[j][temp];
			}
			temp--;
		}
		map=map_rotate;
		temp=N;
		N=M;
		M=temp;
	}
	static void operator_5()
	{
		int temp_map[][] = new int[N/2][M/2];
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				temp_map[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<N/2;i++)
		{
			for(int j=M/2;j<M;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i][j-M/2];
				temp_map[i][j-M/2]=temp;
			}
		}

		for(int i=N/2;i<N;i++)
		{
			for(int j=M/2;j<M;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i-N/2][j-M/2];
				temp_map[i-N/2][j-M/2]=temp;
			}
		}
		
		for(int i=N/2;i<N;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i-N/2][j];
				temp_map[i-N/2][j]=temp;
			}
		}
		
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				map[i][j]=temp_map[i][j];
			}
		}
	}
	static void operator_6()
	{
		int temp_map[][] = new int[N/2][M/2];
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				temp_map[i][j]=map[i][j];
			}
		}
		
		for(int i=N/2;i<N;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i-N/2][j];
				temp_map[i-N/2][j]=temp;
			}
		}
		
		for(int i=N/2;i<N;i++)
		{
			for(int j=M/2;j<M;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i-N/2][j-M/2];
				temp_map[i-N/2][j-M/2]=temp;
			}
		}
			
		for(int i=0;i<N/2;i++)
		{
			for(int j=M/2;j<M;j++)
			{
				int temp = map[i][j];
				map[i][j] = temp_map[i][j-M/2];
				temp_map[i][j-M/2]=temp;
			}
		}
		
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<M/2;j++)
			{
				map[i][j]=temp_map[i][j];
			}
		}
		
	}
}
