package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // N은 학생수
		int M = Integer.parseInt(st.nextToken()); // M은 키를 비교한 회수
		
		int edgeCount[] = new int[N];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<Integer>()); //2차원 배열리스트
		
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1; // from -> to 1부터 시작이라 1 빼줌
			int to = Integer.parseInt(st.nextToken())-1;
			
			list.get(from).add(to); //리스트에 값 넣기
			edgeCount[to]++; // 나를 향하는 (진입차수) 개수
		}

		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++)
		{
			if(edgeCount[i]==0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty())
		{
			int temp = queue.poll();
			
			System.out.print(temp+1+" ");
			ArrayList<Integer> adjlist = list.get(temp);
			
			for(int i=0;i<adjlist.size();i++)
			{
				edgeCount[adjlist.get(i)]--;
				if(edgeCount[adjlist.get(i)]==0)
					queue.offer(adjlist.get(i));
			}
		}
	}

}
