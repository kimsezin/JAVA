import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_11779 {
	public static class distance
	{
		int distance;
		ArrayList<Integer> city = new ArrayList<>();
		
		public distance(int distance, ArrayList<Integer> city) {
			super();
			this.distance = distance;
			this.city = city;
		}
	}
	public static class location implements Comparable<location>
	{
		int connect;
		int distance;
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<location>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<>());
		for(int i=0;i<M;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.get(Integer.parseInt(st.nextToken())-1).add(new location(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<location> pq = new PriorityQueue<>();
		
		distance dist[] = new distance[N];
		for(int i=0;i<N;i++)
		{
			dist[i] = new distance(987654321,new ArrayList<Integer>());
		}
		dist[start].distance=0;
		dist[start].city.add(start+1);
		
		pq.add(new location(0,0));
		
		while(!pq.isEmpty())
		{
			location temp = pq.poll();
			int current = temp.connect;
			int distance = temp.distance;
			
			for(location link : list.get(current))
			{
				if(dist[link.connect].distance > link.distance + distance)
				{
					dist[link.connect].distance = link.distance + distance;
					dist[link.connect].city.add(current);
					pq.add(new location(link.connect, dist[link.connect].distance));
				}
			}
		}
		System.out.println(dist[end].distance);
		dist[end].city.add(end+1);
		System.out.println(dist[end].city.size());
		System.out.print(start+1+" ");
		for(int i=1;i<dist[end].city.size();i++)
			System.out.print(dist[end].city.get(i)+ " ");
		
	}

}
