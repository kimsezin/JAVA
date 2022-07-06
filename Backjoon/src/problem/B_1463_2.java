package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1463_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1000001];
		dp[1]=0;
		dp[2]=1;
		for(int i=3;i<=N;i++)
		{
			dp[i]=Integer.MAX_VALUE;
			if(i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2==0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			
			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}
		System.out.println(dp[N]);

	}

}
