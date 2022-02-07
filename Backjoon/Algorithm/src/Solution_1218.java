import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		for(int test_case=1;test_case<=10;test_case++)
		{
			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();
			Stack<Character> stack3 = new Stack<Character>();
			Stack<Character> stack4 = new Stack<Character>();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			boolean check=false;
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i) == '(')
					stack1.push('(');
				else if(input.charAt(i) == ')')
				{
					if(stack1.empty())
					{
						System.out.println("#"+test_case + " "+0);
						check=true;
						break;
					}
					else
					stack1.pop();
				}
				else if(input.charAt(i) == '[')
					stack2.push('[');
				else if(input.charAt(i) == ']')
				{
					if(stack2.empty())
					{
						System.out.println("#"+test_case + " "+0);
						check=true;
						break;
					}
					else
					stack2.pop();
				}
				
				else if(input.charAt(i) == '{')
					stack3.push('{');
				else if(input.charAt(i) == '}')
				{
					if(stack3.empty())
					{
						System.out.println("#"+test_case + " "+0);
						check=true;
						break;
					}
					else
					stack3.pop();
				}
				
				else if(input.charAt(i) == '<')
					stack4.push('<');
				else if(input.charAt(i) == '>')
				{
					if(stack4.empty())
					{
						System.out.println("#"+test_case + " "+0);
						check=true;
						break;
					}
					else
					stack4.pop();
				}
			}
			
			if(stack1.empty() && stack2.empty() && stack3.empty() && stack4.empty())
				System.out.println("#"+test_case + " "+1);
			else
				if(check==false)
					System.out.println("#"+test_case + " "+0);
				

		}

	}

}
