

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		for(int i=1;i<target;i++)
		{
			int temp= i;
			int sum=i;
			while(temp>0)
			{
				sum = sum+temp%10;
				temp/=10;
			}
			if(sum== target)
			{
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
		

	}

}
