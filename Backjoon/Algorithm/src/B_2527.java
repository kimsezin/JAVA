import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2527 {

	public static void main(String[] args) throws IOException {
		int result=1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		for(int i=0; i<N;i++)
		{
			String input = br.readLine();
			for(int j=0;j<M;j++)
				map[i][j] = input.charAt(j)-'0'; 
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				for(int k=i+1;k<N;k++)
				{
					if(map[i][j] == map[k][j])
					{
						if(j+k-i < M)
						{
							if(map[i][j] == map[i][j+k-i])
								if(map[i][j]==map[k][j+k-i])
									if(result < (k-i+1)*(k-i+1))
										result= (k-i+1)*(k-i+1);
						}
					}
				}
			}
		}
		System.out.println(result);
	}

}
