import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[100][100];
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x;j<x+10;j++)
			{
				for(int k = y; k<y+10;k++)
				{
					map[j][k]=1;
				}
			}
		}
		int result=0;
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(map[i][j]==1)
					result++;
			}
		}
		System.out.println(result);
	}

}
