import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++)
		{
			List<Integer> arrayList = new ArrayList<Integer>();
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				arrayList.add(Integer.parseInt(st.nextToken()));
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				switch (st.nextToken())
				{
					case "I" :
						int where = Integer.parseInt(st.nextToken());
						int cnt = Integer.parseInt(st.nextToken());
						for(int j=0;j<cnt;j++)
						{
							arrayList.add(where+j, Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0;i<10;i++)
				System.out.print(arrayList.get(i)+" ");
			System.out.println();
		}
	}

}
