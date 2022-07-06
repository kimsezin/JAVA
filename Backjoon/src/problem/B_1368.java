package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1368 {
	
	static int N;
	static int parent[], map[][];
	static PriorityQueue<edge> pq;
	static class edge implements Comparable<edge>
	{
		int start,end,cost;

		public edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //논 개수
		parent = new int[N+1]; //논마다 연결됨을 표시하기위한 parent
		pq = new PriorityQueue<>(); //cost가 낮은것부터 찾기위한 pq
		int cost;
		
		for(int i=1;i<=N;i++)
		{
			cost = Integer.parseInt(br.readLine()); //자기자신에게 논을 팔 때 드는 cost
			pq.add(new edge(i,0,cost));
		}
		
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++)
			{
				int temp = Integer.parseInt(st.nextToken());
				if(i<j)
					pq.add(new edge(i,j,temp)); // 각 논끼리 연결했을 때 cost 무방향이므로 절반만
			}
		}
		
		mst();
	}
	
	static int find(int x)
	{
		if(parent[x] == x)
			return x;
		return find(parent[x]);
	}
	static void mst()
	{
		for(int i=0;i<=N;i++)
			parent[i] = i; // 부모 자기 자신으로 초기화
		
		for(int i=0;i<pq.size();i++)
		{
			edge temp = pq.poll(); //비용이 낮은것부터 하나씩 연결
			int start = temp.start;
			int end = temp.end;
			int cost = temp.cost;
			
			if(find(start) != find(end)) //부모가 같지 않으면
			{
				union(start,end); //부모 맞추고 결과 더하기
				result+=cost;
			}
		}
		
		System.out.println(result);
	}

	private static void union(int start, int end) {
		start = find(start);
		end = find(end);
		if(start > end)
			parent[start] = end;
		else
			parent[end] = start;
	}

	
}
