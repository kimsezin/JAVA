package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int weights[] = new int[101]; // 무게
		int profits[] = new int[100001]; // 가치
		
		int result[][] = new int[N+1][K+1];
		int itemWeight = 0, itemBenefit=0;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++)
		{
			itemWeight = weights[i];
			itemBenefit = profits[i];
			
			for(int weight = 1; weight<=K; weight++)
			{
				if(itemWeight <= weight)
					result[i][weight] = Math.max(result[i-1][weight], itemBenefit+result[i-1][weight-itemWeight]);
				else
					result[i][weight] = result[i-1][weight];
			}
		}
		System.out.println(result[N][K]);
		
		
		
	}

}
