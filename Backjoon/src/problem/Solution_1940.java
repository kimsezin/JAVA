package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			int v = 0; //속도체크
			int distance=0;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int command = Integer.parseInt(st.nextToken());

				if(command == 1) // 가속
					v+= Integer.parseInt(st.nextToken());
				else if(command==2)
				{
					v-= Integer.parseInt(st.nextToken());
					if(v<0)
						v=0;
				}
					distance+=v;
			}
			System.out.println("#"+tc+" "+distance);
		}
	}

}
