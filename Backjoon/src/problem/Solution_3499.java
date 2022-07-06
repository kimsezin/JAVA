package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3499 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int test_case =1;test_case<=t;test_case++)
		{
			int N;
			
			int idx_1=0;
			int idx_2=0;
			N=Integer.parseInt(br.readLine());
			List<String> deq1 = new ArrayList<String>();
			List<String> deq2 = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++)
					deq1.add(st.nextToken());
			if(N%2==1)
			{
					deq1.add(st.nextToken());
				for(int i=N/2;i<N-1;i++)
					deq2.add(st.nextToken());
			}
			else
			{
				for(int i=N/2;i<N;i++)
					deq2.add(st.nextToken());
			}
			
			System.out.print("#"+test_case + " ");
			int idx=0;
			while(idx < N/2)
			{
				System.out.print(deq1.get(idx)+" ");
				System.out.print(deq2.get(idx)+" ");
				idx++;
			}
			if(N%2==1)
				System.out.print(deq1.get(idx));
			System.out.println();
				
		}

	}

}
