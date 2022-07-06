package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808 {

	static int win_result=0;
	static int inyeong_cards[];
	static int kyuyeong_cards[];
	static int total = 362880;
	static boolean visited[];
	static int check=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			win_result=0;
			visited = new boolean[9];
			inyeong_cards = new int[9];
			kyuyeong_cards = new int[9];
			
			st=new StringTokenizer(br.readLine()," ");
			int cards[] = new int[18];
			for(int i=0;i<9;i++)
			{
				kyuyeong_cards[i]=Integer.parseInt(st.nextToken());
				cards[kyuyeong_cards[i]-1]=1;
			}
		
			int idx=0;
			for(int i=0;i<18;i++)
			{
				if(cards[i]==0)
				{
					inyeong_cards[idx]=i+1;
					idx++;
				}
			}
			int temp_card[] = new int[9];
			dfs(0,temp_card);
			System.out.println("#"+tc+ " "+win_result+" "+(total-win_result));
		}
	}
	
	static void dfs(int cnt, int cards[])
	{
		if(cnt==9)
		{
//			if(cards[0]==18 && cards[1]==2 && cards[2]==4 && cards[3]==6 && cards[4]==8 && cards[5]==10 && cards[6]==12)
//			{
//				for(int i=0;i<9;i++)
//				{
//					System.out.print(cards[i]+" ");
//				}
//				System.out.println();
//			}
			int K_sum=0;
			int Y_sum=0;
			for(int i=0;i<9;i++)
			{
				if(kyuyeong_cards[i] > cards[i])
					K_sum+=(kyuyeong_cards[i]+cards[i]);
				else
					Y_sum+=(kyuyeong_cards[i]+cards[i]);
			}
			if(K_sum > Y_sum)
				win_result++;
			return;
		}
		
		for(int i=8;i>=0;i--)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				cards[cnt]=inyeong_cards[i];
				dfs(cnt+1,cards);
				visited[i]=false;
			}
		}
	}

}
