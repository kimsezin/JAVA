import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2961 {
	static int N,sour[],bitter[];
	static boolean visited[]; 
	static int result=1000000001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			sour[i]=Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(result);
	}
	
	static void dfs(int cnt)
	{
		if(cnt==N)
		{
			int temp_sour = 1;
			int temp_bitter=0;
			for(int i=0;i<N;i++)
			{
				if(visited[i]==true)
				{
					temp_sour *= sour[i];
					temp_bitter += bitter[i];
				}
				if(temp_sour!=1 && temp_bitter!=0)
					if(Math.abs(temp_sour-temp_bitter) < result)
						result = Math.abs(temp_sour-temp_bitter);
			}
			return;
		}
		
		visited[cnt]=true;
		dfs(cnt+1);
		visited[cnt]=false;
		dfs(cnt+1);
		
	}
}
