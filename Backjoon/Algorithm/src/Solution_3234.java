import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {
	static int weight[],N,result;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringBuilder sb = new StringBuilder();
			result=0;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			weight = new int[N];
			visited = new boolean[N];
			for(int i=0;i<N;i++)
				weight[i]=Integer.parseInt(st.nextToken());
			
			permutation(0,0,0); //순열 탐색
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb.toString());
		}

	}
	static void permutation(int cnt, int left_weight, int right_weight)
	{
		if(cnt==N-1)
		{
			result++;
			for(int i=0;i<N;i++)
			{
				if(visited[i]==false && left_weight >= right_weight+weight[i])
					result++;
			}
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				permutation(cnt+1, left_weight+weight[i],right_weight); // 왼쪽엔 무조건 넣을 수 있으므로 넣어주고 
				
				if(right_weight + weight[i] <= left_weight) // 해당하는 값을 오른쪽에도 넣었는데 그 값이 현재 왼쪽 무게보다 작을경우는 오른쪽에도 넣을 수 있으므로
															// 그에 해당하는 경우의 수 찾기
					permutation(cnt+1,left_weight, right_weight+weight[i]);
				
				visited[i]=false;
			}
		}
	}
}
