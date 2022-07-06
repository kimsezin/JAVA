package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=test_case;tc++)
		{
			int result=0;
			String input = br.readLine();
			Stack<Character> s = new Stack<Character>();
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i)=='(')
				{
					if(input.charAt(i+1)==')')
					{
						if(s.size()>0)
							result+=s.size();
					}
					else
					{
						s.push('(');
                        result++;
					}
				}
				else
				{
					if(input.charAt(i-1)=='(')
						continue;
					else
						s.pop();
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
