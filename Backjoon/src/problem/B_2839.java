package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[5001];
		dp[3]=1;
		dp[5]=1;
		
		for(int i=6;i<=N;i++)
		{
			if(dp[i-3]!=0)
				dp[i]=dp[i-3]+1;
			if(dp[i]!=0)
			{
				if(dp[i-5]!=0)
					dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
			}
			else if(dp[i-5]!=0)
				dp[i]=dp[i-5]+1;
		}
		if(dp[N]==0)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}

}
