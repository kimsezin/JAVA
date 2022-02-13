import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int front=-1;
		int rear=-1;
		int queue[] = new int[2000000];
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String input = st.nextToken();
			if(input.equals("push"))
				queue[++rear]=Integer.parseInt(st.nextToken());
			else if(input.equals("front"))
			{	
				if(front==rear)
					sb.append(-1).append("\n");
				else
					sb.append(queue[front+1]).append("\n");
			}
			else if(input.equals("back"))
			{
				if(rear == front)
					sb.append(-1).append("\n");
				else
					sb.append(queue[rear]).append("\n");
			}
			else if(input.equals("pop"))
			{
				if(front==rear)
					sb.append(-1).append("\n");
				else
					sb.append(queue[++front]).append("\n");
			}
			else if(input.equals("empty"))
			{
				if(front==rear)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			else if(input.equals("size"))
			{
				sb.append(rear-front).append("\n");
			}
		}
		System.out.println(sb);
	}

}
