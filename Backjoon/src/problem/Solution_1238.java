package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int map[][] = new int[101][101];
			N = Integer.parseInt(st.nextToken())/2;
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to]=1; //단방향 이므로 from->to만 추가
			}
			int result = bfs(map,start,new int[101]);
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static int bfs(int map[][], int start, int visited[])
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start]=1; //depth를 visited에 표기
		int result = 0;
		
		while(!queue.isEmpty())
		{
			int current = queue.poll();
			for(int i=0;i<101;i++)
			{
				if(visited[i]==0 && map[current][i]>0) //들리지 않았고 현재있는 current->i경로가 있는경우
				{
					queue.offer(i);
					visited[i]=visited[current]+1; // 현재 depth에서 +1추가해서 visited에 표시
				}
				result = visited[current];
			}
		}
		for(int i=100;i>=0;i--) //값이 가장 큰 노드를 찾아야하므로 100부터 찾기
			if(visited[i] == result)
				result = i;
		return result;
	}

}
