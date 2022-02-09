import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
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
		int price=1000000001;
		int distance=0;
		int temp=0;
		int result=0;
		for(int i=0;i<N;i++)
		{
			distance+=edge[i];
			if(vertex[i] < price)
			{
				for(int j=temp;j<=i;j++)
				{
					result = distance*price;
				}
				temp=i;
			}
		}
	}

}
