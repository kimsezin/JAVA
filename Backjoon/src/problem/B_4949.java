package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String temp = br.readLine();
			if(temp.equals("."))
				break;
			Stack<Character> s = new Stack<Character>();
			boolean check=false;
			for(int i=0;i<temp.length();i++)
			{
				if(temp.charAt(i)=='(')
					s.push('(');
				else if(temp.charAt(i)==')')
				{
					if(s.empty() || s.peek()!='(')
					{
						System.out.println("no");
						check=true;
						break;
					}
					else
						s.pop();
				}
				else if(temp.charAt(i)=='[')
					s.push('[');
				else if(temp.charAt(i)==']')
				{
					if(s.empty() || s.peek()!='[')
					{
						System.out.println("no");
						check=true;
						break;
					}
					else
						s.pop();
				}
			}
			if(check==false)
			{
				if(s.empty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}
