import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1504 {
	static int INF = 200000000;
	static class location implements Comparable<location>
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
	static int N;
	static int dijkstra(int start, int idx)
	{
		PriorityQueue<location> pq  = new PriorityQueue<>();
		
		int distance[] = new int[N+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		pq.add(new location(start,0));
		
		while(!pq.isEmpty())
		{
			int current = pq.poll().connect;

			for(location temp : list.get(current))
			{
				int next = temp.connect;
				int dis = temp.distance;
				if(distance[next] > distance[current]+dis)
				{
					distance[next] = distance[current]+dis;
					pq.add(new location(next,distance[next]));
				}
			}
		}
		return distance[idx];
			
	}
	static ArrayList<ArrayList<location>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0;i<N+1;i++)
			list.add(new ArrayList<>());
		
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.get(start).add(new location(end,value));
            list.get(end).add(new location(start,value));
		}
		st = new StringTokenizer(br.readLine()," ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);
 
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);
 
        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
	}

}
