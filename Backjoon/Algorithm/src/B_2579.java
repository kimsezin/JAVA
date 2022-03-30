import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		for(int i=0;i<N;i++)
			input[i]=Integer.parseInt(br.readLine());
		
		int dp[] = new int[N];
		if(N==1)
			System.out.println(input[0]);
		else if(N==2)
			System.out.println(input[0]+input[1]);
		else
		{
			dp[0]=input[0];
			dp[1]=dp[0]+input[1];
			dp[2]=Math.max(input[0],input[1]) + input[2];
			
			for(int i=3;i<N;i++)
			{
				int case1 = dp[i-2]+input[i];
				int case2 = dp[i-3]+input[i-1]+input[i];
				
				dp[i]=Math.max(case1, case2);
			}
			System.out.println(dp[N-1]);
		}
		

	}

}
