import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_17281 {
	static int inning, order[], hitter[][];
	static boolean visited[];
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		inning = Integer.parseInt(br.readLine());
		visited = new boolean[9];
		order = new int[9]; //타순
		hitter=new int[inning][9]; //이닝 당 타자들 기록
		
		for(int i=0;i<inning;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++)
				hitter[i][j]=Integer.parseInt(st.nextToken());
		}
		
		//1번 선수가 4번타자 고정이므로 
		
		visited[0]=true;
		order[3]=0;
		permutation(1);
		
		System.out.println(result);
		System.out.println(Count);
	}
	
	static void play()
	{
		int out=0;
		int score=0;
		int idx=0;
		int base[] = new int[3];
		for(int i=0;i<inning;i++)
		{
			out=0;
			base = new int[3];
			while(out!=3)
			{
				idx%=9;
				int hit = hitter[i][order[idx]];
				
				switch(hit) {
				case 0:
					out++;
					break;
				case 4:
					score+=base[0]+base[1]+base[2]+1;
					base[0]=0;base[1]=0;base[2]=0;
					break;
				case 3:
					score+=base[2]+base[1]+base[0];
					base[2]=1;base[1]=0;base[0]=0;
					break;
				case 2: 
					score+=base[2]+base[1];
					base[2]=base[0];base[1]=1;base[0]=0;
					break;
				case 1: 
					score+=base[2];
					base[2]=base[1];base[1]=base[0];base[0]=1;
					break;
				}
				idx++;
			}
		}
		if(result < score)
			result=score;
	}
	static int Count=0;
	static void permutation(int cnt)
	{
		if(cnt==3)
			permutation(cnt+1);
		
		if(cnt==9)
		{
//			for(int i=0;i<9;i++)
//				System.out.print(order[i]);
//			System.out.println();
			Count++;
			play();
			return;
		}
		for(int i=1;i<9;i++)
		{		
			if(visited[i]==false)
			{
				visited[i] = true;
				order[cnt]=i;
				permutation(cnt+1);
				visited[i]=false;
			}
		}
	}

	
}
