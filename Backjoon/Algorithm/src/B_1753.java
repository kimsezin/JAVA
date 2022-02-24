import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1753 {
	public static class Node 
	{
		int connect, distance;
		public Node(int connect, int distance) {
			this.connect = connect;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for(int i=0;i<V;i++)
			list.add(new ArrayList<Node>());
		
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int distance = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to,distance));
		}
		boolean[] visited = new boolean[V]; // 최소비용 확정여부
		int distance[] = new int[V]; // 출발지에서 자신으로 오는 최소비용
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0으로
		visited[start] = true;
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		PQ.add(new Node(start,0));
		while(!PQ.isEmpty())
		{
			int current = PQ.poll().connect;
			if(visited[current]) continue;
			for(Node temp : list.get(current))
			{
				int next = temp.connect;
				int dis = temp.distance;
				
				if(distance[next] > distance[current] + dis)
				{
					distance[next] = distance[current]+dis;
					PQ.add(new Node(next,distance[next]));
				}
			}
		}
		for(int i=0;i<V;i++)
			if(distance[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
	}

}
