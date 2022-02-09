import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2309 {
		static int height[];
		static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		height = new int[9];
		result = new int[7];
		for(int i=0;i<9;i++)
		{
			height[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(height);
		dfs(0,0);
	}
	
	public static void dfs(int height_t, int cnt)
	{
		if(cnt==7)
		{
			if(height_t==100)
			{
				for(int i=0;i<7;i++)
					System.out.println(result[i]);
				System.exit(0);
			}
			return;
		}
		
		for(int i=cnt;i<9;i++)
		{
			result[cnt]=height[i];
			dfs(height_t+height[i], cnt+1);
			result[cnt]=0;
		}
	}

}
