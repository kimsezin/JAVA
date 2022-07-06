package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2564 {
	public static class store
	{
		int direction, x;

		public store(int direction, int x) {
			super();
			this.direction = direction;
			this.x = x;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int storeCnt = Integer.parseInt(br.readLine());
		ArrayList<store> stores = new ArrayList<>();
		for(int i=0;i<storeCnt;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			stores.add(new store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine()," ");
		int start_direction = Integer.parseInt(st.nextToken());
		int start_x = Integer.parseInt(st.nextToken());
		
		int result=0;
		for(store temp : stores)
		{
			switch(start_direction)
			{
			case 1: // 북쪽
				if(temp.direction==1) // 북쪽
					result+=Math.abs(temp.x - start_x);
				else if(temp.direction==2) //남쪽		
					result+=Math.min(temp.x+start_x+N,(M-start_x)+(M-temp.x)+N);
				else if(temp.direction==3) //서쪽
					result+=start_x+temp.x;
				else //동쪽
					result+=M-start_x+temp.x;
				break;
			case 2: //남쪽
				if(temp.direction==1) // 북쪽
					result+=Math.min(start_x + temp.x + N, M-start_x + M-temp.x + N);
				else if(temp.direction==2) // 남쪽
					result+=Math.abs(start_x-temp.x);
				else if(temp.direction==3) //서쪽
					result+=start_x + N-temp.x;
				else // 동쪽
					result+=M-start_x + N-temp.x;
				break;
			case 3: // 서쪽
				if(temp.direction==1) //북쪽
					result+=temp.x+start_x;
				else if(temp.direction==2) // 남쪽
					result+=N-start_x + temp.x;
				else if(temp.direction==3)
					result+=Math.abs(temp.x-start_x);
				else
					result+=Math.min(temp.x + M + start_x, N-start_x+M+N-temp.x);
				break;
			case 4: // 동쪽
				if(temp.direction==1) //북쪽
					result+=M-temp.x+start_x;
				else if(temp.direction==2) //남쪽
					result+=N-start_x+M-temp.x;
				else if(temp.direction==3) //서쪽
					result+=Math.min(M+start_x+temp.x, N-start_x+M+N-temp.x);
				else //동쪽
					result+=Math.abs(temp.x-start_x);
			}
		}
		
		System.out.println(result);
		
	}

}
