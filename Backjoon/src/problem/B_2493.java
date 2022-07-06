package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Stack<int[]> stack = new Stack<>();
		int result[] = new int[N];
		
 		for(int i=1;i<=N;i++)
		{
			int input = Integer.parseInt(st.nextToken());
			while(!stack.empty())
			{
				if(stack.peek()[1] > input)
				{
					System.out.print(stack.peek()[0]+" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.empty())
				System.out.print(0+" ");
			stack.push(new int[] {i,input});
		}
		
		

	}

}
