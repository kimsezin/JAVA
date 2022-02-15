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
		
//		dfs(0);
		binary(0);
		System.out.println(result);
	}
	static void binary(int cnt)
	{
		//바이너리 카운팅을 이용한 부분집합
		//N=10이면 비트를 이용해서 각 요소의 자리수에 해당하는 경우의 수를 만들 수 있음
		//0000000000~1111111111
		//부분집합의 개수 = 2^N개
		for (int i = 0; i <(1<<N); i++) {
			int t_sour = 1;
			int t_bitter = 0;
			for(int j = 0; j<N;j++)
			{
				if((i&(1<<j)) !=0) 
				{
					t_sour *= sour[j];
					t_bitter += bitter[j];
				}
			}
			//공집합인지 아닌지 확인
			if(!(t_sour==1&&t_bitter==0) && result > Math.abs(t_sour-t_bitter))
				result = Math.abs(t_sour-t_bitter);
		}
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
