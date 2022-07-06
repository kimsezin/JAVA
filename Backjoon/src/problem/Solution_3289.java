package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289 {
	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n];
			for(int i=0;i<n;i++)
				parents[i]=i;
			
			for(int i=0;i<m;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				if(type==1)
				{
					if(findSet(a) == findSet(b))
						sb.append(1);
					else
						sb.append(0);
				}
				else if(type==0)
				{
					if(findSet(a)==findSet(b))
						continue;
					else
					{
						int aRoot = findSet(a);
						int bRoot = findSet(b);
						parents[bRoot] = aRoot;
					}
				}
			}
			System.out.println(sb);
		}

	}
	public static int findSet( int a)
	{
		if(parents[a]==a)
			return a;
		else
			return parents[a] = findSet(parents[a]);
	}

}
