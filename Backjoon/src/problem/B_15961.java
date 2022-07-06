package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken()); //접시 수
		int d = Integer.parseInt(st.nextToken()); //초밥 종류 수
		int k = Integer.parseInt(st.nextToken()); //연속 접시 개수
		int c = Integer.parseInt(st.nextToken()); //쿠폰번호
		
		int input[] = new int[n+1];
		int checked[] = new int[d+1];
		int result=0; int cnt=0;
		
		for(int i=0;i<n;i++)
			input[i] = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++)
		{
			if(checked[input[i]]==0) //처음으로 먹은 초밥일 경우
				cnt++;//종류에 추가
			checked[input[i]]++;
		}
		result = cnt;
		
		for(int i=1;i<n;i++)
		{
			if(result <= cnt)
				if(checked[c]==0)
					result = cnt+1;
				else
					result = cnt;
			
			checked[input[i-1]]--;//제일 앞에 하나 빼주기
			if(checked[input[i-1]]==0)//하나 있던 것이면
				cnt--;
			
			if(checked[input[(i+k-1)%n]]==0) cnt++; // 하나 추가해서 없던거면 종류 늘려주기
			checked[input[(i+k-1)%n]]++;
		}
	
		System.out.println(result);
		
	}

}
