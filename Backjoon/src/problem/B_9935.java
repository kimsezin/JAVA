package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String C4 = br.readLine();
		
		char result[] = new char[input.length()];
		int idx=0;
		for(int i=0;i<input.length();i++)
		{
			char temp = input.charAt(i);
			//C4문자열의 젤 끝이 input과 같을 때
			if(C4.charAt(C4.length()-1)==temp)
			{
				if(idx < C4.length()-1)//C4문자열 보다 현재 쌓아올린 문자개수가 작은경우 어차피 폭발안함
					result[idx++]=temp;
				else //길이가 폭발문자열보다 길 떄
				{
					boolean check = true;
					int back_idx = idx-1;
					for(int j = C4.length()-2; j>=0; j--)
					{
						if(result[back_idx]!=C4.charAt(j)) //폭발 문자열하고 다르면 폭발 X
						{
							check=false;
							
							break;
						}
						back_idx--;
					}
					
					if(check) //다 같을 떄
						idx -= C4.length()-1; //폭발한 문자열 길이만큼 idx 뺴서 다시 넣어주기
					else
						result[idx++]=temp; //문자열 넣어주기
				}
			}
			else
				result[idx++]=temp; //문자열 넣어주기
		}
		
		if(idx==0) // 다폭발해서 없을경우
			System.out.println("FRULA");
		else
			for(int i=0;i<idx;i++)
				System.out.print(result[i]);
//		while(true)
//		{
//			if(input.contains(C4))
//				input = input.replace(C4, "");
//			else
//				break;
//		}
//		
//		if(input.equals(""))
//			System.out.println("FRULA");
//		else
//			System.out.println(input);
		
//		ArrayList<Character> target = new ArrayList<>();
//		for(int i=0;i<input.length();i++)
//		{
//			target.add(input.charAt(i));
//			if(target.size() >= C4.length())
//			{
//				boolean check = false;
//				for(int j=0;j<C4.length();j++)
//				{
//					if(target.get(target.size()-C4.length()+j) != C4.charAt(j))
//					{
//						check=true;
//						break;
//					}
//				}
//				if(check==false)
//				{
//					for(int j=0;j<C4.length();j++)
//						target.remove(target.size()-1);
//					
//				}
//			}
//		}
//		
//		if(target.size()==0)
//			System.out.println("FRULA");
//		else
//		{
//			for(int i=0;i<target.size();i++)
//				System.out.print(target.get(i));
//		}
//		
	}

}
