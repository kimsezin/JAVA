package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124 {
	
	static class Edge implements Comparable<Edge>
	{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static int parents[];
	static Edge edgeList[];
	public static void makeSet() //단위집합 생성
	{
		parents = new int[N+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i=0;i<N;i++)
			parents[i]=i;
	}
	public static int findSet(int a) //a가 속하는 집합의 대표자 찾기
	{
		if(a==parents[a]) //자신이 자신부모값일때
			return a;
		return parents[a] = findSet(parents[a]); //path compression
		
	}
	//a가 속한집합,b가 속한집합 두 집합 합치기
	public static boolean union(int a, int b)
	{
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			for(int t=1;t<=tc;t++)
			{
				
				StringTokenizer st =new StringTokenizer(br.readLine()," ");
				N = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				edgeList = new Edge[E];
				
				for(int i=0;i<E;i++)
				{
					st = new StringTokenizer(br.readLine()," ");
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					int weight = Integer.parseInt(st.nextToken());
					edgeList[i] = new Edge(from,to,weight);
				}
				
				Arrays.sort(edgeList);
				makeSet();
				
				long result = 0, cnt = 0;
				for(Edge edge : edgeList)
				{
					if(union(edge.from,edge.to))
					{
						cnt++;
						result+=edge.weight;
						if(cnt == N-1)
							break;
					}
				}
				
				System.out.println("#"+t+" " + result);
			}
	}

}
