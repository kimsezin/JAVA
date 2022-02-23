import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int directions[] = new int[6];
		int distances[] = new int[6];
		int max_x=0, max_y=0;
		int max_x_idx=0, max_y_idx=0;
		for(int i=0;i<6;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			directions[i]=direction;
			distances[i]=distance;
			
			if(direction <3)
			{
				max_x = Math.max(max_x, distance);
				max_x_idx = i;
			}
			else
			{
				max_y = Math.max(max_y, distance);
				max_y_idx=i;
			}
		}
		int minus_x;
		int minus_y;
		if(max_x_idx-1<0)
			minus_x = Math.abs(distances[5]-distances[max_x_idx+1]);
		else if(max_x_idx+1>5)
			minus_x = Math.abs(distances[0]-distances[max_x_idx-1]);
		else
			minus_x = Math.abs(distances[max_x_idx+1]-distances[max_x_idx-1]);
		
		if(max_y_idx-1<0)
			minus_y = Math.abs(distances[5]-distances[max_y_idx+1]);
		else if(max_y_idx+1>5)
			minus_y = Math.abs(distances[0]-distances[max_y_idx-1]);
		else
			minus_y = Math.abs(distances[max_y_idx+1]-distances[max_y_idx-1]);
		int result = (max_x*max_y)-(minus_x*minus_y);
		System.out.println(result * K);

	}

}
