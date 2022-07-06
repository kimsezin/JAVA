package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			int input[][] = new int[2][N];
			for(int i=0;i<2;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					input[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int dp[] = new int[N];
			dp[0] = input[0][0];
			for(int i=1;i<N;i++)
			{
				if(i+1 < N)
				{
					
				}
			}
		}

	}

}
