import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20058 {
	static int N,Q,L,SIZE,map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		SIZE = (int) Math.pow(2, N);
		map = new int[SIZE][SIZE];
		for(int i=0;i<SIZE;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<SIZE;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<Q;i++)
		{	
			int L = Integer.parseInt(st.nextToken());
			int size = (int)Math.pow(2, L);
			for(int x=0;x<SIZE;x+=size)
			{
				for(int y=0;y<SIZE;y+=size)
				{
				
				}
			}
		}
	}

}
