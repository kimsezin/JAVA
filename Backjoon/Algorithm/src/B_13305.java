import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean visited[] =  new boolean[N];
		int edge[] = new int[N-1];
		int vertex[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N-1;i++)
		{
			edge[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			vertex[i] = Integer.parseInt(st.nextToken());
		}
		int distance=0;
		int result=0;
		
		for(int i=0;i<N;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				for(int j=i+1;j<N;j++)
				{
					if(vertex[i] >= vertex[j])
					{
						distance += edge[j-1];
						result += vertex[i]*distance;
						distance=0;
						break;
					}
					else
					{
						distance += edge[j-i];
						visited[j]=true;
					}
				}
			}
		}
		System.out.println(result);
	}

}
