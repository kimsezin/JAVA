import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1238 {
	public static class location implements Comparable<location>
	{
		int connect, distance;

		public location(int connect, int distance) {
			super();
			this.connect = connect;
			this.distance = distance;
		}
		@Override
		public int compareTo(location o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<location>> list = new ArrayList<>();
		for(int i=0;i<N+1;i++)
			list.add(new ArrayList<>());
		
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.get(start).add(new location(end,value));
		}
		int result = 0;
		for(int i=1;i<=N;i++)
		{
			int sum=0;
			if(i==X)
				continue;
			int distance[] = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[i]=0;
			
			PriorityQueue<location> pq = new PriorityQueue<>();
			pq.add(new location(i,0));
			
			while(!pq.isEmpty())
			{
				int current  = pq.poll().connect;
				for(location temp : list.get(current))
				{
					int next = temp.connect;
					int value = temp.distance;
					
					if(distance[next] > distance[current] +value)
					{
						distance[next] = distance[current]+value;
						pq.add(new location(next,distance[next]));
					}
				}
			}
			sum = distance[X];
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[X]=0;
			pq.add(new location(X,0));
			
			while(!pq.isEmpty())
			{
				int current = pq.poll().connect;
				for(location temp : list.get(current))
				{
					int next = temp.connect;
					int value = temp.distance;
					
					if(distance[next] > distance[current] + value)
					{
						distance[next] = distance[current] + value;
						pq.add(new location(next,distance[next]));
					}
				}
			}
			sum += distance[i];
			
			if(result < sum)
				result=sum;
		}
		System.out.println(result);
	}

}
