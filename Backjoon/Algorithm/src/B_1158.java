import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++)
			queue.offer(i);
		
		sb.append("<");
		
		while(queue.size() > 1)
		{
			for(int i=0;i<K-1;i++)
			{
				int temp=queue.poll();
				queue.offer(temp); 
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}

}
