import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2578 {
	static int[][] map,map2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];
		for(int i=0;i<5;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for(int i=0;i<5;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++)
			{
				cnt++;
				change(Integer.parseInt(st.nextToken()));
				if(check())
				{
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	static void change(int temp)
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(map[i][j]==temp)
				{
					map[i][j]=0;
					return;
				}
	}
	static boolean check()
	{
		int check=0;
		for(int i=0;i<5;i++)
		{
			int sum=0;
			for(int j=0;j<5;j++)
				sum+=map[i][j];
			if(sum==0)
			{
				check++;
				if(check==3)
					return true;
			}
			sum=0;
			for(int j=0;j<5;j++)
				sum+=map[j][i];
			if(sum==0)
			{
				check++;
				if(check==3)
					return true;
			}
		}
		int sum=0;
		for(int i=0;i<5;i++)
			sum+=map[i][i];
		if(sum==0)
		{
			check++;
			if(check==3)
				return true;
		}
		sum=0;
		for(int i=0;i<5;i++)
			sum+=map[i][4-i];
		if(sum==0)
		{
			check++;
			if(check==3)
				return true;
		}
		
		return false;
		
	}
}
