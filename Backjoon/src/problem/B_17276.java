package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17276 {

	static int N,D, map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			//시계방향
			if(D>=0)
			{
				int cnt = D/45;
				for (int i=0;i<cnt;i++)
					map = rotateRight(map);
			}
			//반시계방향
			else
			{
				int cnt = Math.abs(D)/45;
				for(int i=0;i<cnt;i++)
					map = rotateLeft(map);
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
					System.out.print(map[i][j]+" ");

				System.out.println();
			}
			
		}

	}

	private static int[][] rotateRight(int[][] map2) {
		int temp[][] = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				temp[i][j] = map2[i][j];
		
		for(int i=0;i<N;i++)
			temp[i][N/2] = map2[i][i]; //1번 조건
		
		for(int i=0;i<N;i++)
			temp[i][N-i-1] = map2[i][N/2]; //2번 조건
		
		for(int i=0;i<N;i++)
			temp[N/2][N-i-1] = map2[i][N-i-1]; //3번조건
		
		for(int i=0;i<N;i++)
			temp[i][i] = map2[N/2][i];//4번조건
		
		return temp;
	}

	private static int[][] rotateLeft(int[][] map2) {
		int temp[][] = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				temp[i][j] = map2[i][j];
		
		for(int i=0;i<N;i++)
			temp[N/2][i] = map2[i][i]; //1번조건
		for(int i=0;i<N;i++)
			temp[i][i] = map2[i][N/2]; //2번조건
		for(int i=0;i<N;i++)
			temp[i][N/2] = map2[i][N-i-1];//3번조건
		for(int i=0;i<N;i++)
			temp[N-i-1][i] = map2[N/2][i];//4번조건
		
		return temp;
	}
}
