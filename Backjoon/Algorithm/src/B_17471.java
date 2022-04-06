import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471 {
	static int area[][], population[];
	static int result0=0, result1=0, N;
	static int result=10001;
	static boolean selected[];
	static int ac = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++)
			population[i] = Integer.parseInt(st.nextToken());
		area = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++)
			{
				int adj = Integer.parseInt(st.nextToken());
				area[i][adj] = 1;
				area[adj][i] = 1;
			}
		}
		
		selected = new boolean[N+1];
		permutation(0);
		if(result==10001)
			System.out.println(-1);
		else
			System.out.println(result);
		
	}
	private static void permutation(int cnt) {
		if(cnt==N)
		{
			result1=0;
			result0=0;
			ArrayList<Integer> area0 = new ArrayList<>();
			ArrayList<Integer> area1 = new ArrayList<>();
			
			for(int i=1;i<=N;i++)
				if(selected[i]==false)
					area0.add(i);
				else
					area1.add(i);
			
			if(area0.size()==0 || area1.size()==0) // 두 구역내에 하나라도 아무것도 없을 시 하면안됨
				return;
			
			boolean check0 = bfs0(area0);
			boolean check1 = bfs1(area1);
			
			if(check0 == true && check1 == true)
			{
				for(int temp :area0)
					result0 += population[temp];
				for(int temp :area1)
					result1 += population[temp];
				
				result = Math.min(result, Math.abs(result0-result1));
			}
			return;
		}
		
		
		selected[cnt]=true;
		permutation(cnt+1);
		selected[cnt]=false;
		permutation(cnt+1);
			
		
	}
	private static boolean bfs1(ArrayList<Integer> area1) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		q.offer(area1.get(0));
		int cnt=1;
		visited[area1.get(0)]=true;
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int i=1;i<=N;i++)
			{
				if(area[temp][i]==1 && selected[i]==true && visited[i]==false)
				{
					visited[i]=true;
					q.offer(i);
					cnt++;
				}
			}
		}
		
		if(cnt==area1.size())
			return true;
		else
			return false;
	}
	private static boolean bfs0(ArrayList<Integer> area0) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		q.offer(area0.get(0));
		int cnt=1;
		visited[area0.get(0)]=true;
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int i=1;i<=N;i++)
			{
				if(area[temp][i]==1 && selected[i]==false && visited[i]==false)
				{
					visited[i]=true;
					q.offer(i);
					cnt++;
				}
			}
		}
		
		if(cnt==area0.size())
			return true;
		else
			return false;
	}
}
