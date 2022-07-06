package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Softeer_8단변속기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int input[] = new int[8];
		for(int i=0;i<8;i++)
			input[i]=Integer.parseInt(st.nextToken());
		
		int idx=3;
		for(int i=0;i<7;i++)
		{
			if(input[i] < input[i+1])
			{
				if(idx==1)
				{
					System.out.println("mixed");
					return;
				}
				idx =0;
			}
			else if(input[i]>input[i+1])
			{
				if(idx==0)
				{
					System.out.println("mixed");
					return;
				}
				idx=1;
			}
		}
		if(idx==0)
			System.out.println("ascending");
		else if(idx==1)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}

}
