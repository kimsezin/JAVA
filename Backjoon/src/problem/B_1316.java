package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result=0;
		for(int i=0;i<N;i++)
		{
			String input = br.readLine(); //입력값 받기
			boolean visited[] = new boolean['z'-'a'+1]; //알파벳 개수만큼 배열생성
			boolean check=false;
			
			for(int j=0;j<input.length();j++)
			{
				char idx = input.charAt(j);
				if(visited[idx-'a']==true) //이미 들렸다면 (그룹에 속하지 못함)
				{
					check=true; //체크하기
					break;
				}
				else
					visited[idx-'a']=true;
				
				while(true)
				{
					if(j+1 < input.length() && idx == input.charAt(j+1)) //다음 알파벳부터 그룹에 속하는지 체크하고 건너뛰기
						j++;
					else //그룹해제
						break; 
				}
			}
			if(check==false) //그룹에 속하지 않은 알파벳이 없는경우
				result++;
		}
		System.out.println(result);
	}

}
