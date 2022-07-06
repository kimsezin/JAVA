package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine(); //input
		String target = br.readLine(); //찾아야될 문자열
		int cnt=0;
		for(int i=0;i<input.length();i++)
		{
			if(input.length() >= i+target.length() && input.substring(i, i+target.length()).equals(target))
			//타겟의 개수보다 탐색할 수 있는 input의 길이 짧지 않으며 탐색 할 수 있는 input에서 아직 탐색하지 않은 index부터 target의 길이만큼 substring해 비교하기
			{
				cnt++;
				i+= target.length()-1;
			}
		}
		System.out.println(cnt);
	}

}
