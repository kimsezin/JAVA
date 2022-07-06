package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_7465 {

	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N];
			for(int i=0;i<N;i++)
				parents[i]=i;
			
			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				if(findSet(a) == findSet(b))
					continue;
				else
				{
					int aRoot = findSet(a);
					int bRoot = findSet(b);
					parents[bRoot] = aRoot;
				}
			}
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0;i<parents.length;i++)
			{
				set.add(findSet(i));
			}
			sb.append(set.size());
			System.out.println(sb);
		}
	}
	
	static int findSet(int a)
	{
		if(a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

}
