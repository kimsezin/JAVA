package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_14501 {
	public static class consulting implements Comparable<consulting>
	{
		int day,pay;

		public consulting(int day, int pay) {
			super();
			this.day = day;
			this.pay = pay;
		}
		@Override
		public int compareTo(consulting o) {
			// TODO Auto-generated method stub
			return -(this.pay-o.pay);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		ArrayList<ArrayList<consulting>> result = new ArrayList<>();
		for(int i=0;i<=N;i++)
		{
			result.add(new ArrayList<consulting>());
		}
		
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int after = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(i+after <= N)
			{
				result.get(i+after).add(new consulting(after,value));	
			}
		}
		int sum=0;
		int start = 0;
		for(int i=0;i<=N;i++)
		{
			if(result.get(i).size()!=0)
			{
				Collections.sort(result.get(i));
				for(int j=0;j<result.get(i).size();j++)
				{
					if(start+result.get(i).get(j).day <= i)
					{
						sum+=result.get(i).get(j).pay;
						start = i;
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
