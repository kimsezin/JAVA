import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++)
		{
			br.readLine();
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<8;i++)
			{
				q.add(Integer.parseInt(st.nextToken()));
			}
			int cnt=1;
			while(true)
			{
				int temp = q.poll();
				temp-=cnt;
				cnt++;
				if(cnt>5)
					cnt=1;
				if(temp<=0)
				{
					q.add(0);
					break;
				}
				q.add(temp);
			}
			System.out.print("#"+t+ " ");
			for(int i=0;i<8;i++)
			{
				System.out.print(q.poll()+ " ");
			}
			System.out.println();
			
		}

	}

}
