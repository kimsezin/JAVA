package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//해결필요
public class B_2304 {

	static class top
	{
		int width, height;

		public top(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;		
		int input[] = new int[1001];
		int start = 1001;
		int end = 0;
		int sum=0;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			if(start > width)
				start = width;
			if(end < width)
				end = width;
			input[width] = height;
		}
		int checkLeft=start;
		int checkRight=end;
		while(start<=end)
		{
			if(input[++start] >= input[checkLeft])
			{
				sum+= (start-checkLeft)*input[checkLeft];
				checkLeft = start;
			}
			if(input[--end] > input[checkRight])
			{
				sum+= (checkRight - end) *input[checkRight];
				checkRight=end;
			}
		}
		sum+=input[checkLeft];
		System.out.println(sum);
	}

}
