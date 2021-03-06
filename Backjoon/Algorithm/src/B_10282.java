import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_10282 {

	static class computer implements Comparable<computer>
	{
		int computer;
		int time;
		public computer(int computer, int time) {
			super();
			this.computer = computer;
			this.time = time;
		}
		
		@Override
		public int compareTo(computer o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}
	static ArrayList<ArrayList<computer>> list = new ArrayList<>();
	static int n,d,c, distance[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(new ArrayList<computer>());
			for(int i=0;i<d;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int time = Integer.parseInt(st.nextToken());
				
				list.get(end).add(new computer(start,time));
				//현재 나를 의존하고있는 컴퓨터를 저장해야하므로 end에 start를 넣어준다.
			}
			
			visited = new boolean[10001];
			distance = new int[10001];
			Arrays.fill(visited, false);
			Arrays.fill(distance, 987654321);
			dijkstra(c-1);
			int cnt=0;
			int result=0;
			
			for(int i=0;i<n;i++)
				if(visited[i]==true)
					cnt++;
			for(int i=0;i<n;i++)
				if(distance[i] != 987654321)
					if(result < distance[i])
						result = distance[i];
			System.out.println(cnt + " " + result);
		}

	}
	
	static int[] dijkstra(int c)
	{
		
		PriorityQueue<computer> pq = new PriorityQueue<>();
		pq.add(new computer(c,0));
		Arrays.fill(distance, 987654321);
		distance[c]=0;
		visited[c]=true;
		while(!pq.isEmpty())
		{
			computer temp = pq.poll();
			int current = temp.computer;
			int time = temp.time;
			
			for(computer next : list.get(current)) //current를 의지하고있는 컴퓨터를 탐색
			{
				if(visited[current]==true) //current가 감염되어 있으면
				{
					if(distance[next.computer] > distance[current]+next.time)
					{
						distance[next.computer] = distance[current]+next.time;
						pq.add(new computer(next.computer,distance[next.computer]));
						visited[next.computer]=true;
					}
				}
			}
		
		}
		return distance;
	}

}
