import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][3];
		
		int result = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			dp[i][0]= Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());
			dp[i][1]= Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());
			dp[i][2]= Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());
			
			result = Math.min(dp[i][2], Math.min(dp[i][0], dp[i][1]));
		}
		System.out.println(result);
		
		

	}

}
