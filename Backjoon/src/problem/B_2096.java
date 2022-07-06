package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//min, max DP
		int maxDP[] = new int[3];
		int minDP[] = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//초기 첫번째 줄 넣어주기 DP에
		for(int i=0;i<3;i++)
		{
			int input = Integer.parseInt(st.nextToken());
			minDP[i]=input;
			maxDP[i]=input;
		} 
		
		//N-1번 반복
		for(int i=1;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int input[] = new int[3];
			for(int j=0;j<3;j++)
				input[j]=Integer.parseInt(st.nextToken());
			
			maxDP[0] += Math.max(input[0], input[1]); //새로운 input 1,2번쨰 비교
			maxDP[1] += Math.max(input[0], Math.max(input[1],input[2])); //새로운 input 1,2,3 index 비교
			maxDP[2] += Math.max(input[1], input[2]); //새로운 input 2,3번째 비교
			
			minDP[0] += Math.min(input[0], input[1]);
			minDP[1] += Math.min(input[0], Math.min(input[1],input[2]));
			minDP[2] += Math.min(input[1], input[2]);
		}
		
		System.out.println(Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]))+" " +Math.min(minDP[0], Math.min(minDP[1], minDP[2])));

	}

}
