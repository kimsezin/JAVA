

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class B_2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		int N=Integer.parseInt(temp[0]);
		int target = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		int cards[] = new int[temp.length];
		
		for(int i=0;i<temp.length;i++)
		{
			cards[i] = Integer.parseInt(temp[i]);
		}
		
		int gap = 300001;
		int max_value=0;
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				for(int k=j+1;k<N;k++)
				{
					int t=cards[i]+cards[j]+cards[k];
					if(target - t >= 0)
					{
						if(gap > target-t)
						{
							gap = target-t;
							max_value = t;
						}
					}
				}
			}
		}
		System.out.println(max_value);
		
	}

}
