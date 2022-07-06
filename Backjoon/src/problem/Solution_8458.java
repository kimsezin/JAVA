package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			int input[] = new int[N];
			
			int max=0;
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				input[i] =  Math.abs(x)+Math.abs(y);
				max = Math.max(max, input[i]);
			}
			
			boolean isodd =false;
			boolean iseven = false;
			for(int i=0;i<N;i++)
			{
				if(input[i]%2==0)
					iseven = true;
				else
					isodd = true;
			}
			
			if(isodd == true && iseven == true)
			{
				System.out.println("#"+tc+" "+-1);
				continue;
			}
			else
			{
				int sum=0;
				int idx=0;
				while(true)
				{
					sum+=idx;
					
					if(sum>=max && (sum%2) == (max%2))
					{
						System.out.println("#"+tc+ " " + idx);
						break;
					}
					idx++;
				}
			}
			
		}
	}

}
