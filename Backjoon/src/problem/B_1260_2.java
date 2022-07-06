package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260_2 {

	public static class Node
	{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next)
		{
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
		
	}
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		
		Node adjlist[] = new Node[N];
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			if(adjlist[from]==null)
				adjlist[from] = new Node(to,null);
			else
			{
				for(Node temp = adjlist[from]; temp!=null;temp=temp.next)
				{
					if(temp.next == null)
					{
						Node next = new Node(to,null);
						temp.next = next;
						break;
					}
				}
			}
			
			if(adjlist[to]==null)
				adjlist[to] = new Node(from,null);
			else
			{
				for(Node temp = adjlist[to]; temp!=null;temp=temp.next)
				{
					if(temp.next == null)
					{
						Node next = new Node(from,null);
						temp.next = next;
						break;
					}
				}
			}
		}
		dfs(adjlist,start,new boolean[N]);
		System.out.println();
		bfs(adjlist,start, new boolean[N]);
	}
	static void bfs(Node[] adjlist, int start, boolean visited[])
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start]=true;
		queue.offer(start);
		
		while(!queue.isEmpty())
		{
			int from = queue.poll();
			System.out.print(from+1+" ");
			for(Node temp = adjlist[from]; temp!=null; temp=temp.next)
			{
				if(visited[temp.vertex]==false)
				{
					queue.offer(temp.vertex);
					visited[temp.vertex]=true;
				}
			}
		}
	}
	static void dfs(Node[] adjlist, int start, boolean visited[])
	{
		visited[start]=true;
		System.out.print(start+1+" ");
		for(Node temp = adjlist[start]; temp!=null; temp=temp.next)
		{
			if(visited[temp.vertex]==false)
			{
				dfs(adjlist,temp.vertex,visited);
			}
		}
	}
}
